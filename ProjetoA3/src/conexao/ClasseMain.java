
package conexao;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class ClasseMain {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.getConnection();
        
        if (conexao != null) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Falha na conexão!");
        }
    }
}