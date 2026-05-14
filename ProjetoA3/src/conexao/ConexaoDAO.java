package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ConexaoDAO {
    private final Connection conexao;
    
    public ConexaoDAO() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
    public void inserirCliente(Cliente_FlowBank cliente) {
        String sql = "INSERT INTO clientes (nome, email, celular, data_nascimento, senha) VALUES (?,?,?,?,?)";  
        
        try {
            PreparedStatement ps = conexao.prepareStatement (sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCelular());
            ps.setDate(4, cliente.getData_Nascimento());
            ps.setString(5, cliente.getSenha());
            ps.execute();
            ps.close();
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuario");
            throw new RuntimeException(exception);
        }
    }
    
    public boolean loginCliente(String email, String senha) {
        String sql = "SELECT * FROM clientes WHERE email = ? AND senha = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement (sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
            throw new RuntimeException(exception);
        }
    }
}
