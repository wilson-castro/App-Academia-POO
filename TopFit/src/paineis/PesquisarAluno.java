package paineis;

import DAO.PesquisarAlunosDAO;
import DAO.PesquisarDAO;
import Frames.EditarAluno;
import Beans.BeansBuscarAluno;
import Beans.BeansPesquisar;
import controle.conexao;
import static controle.conexao.getConnection;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PesquisarAluno extends javax.swing.JPanel {

    static Connection con = null;
    private int pos;
    
    EditarAluno janelaPesquisar;
    ArrayList<BeansPesquisar> pesquisas = new ArrayList();
    BeansPesquisar pesquisa;

    public PesquisarAluno() {
        initComponents();

        DefaultTableModel pesquisarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        TableMetroBuscarAlunos.setRowSorter(new TableRowSorter(pesquisarAluno));

        readtabelaAluno();
       
        MTextFullPesquisar.setVisible(false);
        PopuMenu.add(PanelGradienteTabela);
         
    }

    //Buscar Alunos
    public void readtabelaAluno() {
        DefaultTableModel buscarAluno= (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarDAO dao = new PesquisarDAO();

        for (BeansPesquisar pesquisarAluno : dao.readAll()) {
            buscarAluno.addRow(new Object[]{
                pesquisarAluno.getId_aluno(),
                pesquisarAluno.getNome(),
                pesquisarAluno.getSexo(),
                pesquisarAluno.getIdade(),
            });
            this.pesquisas.add(pesquisarAluno);
        }
    }
    

    public void readtabelaForDescId(String desc) {
        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescId(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getIdade(),});

        }
    }

    public void readtabelaForDescNome(String desc) {

        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescNome(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getIdade(),});

        }
    }

    public void readtabelaForDescIdade(String desc) {

        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescIdade(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getIdade(),});

        }
    }

    public void readtabelaForDescSexo(String desc) {

        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescSexo(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getIdade(),});

        }
    }

    public ArrayList<BeansBuscarAluno> getAlunosList() {
        ArrayList<BeansBuscarAluno> AlunosList = new ArrayList<BeansBuscarAluno>();
        Connection con = getConnection();
        String query = "SELECT * FROM alunos";

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            BeansBuscarAluno Alunos;

            while (rs.next()) {
                Alunos = new BeansBuscarAluno(rs.getString("Id_aluno"), rs.getString("nome"), rs.getString("sexo"), rs.getBytes("img"), rs.getInt("idade"));
                AlunosList.add(Alunos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return AlunosList;

    }

    public ImageIcon ResizeImage(String imagePath, byte[] pic) {

        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }

        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(LabelImage.getWidth(), LabelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;

    }

     public void ShowItem(int index) {

        LabelImage.setIcon(ResizeImage(null, getAlunosList().get(index).getImagem()));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopuMenu = new rojerusan.RSPopuMenu();
        PanelGradienteTabela = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomExcluir = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomEditar = new rsbuttoncustom.RSButtonCustom();
        jPanelAluno = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel3 = new javax.swing.JLabel();
        ComboMetroPesquisar = new rojerusan.RSComboMetro();
        MTextFullPesquisar = new rojeru_san.RSMTextFull();
        LabelImage = new rojerusan.RSLabelImage();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMetroBuscarAlunos = new rojerusan.RSTableMetro();

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

        setPreferredSize(new java.awt.Dimension(894, 750));

        jPanelAluno.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAluno.setPreferredSize(new java.awt.Dimension(884, 750));

        rSPanelShadow1.setPreferredSize(new java.awt.Dimension(884, 750));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(874, 750));

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel3.setText("    Alunos");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por:", "Codigo", "Nome", "Sexo", "Idade" }));
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

        LabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        LabelImage.setForeground(new java.awt.Color(255, 0, 0));
        LabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/people.png"))); // NOI18N
        LabelImage.setText("");
        LabelImage.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N

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

        TableMetroBuscarAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Sexo", "Idade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroBuscarAlunos.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        TableMetroBuscarAlunos.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroBuscarAlunos.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        TableMetroBuscarAlunos.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        TableMetroBuscarAlunos.setColorSelBackgound(new java.awt.Color(51, 51, 51));
        TableMetroBuscarAlunos.setComponentPopupMenu(PopuMenu);
        TableMetroBuscarAlunos.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        TableMetroBuscarAlunos.setFuenteFilas(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarAlunos.setFuenteFilasSelect(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroBuscarAlunos.setFuenteHead(new java.awt.Font("Georgia", 3, 15)); // NOI18N
        TableMetroBuscarAlunos.setSelectionBackground(new java.awt.Color(51, 51, 51));
        TableMetroBuscarAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMetroBuscarAlunosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMetroBuscarAlunos);

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MTextFullPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(rSPanelGradiente1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelAlunoLayout = new javax.swing.GroupLayout(jPanelAluno);
        jPanelAluno.setLayout(jPanelAlunoLayout);
        jPanelAlunoLayout.setHorizontalGroup(
            jPanelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelAlunoLayout.setVerticalGroup(
            jPanelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        
        LabelImage.setIcon( new ImageIcon(getClass().getResource("/img/people.png")));
        
        if (ComboMetroPesquisar.getSelectedItem().equals("Codigo")) {
            readtabelaForDescId(MTextFullPesquisar.getText());
        } else if (ComboMetroPesquisar.getSelectedItem().equals("Nome")) {
            readtabelaForDescNome(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Sexo")) {
            readtabelaForDescSexo(MTextFullPesquisar.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Idade")) {
            readtabelaForDescIdade(MTextFullPesquisar.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");

        }
    }//GEN-LAST:event_MTextFullPesquisarKeyReleased

    private void TableMetroBuscarAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMetroBuscarAlunosMouseClicked

        if ( TableMetroBuscarAlunos.getSelectedRow() != -1 ) {
             int index = TableMetroBuscarAlunos.getSelectedRow();
            ShowItem(index);
             for (BeansPesquisar pesq : pesquisas) {
                if (pesq.getId_aluno() == TableMetroBuscarAlunos.getValueAt(TableMetroBuscarAlunos.getSelectedRow(), 0)) {
                    this.pesquisa = pesq;
                }
            }
        }
    }//GEN-LAST:event_TableMetroBuscarAlunosMouseClicked

    private void ButtonCustomExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomExcluirActionPerformed
             if (TableMetroBuscarAlunos.getSelectedRow() != -1) {

            BeansBuscarAluno a = new BeansBuscarAluno();
            PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

            a.setId_aluno((String) TableMetroBuscarAlunos.getValueAt(TableMetroBuscarAlunos.getSelectedRow(), 0));

            dao.delete(a);

            readtabelaAluno();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um aluno para excluir!");
        }
    }//GEN-LAST:event_ButtonCustomExcluirActionPerformed

    private void ButtonCustomEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomEditarActionPerformed

        if(TableMetroBuscarAlunos.getSelectedRow() != -1){
            this.setEnabled(false);
        janelaPesquisar = new EditarAluno();
        janelaPesquisar.setVisible(true);

            janelaPesquisar.setCelular(this.pesquisa.getCelular());
            janelaPesquisar.setSexo(this.pesquisa.getSexo());
            janelaPesquisar.setUF(this.pesquisa.getUf());
            janelaPesquisar.setCpf(this.pesquisa.getCpf());
            janelaPesquisar.setData(this.pesquisa.getData_cadastro());
            janelaPesquisar.setDataNascimento(this.pesquisa.getData_nascimento());
            janelaPesquisar.setIdade(this.pesquisa.getIdade());
            janelaPesquisar.setBairro(this.pesquisa.getBairro());
            janelaPesquisar.setCidade(this.pesquisa.getCidade());
            janelaPesquisar.setEmail(this.pesquisa.getEmail());
            janelaPesquisar.setNome(this.pesquisa.getNome());
            janelaPesquisar.setNºDaCasa(this.pesquisa.getNºDaCasa());
            janelaPesquisar.setRua(this.pesquisa.getRua());
            janelaPesquisar.setObservacoes(this.pesquisa.getObservacao());
            janelaPesquisar.setTelefone(this.pesquisa.getTelefone());
            janelaPesquisar.setCep(this.pesquisa.getCep());
            janelaPesquisar.setNome(this.pesquisa.getNome());
            janelaPesquisar.setId(this.pesquisa.getId_aluno());
            janelaPesquisar.setFoto(this.pesquisa.getImagem());

        }
    }//GEN-LAST:event_ButtonCustomEditarActionPerformed

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed
        readtabelaAluno();
        LabelImage.setIcon( new ImageIcon(getClass().getResource("/img/people.png")));
        MTextFullPesquisar.setText("");
        ComboMetroPesquisar.setSelectedItem("Pesquisar por: ");
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttoncustom.RSButtonCustom ButtonCustomEditar;
    private rsbuttoncustom.RSButtonCustom ButtonCustomExcluir;
    private rojeru_san.RSButtonRiple ButtonRipleTodos;
    private rojerusan.RSComboMetro ComboMetroPesquisar;
    private rojerusan.RSLabelImage LabelImage;
    private rojeru_san.RSMTextFull MTextFullPesquisar;
    private rspanelgradiente.RSPanelGradiente PanelGradienteTabela;
    private rojerusan.RSPopuMenu PopuMenu;
    public static rojerusan.RSTableMetro TableMetroBuscarAlunos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelAluno;
    private javax.swing.JScrollPane jScrollPane2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
