
package Telas;

import conexao.ClienteDAO;
import conexao.Cliente_FlowBank;
import conexao.TransacoesDAO;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class TelaTransferencia extends javax.swing.JFrame {
    private Integer id;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaTransferencia.class.getName());

   
    public TelaTransferencia() {
        initComponents();
     // --- FAZ O ENTER FUNCIONAR COMO TAB EM TODOS OS CAMPOS DESTA TELA ---
java.util.Set<java.awt.AWTKeyStroke> conjTeclas = new java.util.HashSet<>(
    java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(
        java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS
    )
);

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
// --- CONFIGURAÇÃO INICIAL DO VALOR ---
txtValorPagar.setText("R$ 0,00");
txtValorPagar.setHorizontalAlignment(javax.swing.JTextField.LEFT); // Alinha o texto à direita igual aos bancos

// --- MÁSCARA MONETÁRIA DINÂMICA ---
txtValorPagar.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        // Remove tudo o que não for número
        String limpo = txtValorPagar.getText().replaceAll("[^0-9]", "");
        
        // Se o usuário apagar tudo, resgata o padrão
        if (limpo.isEmpty()) {
            limpo = "0";
        }
        
        try {
            // Converte para double jogando os centavos para as casas decimais corretas
            double valor = Double.parseDouble(limpo) / 100.0;
            
            // Formata o número de volta para a moeda brasileira (R$)
            java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
            String formatado = nf.format(valor);
            
            txtValorPagar.setText(formatado);
        } catch (NumberFormatException ex) {
            // Prevenção de erros de conversão
        }
    }
});
    }

    public TelaTransferencia(Integer id) {
        initComponents();
        
        this.id = id;
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente_FlowBank cliente = clienteDAO.buscarClientePorId(id);
        lblNome.setText(cliente.getNome());
        lblId.setText(String.valueOf(cliente.getId()));
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
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        drpdwFormaPagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtChaveTransfEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorPagar = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        btnCancelarPgto = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
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
                        .addGap(14, 14, 14)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(244, 245, 248));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        drpdwFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha o tipo", "Pix", " " }));
        drpdwFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", " " }));
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

        txtValorPagar.setText("R$ 0,00");

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(this::btnPagarActionPerformed);

        btnCancelarPgto.setText("Cancelar");
        btnCancelarPgto.addActionListener(this::btnCancelarPgtoActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtValorPagar)
                        .addComponent(txtChaveTransfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(drpdwFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCancelarPgto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addGap(213, 213, 213)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            String valorTexto = txtValorPagar.getText();

            String mensagem = "";
            
            if (drpdwFormaPagamento.getSelectedItem().toString().equals("Escolha o tipo")) {
                mensagem += "- Forma de Pagamento\n";
            }
            if (emailDestinatario.equals("")) {
                mensagem += "- Chave de Transferência\n";
            }
            if (valorTexto.equals("")) {
                mensagem += "- Valor a pagar\n";
            }
            if (!mensagem.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Os seguintes campos precisam ser preenchidos:\n"+mensagem);
                return;
            }
            
            BigDecimal valor = new BigDecimal(txtValorPagar.getText());
            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(null, "Valor à transferir deve ser maior que 0!");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtChaveTransfEmail;
    private javax.swing.JTextField txtValorPagar;
    // End of variables declaration//GEN-END:variables
}
