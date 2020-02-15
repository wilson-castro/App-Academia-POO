package Frames;

import CPF.CPF;
import static Frames.EditarAluno.Celular;
import static Frames.EditarAluno.ComboMetroSexo;
import static Frames.EditarAluno.ComboMetroUF;
import static Frames.EditarAluno.Cpf;
import static Frames.EditarAluno.Data_cadastro;
import static Frames.EditarAluno.Data_nascimento;
import static Frames.EditarAluno.Idade;
import static Frames.EditarAluno.MTextFullBairro;
import static Frames.EditarAluno.MTextFullCidade;
import static Frames.EditarAluno.MTextFullEmail;
import static Frames.EditarAluno.MTextFullNome;
import static Frames.EditarAluno.MTextFullNºDaCasa;
import static Frames.EditarAluno.MTextFullRua;
import static Frames.EditarAluno.Observacoes;
import static Frames.EditarAluno.Telefone;
import static Frames.EditarAluno.jFormattedTextFieldCep;
import paineis.CadastroAlunos;
import Beans.BeansAluno;
import Beans.BeansPesquisar;
import DAO.PesquisarDAO;
import FadeEffect.FadeEffect;
import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPException;
import controle.conexao;
import static controle.conexao.getConnection;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import necesario.RSAWTUtilities;
import static paineis.PesquisarAluno.TableMetroBuscarAlunos;

public class EditarAluno extends javax.swing.JFrame implements Runnable {

    private BeansPesquisar dados_aluno;

    private Thread tempo = null;
    private Timer t;

    public void setDados_aluno(BeansPesquisar pesquisar) {
        this.dados_aluno = pesquisar;
    }

    public EditarAluno() {
        initComponents();
        this.setLocationRelativeTo(null);

        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);

        jTextFieldId.setEnabled(false);
        Idade.setEnabled(false);
        MTextFullNome.setEnabled(false);
        Data_cadastro.setEnabled(false);
        Data_nascimento.setEnabled(false);
        Cpf.setEnabled(false);
        ComboMetroSexo.setEnabled(false);
        jFormattedTextFieldCep.setEnabled(false);
        MTextFullCidade.setEnabled(false);
        MTextFullBairro.setEnabled(false);
        MTextFullRua.setEnabled(false);
        ComboMetroUF.setEnabled(false);
        MTextFullNºDaCasa.setEnabled(false);
        Celular.setEnabled(false);
        Telefone.setEnabled(false);
        MTextFullEmail.setEnabled(false);
        Observacoes.setEnabled(false);

        FotoSquareResize.setColorBorde(Color.GRAY);
        FotoSquareResize.setColorBotonRemover(Color.GRAY);

        //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();
    }

    public void setCelular(String celular) {
        Celular.setText(celular);
    }

    public void setSexo(String sexo) {
        ComboMetroSexo.setSelectedItem(sexo);
    }

    public void setUF(String uf) {
        ComboMetroUF.setSelectedItem(uf);
    }

    public void setCpf(String cpf) {
        Cpf.setText(cpf);
    }

    public void setData(String data) {
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Data_cadastro.setDate(frmt.parse(data));
        } catch (ParseException ex) {
            Logger.getLogger(EditarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDataNascimento(String DataNascimento) {
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Data_nascimento.setDate(frmt.parse(DataNascimento));
        } catch (ParseException ex) {
            Logger.getLogger(EditarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setIdade(String idade) {
        Idade.setText(idade);
    }

    public void setBairro(String bairro) {
        MTextFullBairro.setText(bairro);
    }

    public void setCidade(String cidade) {
        MTextFullCidade.setText(cidade);
    }

    public void setEmail(String email) {
        MTextFullEmail.setText(email);
    }

    public void setNome(String nome) {
        MTextFullNome.setText(nome);
    }

    public void setNºDaCasa(String NºDaCasa) {
        MTextFullNºDaCasa.setText(NºDaCasa);
    }

    public void setRua(String rua) {
        MTextFullRua.setText(rua);
    }

    public void setObservacoes(String Observacões) {
        Observacoes.setText(Observacões);
    }

    public void setTelefone(String telefone) {
        Telefone.setText(telefone);
    }

    public void setCep(String cep) {
        jFormattedTextFieldCep.setText(cep);
    }

    public void setId(String Id) {
        jTextFieldId.setText(Id);
    }

    public void setFoto(byte[] img) {
        FotoSquareResize.setImagenDefault(new ImageIcon(img));

    }

    ResultSet rs = null;
    Statement sr = null;

    String ImgPath = null;

    public ArrayList<BeansAluno> getProductList() {
        ArrayList<BeansAluno> productList = new ArrayList<BeansAluno>();
        Connection con = getConnection();
        String query = "SELECT * FROM alunos";
        try {

            sr = con.createStatement();
            rs = sr.executeQuery(query);
            BeansAluno product;

            while (rs.next()) {
                product = new BeansAluno(
                        rs.getString("id_aluno"),
                        rs.getString("data_cadastro"),
                        rs.getString("nome"),
                        rs.getString("data_nascimento"),
                        rs.getString("sexo"),
                        rs.getString("cpf"),
                        rs.getString("rua"),
                        rs.getString("NºDaCasa"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("cep"),
                        rs.getString("uf"),
                        rs.getString("telefone"),
                        rs.getString("celular"),
                        rs.getString("observacoes"),
                        rs.getString("email"),
                        rs.getBytes("img"),
                        rs.getInt("idade"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    public int calculaIdade(Date dataNascimento, Date dataHoje) throws ParseException {
        long tempoNascimento = dataNascimento.getTime();
        long tempoHoje = dataHoje.getTime();

        return (int) (((tempoHoje - tempoNascimento) + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) / 365;
    }

    public void readtabelaAluno() {
        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroBuscarAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarDAO dao = new PesquisarDAO();

        for (BeansPesquisar pesquisarAluno : dao.readAll()) {
            buscarAluno.addRow(new Object[]{
                pesquisarAluno.getId_aluno(),
                pesquisarAluno.getNome(),
                pesquisarAluno.getSexo(),
                pesquisarAluno.getIdade(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        dt_cad = new javax.swing.JLabel();
        Cel_lbl = new javax.swing.JLabel();
        Cpf_label = new javax.swing.JLabel();
        jLabel352 = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        Data_cadastro = new com.toedter.calendar.JDateChooser();
        Celular = new javax.swing.JFormattedTextField();
        Idade = new javax.swing.JTextField();
        jLabel354 = new javax.swing.JLabel();
        jLabel364 = new javax.swing.JLabel();
        Cpf = new javax.swing.JFormattedTextField();
        jLabel355 = new javax.swing.JLabel();
        Data_nascimento = new com.toedter.calendar.JDateChooser();
        Dt_nasc = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        Telefone = new javax.swing.JFormattedTextField();
        Tel_lbl = new javax.swing.JLabel();
        Email_lbl = new javax.swing.JLabel();
        jLabel367 = new javax.swing.JLabel();
        Observacoes = new javax.swing.JTextArea();
        Obs_lbl = new javax.swing.JLabel();
        Sexo_lbl = new javax.swing.JLabel();
        MTextFullNome = new rojeru_san.RSMTextFull();
        jTextFieldId = new javax.swing.JTextField();
        ComboMetroSexo = new rojerusan.RSComboMetro();
        jLabelAlertaCEP = new javax.swing.JLabel();
        jLabelCEP = new javax.swing.JLabel();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        MTextFullCidade = new rojeru_san.RSMTextFull();
        jLabelAlertaCiadade = new javax.swing.JLabel();
        MTextFullRua = new rojeru_san.RSMTextFull();
        jLabelAlertaRua = new javax.swing.JLabel();
        MTextFullBairro = new rojeru_san.RSMTextFull();
        MTextFullNºDaCasa = new rojeru_san.RSMTextFull();
        jLabelAlertaUF = new javax.swing.JLabel();
        ButtonRipleBuscarCep = new rojeru_san.RSButtonRiple();
        ButtonRipleBuscarEndereço = new rojeru_san.RSButtonRiple();
        ComboMetroUF = new rojerusan.RSComboMetro();
        jLabelAlertaBairro = new javax.swing.JLabel();
        jLabelAlertaNºDaCasa = new javax.swing.JLabel();
        MTextFullEmail = new rojeru_san.RSMTextFull();
        FotoSquareResize = new rojerusan.RSFotoSquareResize();
        jLabel1 = new javax.swing.JLabel();
        ButtonRipleLimpar = new rojeru_san.RSButtonRiple();
        jLabelAlertaFoto = new javax.swing.JLabel();
        ButtonRipleAtualizar = new rojeru_san.RSButtonRiple();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        ButtonRipleEditar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 750));

        jScrollPane2.setBorder(null);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(880, 723));
        jScrollPane2.setVerifyInputWhenFocusTarget(false);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(555, 750));
        jPanel23.setRequestFocusEnabled(false);
        jPanel23.setVerifyInputWhenFocusTarget(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(894, 723));

        dt_cad.setBackground(new java.awt.Color(255, 255, 255));
        dt_cad.setFont(new java.awt.Font("Georgia", 3, 20)); // NOI18N
        dt_cad.setForeground(new java.awt.Color(255, 51, 51));
        dt_cad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dt_cad.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Cel_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Cel_lbl.setForeground(new java.awt.Color(255, 51, 51));
        Cel_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cel_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Cel_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Cpf_label.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Cpf_label.setForeground(new java.awt.Color(255, 51, 51));
        Cpf_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cpf_label.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Cpf_label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel352.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel352.setText("Data do cadastro:");

        name_lbl.setBackground(new java.awt.Color(255, 255, 255));
        name_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        name_lbl.setForeground(new java.awt.Color(255, 51, 51));
        name_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        name_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Data_cadastro.setBackground(new java.awt.Color(255, 255, 255));
        Data_cadastro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Data_cadastro.setAutoscrolls(true);
        Data_cadastro.setDoubleBuffered(false);
        Data_cadastro.setFocusable(false);
        Data_cadastro.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        Celular.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Celular.setCaretColor(new java.awt.Color(102, 102, 102));
        Celular.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        Celular.setDoubleBuffered(true);
        Celular.setDragEnabled(true);
        Celular.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Celular.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        Celular.setSelectionColor(new java.awt.Color(0, 0, 0));
        Celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CelularKeyReleased(evt);
            }
        });

        Idade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Idade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Idade.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Idade.setCaretColor(new java.awt.Color(102, 102, 102));
        Idade.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        Idade.setDoubleBuffered(true);
        Idade.setDragEnabled(true);
        Idade.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel354.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel354.setText("Data de nascimento:");

        jLabel364.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel364.setText("Celular:");

        Cpf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Cpf.setCaretColor(new java.awt.Color(102, 102, 102));
        Cpf.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        Cpf.setDoubleBuffered(true);
        Cpf.setDragEnabled(true);
        Cpf.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        Cpf.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Cpf.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        Cpf.setSelectionColor(new java.awt.Color(0, 0, 0));
        Cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CpfKeyReleased(evt);
            }
        });

        jLabel355.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel355.setText("Idade:");

        Data_nascimento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Data_nascimento.setDoubleBuffered(false);
        Data_nascimento.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Data_nascimento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Data_nascimentoPropertyChange(evt);
            }
        });

        Dt_nasc.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Dt_nasc.setForeground(new java.awt.Color(255, 51, 51));
        Dt_nasc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Dt_nasc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Dt_nasc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel356.setFont(new java.awt.Font("Georgia", 2, 15)); // NOI18N
        jLabel356.setText("C.P.F:");

        jLabel365.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel365.setText("Telefone:");

        Telefone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Telefone.setCaretColor(new java.awt.Color(102, 102, 102));
        Telefone.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        Telefone.setDoubleBuffered(true);
        Telefone.setDragEnabled(true);
        Telefone.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Telefone.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        Telefone.setSelectionColor(new java.awt.Color(0, 0, 0));
        Telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelefoneKeyReleased(evt);
            }
        });

        Tel_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Tel_lbl.setForeground(new java.awt.Color(255, 51, 51));
        Tel_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Tel_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Tel_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Email_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Email_lbl.setForeground(new java.awt.Color(255, 51, 51));
        Email_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Email_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel367.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel367.setText("Observações:");

        Observacoes.setColumns(20);
        Observacoes.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        Observacoes.setRows(5);
        Observacoes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Observacoes.setCaretColor(new java.awt.Color(102, 102, 102));
        Observacoes.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        Observacoes.setDoubleBuffered(true);
        Observacoes.setDragEnabled(true);
        Observacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ObservacoesKeyReleased(evt);
            }
        });

        Obs_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Obs_lbl.setForeground(new java.awt.Color(255, 51, 51));
        Obs_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Obs_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Obs_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Sexo_lbl.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        Sexo_lbl.setForeground(new java.awt.Color(255, 51, 51));
        Sexo_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Sexo_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Sexo_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        MTextFullNome.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullNome.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullNome.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullNome.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullNome.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullNome.setDoubleBuffered(true);
        MTextFullNome.setDragEnabled(true);
        MTextFullNome.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullNome.setModoMaterial(true);
        MTextFullNome.setPlaceholder("Nome completo...");
        MTextFullNome.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullNomeKeyReleased(evt);
            }
        });

        jTextFieldId.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jTextFieldId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldId.setCaretColor(new java.awt.Color(102, 102, 102));
        jTextFieldId.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jTextFieldId.setDragEnabled(true);
        jTextFieldId.setSelectionColor(new java.awt.Color(0, 0, 0));

        ComboMetroSexo.setEditable(true);
        ComboMetroSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o sexo", "Feminino", "Masculino", "Outros" }));
        ComboMetroSexo.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroSexo.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroSexo.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroSexo.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ComboMetroSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMetroSexoItemStateChanged(evt);
            }
        });

        jLabelAlertaCEP.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaCEP.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaCEP.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaCEP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaCEP.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaCEP.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaCEP.setPreferredSize(new java.awt.Dimension(10, 10));

        jLabelCEP.setFont(new java.awt.Font("Georgia", 2, 15)); // NOI18N
        jLabelCEP.setText("C.E.P:");

        jFormattedTextFieldCep.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            jFormattedTextFieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCep.setToolTipText("");
        jFormattedTextFieldCep.setCaretColor(new java.awt.Color(102, 102, 102));
        jFormattedTextFieldCep.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jFormattedTextFieldCep.setDoubleBuffered(true);
        jFormattedTextFieldCep.setDragEnabled(true);
        jFormattedTextFieldCep.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jFormattedTextFieldCep.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jFormattedTextFieldCep.setName(""); // NOI18N
        jFormattedTextFieldCep.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        jFormattedTextFieldCep.setSelectionColor(new java.awt.Color(0, 0, 0));
        jFormattedTextFieldCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCepKeyReleased(evt);
            }
        });

        MTextFullCidade.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullCidade.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullCidade.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullCidade.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullCidade.setCaretColor(new java.awt.Color(102, 102, 102));
        MTextFullCidade.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullCidade.setDoubleBuffered(true);
        MTextFullCidade.setDragEnabled(true);
        MTextFullCidade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullCidade.setModoMaterial(true);
        MTextFullCidade.setPlaceholder("Cidade...");
        MTextFullCidade.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullCidadeKeyReleased(evt);
            }
        });

        jLabelAlertaCiadade.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaCiadade.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaCiadade.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaCiadade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaCiadade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaCiadade.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaCiadade.setPreferredSize(new java.awt.Dimension(10, 10));

        MTextFullRua.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullRua.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullRua.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullRua.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullRua.setCaretColor(new java.awt.Color(102, 102, 102));
        MTextFullRua.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullRua.setDoubleBuffered(true);
        MTextFullRua.setDragEnabled(true);
        MTextFullRua.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullRua.setModoMaterial(true);
        MTextFullRua.setPlaceholder("Rua...");
        MTextFullRua.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullRuaKeyReleased(evt);
            }
        });

        jLabelAlertaRua.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaRua.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaRua.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaRua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaRua.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaRua.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaRua.setPreferredSize(new java.awt.Dimension(10, 10));

        MTextFullBairro.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullBairro.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullBairro.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullBairro.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullBairro.setCaretColor(new java.awt.Color(102, 102, 102));
        MTextFullBairro.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullBairro.setDoubleBuffered(true);
        MTextFullBairro.setDragEnabled(true);
        MTextFullBairro.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullBairro.setModoMaterial(true);
        MTextFullBairro.setPlaceholder("Bairro...");
        MTextFullBairro.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullBairroKeyReleased(evt);
            }
        });

        MTextFullNºDaCasa.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullNºDaCasa.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullNºDaCasa.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullNºDaCasa.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullNºDaCasa.setCaretColor(new java.awt.Color(102, 102, 102));
        MTextFullNºDaCasa.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullNºDaCasa.setDoubleBuffered(true);
        MTextFullNºDaCasa.setDragEnabled(true);
        MTextFullNºDaCasa.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullNºDaCasa.setModoMaterial(true);
        MTextFullNºDaCasa.setPlaceholder("N°...");
        MTextFullNºDaCasa.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullNºDaCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullNºDaCasaKeyReleased(evt);
            }
        });

        jLabelAlertaUF.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaUF.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaUF.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaUF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaUF.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaUF.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaUF.setPreferredSize(new java.awt.Dimension(10, 10));

        ButtonRipleBuscarCep.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleBuscarCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleBuscarCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifying-glass-searcher.png"))); // NOI18N
        ButtonRipleBuscarCep.setText(" C.E.P");
        ButtonRipleBuscarCep.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleBuscarCep.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleBuscarCep.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ButtonRipleBuscarCep.setIconTextGap(5);
        ButtonRipleBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleBuscarCepActionPerformed(evt);
            }
        });

        ButtonRipleBuscarEndereço.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleBuscarEndereço.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleBuscarEndereço.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/magnifying-glass-searcher.png"))); // NOI18N
        ButtonRipleBuscarEndereço.setText("Endereço");
        ButtonRipleBuscarEndereço.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleBuscarEndereço.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleBuscarEndereço.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ButtonRipleBuscarEndereço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleBuscarEndereçoActionPerformed(evt);
            }
        });

        ComboMetroUF.setEditable(true);
        ComboMetroUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UF", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        ComboMetroUF.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroUF.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroUF.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroUF.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ComboMetroUF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMetroUFItemStateChanged(evt);
            }
        });

        jLabelAlertaBairro.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaBairro.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaBairro.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaBairro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaBairro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaBairro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaBairro.setPreferredSize(new java.awt.Dimension(10, 10));

        jLabelAlertaNºDaCasa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaNºDaCasa.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaNºDaCasa.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaNºDaCasa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaNºDaCasa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaNºDaCasa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaNºDaCasa.setPreferredSize(new java.awt.Dimension(10, 10));

        MTextFullEmail.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullEmail.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullEmail.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullEmail.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullEmail.setCaretColor(new java.awt.Color(102, 102, 102));
        MTextFullEmail.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        MTextFullEmail.setDragEnabled(true);
        MTextFullEmail.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullEmail.setModoMaterial(true);
        MTextFullEmail.setPlaceholder("E - mail...");
        MTextFullEmail.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullEmailKeyReleased(evt);
            }
        });

        FotoSquareResize.setColorBotonRemover(new java.awt.Color(0, 0, 0));
        FotoSquareResize.setEnabled(false);
        FotoSquareResize.setImagenDefault(new javax.swing.ImageIcon(getClass().getResource("/img/people.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Editar de Aluno");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

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

        jLabelAlertaFoto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAlertaFoto.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        jLabelAlertaFoto.setForeground(new java.awt.Color(255, 51, 51));
        jLabelAlertaFoto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlertaFoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelAlertaFoto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabelAlertaFoto.setPreferredSize(new java.awt.Dimension(10, 10));

        ButtonRipleAtualizar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleAtualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleAtualizar.setText("Salvar");
        ButtonRipleAtualizar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleAtualizar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleAtualizarActionPerformed(evt);
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
                .addGap(31, 31, 31)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel367)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Obs_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabelCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAlertaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel364)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cel_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel365)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Tel_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(MTextFullEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Email_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(MTextFullRua, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAlertaRua, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboMetroUF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAlertaUF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MTextFullNºDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAlertaNºDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonRipleBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonRipleBuscarEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addGap(174, 174, 174)
                                            .addComponent(Data_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addComponent(jLabel356)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Cpf_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addComponent(Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(ComboMetroSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Sexo_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(Data_cadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                                                    .addComponent(jLabel352)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dt_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel354)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Dt_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel355)
                                                .addComponent(Idade, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(MTextFullNome, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(name_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FotoSquareResize, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelAlertaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                                    .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(MTextFullCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelAlertaCiadade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(MTextFullBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelAlertaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(Observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonRipleAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MTextFullNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(name_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel352, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dt_cad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel355)
                                        .addGap(7, 7, 7)
                                        .addComponent(Idade))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(Dt_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2))
                                            .addComponent(jLabel354, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Data_nascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(24, 24, 24)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cpf_label, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel356))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sexo_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboMetroSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelAlertaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FotoSquareResize, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCEP)
                    .addComponent(jLabelAlertaCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAlertaBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MTextFullBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MTextFullCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAlertaUF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MTextFullNºDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboMetroUF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonRipleBuscarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonRipleBuscarEndereço, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelAlertaNºDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MTextFullRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAlertaRua, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelAlertaCiadade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel365, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel364, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cel_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tel_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Telefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(MTextFullEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Email_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel367, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Obs_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonRipleAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Observacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CelularKeyReleased
        Cel_lbl.setText("");
    }//GEN-LAST:event_CelularKeyReleased

    private void CpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CpfKeyReleased
        Cpf_label.setText("");
    }//GEN-LAST:event_CpfKeyReleased

    private void Data_nascimentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Data_nascimentoPropertyChange
        Dt_nasc.setText("");

        DateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");

        if (Data_nascimento.getDate() != null) {
            try {
                Idade.setText(String.valueOf(calculaIdade(Data_nascimento.getDate(), new Date()) + " anos"));
            } catch (ParseException ex) {
                Logger.getLogger(CadastroAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Data_nascimentoPropertyChange

    private void TelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefoneKeyReleased
        Tel_lbl.setText("");
    }//GEN-LAST:event_TelefoneKeyReleased

    private void ObservacoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ObservacoesKeyReleased
        Obs_lbl.setText("");
    }//GEN-LAST:event_ObservacoesKeyReleased

    private void MTextFullNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullNomeKeyReleased
        name_lbl.setText("");
    }//GEN-LAST:event_MTextFullNomeKeyReleased

    private void ComboMetroSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMetroSexoItemStateChanged
        Sexo_lbl.setText("");
    }//GEN-LAST:event_ComboMetroSexoItemStateChanged

    private void jFormattedTextFieldCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCepKeyReleased

        if (jFormattedTextFieldCep.getText().equals("      -   ")) {
            MTextFullCidade.setText("");
            MTextFullBairro.setText("");
            MTextFullRua.setText("");
            ComboMetroUF.setSelectedItem("UF");
            MTextFullNºDaCasa.setText("");
        }

        jLabelAlertaCiadade.setText("");

        jLabelAlertaRua.setText("");

        jLabelAlertaCEP.setText("");

        jLabelAlertaUF.setText("");

        jLabelAlertaBairro.setText("");
    }//GEN-LAST:event_jFormattedTextFieldCepKeyReleased

    private void MTextFullCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullCidadeKeyReleased

        jLabelAlertaCiadade.setText("");

        jLabelAlertaRua.setText("");

        jLabelAlertaCEP.setText("");

        jLabelAlertaUF.setText("");

        jLabelAlertaBairro.setText("");
    }//GEN-LAST:event_MTextFullCidadeKeyReleased

    private void MTextFullRuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullRuaKeyReleased

        jLabelAlertaBairro.setText("");

        jLabelAlertaCiadade.setText("");

        jLabelAlertaRua.setText("");

        jLabelAlertaCEP.setText("");

        jLabelAlertaUF.setText("");
    }//GEN-LAST:event_MTextFullRuaKeyReleased

    private void MTextFullBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullBairroKeyReleased

        jLabelAlertaCiadade.setText("");

        jLabelAlertaRua.setText("");

        jLabelAlertaCEP.setText("");

        jLabelAlertaUF.setText("");

        jLabelAlertaBairro.setText("");
    }//GEN-LAST:event_MTextFullBairroKeyReleased

    private void MTextFullNºDaCasaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullNºDaCasaKeyReleased
        jLabelAlertaNºDaCasa.setText("");
    }//GEN-LAST:event_MTextFullNºDaCasaKeyReleased

    private void ButtonRipleBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleBuscarCepActionPerformed
        if (MTextFullCidade.getText().equals("")) {
            jLabelAlertaCiadade.setText("*");
        }
        if (MTextFullRua.getText().equals("")) {
            jLabelAlertaRua.setText("*");
        }
        if (ComboMetroUF.getSelectedItem().equals("UF")) {
            jLabelAlertaUF.setText("*");
        }

        if (jLabelAlertaCiadade.getText().equals("*") && jLabelAlertaRua.getText().equals("*") && jLabelAlertaUF.getText().equals("*")) {
            jLabelAlertaCEP.setText("");
        }

        ViaCEP viaCEP = new ViaCEP();

        try {
            viaCEP.buscarCEP((String) ComboMetroUF.getSelectedItem(), MTextFullCidade.getText(), MTextFullRua.getText());
            jFormattedTextFieldCep.setText(viaCEP.getCep());
        } catch (ViaCEPException e) {
            java.util.logging.Logger.getLogger(CadastroAlunos.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
            jFormattedTextFieldCep.setText("");
        }
    }//GEN-LAST:event_ButtonRipleBuscarCepActionPerformed

    private void ButtonRipleBuscarEndereçoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleBuscarEndereçoActionPerformed

        if (jFormattedTextFieldCep.getText().equals("     -   ")) {
            jLabelAlertaCEP.setText("*");
        }

        if (jLabelAlertaCEP.getText().equals("*")) {
            jLabelAlertaCiadade.setText("");
            jLabelAlertaRua.setText("");
            jLabelAlertaUF.setText("");

        }

        ViaCEP viaCEP = new ViaCEP();

        try {
            viaCEP.buscar(jFormattedTextFieldCep.getText());
            MTextFullCidade.setText(viaCEP.getLocalidade());
            MTextFullBairro.setText(viaCEP.getBairro());
            MTextFullRua.setText(viaCEP.getLogradouro());
            ComboMetroUF.setSelectedItem(viaCEP.getUf());

        } catch (ViaCEPException e) {
            java.util.logging.Logger.getLogger(CadastroAlunos.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());

            MTextFullCidade.setText("");
            MTextFullBairro.setText("");
            MTextFullRua.setText("");
            ComboMetroUF.setSelectedItem("UF");
            MTextFullNºDaCasa.setText("");
        }
    }//GEN-LAST:event_ButtonRipleBuscarEndereçoActionPerformed

    private void ComboMetroUFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMetroUFItemStateChanged

        jLabelAlertaCiadade.setText("");

        jLabelAlertaRua.setText("");

        jLabelAlertaCEP.setText("");

        jLabelAlertaUF.setText("");

        jLabelAlertaBairro.setText("");
    }//GEN-LAST:event_ComboMetroUFItemStateChanged

    private void MTextFullEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullEmailKeyReleased
        Email_lbl.setText("");
    }//GEN-LAST:event_MTextFullEmailKeyReleased

    private void ButtonRipleLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLimparActionPerformed

        MTextFullNome.setText("");
        Idade.setText("");
        Cpf.setText("");
        ComboMetroSexo.setSelectedItem("Selecione o sexo");
        Telefone.setText("");
        MTextFullRua.setText("");
        MTextFullNºDaCasa.setText("");
        MTextFullBairro.setText("");
        jFormattedTextFieldCep.setText("");
        MTextFullCidade.setText("");
        ComboMetroUF.setSelectedItem("UF");
        Telefone.setText("");
        Celular.setText("");
        Observacoes.setText("");
        MTextFullEmail.setText("");
        FotoSquareResize.setImagenDefault(new ImageIcon(getClass().getResource("/img/people.png")));
        Data_nascimento.setDate(null);
    }//GEN-LAST:event_ButtonRipleLimparActionPerformed

    private void ButtonRipleAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAtualizarActionPerformed

        //ALERTAS
        if (MTextFullNome.getText().trim().isEmpty()) {
            name_lbl.setText("*");
        }
        if (ComboMetroSexo.getSelectedItem().equals("Selecione o sexo")) {
            Sexo_lbl.setText("*");
        }
        if (Cpf.getText().equals("   .   .   -  ")) {
            Cpf_label.setText("*");
        }
        if (Data_cadastro.getDate() == null) {
            dt_cad.setText("*");
        }
        if (MTextFullBairro.getText().trim().isEmpty()) {
            jLabelAlertaBairro.setText("*");
        }
        if (MTextFullCidade.getText().trim().isEmpty()) {
            jLabelAlertaCiadade.setText("*");
        }
        if (Data_nascimento.getDate() == null) {
            Dt_nasc.setText("*");
        }
        if (MTextFullEmail.getText().trim().isEmpty()) {
            Email_lbl.setText("*");
        }
        if (FotoSquareResize.getRutaImagen().trim().isEmpty()) {
            jLabelAlertaFoto.setText("*");
        }
        if (jFormattedTextFieldCep.getText().equals("     -   ")) {
            jLabelAlertaCEP.setText("*");
        }
        if (MTextFullRua.getText().trim().isEmpty()) {
            jLabelAlertaRua.setText("*");
        }
        if (MTextFullNºDaCasa.getText().trim().isEmpty()) {
            jLabelAlertaNºDaCasa.setText("*");
        }
        if (ComboMetroUF.getSelectedItem().equals("UF")) {
            jLabelAlertaUF.setText("*");
        }
        if (Celular.getText().equals("(  )      -    ")) {
            Cel_lbl.setText("*");
        }
        if (Telefone.getText().equals("(  )      -    ")) {
            Tel_lbl.setText("*");
        }
        if (Observacoes.getText().trim().isEmpty()) {
            Obs_lbl.setText("*");
        }

        //VERIFICAR CPF
        String cpf = Cpf.getText();

        CPF pf = new CPF(cpf);
        if (pf.isCPF()) {
            if (jTextFieldId.getText() != null) {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = getConnection();

                //CADASTRAR
                try {
                    UpdateQuery = "UPDATE alunos SET "
                            + "nome = ?, data_nascimento = ?, sexo = ?, cpf = ?, rua = ?, num_casa = ?, "
                            + "bairro = ?, cidade = ?, cep = ?, uf = ?, telefone = ?, celular = ?, observacao = ?, email = ?, img = ?, idade = ? WHERE id_aluno = ?";
                    ps = con.prepareStatement(UpdateQuery);

                    ps.setString(1, MTextFullNome.getText());

                    SimpleDateFormat dn = new SimpleDateFormat("yyyy-MM-dd");
                    String data = dn.format(Data_nascimento.getDate());

                    ps.setString(2, data);
                    ps.setString(3, (String) ComboMetroSexo.getSelectedItem());
                    ps.setString(4, Cpf.getText());
                    ps.setString(5, MTextFullRua.getText());
                    ps.setString(6, MTextFullNºDaCasa.getText());
                    ps.setString(7, MTextFullBairro.getText());
                    ps.setString(8, MTextFullCidade.getText());
                    ps.setString(9, jFormattedTextFieldCep.getText());
                    ps.setString(10, (String) ComboMetroUF.getSelectedItem());
                    ps.setString(11, Telefone.getText());
                    ps.setString(12, Celular.getText());
                    ps.setString(13, Observacoes.getText());
                    ps.setString(14, MTextFullEmail.getText());

                    InputStream img = new FileInputStream(new File(FotoSquareResize.getRutaImagen()));
                    ps.setBlob(15, img);

                    ps.setString(16, Idade.getText());
                    ps.setString(17, jTextFieldId.getText());

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!!");

                    this.setVisible(false);
                    readtabelaAluno();

                } catch (Exception ex) {

                    //MENSAGEM DE ERRO
                    java.util.logging.Logger.getLogger(CadastroAlunos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Não foi possível atualizar!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido!");
            }
        }
    }//GEN-LAST:event_ButtonRipleAtualizarActionPerformed

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(EditarAluno.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (dados_aluno != null) {

            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

            jTextFieldId.setText(dados_aluno.getId_aluno());
            MTextFullNome.setText(dados_aluno.getNome());
            try {
                Data_cadastro.setDate(date.parse(dados_aluno.getData_cadastro()));
            } catch (ParseException ex) {
                Logger.getLogger(EditarAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Data_nascimento.setDate(date.parse(dados_aluno.getData_nascimento()));
            } catch (ParseException ex) {
                Logger.getLogger(EditarAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            Idade.setText(dados_aluno.getIdade());
            Cpf.setText(dados_aluno.getCpf());
            ComboMetroSexo.setSelectedItem(dados_aluno.getSexo());
            jFormattedTextFieldCep.setText(dados_aluno.getCep());
            MTextFullCidade.setText(dados_aluno.getCidade());
            MTextFullBairro.setText(dados_aluno.getBairro());
            MTextFullRua.setText(dados_aluno.getRua());
            ComboMetroUF.setSelectedItem(dados_aluno.getUf());
            MTextFullNºDaCasa.setText(dados_aluno.getNºDaCasa());
            Celular.setText(dados_aluno.getCelular());
            Telefone.setText(dados_aluno.getTelefone());
            MTextFullEmail.setText(dados_aluno.getEmail());
            Observacoes.setText(dados_aluno.getObservacao());

        }
    }//GEN-LAST:event_formWindowOpened

    private void ButtonRipleEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleEditarActionPerformed

        Idade.setEnabled(true);
        MTextFullNome.setEnabled(true);
        Data_nascimento.setEnabled(true);
        Cpf.setEnabled(true);
        ComboMetroSexo.setEnabled(true);
        jFormattedTextFieldCep.setEnabled(true);
        MTextFullCidade.setEnabled(true);
        MTextFullBairro.setEnabled(true);
        MTextFullRua.setEnabled(true);
        ComboMetroUF.setEnabled(true);
        MTextFullNºDaCasa.setEnabled(true);
        Celular.setEnabled(true);
        Telefone.setEnabled(true);
        MTextFullEmail.setEnabled(true);
        Observacoes.setEnabled(true);
        FotoSquareResize.setColorBorde(Color.BLACK);
        FotoSquareResize.setColorBotonRemover(Color.BLACK);

    }//GEN-LAST:event_ButtonRipleEditarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EditarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleAtualizar;
    private rojeru_san.RSButtonRiple ButtonRipleBuscarCep;
    private rojeru_san.RSButtonRiple ButtonRipleBuscarEndereço;
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleEditar;
    private rojeru_san.RSButtonRiple ButtonRipleLimpar;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private javax.swing.JLabel Cel_lbl;
    public static javax.swing.JFormattedTextField Celular;
    public static rojerusan.RSComboMetro ComboMetroSexo;
    public static rojerusan.RSComboMetro ComboMetroUF;
    public static javax.swing.JFormattedTextField Cpf;
    private javax.swing.JLabel Cpf_label;
    public static com.toedter.calendar.JDateChooser Data_cadastro;
    public static com.toedter.calendar.JDateChooser Data_nascimento;
    private javax.swing.JLabel Dt_nasc;
    private javax.swing.JLabel Email_lbl;
    public static rojerusan.RSFotoSquareResize FotoSquareResize;
    public static javax.swing.JTextField Idade;
    public static rojeru_san.RSMTextFull MTextFullBairro;
    public static rojeru_san.RSMTextFull MTextFullCidade;
    public static rojeru_san.RSMTextFull MTextFullEmail;
    public static rojeru_san.RSMTextFull MTextFullNome;
    public static rojeru_san.RSMTextFull MTextFullNºDaCasa;
    public static rojeru_san.RSMTextFull MTextFullRua;
    private javax.swing.JLabel Obs_lbl;
    public static javax.swing.JTextArea Observacoes;
    private javax.swing.JLabel Sexo_lbl;
    private javax.swing.JLabel Tel_lbl;
    public static javax.swing.JFormattedTextField Telefone;
    private javax.swing.JLabel dt_cad;
    public static javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel355;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabelAlertaBairro;
    private javax.swing.JLabel jLabelAlertaCEP;
    private javax.swing.JLabel jLabelAlertaCiadade;
    private javax.swing.JLabel jLabelAlertaFoto;
    private javax.swing.JLabel jLabelAlertaNºDaCasa;
    private javax.swing.JLabel jLabelAlertaRua;
    private javax.swing.JLabel jLabelAlertaUF;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField jTextFieldId;
    private javax.swing.JLabel name_lbl;
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
