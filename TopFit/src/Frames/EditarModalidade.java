
package Frames;

import Beans.BeansModalidades;
import DAO.ModalidadesDAO;
import FadeEffect.FadeEffect;
import controle.conexao;
import static controle.conexao.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import static paineis.PesquisarModalidade.TableMetroBuscarModalidade;

public class EditarModalidade extends javax.swing.JFrame implements Runnable{

private BeansModalidades dados_modalidade;

    private Thread tempo = null;
    private Timer t;
    public void setDados_modalidade(BeansModalidades pesquisar) {
        this.dados_modalidade = pesquisar;
    }
    public EditarModalidade() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);

        jTextFieldId.setEnabled(false);
        MTextFullModalidade.setEnabled(false);
        MTextFullPreço.setEnabled(false);
                //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();
    }
    

    public void setModalidade(String modalidade) {
        MTextFullModalidade.setText(modalidade);
    }

    public void setPreco(String preco) {
        MTextFullPreço.setText(preco);
    }

    public void setId_modalidade(String id) {
       jTextFieldId.setText(id);
    }

    ResultSet rs = null;
    Statement sr = null;
    
    public ArrayList<BeansModalidades> getProductList() {
        ArrayList<BeansModalidades> ModalidadesList = new ArrayList<BeansModalidades>();
        Connection con = getConnection();
        String query = "SELECT * FROM modalidade";
        try {

            sr = con.createStatement();
            rs = sr.executeQuery(query);
            BeansModalidades Modalidade;

            while (rs.next()) {
                Modalidade = new BeansModalidades(
                        rs.getString("id_modalidade"),
                        rs.getString("modalidade"),
                        rs.getFloat("preco"));

                ModalidadesList.add(Modalidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ModalidadesList;
    }
    
        public void readtabelaModalidade() {
        DefaultTableModel buscarModalidade = (DefaultTableModel) TableMetroBuscarModalidade.getModel();
        buscarModalidade.setNumRows(0);
        ModalidadesDAO dao = new ModalidadesDAO();

        for (BeansModalidades pesquisarModalidade : dao.readAll()) {
            buscarModalidade.addRow(new Object[]{
                pesquisarModalidade .getId_modalidade(),
                pesquisarModalidade .getModalidades(),
                pesquisarModalidade .getPreço(),
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel2 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        modalidade_lbl = new javax.swing.JLabel();
        sal_lbl = new javax.swing.JLabel();
        preço_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        MTextFullModalidade = new rojeru_san.RSMTextFull();
        MTextFullPreço = new rojeru_san.RSMTextFull();
        ButtonRipleLimpar = new rojeru_san.RSButtonRiple();
        ButtonRipleSalvar = new rojeru_san.RSButtonRiple();
        ButtonRipleEditar = new rojeru_san.RSButtonRiple();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rSPanelShadow1.setPreferredSize(new java.awt.Dimension(894, 745));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        modalidade_lbl.setBackground(new java.awt.Color(255, 255, 255));
        modalidade_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        modalidade_lbl.setForeground(new java.awt.Color(255, 51, 51));

        sal_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        sal_lbl.setForeground(new java.awt.Color(255, 51, 51));

        preço_lbl.setBackground(new java.awt.Color(255, 255, 255));
        preço_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        preço_lbl.setForeground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Editar Modalidades");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jTextFieldId.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jTextFieldId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldId.setSelectionColor(new java.awt.Color(0, 0, 0));

        MTextFullModalidade.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullModalidade.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullModalidade.setModoMaterial(true);
        MTextFullModalidade.setPlaceholder("Modalidade...");
        MTextFullModalidade.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullModalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullModalidadeKeyReleased(evt);
            }
        });

        MTextFullPreço.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullPreço.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullPreço.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullPreço.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullPreço.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullPreço.setModoMaterial(true);
        MTextFullPreço.setPlaceholder("Preço...");
        MTextFullPreço.setSelectedTextColor(new java.awt.Color(204, 204, 204));

        ButtonRipleLimpar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleLimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleLimpar.setText("Limpar");
        ButtonRipleLimpar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleLimpar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleLimparActionPerformed(evt);
            }
        });

        ButtonRipleSalvar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleSalvar.setText("Salvar");
        ButtonRipleSalvar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleSalvar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleSalvarActionPerformed(evt);
            }
        });

        ButtonRipleEditar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleEditar.setText("Editar");
        ButtonRipleEditar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleEditar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleEditarActionPerformed(evt);
            }
        });

        ButtonRipleMinimize.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleMinimize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonRipleMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize (1).png"))); // NOI18N
        ButtonRipleMinimize.setColorHover(new java.awt.Color(204, 204, 204));
        ButtonRipleMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleMinimizeActionPerformed(evt);
            }
        });

        ButtonRipleClose.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonRipleClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-cross (1).png"))); // NOI18N
        ButtonRipleClose.setColorHover(new java.awt.Color(204, 204, 204));
        ButtonRipleClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MTextFullPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modalidade_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sal_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(530, 530, 530)
                                .addComponent(preço_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonRipleSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preço_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MTextFullPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sal_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(modalidade_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRipleSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rSPanelShadow1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MTextFullModalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullModalidadeKeyReleased
        modalidade_lbl.setText("");
    }//GEN-LAST:event_MTextFullModalidadeKeyReleased

    private void ButtonRipleLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLimparActionPerformed
        MTextFullModalidade.setText("");
        MTextFullPreço.setText("");
    }//GEN-LAST:event_ButtonRipleLimparActionPerformed

    private void ButtonRipleSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleSalvarActionPerformed

        if (MTextFullModalidade.getText().trim().isEmpty()) {
            modalidade_lbl.setText("*");
        }
        if (MTextFullPreço.getText().equals("    .    ")) {
            preço_lbl.setText("*");
        } else {
            BeansModalidades mod = new BeansModalidades();
            ModalidadesDAO dao = new ModalidadesDAO();

            mod.setId_modalidade(jTextFieldId.getText());
            mod.setModalidades(MTextFullModalidade.getText());
            mod.setPreço(Float.parseFloat(MTextFullPreço.getText()));

            dao.UpdateModalidades(mod);
            
            this.setVisible(false);
            readtabelaModalidade();

        }
    }//GEN-LAST:event_ButtonRipleSalvarActionPerformed

    private void ButtonRipleEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleEditarActionPerformed

        MTextFullModalidade.setEnabled(true);
        MTextFullPreço.setEnabled(true);
    }//GEN-LAST:event_ButtonRipleEditarActionPerformed

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(EditarModalidade.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarModalidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleEditar;
    private rojeru_san.RSButtonRiple ButtonRipleLimpar;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private rojeru_san.RSButtonRiple ButtonRipleSalvar;
    private rojeru_san.RSMTextFull MTextFullModalidade;
    private rojeru_san.RSMTextFull MTextFullPreço;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JLabel modalidade_lbl;
    private javax.swing.JLabel preço_lbl;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JLabel sal_lbl;
    // End of variables declaration//GEN-END:variables

    public void run() {
        try {
            Thread.sleep(7000);
            //FadeEffect.fadeOutFrameSplash1(this, 50, 0.1f);
        } catch (InterruptedException ex) {
            Logger.getLogger(opening.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
