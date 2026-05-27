
package Telas;

import conexao.ClienteDAO;
import conexao.Cliente_FlowBank;
import conexao.TransacoesDAO;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class TelaTransferencia extends javax.swing.JFrame {
    private Integer id;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaTransferencia.class.getName());

   
    public TelaTransferencia() {
        initComponents();
     
    }

    public TelaTransferencia(Integer id) {
        initComponents();
         
        this.id = id;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente_FlowBank cliente = clienteDAO.buscarClientePorId(id);
        lblNome.setText(cliente.getNome());
        lblId.setText(String.valueOf(cliente.getId()));
        
        TransacoesDAO transacoesDAO = new TransacoesDAO();
        BigDecimal saldo = transacoesDAO.verificarSaldo(id);
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        lblSaldoAtual.setText(formato.format(saldo));
        
         // --- FAZ O ENTER FUNCIONAR COMO TAB EM TODOS OS CAMPOS DESTA TELA ---
        java.util.Set<java.awt.AWTKeyStroke> conjTeclas = new java.util.HashSet<>(
        java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(
        java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

        // Adiciona a tecla ENTER na lista de comandos de pulo
        conjTeclas.add(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));

        // Aplica a regra para os campos de texto e caixas de seleção da TelaTransferencia
        this.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjTeclas);
        txtChaveTransfEmail.setText("Digite a chave");
        txtChaveTransfEmail.setForeground(java.awt.Color.GRAY);

        // --- COMPORTAMENTO AO CLICAR E SAIR DO CAMPO ---
        txtChaveTransfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            // Quando o usuário clica no campo, se o texto for o padrão, ele limpa
            if (txtChaveTransfEmail.getText().equals("Digite a chave")) {
            txtChaveTransfEmail.setText("");
            txtChaveTransfEmail.setForeground(java.awt.Color.BLACK); // Altere para WHITE se o seu fundo for escuro
            }
        }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        // Se o usuário clicar fora e não tiver digitado nada, o texto padrão volta
        if (txtChaveTransfEmail.getText().trim().isEmpty()) {
            txtChaveTransfEmail.setText("Digite a chave");
            txtChaveTransfEmail.setForeground(java.awt.Color.GRAY);
        }
    }
    });
        
        NumberFormat formatoMoeda = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        formatoMoeda.setMinimumFractionDigits(2);
        formatoMoeda.setMaximumFractionDigits(2);

        NumberFormatter formatter = new NumberFormatter(formatoMoeda);
        formatter.setMinimum(0.0);
        formatter.setAllowsInvalid(false); // ✅ Não permite digitar letras

        txtValorPagar.setFormatterFactory(new DefaultFormatterFactory(formatter));
        txtValorPagar.setValue(0.0); // ✅ Valor inicial
        
        txtValorPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            SwingUtilities.invokeLater(() -> txtValorPagar.selectAll()); // ✅ Seleciona tudo ao entrar no campo
    }
});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bntPerfil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSaldoAtual = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        drpdwFormaPagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtChaveTransfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        btnCancelarPgto = new javax.swing.JButton();
        txtValorPagar = new javax.swing.JFormattedTextField();
        lblR$ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        bntPerfil.setBackground(new java.awt.Color(0, 0, 0));
        bntPerfil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bntPerfil.setForeground(new java.awt.Color(255, 255, 255));
        bntPerfil.setText("Editar Perfil");
        bntPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bntPerfil.setContentAreaFilled(false);
        bntPerfil.setFocusable(false);
        bntPerfil.addActionListener(this::bntPerfilActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(bntPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(bntPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Saldo");

        lblSaldoAtual.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoAtual.setText("Saldo_Atual");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addComponent(lblSaldoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(244, 245, 248));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        drpdwFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "" }));
        drpdwFormaPagamento.setSelectedIndex(1);
        drpdwFormaPagamento.addActionListener(this::drpdwFormaPagamentoActionPerformed);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tipo de Transferência: ");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Chave de Transferência:");

        txtChaveTransfEmail.setText("Digite a chave");
        txtChaveTransfEmail.addActionListener(this::txtChaveTransfEmailActionPerformed);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Valor a Pagar:");

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(this::btnPagarActionPerformed);

        btnCancelarPgto.setText("Cancelar");
        btnCancelarPgto.addActionListener(this::btnCancelarPgtoActionPerformed);

        txtValorPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtValorPagar.addActionListener(this::txtValorPagarActionPerformed);

        lblR$.setBackground(new java.awt.Color(255, 255, 255));
        lblR$.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblR$.setForeground(new java.awt.Color(0, 0, 0));
        lblR$.setText("R$");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCancelarPgto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblR$)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtChaveTransfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(drpdwFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(txtValorPagar))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drpdwFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChaveTransfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblR$))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntPerfilActionPerformed

    private void txtChaveTransfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChaveTransfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChaveTransfEmailActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja confirmar a transferencia?");
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            String formaPagamento = drpdwFormaPagamento.getSelectedItem().toString();
            String emailDestinatario = txtChaveTransfEmail.getText();
            Number valorTexto = (Number) txtValorPagar.getValue();

            String mensagem = "";
            
            if (drpdwFormaPagamento.getSelectedItem().toString().equals("")) {
                mensagem += "- Forma de Pagamento\n";
            }
            if (emailDestinatario.equals("") || emailDestinatario.equals("Digite a chave")) {
                mensagem += "- Chave de Transferência\n";
            }
            if (valorTexto.equals("R$ 0,00")) {
                mensagem += "- Valor a pagar\n";
            }
            if (!mensagem.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Os seguintes campos precisam ser preenchidos:\n"+mensagem);
                return;
            }
            
            BigDecimal valor = new BigDecimal(valorTexto.toString());
            
            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(null, "Valor a transferir deve ser maior que R$0,00!");
                return; 
            }
  
            
            ClienteDAO clienteDAO = new ClienteDAO();  
            Cliente_FlowBank destinatario = clienteDAO.buscarClientePorEmail(emailDestinatario);
           
            
            if (destinatario == null) {
                JOptionPane.showMessageDialog(null, "chave pix incorreta ou não encontrada!");
                return;
            }
            if (destinatario.getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Impossível concluir a transferência! Id do remetente é identico ao destinatário.");
                return;
            }
            
            TransacoesDAO transacoesDAO = new TransacoesDAO();  
            transacoesDAO.transferencia(id, destinatario.getId(), valor, formaPagamento);
            
            TelaExtrato telaExtrato = new TelaExtrato(this.id);
            telaExtrato.setVisible(true);
            this.dispose();
        }
        else {
            confirmacao = JOptionPane.CLOSED_OPTION;
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCancelarPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPgtoActionPerformed
        TelaExtrato telaExtrato = new TelaExtrato(this.id);
        telaExtrato.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarPgtoActionPerformed

    private void drpdwFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpdwFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drpdwFormaPagamentoActionPerformed

    private void txtValorPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorPagarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TelaTransferencia().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPerfil;
    private javax.swing.JButton btnCancelarPgto;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> drpdwFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblR$;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTextField txtChaveTransfEmail;
    private javax.swing.JFormattedTextField txtValorPagar;
    // End of variables declaration//GEN-END:variables
}
