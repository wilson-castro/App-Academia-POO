
package paineis;

import Beans.BeansFrequencia;
import DAO.FrequenciaDAO;
import DAO.FuncionarioDAO;
import Frames.EditarFrequencia;
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

public class PesquisarFrequencia extends javax.swing.JPanel {

    static Connection con = null;
    private int pos;

    EditarFrequencia janelaPesquisar;
    ArrayList<BeansFrequencia> pesquisas = new ArrayList();
    BeansFrequencia pesquisa;
    
    public PesquisarFrequencia() {
        initComponents();
        
        DefaultTableModel pesquisarFrequencia = (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        TableMetroBuscarFrequencia.setRowSorter(new TableRowSorter(pesquisarFrequencia));

        readtabelaFrequencia();
       
        MTextFullPesquisar.setVisible(false);
        PopuMenu.add(PanelGradienteTabela);
    }

    
     // Buscar Frequencia
    public void readtabelaFrequencia() {
        DefaultTableModel buscarFrequencia= (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        buscarFrequencia.setNumRows(0);
        FrequenciaDAO dao = new FrequenciaDAO();

        for (BeansFrequencia pesquisarFrequencia : dao.readA()) {
            
            buscarFrequencia.addRow(new Object[]{
                pesquisarFrequencia.getId_aluno(),
                pesquisarFrequencia.getNome(),
                pesquisarFrequencia.getData(),
                pesquisarFrequencia.getHora(),
            });
            this.pesquisas.add(pesquisarFrequencia);
        }
    }
    
        public void readtabelaForDescId(String desc) {
        DefaultTableModel buscarFrequencia = (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        buscarFrequencia.setNumRows(0);
        FrequenciaDAO dao = new FrequenciaDAO();

        for (BeansFrequencia Frequencia : dao.readForDescId(desc)) {

            buscarFrequencia.addRow(new Object[]{
                Frequencia.getId_aluno(),
                Frequencia.getNome(),
                Frequencia.getData(),
                Frequencia.getHora(),
            });

        }
    }

    public void readtabelaForDescNome(String desc) {

        DefaultTableModel buscarFrequencia = (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        buscarFrequencia.setNumRows(0);
        FrequenciaDAO dao = new FrequenciaDAO();

        for (BeansFrequencia Frequencia : dao.readForDescNome(desc)) {

            buscarFrequencia.addRow(new Object[]{
                Frequencia.getId_aluno(),
                Frequencia.getNome(),
                Frequencia.getData(),
                Frequencia.getHora(),
            });

        }
    }

    public void readtabelaForDescData(String desc) {

        DefaultTableModel buscarFrequencia = (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        buscarFrequencia.setNumRows(0);
        FrequenciaDAO dao = new FrequenciaDAO();

        for (BeansFrequencia Frequencia : dao.readForDescData(desc)) {

            buscarFrequencia.addRow(new Object[]{
                Frequencia.getId_aluno(),
                Frequencia.getNome(),
                Frequencia.getData(),
                Frequencia.getHora(),
            });

        }
    }

    public void readtabelaForDescHora(String desc) {

        DefaultTableModel buscarFrequencia = (DefaultTableModel) TableMetroBuscarFrequencia.getModel();
        buscarFrequencia.setNumRows(0);
        FrequenciaDAO dao = new FrequenciaDAO();

        for (BeansFrequencia Frequencia : dao.readForDescHora(desc)) {

            buscarFrequencia.addRow(new Object[]{
                Frequencia.getId_aluno(),
                Frequencia.getNome(),
                Frequencia.getData(),
                Frequencia.getHora(),
            });

        }
    }

    public ArrayList<BeansFrequencia> getFequenciaList() {
        ArrayList<BeansFrequencia> FrequenciaList = new ArrayList<BeansFrequencia>();
        Connection con = getConnection();
        String query = "SELECT * FROM frequencia";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            BeansFrequencia Frequencias;

            while (rs.next()) {
                Frequencias = new BeansFrequencia(rs.getString("Id_aluno"), rs.getString("nome"), rs.getString("data"), rs.getString("hora"));
                FrequenciaList.add(Frequencias);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return FrequenciaList;

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopuMenu = new rojerusan.RSPopuMenu();
        PanelGradienteTabela = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomExcluir = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomEditar = new rsbuttoncustom.RSButtonCustom();
        jPanelFuncionario = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel3 = new javax.swing.JLabel();
        ComboMetroPesquisar = new rojerusan.RSComboMetro();
        MTextFullPesquisar = new rojeru_san.RSMTextFull();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMetroBuscarFrequencia = new rojerusan.RSTableMetro();

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
        jLabel3.setText("Frequencia");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por:", "Codigo", "Nome", "Data", "Hora" }));
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

        TableMetroBuscarFrequencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroBuscarFrequencia.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        TableMetroBuscarFrequencia.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroBuscarFrequencia.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        TableMetroBuscarFrequencia.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        TableMetroBuscarFrequencia.setColorSelBackgound(new java.awt.Color(51, 51, 51));
        TableMetroBuscarFrequencia.setComponentPopupMenu(PopuMenu);
        TableMetroBuscarFrequencia.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        TableMetroBuscarFrequencia.setFuenteFilas(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarFrequencia.setFuenteFilasSelect(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarFrequencia.setFuenteHead(new java.awt.Font("Georgia", 3, 15)); // NOI18N
        TableMetroBuscarFrequencia.setSelectionBackground(new java.awt.Color(51, 51, 51));
        TableMetroBuscarFrequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMetroBuscarFrequenciaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMetroBuscarFrequencia);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                    .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(322, 322, 322))))
                        .addGap(17, 17, 17)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        } else if (ComboMetroPesquisar.getSelectedItem().equals("Nome")) {
            readtabelaForDescNome(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Data")) {
            readtabelaForDescData(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Hora")) {
            readtabelaForDescHora(MTextFullPesquisar.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");

        }
    }//GEN-LAST:event_MTextFullPesquisarKeyReleased

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed
        readtabelaFrequencia();
        MTextFullPesquisar.setText("");
        ComboMetroPesquisar.setSelectedItem("Pesquisar por: ");
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    private void TableMetroBuscarFrequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMetroBuscarFrequenciaMouseClicked

        if (TableMetroBuscarFrequencia.getSelectedRow() != -1) {
            for (BeansFrequencia pesq : pesquisas) {
                if (pesq.getId_aluno() == TableMetroBuscarFrequencia.getValueAt(TableMetroBuscarFrequencia.getSelectedRow(), 0)) {
                    this.pesquisa = pesq;
                }
            }
        }
    }//GEN-LAST:event_TableMetroBuscarFrequenciaMouseClicked

    private void ButtonCustomExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomExcluirActionPerformed
        if (TableMetroBuscarFrequencia.getSelectedRow() != -1) {

            BeansFrequencia f = new BeansFrequencia();
            FrequenciaDAO dao = new FrequenciaDAO();

            f.setId_aluno((String) TableMetroBuscarFrequencia.getValueAt(TableMetroBuscarFrequencia.getSelectedRow(), 0));

            dao.delete(f);

            readtabelaFrequencia();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma frequência para excluir!");
        }
    }//GEN-LAST:event_ButtonCustomExcluirActionPerformed

    private void ButtonCustomEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomEditarActionPerformed

        if(TableMetroBuscarFrequencia.getSelectedRow() != -1){
            this.setEnabled(false);
            janelaPesquisar = new EditarFrequencia();
            janelaPesquisar.setVisible(true);

            janelaPesquisar.setCodigoAluno(this.pesquisa.getId_aluno());
            janelaPesquisar.setLABELnome(this.pesquisa.getNome());
            janelaPesquisar.setLABELcodigo_aluno(this.pesquisa.getId_aluno());
            janelaPesquisar.setHora(this.pesquisa.getHora());
            janelaPesquisar.setData(this.pesquisa.getData());

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
    public static rojerusan.RSTableMetro TableMetroBuscarFrequencia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelFuncionario;
    private javax.swing.JScrollPane jScrollPane2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
