
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import conexao.TransacoesExtrato_FlowBank;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.UUID;

public class TransacoesDAO {
    private final Connection conexao;
    
    public TransacoesDAO() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
    public List<TransacoesExtrato_FlowBank> buscarTransacoesPorId (int id) {
        List <TransacoesExtrato_FlowBank> lista = new ArrayList<>();       
        String sql = "SELECT * FROM extrato WHERE id_cliente = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement (sql)) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TransacoesExtrato_FlowBank extrato = new TransacoesExtrato_FlowBank();
                    
                    extrato.setId_Transacao(rs.getInt("id_transacao"));
                    extrato.setId_Cliente(rs.getInt("id_cliente"));
                    extrato.setData_Transacao(rs.getTimestamp("data_transacao"));
                    extrato.setValor_Transacao(rs.getBigDecimal("valor_transacao"));
                    extrato.setForma_Pagamento(rs.getString("forma_pagamento"));
                    extrato.setTipo_Transacao(rs.getString("tipo_transacao"));
                    lista.add(extrato);                  
                }
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar lançamentos!");
            throw new RuntimeException(exception);
        }
        
        return lista;
    }
    
    public void transferencia (int idRemetente, int idDestinatario, BigDecimal valor, String formaPagamento) {
        
        BigDecimal saldoAtual = verificarSaldo(idRemetente);
        
        if (saldoAtual.compareTo(valor) < 0) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            return;
        }
                
        String sql = "INSERT INTO extrato (id_cliente, id_transferencia, tipo_transacao, valor_transacao, forma_pagamento) VALUES (?,?,?,?,?)";
        
        // UUID garante que os dois registros ficam vinculados
        UUID idTransferencia = UUID.randomUUID();
        Timestamp horaAtual = new Timestamp(System.currentTimeMillis());
        
        try {
            conexao.setAutoCommit(false); //Inicia transação. Ou ambos inserem ou nenhum
            
            try (PreparedStatement ps = conexao.prepareStatement (sql)) {
                // Registro 1:  Saída para o remetente           
                ps.setInt(1, idRemetente);
                ps.setObject(2, idTransferencia);
                ps.setString(3, "Saída");
                ps.setBigDecimal(4, valor);
                ps.setString(5, formaPagamento);
                ps.executeUpdate();
                
                // Registro 2: Entrada para o destinatário
                ps.setInt(1, idDestinatario);
                ps.setObject(2, idTransferencia);
                ps.setString(3, "Entrada");
                ps.setBigDecimal(4, valor);
                ps.setString(5, formaPagamento);
                ps.executeUpdate();
                
                conexao.commit(); //Confirma os dois registros juntos
                JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
                
            }
            catch (SQLException exception) {
                conexao.rollback(); //Se qualquer insert falhar, desfaz tudo
                JOptionPane.showMessageDialog(null, "Erro ao realizar a transferência!");
                throw new RuntimeException(exception);
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro de conexão interna.");
            throw new RuntimeException(exception);
        }
        finally {
            try {
                conexao.setAutoCommit(true); //Restaura o comportamento padrão
            }
            catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
    
    public BigDecimal verificarSaldo (int id_Cliente) {
        String sql = "SELECT COALESCE( SUM ("
                        + "CASE "
                            + "WHEN tipo_transacao = 'Entrada' THEN valor_transacao "
                            + "WHEN tipo_transacao = 'Saída' THEN -valor_transacao "
                        + "END "
                    + "), 0) AS saldo FROM extrato WHERE id_cliente = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement (sql)) {
            ps.setInt(1, id_Cliente);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return(rs.getBigDecimal("saldo"));
                }
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar saldo");
            throw new RuntimeException(exception);
        }
        return BigDecimal.ZERO;
    }
}
