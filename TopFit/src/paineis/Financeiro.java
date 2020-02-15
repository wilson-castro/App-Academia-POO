package paineis;

import Beans.BeansAluno;
import DAO.AlunoDAO;
import Frames.TabelaAlunos;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Financeiro extends javax.swing.JPanel {

    public Financeiro() {
        initComponents();
        
        DefaultTableModel modeloPagamentos = (DefaultTableModel) rSTableMetroFinanceiro.getModel();
        rSTableMetroFinanceiro.setRowSorter(new TableRowSorter(modeloPagamentos));

        readTabelaAluno();

    }
    public void readTabelaAluno() {

        DefaultTableModel modeloPagamentos = (DefaultTableModel) rSTableMetroFinanceiro.getModel();
        modeloPagamentos.setNumRows(0);
        AlunoDAO dao = new AlunoDAO();

        for (BeansAluno aluno : dao.readAll()) {
            String situacao = "";
            if(aluno.getPagamento() == 1){
                situacao = "Pago";
            }
            else if(aluno.getPagamento() == 0){
                situacao = "Não Pago";
            }
            modeloPagamentos.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getPagamento(),});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel2 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        ButtonRiple = new rojeru_san.RSButtonRiple();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        JPANELsaldo = new javax.swing.JPanel();
        Jlabel13 = new javax.swing.JLabel();
        JLABELsaldo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonRiple1 = new rojeru_san.RSButtonRiple();
        ButtonRiple2 = new rojeru_san.RSButtonRiple();
        ButtonRiple3 = new rojeru_san.RSButtonRiple();
        MTextFulCodigoAluno = new rojeru_san.RSMTextFull();
        ButtonRipleAluno = new rojeru_san.RSButtonRiple();
        jLabel3 = new javax.swing.JLabel();
        JLABELnome = new javax.swing.JLabel();
        jLabel_aluno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelCodigoAluno2 = new javax.swing.JLabel();
        JLABELcodigo_aluno = new javax.swing.JLabel();
        jLabelCodigoAluno = new javax.swing.JLabel();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetroFinanceiro = new rojerusan.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(894, 750));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        ButtonRiple.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRiple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRiple.setText("Excluir");
        ButtonRiple.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRiple.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(51, 51, 51)));
        jPanel1.setPreferredSize(new java.awt.Dimension(604, 36));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        JPANELsaldo.setBackground(new java.awt.Color(153, 255, 153));
        JPANELsaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(51, 51, 51)));
        JPANELsaldo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlabel13.setBackground(new java.awt.Color(0, 0, 0));
        Jlabel13.setFont(new java.awt.Font("Georgia", 3, 13)); // NOI18N
        Jlabel13.setForeground(new java.awt.Color(51, 51, 51));
        Jlabel13.setText("Total a receber:");
        JPANELsaldo.add(Jlabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 21));

        JLABELsaldo.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        JLABELsaldo.setForeground(new java.awt.Color(255, 255, 255));
        JLABELsaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JPANELsaldo.add(JLABELsaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 130, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPANELsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPANELsaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Georgia", 2, 22)); // NOI18N
        jLabel2.setText("Financeiro ");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ButtonRiple1.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRiple1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRiple1.setText("Editar");
        ButtonRiple1.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRiple1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        ButtonRiple2.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRiple2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRiple2.setText("Lançar");
        ButtonRiple2.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRiple2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        ButtonRiple3.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRiple3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRiple3.setText("Receber");
        ButtonRiple3.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRiple3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        MTextFulCodigoAluno.setForeground(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFulCodigoAluno.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFulCodigoAluno.setModoMaterial(true);
        MTextFulCodigoAluno.setPlaceholder("Codigo do aluno...");
        MTextFulCodigoAluno.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFulCodigoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTextFulCodigoAlunoActionPerformed(evt);
            }
        });
        MTextFulCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFulCodigoAlunoKeyReleased(evt);
            }
        });

        ButtonRipleAluno.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleAluno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));
        ButtonRipleAluno.setText("...");
        ButtonRipleAluno.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleAlunoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel3.setText("Nome:");

        JLABELnome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELnome.setText("- - - - - - - - - - - -");

        jLabel_aluno.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel6.setText("Codigo:");

        jLabelCodigoAluno2.setForeground(new java.awt.Color(255, 0, 0));

        JLABELcodigo_aluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");

        jLabelCodigoAluno.setForeground(new java.awt.Color(255, 0, 0));

        ButtonRipleTodos.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
        ButtonRipleTodos.setText("Todos");
        ButtonRipleTodos.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleTodos.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleTodosActionPerformed(evt);
            }
        });

        rSTableMetroFinanceiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetroFinanceiro.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetroFinanceiro.setColorBordeHead(new java.awt.Color(255, 255, 255));
        rSTableMetroFinanceiro.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetroFinanceiro.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetroFinanceiro.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(rSTableMetroFinanceiro);
        if (rSTableMetroFinanceiro.getColumnModel().getColumnCount() > 0) {
            rSTableMetroFinanceiro.getColumnModel().getColumn(0).setResizable(false);
            rSTableMetroFinanceiro.getColumnModel().getColumn(1).setResizable(false);
            rSTableMetroFinanceiro.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(MTextFulCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(ButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ButtonRiple3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(ButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(ButtonRiple, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MTextFulCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(25, 25, 25)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6))
                                        .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JLABELnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRiple2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRiple3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRiple1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRiple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRipleAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAlunoActionPerformed
        new TabelaAlunos().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAlunoActionPerformed

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed

    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    private void MTextFulCodigoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFulCodigoAlunoKeyReleased
        if (!MTextFulCodigoAluno.getText().isEmpty()) {
            //search(MTextFulCodigoAluno.getText());
        } else{
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFulCodigoAlunoKeyReleased

    private void MTextFulCodigoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTextFulCodigoAlunoActionPerformed
        
    }//GEN-LAST:event_MTextFulCodigoAlunoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRiple;
    private rojeru_san.RSButtonRiple ButtonRiple1;
    private rojeru_san.RSButtonRiple ButtonRiple2;
    private rojeru_san.RSButtonRiple ButtonRiple3;
    private rojeru_san.RSButtonRiple ButtonRipleAluno;
    private rojeru_san.RSButtonRiple ButtonRipleTodos;
    private javax.swing.JLabel JLABELcodigo_aluno;
    private javax.swing.JLabel JLABELnome;
    private javax.swing.JLabel JLABELsaldo;
    private javax.swing.JPanel JPANELsaldo;
    private javax.swing.JLabel Jlabel13;
    private rojeru_san.RSMTextFull MTextFulCodigoAluno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCodigoAluno;
    private javax.swing.JLabel jLabelCodigoAluno2;
    private javax.swing.JLabel jLabel_aluno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojerusan.RSTableMetro rSTableMetroFinanceiro;
    // End of variables declaration//GEN-END:variables
}
