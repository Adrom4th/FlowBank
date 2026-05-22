
package Telas;

import conexao.Cliente_FlowBank;
import javax.swing.JOptionPane;
import conexao.ClienteDAO;
import conexao.TransacoesDAO;
import conexao.TransacoesExtrato_FlowBank;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

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
        Cliente_FlowBank cliente = clienteDAO.buscarClientePorId(id);
        lblId.setText(String.valueOf(cliente.getId()));
        lblNome.setText(cliente.getNome());
        
        TransacoesDAO transacoesDAO = new TransacoesDAO();
        List<TransacoesExtrato_FlowBank> lista = transacoesDAO.buscarTransacoesPorId(cliente.getId());
        
        DefaultTableModel modelo = (DefaultTableModel) tblExtrato.getModel();
        for (TransacoesExtrato_FlowBank transacoes : lista) {
            String formatoData = "dd/MM/yyyy HH:mm";
            SimpleDateFormat dataConvertida = new SimpleDateFormat(formatoData);
            
            Integer Id_Transacao = transacoes.getId_Transacao();
            String Tipo = transacoes.getTipo_Transacao();
            BigDecimal Valor = transacoes.getValor_Transacao();
            String Data = dataConvertida.format(transacoes.getData_Transacao());
            
            modelo.addRow(new Object[] {Id_Transacao, Tipo, Valor, Data});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnTransferencia = new javax.swing.JButton();
        txtInicio = new javax.swing.JLabel();
        bntPerfil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExtrato = new javax.swing.JTable();
        Label_Extrato = new javax.swing.JLabel();
        txtTransacoes = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 245, 248));

        jPanel2.setBackground(new java.awt.Color(2, 3, 5));

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome_Usuario");

        lblId.setBackground(new java.awt.Color(255, 255, 255));
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("Id_Usuario");

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Id:");

        jPanel3.setOpaque(false);

        btnTransferencia.setBackground(new java.awt.Color(0, 0, 0));
        btnTransferencia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTransferencia.setText("Transferência");
        btnTransferencia.addActionListener(this::btnTransferenciaActionPerformed);

        txtInicio.setBackground(new java.awt.Color(255, 255, 255));
        txtInicio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtInicio.setForeground(new java.awt.Color(0, 204, 204));
        txtInicio.setText("Início");

        bntPerfil.setBackground(new java.awt.Color(0, 0, 0));
        bntPerfil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntPerfil.setText("Editar Perfil");
        bntPerfil.addActionListener(this::bntPerfilActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtInicio)
                .addGap(18, 18, 18)
                .addComponent(btnTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntPerfil)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferencia)
                    .addComponent(txtInicio)
                    .addComponent(bntPerfil))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Downloads\\Adobe Express - file (2).jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblExtrato.setBackground(new java.awt.Color(255, 255, 255));
        tblExtrato.setForeground(new java.awt.Color(0, 0, 0));
        tblExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_Transacao", "Tipo", "Valor", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblExtrato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblExtrato.setEnabled(false);
        tblExtrato.setGridColor(new java.awt.Color(0, 0, 0));
        tblExtrato.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblExtrato.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblExtrato.setShowHorizontalLines(true);
        tblExtrato.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tblExtrato);

        Label_Extrato.setBackground(new java.awt.Color(0, 0, 0));
        Label_Extrato.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Label_Extrato.setForeground(new java.awt.Color(0, 0, 0));
        Label_Extrato.setText("Extrato");

        txtTransacoes.setBackground(new java.awt.Color(204, 204, 204));
        txtTransacoes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTransacoes.setForeground(new java.awt.Color(0, 204, 204));
        txtTransacoes.setText("Últimas Transações");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Extrato)
                    .addComponent(txtTransacoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Label_Extrato)
                .addGap(28, 28, 28)
                .addComponent(txtTransacoes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntPerfilActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferenciaActionPerformed

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
    private javax.swing.JLabel Label_Extrato;
    private javax.swing.JButton bntPerfil;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblExtrato;
    private javax.swing.JLabel txtInicio;
    private javax.swing.JLabel txtTransacoes;
    // End of variables declaration//GEN-END:variables
}
