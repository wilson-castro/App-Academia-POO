
package Frames;

import Beans.BeansAluno;
import Beans.BeansFuncionarios;
import Beans.BeansMatricula;
import Beans.BeansModalidades;
import DAO.AlunoDAO;
import DAO.MatriculaDAO;
import DAO.ModalidadesDAO;
import FadeEffect.FadeEffect;
import controle.conexao;
import static controle.conexao.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import paineis.Matricula;
import javax.swing.Timer;
import static paineis.PesquisarFuncionario.TableMetroBuscarFuncionarios;
import static paineis.PesquisarMatricula.TableMetroBuscarMatricula;

public class EditarMatricula extends javax.swing.JFrame implements Runnable{

    private BeansMatricula dados_matricula;

    static Connection con = null;

    EditarLançamentoConta enviarInformações;
    private Thread tempo = null;
    private Timer t;

    public void setDados_Matricula (BeansMatricula pesquisar) {
        this.dados_matricula = pesquisar;
    }
    public EditarMatricula() {
        initComponents();

        this.setLocationRelativeTo(null);

        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);

        MTextFullCodigoAluno.setEnabled(false);
        JLABELnome.setEnabled(false);
        JLABELcodigo_aluno.setEnabled(false);
        Data_matricula.setEnabled(false);
        MTextFullModalidade.setEnabled(false);
        JLABELmodalidade.setEnabled(false);
        JLABELcodigo_modalidade.setEnabled(false);
        JLABELpreço_modalidade.setEnabled(false);
        ComboMetroPagamento.setEnabled(false);
        jTextFieldId.setEnabled(false);
        
                //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();
    }
    
    
    public void setCodigoAluno(String CodigoAluno) {
        MTextFullCodigoAluno.setText(CodigoAluno);
    }

    public void setNome(String nome) {
        JLABELnome.setText(nome);
    }

    public void setLABELcodigo_aluno(String LABELcodigo_aluno) {
        JLABELcodigo_aluno.setText(LABELcodigo_aluno);
    }

    public void setModalidade(String modalidade) {
        MTextFullModalidade.setText(modalidade);
    }

    public void setLABELModalidade(String LABELModalidade) {
        JLABELmodalidade.setText(LABELModalidade);
    }

    public void setId_matricula(String id) {
        jTextFieldId.setText(id);
    }

    public void setCodigo_modalidade(String codigo_modalidade) {
        JLABELcodigo_modalidade.setText(codigo_modalidade);
    }

    public void setPreco(String preco) {
        JLABELpreço_modalidade.setText(preco);
    }


    public void setDataMtricula(String DataMtricula) {
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Data_matricula.setDate(frmt.parse(DataMtricula));
        } catch (ParseException ex) {
            Logger.getLogger(EditarMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVencimento(String vencimento){
        ComboMetroPagamento.setSelectedItem(vencimento);
    }
    
    ResultSet rs = null;
    Statement sr = null;
    
    public ArrayList<BeansMatricula> getProductList() {
        ArrayList<BeansMatricula> MatriculaList = new ArrayList<BeansMatricula>();
        Connection con = getConnection();
        String query = "SELECT * FROM matriculas";
        try {

            sr = con.createStatement();
            rs = sr.executeQuery(query);
            BeansMatricula Matricula;

            while (rs.next()) {
                Matricula = new BeansMatricula(
                        rs.getString("id"),
                        rs.getString("id_aluno"),
                        rs.getString("nome"),
                        rs.getString("id_modalidade"),
                        rs.getString("modalidade"),
                        rs.getFloat("valor"),
                        rs.getString("data"),
                        rs.getString("vencimento"));

                MatriculaList.add(Matricula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MatriculaList;
    }
    
     public void searchAluno(String id) {
           AlunoDAO dao = new AlunoDAO();

           BeansAluno result = dao.readForId(id);
           if (result != null) {
               JLABELnome.setText(result.getNome());
               JLABELcodigo_aluno.setText(result.getId_aluno());

           } else{
               JLABELnome.setText("- - - - - - - - - -");
               JLABELcodigo_aluno.setText("- - - - - - - - - -");
           }
       }
    
    public void searchModalidade(String id_modalidade) {
           ModalidadesDAO dao = new ModalidadesDAO();

           BeansModalidades result = dao.readForId(id_modalidade);
           if (result != null) {
               JLABELpreço_modalidade.setText(Float.toString(result.getPreço()));
               JLABELmodalidade.setText(result.getModalidades());
               JLABELcodigo_modalidade.setText(result.getId_modalidade());
               
           } else{
               JLABELmodalidade.setText("- - - - - - - - - -");
               JLABELcodigo_modalidade.setText("- - - - - - - - - -");
               JLABELpreço_modalidade.setText("- - - - - - - - - -");
           }
       }   
    
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

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel2 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        JLABELnome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JLABELcodigo_aluno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLABELmodalidade = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLABELcodigo_modalidade = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        JLABELpreço_modalidade = new javax.swing.JLabel();
        jLabel352 = new javax.swing.JLabel();
        Data_matricula = new com.toedter.calendar.JDateChooser();
        jLabelNome = new javax.swing.JLabel();
        jLabelpagamento = new javax.swing.JLabel();
        jLabelCodigoModalidades = new javax.swing.JLabel();
        jLabelCodigoAluno = new javax.swing.JLabel();
        jLabelCodigoAluno2 = new javax.swing.JLabel();
        jLabelCodigoModalidade2 = new javax.swing.JLabel();
        jLabelModalidade = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        MTextFullCodigoAluno = new rojeru_san.RSMTextFull();
        ButtonRipleAluno = new rojeru_san.RSButtonRiple();
        MTextFullModalidade = new rojeru_san.RSMTextFull();
        ButtonRipleAluno1 = new rojeru_san.RSButtonRiple();
        ComboMetroPagamento = new rojerusan.RSComboMetro();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        ButtonRipleLimpar = new rojeru_san.RSButtonRiple();
        ButtonRipleSalvar = new rojeru_san.RSButtonRiple();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        ButtonRipleEditar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 550));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        JLABELnome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELnome.setText("- - - - - - - - - - - -");

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel6.setText("Codigo:");

        JLABELcodigo_aluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");

        jLabel5.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel5.setText("Modalidade:");

        JLABELmodalidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELmodalidade.setText("- - - - - - - - - - - - - ");

        jLabel7.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel7.setText("Codigo:");

        JLABELcodigo_modalidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_modalidade.setText("- - - - - - - - - - - - - ");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel8.setText("Valor R$:");

        JLABELpreço_modalidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELpreço_modalidade.setText("- - - - - - - - - - - - -");

        jLabel352.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel352.setText("Data do matricula:");

        Data_matricula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Data_matricula.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        jLabelNome.setForeground(new java.awt.Color(255, 0, 0));

        jLabelpagamento.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoModalidades.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoAluno.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoAluno2.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoModalidade2.setForeground(new java.awt.Color(255, 0, 0));

        jLabelModalidade.setForeground(new java.awt.Color(255, 0, 0));

        jLabelPreco.setForeground(new java.awt.Color(255, 0, 0));

        MTextFullCodigoAluno.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullCodigoAluno.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullCodigoAluno.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullCodigoAluno.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullCodigoAluno.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        MTextFullCodigoAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullCodigoAluno.setModoMaterial(true);
        MTextFullCodigoAluno.setPlaceholder("Codigo do aluno...");
        MTextFullCodigoAluno.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullCodigoAlunoKeyReleased(evt);
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

        MTextFullModalidade.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullModalidade.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullModalidade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullModalidade.setModoMaterial(true);
        MTextFullModalidade.setPlaceholder("Codigo do modalidade...");
        MTextFullModalidade.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullModalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullModalidadeKeyReleased(evt);
            }
        });

        ButtonRipleAluno1.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleAluno1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));
        ButtonRipleAluno1.setText("...");
        ButtonRipleAluno1.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleAluno1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleAluno1ActionPerformed(evt);
            }
        });

        ComboMetroPagamento.setEditable(true);
        ComboMetroPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia do pagamento", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ComboMetroPagamento.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroPagamento.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroPagamento.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroPagamento.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ComboMetroPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMetroPagamentoItemStateChanged(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Matricula");

        jTextFieldId.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jTextFieldId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldId.setOpaque(false);
        jTextFieldId.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(MTextFullCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Data_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel352)))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCodigoModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonRipleAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JLABELpreço_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLABELmodalidade))
                                        .addGap(7, 7, 7)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelCodigoModalidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JLABELcodigo_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(ComboMetroPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonRipleSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addGap(110, 110, 110)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MTextFullCodigoAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel352, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Data_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLABELnome)
                            .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MTextFullModalidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonRipleAluno1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCodigoModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabelCodigoModalidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLABELmodalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLABELcodigo_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLABELpreço_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboMetroPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRipleSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, Short.MAX_VALUE)
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

    private void MTextFullCodigoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullCodigoAlunoKeyReleased
        jLabelCodigoAluno.setText("");

        if (!MTextFullCodigoAluno.getText().isEmpty()) {
            searchAluno(MTextFullCodigoAluno.getText());
        } else{
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFullCodigoAlunoKeyReleased

    private void ButtonRipleAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAlunoActionPerformed
        new TabelaAlunos().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAlunoActionPerformed

    private void MTextFullModalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullModalidadeKeyReleased
        jLabelCodigoModalidades.setText("");

        if (!MTextFullModalidade.getText().isEmpty()) {
            searchModalidade(MTextFullModalidade.getText());
        } else{
            JLABELmodalidade.setText("- - - - - - - - - -");
            JLABELcodigo_modalidade.setText("- - - - - - - - - -");
            JLABELpreço_modalidade.setText("- - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFullModalidadeKeyReleased

    private void ButtonRipleAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAluno1ActionPerformed
        new TabelaModalidades().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAluno1ActionPerformed

    private void ComboMetroPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMetroPagamentoItemStateChanged
        jLabelpagamento.setText("");
    }//GEN-LAST:event_ComboMetroPagamentoItemStateChanged

    private void ButtonRipleLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLimparActionPerformed
        MTextFullModalidade.setText("");
        MTextFullCodigoAluno.setText("");
        JLABELnome.setText("- - - - - - - - - - - -");
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");
        JLABELmodalidade.setText("- - - - - - - - - - - - - ");
        JLABELcodigo_modalidade.setText("- - - - - - - - - - - - - ");
        JLABELpreço_modalidade.setText("- - - - - - - - - - - - -");
        ComboMetroPagamento.setSelectedItem("Dia do pagamento");
    }//GEN-LAST:event_ButtonRipleLimparActionPerformed

    private void ButtonRipleSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleSalvarActionPerformed

        if(MTextFullCodigoAluno.getText().trim().isEmpty()){
            jLabelCodigoAluno.setText("*");
        }
        if(MTextFullModalidade.getText().trim().isEmpty()){
            jLabelCodigoModalidades.setText("*");
        }
        if(JLABELcodigo_aluno.getText().equals("- - - - - - - - - -")){
            jLabelCodigoAluno2.setText("*");
        }
        if(JLABELcodigo_modalidade.getText().equals("- - - - - - - - - -")){
            jLabelCodigoModalidade2.setText("*");
        }
        if(JLABELnome.getText().equals("- - - - - - - - - -")){
            jLabelNome.setText("*");
        }
        if(MTextFullModalidade.getText().equals("- - - - - - - - - -")){
            jLabelModalidade.setText("*");
        }
        if(JLABELpreço_modalidade.getText().equals("- - - - - - - - - -")){
            jLabelPreco.setText("*");
        }
        if(ComboMetroPagamento.getSelectedItem().equals("Dia do pagamento: ")){
            jLabelpagamento.setText("*");
        }

        else{
            BeansMatricula matri = new BeansMatricula();
            MatriculaDAO dao = new MatriculaDAO();
            
            matri.setId(jTextFieldId.getText());
            matri.setId_aluno(JLABELcodigo_aluno.getText());
            matri.setNome(JLABELnome.getText());
            matri.setId_modalidade(JLABELcodigo_modalidade.getText());
            matri.setModalidade(JLABELmodalidade.getText());
            matri.setValor(Float.parseFloat(JLABELpreço_modalidade.getText()));

            SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
            String date = dc.format(Data_matricula.getDate());
            matri.setVencimento((String) ComboMetroPagamento.getSelectedItem());
            matri.setData(date);

            dao.update(matri);

            if(enviarInformações == null){
                SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

                enviarInformações = new EditarLançamentoConta();
                enviarInformações.setVisible(true);

                enviarInformações.recebendo_aluno(JLABELcodigo_aluno.getText());
                enviarInformações.recebendo_nome(JLABELnome.getText());
                enviarInformações.recebendo_codigo(JLABELcodigo_aluno.getText());
                enviarInformações.recebendo_modalidade(JLABELmodalidade.getText());
                enviarInformações.recebendo_preço(JLABELpreço_modalidade.getText());
                try {
                    enviarInformações.recebendo_data(format1.parse(ComboMetroPagamento.getSelectedItem()+format2.format(new Date()).substring(2, 10)));
                } catch (ParseException ex) {
                    Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                this.setVisible(false);
                readtabela_matricula();

            }
        }
    }//GEN-LAST:event_ButtonRipleSalvarActionPerformed

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(EditarModalidade.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    private void ButtonRipleEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleEditarActionPerformed
        
        MTextFullCodigoAluno.setEnabled(true);
        JLABELnome.setEnabled(true);
        JLABELcodigo_aluno.setEnabled(true);
        Data_matricula.setEnabled(true);
        MTextFullModalidade.setEnabled(true);
        JLABELmodalidade.setEnabled(true);
        JLABELcodigo_modalidade.setEnabled(true);
        JLABELpreço_modalidade.setEnabled(true);
        ComboMetroPagamento.setEnabled(true);
        jTextFieldId.setEnabled(true);
    }//GEN-LAST:event_ButtonRipleEditarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleAluno;
    private rojeru_san.RSButtonRiple ButtonRipleAluno1;
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleEditar;
    private rojeru_san.RSButtonRiple ButtonRipleLimpar;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private rojeru_san.RSButtonRiple ButtonRipleSalvar;
    public static rojerusan.RSComboMetro ComboMetroPagamento;
    public static com.toedter.calendar.JDateChooser Data_matricula;
    public static javax.swing.JLabel JLABELcodigo_aluno;
    public static javax.swing.JLabel JLABELcodigo_modalidade;
    public static javax.swing.JLabel JLABELmodalidade;
    public static javax.swing.JLabel JLABELnome;
    public static javax.swing.JLabel JLABELpreço_modalidade;
    public static rojeru_san.RSMTextFull MTextFullCodigoAluno;
    public static rojeru_san.RSMTextFull MTextFullModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCodigoAluno;
    private javax.swing.JLabel jLabelCodigoAluno2;
    private javax.swing.JLabel jLabelCodigoModalidade2;
    private javax.swing.JLabel jLabelCodigoModalidades;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelpagamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextField jTextFieldId;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
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
