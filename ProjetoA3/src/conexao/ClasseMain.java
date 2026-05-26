
package conexao;

import java.sql.Connection;
import java.util.TimeZone;
import javax.swing.JOptionPane;

public class ClasseMain {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        Connection conexao = ConexaoBD.getConnection();
        
        if (conexao != null) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Falha na conexão!");
        }
    }
}