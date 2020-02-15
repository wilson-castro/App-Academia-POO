
package paineis;

import Beans.BeansMatricula;
import DAO.MatriculaDAO;
import Frames.EditarMatricula;
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

public class PesquisarMatricula extends javax.swing.JPanel {

    static Connection con = null;
    private int pos;
    
    EditarMatricula janelaPesquisar;
    ArrayList<BeansMatricula> pesquisas = new ArrayList();
    BeansMatricula pesquisa;

    public PesquisarMatricula() {
        initComponents();
        
        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        TableMetroBuscarMatricula.setRowSorter(new TableRowSorter(buscarMatricula));

        readtabela_matricula();

        MTextFullPesquisar.setVisible(false);
        PopuMenu.add(PanelGradienteTabela);
    }
    
     //Buscar Matricula
    public void readtabela_matricula() {

        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        buscarMatricula.setNumRows(0);
        MatriculaDAO dao = new MatriculaDAO();

        for (BeansMatricula matric : dao.readAll()) {

            buscarMatricula.addRow(new Object[]{
                matric.getId(),
                matric.getNome(),
                matric.getModalidade(),
                matric.getValor(),
                matric.getData(),});
            
            this.pesquisas.add(matric);

        }
    }

    public void readtabelaMatriculaForDescId(String desc) {
        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        buscarMatricula.setNumRows(0);
        MatriculaDAO dao = new MatriculaDAO();

        for (BeansMatricula matric : dao.readForDescId(desc)) {

            buscarMatricula.addRow(new Object[]{
                matric.getId(),
                matric.getNome(),
                matric.getModalidade(),
                matric.getValor(),
                matric.getData(),});
        }
    }

    public void readtabelaMatriculaForDescCodigoAluno(String desc) {

        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        buscarMatricula.setNumRows(0);
        MatriculaDAO dao = new MatriculaDAO();

        for (BeansMatricula matric : dao.readForDescCodigoAluno(desc)) {

            buscarMatricula.addRow(new Object[]{
                matric.getId(),
                matric.getNome(),
                matric.getModalidade(),
                matric.getValor(),
                matric.getData(),});
        }
    }

    public void readtabelaMatriculaForDescNome(String desc) {

        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        buscarMatricula.setNumRows(0);
        MatriculaDAO dao = new MatriculaDAO();

        for (BeansMatricula matric : dao.readForDescNome(desc)) {

            buscarMatricula.addRow(new Object[]{
                matric.getId(),
                matric.getNome(),
                matric.getModalidade(),
                matric.getValor(),
                matric.getData(),});
        }
    }

    public void readtabelaMatriculaForDescModalidade(String desc) {

        DefaultTableModel buscarMatricula = (DefaultTableModel) TableMetroBuscarMatricula.getModel();
        buscarMatricula.setNumRows(0);
        MatriculaDAO dao = new MatriculaDAO();

        for (BeansMatricula matric : dao.readForDescModalidade(desc)) {

            buscarMatricula.addRow(new Object[]{
                matric.getId(),
                matric.getNome(),
                matric.getModalidade(),
                matric.getValor(),
                matric.getData(),});
        }
    }

    public ArrayList<BeansMatricula> getMatriculaList() {
        ArrayList<BeansMatricula> MatriculaList = new ArrayList<BeansMatricula>();
        Connection con = getConnection();
        String query = "SELECT * FROM matriculas";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            BeansMatricula Matricula;

            while (rs.next()) {
                Matricula = new BeansMatricula(rs.getString("Id"),rs.getString("Id_aluno"),rs.getString("nome"), rs.getString("id_modalidade"), rs.getString("modalidade"), rs.getFloat("valor"), rs.getString("data"), rs.getString("pagamento"));
                MatriculaList.add(Matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return MatriculaList;

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
        TableMetroBuscarMatricula = new rojerusan.RSTableMetro();

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

        jPanelModalidade.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelShadow1.setBackground(new java.awt.Color(255, 204, 204));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(894, 615));

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel3.setText("Matricula");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por:", "Codigo", "Codigo do aluno", "Nome", "Modalidade" }));
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

        TableMetroBuscarMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Modalidade", "Valor", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroBuscarMatricula.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        TableMetroBuscarMatricula.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroBuscarMatricula.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        TableMetroBuscarMatricula.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        TableMetroBuscarMatricula.setColorSelBackgound(new java.awt.Color(51, 51, 51));
        TableMetroBuscarMatricula.setComponentPopupMenu(PopuMenu);
        TableMetroBuscarMatricula.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        TableMetroBuscarMatricula.setFuenteFilas(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarMatricula.setFuenteFilasSelect(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarMatricula.setFuenteHead(new java.awt.Font("Georgia", 3, 15)); // NOI18N
        TableMetroBuscarMatricula.setSelectionBackground(new java.awt.Color(51, 51, 51));
        TableMetroBuscarMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMetroBuscarMatriculaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMetroBuscarMatricula);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        rSPanelShadow1.add(rSPanelGradiente1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelModalidadeLayout = new javax.swing.GroupLayout(jPanelModalidade);
        jPanelModalidade.setLayout(jPanelModalidadeLayout);
        jPanelModalidadeLayout.setHorizontalGroup(
            jPanelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModalidadeLayout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanelModalidadeLayout.setVerticalGroup(
            jPanelModalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
            readtabelaMatriculaForDescId(MTextFullPesquisar.getText());
        } else if (ComboMetroPesquisar.getSelectedItem().equals("Codigo do aluno")) {
            readtabelaMatriculaForDescCodigoAluno(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Nome")) {
            readtabelaMatriculaForDescNome(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Modalidade")) {
            readtabelaMatriculaForDescModalidade(MTextFullPesquisar.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");

        }
    }//GEN-LAST:event_MTextFullPesquisarKeyReleased

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed
        readtabela_matricula();
        MTextFullPesquisar.setText("");
        ComboMetroPesquisar.setSelectedItem("Pesquisar por: ");
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    private void TableMetroBuscarMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMetroBuscarMatriculaMouseClicked

        if (TableMetroBuscarMatricula.getSelectedRow() != -1) {
            for (BeansMatricula pesq : pesquisas) {
                if (pesq.getId() == TableMetroBuscarMatricula.getValueAt(TableMetroBuscarMatricula.getSelectedRow(), 0)) {
                    this.pesquisa = pesq;
                }
            }
        }
    }//GEN-LAST:event_TableMetroBuscarMatriculaMouseClicked

    private void ButtonCustomExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomExcluirActionPerformed
        if (TableMetroBuscarMatricula.getSelectedRow() != -1) {

            BeansMatricula delete = new BeansMatricula();
            MatriculaDAO dao = new MatriculaDAO();

            delete.setId((String) TableMetroBuscarMatricula.getValueAt(TableMetroBuscarMatricula.getSelectedRow(), 0));

            dao.delete(delete);

            readtabela_matricula();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma matricula para excluir!");
        }
    }//GEN-LAST:event_ButtonCustomExcluirActionPerformed

    private void ButtonCustomEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomEditarActionPerformed

        if(TableMetroBuscarMatricula.getSelectedRow() != -1){
            this.setEnabled(false);
            janelaPesquisar = new EditarMatricula();
            janelaPesquisar.setVisible(true);

            janelaPesquisar.setId_matricula(this.pesquisa.getId());
            janelaPesquisar.setCodigoAluno(this.pesquisa.getId_aluno());
            janelaPesquisar.setDataMtricula(this.pesquisa.getData());
            janelaPesquisar.setNome(this.pesquisa.getNome());
            janelaPesquisar.setLABELcodigo_aluno(this.pesquisa.getId_aluno());
            janelaPesquisar.setModalidade(this.pesquisa.getId_modalidade());
            janelaPesquisar.setLABELModalidade(this.pesquisa.getModalidade());
            janelaPesquisar.setCodigo_modalidade(this.pesquisa.getId_modalidade());
            janelaPesquisar.setPreco(String.valueOf(this.pesquisa.getValor()));
            janelaPesquisar.setVencimento(this.pesquisa.getVencimento());

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
    public static rojerusan.RSTableMetro TableMetroBuscarMatricula;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelModalidade;
    private javax.swing.JScrollPane jScrollPane2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
