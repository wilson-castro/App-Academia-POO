
package paineis;

import Beans.BeansBuscarFuncionario;
import Beans.BeansModalidades;
import DAO.FuncionarioDAO;
import DAO.ModalidadesDAO;
import Frames.EditarModalidade;
import controle.conexao;
import static controle.conexao.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PesquisarModalidade extends javax.swing.JPanel {

    static Connection con = null;
    private int pos;
    
    EditarModalidade janelaPesquisar;
    ArrayList<BeansModalidades> pesquisas = new ArrayList();
    BeansModalidades pesquisa;

    public PesquisarModalidade() {
        initComponents();
        
        DefaultTableModel pesquisarModalidade = (DefaultTableModel) TableMetroBuscarModalidade.getModel();
        TableMetroBuscarModalidade.setRowSorter(new TableRowSorter(pesquisarModalidade));

        readtabelaModalidade();
       
        MTextFullPesquisar.setVisible(false);
        PopuMenu.add(PanelGradienteTabela);
    }

     //Buscar Modalidades
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
            this.pesquisas.add(pesquisarModalidade);
        }
    }
    

    public void readtabelaForDescId(String desc) {
        DefaultTableModel buscarModalidade = (DefaultTableModel) TableMetroBuscarModalidade.getModel();
        buscarModalidade.setNumRows(0);
        ModalidadesDAO dao = new ModalidadesDAO();

        for (BeansModalidades Modalidade : dao.readForDescId_modalidade(desc)) {

            buscarModalidade.addRow(new Object[]{
                Modalidade.getId_modalidade(),
                Modalidade.getModalidades(),
                Modalidade.getPreço(),
            });

        }
    }

    public void readtabelaForDescPreco(String desc) {

        DefaultTableModel buscarModalidade = (DefaultTableModel) TableMetroBuscarModalidade.getModel();
        buscarModalidade.setNumRows(0);
        ModalidadesDAO dao = new ModalidadesDAO();

        for (BeansModalidades Modalidade : dao.readForDescPreco(desc)) {

            buscarModalidade.addRow(new Object[]{
                Modalidade.getId_modalidade(),
                Modalidade.getModalidades(),
                Modalidade.getPreço(),
            });

        }
    }
    
    public void readtabelaForDescModalidade(String desc) {
        DefaultTableModel buscarModalidade = (DefaultTableModel) TableMetroBuscarModalidade.getModel();
        buscarModalidade.setNumRows(0);
        ModalidadesDAO dao = new ModalidadesDAO();

        for (BeansModalidades Modalidade : dao.readForDescModalidade(desc)) {

            buscarModalidade.addRow(new Object[]{
                Modalidade.getId_modalidade(),
                Modalidade.getModalidades(),
                Modalidade.getPreço(),
            });

        }
    }
    public ArrayList<BeansModalidades> getModalidadeList() {
        ArrayList<BeansModalidades> ModalidadeList = new ArrayList<BeansModalidades>();
        Connection con = getConnection();
        String query = "SELECT * FROM modalidade";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            BeansModalidades Modalidade;

            while (rs.next()) {
                Modalidade = new BeansModalidades(rs.getString("Id_modalidade"), rs.getString("modalidade"), rs.getFloat("preco"));
                ModalidadeList.add(Modalidade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ModalidadeList;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGradienteTabela = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomExcluir = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomEditar = new rsbuttoncustom.RSButtonCustom();
        PopuMenu = new rojerusan.RSPopuMenu();
        jPanelModalidade = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel3 = new javax.swing.JLabel();
        ComboMetroPesquisar = new rojerusan.RSComboMetro();
        MTextFullPesquisar = new rojeru_san.RSMTextFull();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMetroBuscarModalidade = new rojerusan.RSTableMetro();

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

        setPreferredSize(new java.awt.Dimension(904, 625));

        jPanelModalidade.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelShadow1.setBackground(new java.awt.Color(255, 204, 204));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(894, 615));

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel3.setText("Modalidade");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por:", "Codigo", "Modalidade", "Preço" }));
        ComboMetroPesquisar.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ComboMetroPesquisar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMetroPesquisarItemStateChanged(evt);
            }
        });

        MTextFullPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullPesquisar.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullPesquisar.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullPesquisar.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullPesquisar.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        MTextFullPesquisar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullPesquisar.setModoMaterial(true);
        MTextFullPesquisar.setPlaceholder("Digite...");
        MTextFullPesquisar.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullPesquisarKeyReleased(evt);
            }
        });

        ButtonRipleTodos.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleTodos.setText("Todos");
        ButtonRipleTodos.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleTodos.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleTodos.setIconTextGap(15);
        ButtonRipleTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleTodosActionPerformed(evt);
            }
        });

        TableMetroBuscarModalidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Modalidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroBuscarModalidade.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        TableMetroBuscarModalidade.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroBuscarModalidade.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        TableMetroBuscarModalidade.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        TableMetroBuscarModalidade.setColorSelBackgound(new java.awt.Color(51, 51, 51));
        TableMetroBuscarModalidade.setComponentPopupMenu(PopuMenu);
        TableMetroBuscarModalidade.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        TableMetroBuscarModalidade.setFuenteFilas(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarModalidade.setFuenteFilasSelect(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarModalidade.setFuenteHead(new java.awt.Font("Georgia", 3, 15)); // NOI18N
        TableMetroBuscarModalidade.setSelectionBackground(new java.awt.Color(51, 51, 51));
        TableMetroBuscarModalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMetroBuscarModalidadeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMetroBuscarModalidade);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGap(31, 31, 31)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(rSPanelGradiente1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelModalidadeLayout = new javax.swing.GroupLayout(jPanelModalidade);
        jPanelModalidade.setLayout(jPanelModalidadeLayout);
        jPanelModalidadeLayout.setHorizontalGroup(
            jPanelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelModalidadeLayout.setVerticalGroup(
            jPanelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModalidadeLayout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelModalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelModalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboMetroPesquisarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMetroPesquisarItemStateChanged

        if (ComboMetroPesquisar.getSelectedIndex() == 0) {
            MTextFullPesquisar.setVisible(false);
        } else {
            MTextFullPesquisar.setVisible(true);

        }
    }//GEN-LAST:event_ComboMetroPesquisarItemStateChanged

    private void MTextFullPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullPesquisarKeyReleased


        if (ComboMetroPesquisar.getSelectedItem().equals("Codigo")) {
            readtabelaForDescId(MTextFullPesquisar.getText());
        } else if (ComboMetroPesquisar.getSelectedItem().equals("Modalidade")) {
            readtabelaForDescModalidade(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Preço")) {
            readtabelaForDescPreco(MTextFullPesquisar.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");

        }
    }//GEN-LAST:event_MTextFullPesquisarKeyReleased

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed
        readtabelaModalidade();
        MTextFullPesquisar.setText("");
        ComboMetroPesquisar.setSelectedItem("Pesquisar por: ");
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    private void TableMetroBuscarModalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMetroBuscarModalidadeMouseClicked

        if (TableMetroBuscarModalidade.getSelectedRow() != -1) {
            for (BeansModalidades pesq : pesquisas) {
                if (pesq.getId_modalidade() == TableMetroBuscarModalidade.getValueAt(TableMetroBuscarModalidade.getSelectedRow(), 0)) {
                    this.pesquisa = pesq;
                }
            }
        }
    }//GEN-LAST:event_TableMetroBuscarModalidadeMouseClicked

    private void ButtonCustomExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomExcluirActionPerformed
        if (TableMetroBuscarModalidade.getSelectedRow() != -1) {

            BeansModalidades m = new BeansModalidades();
            ModalidadesDAO dao = new ModalidadesDAO();

            m.setId_modalidade((String) TableMetroBuscarModalidade.getValueAt(TableMetroBuscarModalidade.getSelectedRow(), 0));

            dao.delete(m);

            readtabelaModalidade();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma modalidade para excluir!");
        }
    }//GEN-LAST:event_ButtonCustomExcluirActionPerformed

    private void ButtonCustomEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomEditarActionPerformed

        if(TableMetroBuscarModalidade.getSelectedRow() != -1){
            this.setEnabled(false);
            janelaPesquisar = new EditarModalidade();
            janelaPesquisar.setVisible(true);

            janelaPesquisar.setId_modalidade(this.pesquisa.getId_modalidade());
            janelaPesquisar.setModalidade(this.pesquisa.getModalidades());
            janelaPesquisar.setPreco(String.valueOf(this.pesquisa.getPreço()));

        }
    }//GEN-LAST:event_ButtonCustomEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttoncustom.RSButtonCustom ButtonCustomEditar;
    private rsbuttoncustom.RSButtonCustom ButtonCustomExcluir;
    private rojeru_san.RSButtonRiple ButtonRipleTodos;
    private rojerusan.RSComboMetro ComboMetroPesquisar;
    private rojeru_san.RSMTextFull MTextFullPesquisar;
    private rspanelgradiente.RSPanelGradiente PanelGradienteTabela;
    private rojerusan.RSPopuMenu PopuMenu;
    public static rojerusan.RSTableMetro TableMetroBuscarModalidade;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelModalidade;
    private javax.swing.JScrollPane jScrollPane2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
