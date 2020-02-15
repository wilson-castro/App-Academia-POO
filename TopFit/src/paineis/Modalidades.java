
package paineis;

import GerarCodigo.GenerarCodigo;
import DAO.ModalidadesDAO;
import Beans.BeansModalidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modalidades extends javax.swing.JPanel {

    static Connection con = null;

    public Modalidades() {
        initComponents();
  
        carregarcodigo();
        
        jTextFieldId.setEnabled( false );

    }
    
    void carregarcodigo(){
        con = controle.conexao.getConnection();

        int j;
        String num = "";
        String c = "";
        String SQL = "select max(id_modalidade) from modalidade";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                jTextFieldId.setText("MO0001");
            } else {
                char r1 = c.charAt(2);
                char r2 = c.charAt(3);
                char r3 = c.charAt(4);
                char r4 = c.charAt(5);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;

                j = Integer.parseInt(r);
                GenerarCodigo gen = new GenerarCodigo();
                gen.generar(j);
                jTextFieldId.setText("MO" + gen.serie());

            }

        } catch (Exception e) {
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        ButtonRipleCadastrar = new rojeru_san.RSButtonRiple();

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
        jLabel1.setText("Modalidades");
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

        ButtonRipleCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleCadastrar.setText("Cadastrar");
        ButtonRipleCadastrar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleCadastrar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(preço_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MTextFullPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(modalidade_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sal_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonRipleCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preço_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
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
                .addGap(37, 37, 37)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRipleCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rSPanelShadow1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MTextFullModalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullModalidadeKeyReleased
        modalidade_lbl.setText("");
    }//GEN-LAST:event_MTextFullModalidadeKeyReleased

    private void ButtonRipleLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLimparActionPerformed
               MTextFullModalidade.setText("");
        MTextFullPreço.setText("");
    }//GEN-LAST:event_ButtonRipleLimparActionPerformed

    private void ButtonRipleCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCadastrarActionPerformed

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

            dao.Cadastro_Modalidades(mod);

            MTextFullModalidade.setText("");
            MTextFullPreço.setText("");
            carregarcodigo();
        }
    }//GEN-LAST:event_ButtonRipleCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleCadastrar;
    private rojeru_san.RSButtonRiple ButtonRipleLimpar;
    private rojeru_san.RSMTextFull MTextFullModalidade;
    private rojeru_san.RSMTextFull MTextFullPreço;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JLabel modalidade_lbl;
    private javax.swing.JLabel preço_lbl;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JLabel sal_lbl;
    // End of variables declaration//GEN-END:variables
}
