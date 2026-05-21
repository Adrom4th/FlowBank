
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
}
