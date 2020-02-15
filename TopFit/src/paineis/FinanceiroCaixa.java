
package paineis;

import Beans.BeansFinanceiro;
import DAO.FinanceiroDAO;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FinanceiroCaixa extends javax.swing.JPanel {


    public FinanceiroCaixa() {
        initComponents();
  
        JDATEdata.setVisible(false);
        JLABELdia.setVisible(false);
        ButtonRiplePesquisar.setVisible(false);
        
        DefaultTableModel modelos = (DefaultTableModel) rSTableMetrofinanceiro.getModel();
        rSTableMetrofinanceiro.setRowSorter(new TableRowSorter(modelos));

        readtabela();
        
        double count = 0;
        for (int i = 0; i <= ButtonRiplePesquisar.getComponentCount() - 1; i++) {
            count += Double.parseDouble(ButtonRiplePesquisar.getComponentAt(i, 2).toString());
        }
        JLABELsaldo.setText(String.valueOf(count));
    }
    
        public void readtabela() {
        DefaultTableModel modelo = (DefaultTableModel) rSTableMetrofinanceiro.getModel();
        modelo.setNumRows(0);
        FinanceiroDAO dao = new FinanceiroDAO();

        for (BeansFinanceiro financ : dao.readAll()) {
            modelo.addRow(new Object[]{
                financ.getRecibo(),
                financ.getDescricao(),
                financ.getValor(),
                financ.getData(),
                financ.getHora(),
                financ.getData_venc(),
                financ.getData_pag(),
            });
        }
    }
    public void readtabelaForDia(String dia) {
        DefaultTableModel modelo = (DefaultTableModel) rSTableMetrofinanceiro.getModel();
        modelo.setNumRows(0);
        FinanceiroDAO dao = new FinanceiroDAO();
        
        for (BeansFinanceiro financ : dao.readForDia(dia)) {
            modelo.addRow(new Object[]{
                financ.getRecibo(),
                financ.getDescricao(),
                financ.getValor(),
                financ.getData(),
                financ.getHora(),
                financ.getData_venc(),
                financ.getData_pag(),
            });
        }
    }
    
    public void deletePagamento(){
        BeansFinanceiro financ = new BeansFinanceiro();
        
        for(int i = 0; i < rSTableMetrofinanceiro.getRowCount(); i++){
            financ.setRecibo(Integer.parseInt(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0))));
            financ.setDescricao(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0)));
            financ.setValor(Float.parseFloat(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0))));
            financ.setData(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0)));
            financ.setHora(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0)));
            financ.setData_venc(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0)));
            financ.setData_pag(String.valueOf(rSTableMetrofinanceiro.getValueAt(i,0)));
        }
        FinanceiroDAO financ_dao = new FinanceiroDAO();
        financ_dao.delete(financ);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGradienteTabela = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomExcluir = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomEditar = new rsbuttoncustom.RSButtonCustom();
        jPanelFuncionario = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel3 = new javax.swing.JLabel();
        ComboMetroPesquisar = new rojerusan.RSComboMetro();
        JDATEdata = new com.toedter.calendar.JDateChooser();
        JLABELdia = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();
        ButtonRiplePesquisar = new rojeru_san.RSButtonRiple();
        jPanel1 = new javax.swing.JPanel();
        JPANELsaldo = new javax.swing.JPanel();
        Jlabel13 = new javax.swing.JLabel();
        JLABELsaldo = new javax.swing.JLabel();
        ButtonRipleTodos2 = new rojeru_san.RSButtonRiple();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetrofinanceiro = new rojerusan.RSTableMetro();

        PanelGradienteTabela.setColorPrimario(new java.awt.Color(51, 51, 51));
        PanelGradienteTabela.setColorSecundario(new java.awt.Color(102, 102, 102));
        PanelGradienteTabela.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.ESQUINA_3);

        ButtonCustomExcluir.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCustomExcluir.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomExcluir.setText("Excluir");
        ButtonCustomExcluir.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomExcluir.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomExcluirActionPerformed(evt);
            }
        });

        ButtonCustomEditar.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCustomEditar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomEditar.setText("Editar");
        ButtonCustomEditar.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomEditar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGradienteTabelaLayout = new javax.swing.GroupLayout(PanelGradienteTabela);
        PanelGradienteTabela.setLayout(PanelGradienteTabelaLayout);
        PanelGradienteTabelaLayout.setHorizontalGroup(
            PanelGradienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGradienteTabelaLayout.createSequentialGroup()
                .addGroup(PanelGradienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCustomExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        PanelGradienteTabelaLayout.setVerticalGroup(
            PanelGradienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGradienteTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCustomEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFuncionario.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelShadow1.setBackground(new java.awt.Color(255, 204, 204));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(894, 615));

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel3.setText("Financeiro Caixa");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por:", "Caixa do Dia", "Dia Específico" }));
        ComboMetroPesquisar.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ComboMetroPesquisar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMetroPesquisarItemStateChanged(evt);
            }
        });

        JDATEdata.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        JLABELdia.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        JLABELdia.setText("Dia:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        ButtonRipleTodos.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
        ButtonRipleTodos.setText("Todos");
        ButtonRipleTodos.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleTodos.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleTodos.setIconTextGap(15);
        ButtonRipleTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleTodosActionPerformed(evt);
            }
        });

        ButtonRiplePesquisar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRiplePesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRiplePesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
        ButtonRiplePesquisar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRiplePesquisar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRiplePesquisar.setIconTextGap(15);
        ButtonRiplePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRiplePesquisarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(51, 51, 51)));
        jPanel1.setPreferredSize(new java.awt.Dimension(604, 36));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        JPANELsaldo.setBackground(new java.awt.Color(204, 204, 255));
        JPANELsaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(51, 51, 51)));
        JPANELsaldo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlabel13.setBackground(new java.awt.Color(0, 0, 0));
        Jlabel13.setFont(new java.awt.Font("Georgia", 3, 13)); // NOI18N
        Jlabel13.setForeground(new java.awt.Color(51, 51, 51));
        Jlabel13.setText("Saldo:");
        JPANELsaldo.add(Jlabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 21));

        JLABELsaldo.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        JLABELsaldo.setForeground(new java.awt.Color(255, 255, 255));
        JLABELsaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JPANELsaldo.add(JLABELsaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPANELsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPANELsaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        ButtonRipleTodos2.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleTodos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleTodos2.setText("Recibo");
        ButtonRipleTodos2.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleTodos2.setFont(new java.awt.Font("Georgia", 3, 16)); // NOI18N
        ButtonRipleTodos2.setIconTextGap(15);
        ButtonRipleTodos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleTodos2ActionPerformed(evt);
            }
        });

        rSTableMetrofinanceiro.setModel(new javax.swing.table.DefaultTableModel(
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
        rSTableMetrofinanceiro.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetrofinanceiro.setColorBordeHead(new java.awt.Color(255, 255, 255));
        rSTableMetrofinanceiro.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetrofinanceiro.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetrofinanceiro.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(rSTableMetrofinanceiro);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                            .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JLABELdia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                    .addComponent(JDATEdata, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ButtonRiplePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(ButtonRipleTodos2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(JLABELdia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDATEdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonRiplePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonRipleTodos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(rSPanelGradiente1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelFuncionarioLayout = new javax.swing.GroupLayout(jPanelFuncionario);
        jPanelFuncionario.setLayout(jPanelFuncionarioLayout);
        jPanelFuncionarioLayout.setHorizontalGroup(
            jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFuncionarioLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
        );
        jPanelFuncionarioLayout.setVerticalGroup(
            jPanelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFuncionarioLayout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboMetroPesquisarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMetroPesquisarItemStateChanged

        if (ComboMetroPesquisar.getSelectedItem() == "Dia Específico") {
            JLABELdia.setVisible(true);
            JDATEdata.setVisible(true);
            ComboMetroPesquisar.setVisible(true);
        } else{
            JDATEdata.setVisible(false);
            JLABELdia.setVisible(false);
            ComboMetroPesquisar.setVisible(false);
        }
        
    }//GEN-LAST:event_ComboMetroPesquisarItemStateChanged

    private void JBUTTONpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUTTONpesquisarActionPerformed
        SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
        String date = dc.format(JDATEdata.getDate());
        readtabelaForDia(date);
        double count = 0;
        for (int i = 0; i <= rSTableMetrofinanceiro.getRowCount() - 1; i++) {
            count += Double.parseDouble(rSTableMetrofinanceiro.getValueAt(i, 2).toString());
        }JLABELsaldo.setText(String.valueOf(count));
    }//GEN-LAST:event_JBUTTONpesquisarActionPerformed

    private void JBUTTONtodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUTTONtodosActionPerformed
        readtabela();
        double count = 0;
        for (int i = 0; i <= rSTableMetrofinanceiro.getRowCount() - 1; i++) {
            count += Double.parseDouble(rSTableMetrofinanceiro.getValueAt(i, 2).toString());
        }JLABELsaldo.setText(String.valueOf(count));
    }//GEN-LAST:event_JBUTTONtodosActionPerformed

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed
        
        readtabela();
        double count = 0;
        for (int i = 0; i <= rSTableMetrofinanceiro.getRowCount() - 1; i++) {
            count += Double.parseDouble(rSTableMetrofinanceiro.getValueAt(i, 2).toString());
        }JLABELsaldo.setText(String.valueOf(count));
        
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    private void ButtonRiplePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRiplePesquisarActionPerformed
        
        SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
        String date = dc.format(JDATEdata.getDate());
        readtabelaForDia(date);
        double count = 0;
        for (int i = 0; i <= rSTableMetrofinanceiro.getRowCount() - 1; i++) {
            count += Double.parseDouble(rSTableMetrofinanceiro.getValueAt(i, 2).toString());
        }JLABELsaldo.setText(String.valueOf(count));
        
    }//GEN-LAST:event_ButtonRiplePesquisarActionPerformed

    private void ButtonCustomExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomExcluirActionPerformed
       
        if (rSTableMetrofinanceiro.getSelectedRow() != -1) {
            deletePagamento();
        }
        
    }//GEN-LAST:event_ButtonCustomExcluirActionPerformed

    private void ButtonCustomEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomEditarActionPerformed

    }//GEN-LAST:event_ButtonCustomEditarActionPerformed

    private void ButtonRipleTodos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRipleTodos2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttoncustom.RSButtonCustom ButtonCustomEditar;
    private rsbuttoncustom.RSButtonCustom ButtonCustomExcluir;
    private rojeru_san.RSButtonRiple ButtonRiplePesquisar;
    private rojeru_san.RSButtonRiple ButtonRipleTodos;
    private rojeru_san.RSButtonRiple ButtonRipleTodos2;
    private rojerusan.RSComboMetro ComboMetroPesquisar;
    private com.toedter.calendar.JDateChooser JDATEdata;
    private javax.swing.JLabel JLABELdia;
    private javax.swing.JLabel JLABELsaldo;
    private javax.swing.JPanel JPANELsaldo;
    private javax.swing.JLabel Jlabel13;
    private rspanelgradiente.RSPanelGradiente PanelGradienteTabela;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFuncionario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private rojerusan.RSTableMetro rSTableMetrofinanceiro;
    // End of variables declaration//GEN-END:variables
}
