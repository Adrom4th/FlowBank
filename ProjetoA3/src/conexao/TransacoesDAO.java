
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import conexao.Transacoes_Extrato_FlowBank;
import java.util.ArrayList;
import java.util.List;

public class TransacoesDAO {
    private final Connection conexao;
    
    public TransacoesDAO() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
    public List<Transacoes_Extrato_FlowBank> buscarTransacoesPorId (int id) {
        List lista = new ArrayList();       
        String sql = "SELECT * FROM extrato WHERE id = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            
        }
    }
}
