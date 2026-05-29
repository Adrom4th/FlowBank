package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public static String URL = "jdbc:postgresql://aws-1-us-west-2.pooler.supabase.com:5432/postgres?sslmode=require";
    public static String USERNAME = "postgres.orvqpsownanqzolexlgv";
    public static String PASSWORD = "MNkLWR1VlT7iASfO";
    public static String DRIVER = "org.postgresql.Driver";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);           
        }
        catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão");
            throw new RuntimeException (exception);
        }
        catch (ClassNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao importar o Driver");
            throw new RuntimeException (exception);
        }        
    }    
}