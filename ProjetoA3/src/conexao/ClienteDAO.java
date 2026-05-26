package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import conexao.Cliente_FlowBank;

public class ClienteDAO {
    private final Connection conexao;
    
    public ClienteDAO() {
        this.conexao = new ConexaoBD().getConnection();
    }
    
    public void inserirCliente(Cliente_FlowBank cliente) {
        String sql = "INSERT INTO clientes (nome, email, celular, data_nascimento, senha) VALUES (?,?,?,?,?)";  
        
        try (PreparedStatement ps = conexao.prepareStatement (sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCelular());
            ps.setDate(4, cliente.getData_Nascimento());
            ps.setString(5, cliente.getSenha());
            ps.executeUpdate();
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuario");
            throw new RuntimeException(exception);
        }
    }
    
    
    public boolean loginCliente(String email, String senha) {
        String sql = "SELECT * FROM clientes WHERE email = ? AND senha = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement (sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar login!");
            throw new RuntimeException(exception);
        }
    }
    
    
    public Cliente_FlowBank buscarClientePorEmail(String email) {
        String sql = "SELECT * FROM clientes WHERE email = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, email);
            
            try(ResultSet rs = ps.executeQuery()) {              
                if(rs.next()) {
                    Cliente_FlowBank cliente = new Cliente_FlowBank();
                    
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setData_Nascimento(rs.getDate("data_nascimento"));
                    cliente.setSenha(rs.getString("senha"));
                    
                    return cliente;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente!");
                    return null;
                }
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            throw new RuntimeException (exception);
        }
    }
    
    
    public Cliente_FlowBank buscarClientePorId(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        
        try (PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente_FlowBank cliente = new Cliente_FlowBank();
                
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setData_Nascimento(rs.getDate("data_nascimento"));
                    cliente.setSenha(rs.getString("senha"));
            
                    return cliente;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não foi possível encontrar o cliente!");
                    return null;
                }
            }
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            throw new RuntimeException(exception);
        }
    }
    
    public Cliente_FlowBank modificarCliente(Cliente_FlowBank cliente) {
        String sql = "UPDATE clientes SET nome=?, email=?, celular=?, data_nascimento=?, senha=?, WHERE id=?";
        
        try {
            System.out.println("Try Modificar");
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCelular());
            ps.setString(3, cliente.getEmail());
            ps.setDate(4, cliente.getdata_nascimento());
            ps.setString(5, cliente.getSenha());
            ps.setInt(6, cliente.getId());
            ps.execute();
        }
    }
}
