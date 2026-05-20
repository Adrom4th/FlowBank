
package Telas;

import conexao.Cliente_FlowBank;
import javax.swing.JOptionPane;
import conexao.ClienteDAO;
import conexao.TransacoesDAO;
import conexao.TransacoesExtrato_FlowBank;
import java.util.List;

public class TelaExtrato_Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaExtrato_Principal.class.getName());

    /**
     * Creates new form TelaPrincipal_Extrato
     */
    public TelaExtrato_Principal() {
        initComponents();
    }
    
    public TelaExtrato_Principal(Integer id) {
        initComponents();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente_FlowBank cliente = clienteDAO.BuscarClientePorId(id);
        txtId.setText(String.valueOf(cliente.getId()));
        txtNome.setText(cliente.getNome());
        
        TransacoesDAO transacoesDAO = new TransacoesDAO();
        List<TransacoesExtrato_FlowBank> lista = transacoesDAO.buscarTransacoesPorId(cliente.getId());
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaExtrato_Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
