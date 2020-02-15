package Frames;

import Beans.BeansAluno;
import Beans.BeansFrequencia;
import DAO.AlunoDAO;
import DAO.FrequenciaDAO;
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
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import necesario.RSAWTUtilities;

public class EditarFrequencia extends javax.swing.JFrame implements Runnable {

    private BeansFrequencia aluno_frequencia = null;

    private BeansFrequencia dados_frequencia;

    static Connection con = null;

    private Thread tempo = null;
    private Timer t;

    public void setDados_Frequencia(BeansFrequencia pesquisar) {
        this.dados_frequencia = pesquisar;
    }

    public EditarFrequencia() {
        initComponents();

        this.setLocationRelativeTo(null);

        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);

        MTextFullPesquisaCodigoAluno.setEnabled(false);
        //JLABELnome.setEnabled(false);
        //JLABELcodigo_aluno.setEnabled(false);
        Data.setEnabled(false);
        jFormattedTextFieldHora.setEnabled(false);

        //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();

    }

    public void setCodigoAluno(String CodigoAluno) {
        MTextFullPesquisaCodigoAluno.setText(CodigoAluno);
    }

    public void setLABELnome(String LABELnome) {
        JLABELnome.setText(LABELnome);
    }

    public void setLABELcodigo_aluno(String LABELcodigo_aluno) {
        JLABELcodigo_aluno.setText(LABELcodigo_aluno);
    }

    public void setHora(String Hora) {
        jFormattedTextFieldHora.setText(Hora);
    }

    public void setData(String data) {
        SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Data.setDate(frmt.parse(data));
        } catch (ParseException ex) {
            Logger.getLogger(EditarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search(String id) {
        AlunoDAO dao = new AlunoDAO();

        BeansAluno result = dao.readForId(id);
        if (result != null) {
            JLABELnome.setText(result.getNome());
            JLABELcodigo_aluno.setText(result.getId_aluno());

        } else {
            JLABELnome.setText("- - - - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - - - -");
        }
    }

    ResultSet rs = null;
    Statement sr = null;

    public ArrayList<BeansFrequencia> getFrequenciaList() {
        ArrayList<BeansFrequencia> FrequenciaList = new ArrayList<BeansFrequencia>();
        Connection con = getConnection();
        String query = "SELECT * FROM frequencia";
        try {

            sr = con.createStatement();
            rs = sr.executeQuery(query);
            BeansFrequencia Frequencia;

            while (rs.next()) {
                Frequencia = new BeansFrequencia(
                        rs.getString("id_aluno"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"));

                FrequenciaList.add(Frequencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FrequenciaList;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel4 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        MTextFullPesquisaCodigoAluno = new rojeru_san.RSMTextFull();
        jLabelCodigoAluno = new javax.swing.JLabel();
        ButtonRipleRegistrar = new rojeru_san.RSButtonRiple();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        Data = new com.toedter.calendar.JDateChooser();
        jLabel352 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        ButtonRipleAluno = new rojeru_san.RSButtonRiple();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel_aluno = new javax.swing.JLabel();
        JLABELnome = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabelCodigo_Aluno = new javax.swing.JLabel();
        JLABELcodigo_aluno = new javax.swing.JLabel();
        jFormattedTextFieldHora = new javax.swing.JFormattedTextField();
        jLabel353 = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        ButtonRipleLimpar = new rojeru_san.RSButtonRiple();
        ButtonRipleEditar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(838, 624));

        rSPanelShadow1.setPreferredSize(new java.awt.Dimension(838, 624));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(838, 624));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(838, 624));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Editar Frequência");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        MTextFullPesquisaCodigoAluno.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullPesquisaCodigoAluno.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullPesquisaCodigoAluno.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullPesquisaCodigoAluno.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullPesquisaCodigoAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullPesquisaCodigoAluno.setModoMaterial(true);
        MTextFullPesquisaCodigoAluno.setPlaceholder("Codigo do aluno...");
        MTextFullPesquisaCodigoAluno.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullPesquisaCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullPesquisaCodigoAlunoKeyReleased(evt);
            }
        });

        jLabelCodigoAluno.setForeground(new java.awt.Color(255, 0, 0));

        ButtonRipleRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleRegistrar.setText("Salvar");
        ButtonRipleRegistrar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleRegistrar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleRegistrarActionPerformed(evt);
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

        Data.setBackground(new java.awt.Color(255, 255, 255));
        Data.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Data.setAutoscrolls(true);
        Data.setDoubleBuffered(false);
        Data.setFocusable(false);
        Data.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        jLabel352.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel352.setText("Data:");

        jLabelData.setForeground(new java.awt.Color(255, 0, 0));

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

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel_aluno.setForeground(new java.awt.Color(255, 0, 0));

        JLABELnome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELnome.setText("- - - - - - - - - - - -");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel7.setText("Codigo:");

        jLabelCodigo_Aluno.setForeground(new java.awt.Color(255, 0, 0));

        JLABELcodigo_aluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");

        jFormattedTextFieldHora.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        try {
            jFormattedTextFieldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldHora.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        jLabel353.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel353.setText("Hora:");

        jLabelHora.setForeground(new java.awt.Color(255, 0, 0));

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
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(MTextFullPesquisaCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 433, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(725, 725, 725)
                        .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel352)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel353)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFormattedTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(148, 148, 148)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelCodigo_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonRipleRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel352, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel353, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(13, 13, 13)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldHora)))))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MTextFullPesquisaCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelCodigo_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addGap(52, 52, 52)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonRipleRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelShadow1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MTextFullPesquisaCodigoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullPesquisaCodigoAlunoKeyReleased
        if (!MTextFullPesquisaCodigoAluno.getText().isEmpty()) {
            search(MTextFullPesquisaCodigoAluno.getText());
        } else {
            JLABELnome.setText("- - - - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFullPesquisaCodigoAlunoKeyReleased

    private void ButtonRipleRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleRegistrarActionPerformed

        if (MTextFullPesquisaCodigoAluno.getText().trim().isEmpty()) {
            jLabelCodigoAluno.setText("*");
        }
        if (jFormattedTextFieldHora.getText().equals("  :  :  ")) {
            jLabelHora.setText("*");
        }
        if (JLABELnome.getText().equals("- - - - - - - - - - - -")) {
            jLabel_aluno.setText("*");
        }
        if (JLABELcodigo_aluno.getText().equals("- - - - - - - - - - - -")) {
            jLabelCodigo_Aluno.setText("*");
        }
        if (Data.getDate() == null) {
            jLabelData.setText("*");
        } else {
            BeansFrequencia Frequencia = new BeansFrequencia();
            FrequenciaDAO dao = new FrequenciaDAO();

            Frequencia.setId_aluno(JLABELcodigo_aluno.getText());
            Frequencia.setNome(JLABELnome.getText());
            Frequencia.setHora(jFormattedTextFieldHora.getText());

            SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
            String date = dc.format(Data.getDate());
            Frequencia.setData(date);

            dao.update(Frequencia);

            this.setVisible(false);

        }
    }//GEN-LAST:event_ButtonRipleRegistrarActionPerformed

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(EditarFrequencia.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    private void ButtonRipleAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAlunoActionPerformed
        new TabelaAlunos().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAlunoActionPerformed

    private void ButtonRipleLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLimparActionPerformed

        MTextFullPesquisaCodigoAluno.setText("");
        JLABELnome.setText("- - - - - - - - - - - -");
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");
        Data.setDate(null);
        jFormattedTextFieldHora.setText("");

    }//GEN-LAST:event_ButtonRipleLimparActionPerformed

    private void ButtonRipleEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleEditarActionPerformed

        MTextFullPesquisaCodigoAluno.setEnabled(true);
        Data.setEnabled(true);
        jFormattedTextFieldHora.setEnabled(true);

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
            java.util.logging.Logger.getLogger(EditarFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarFrequencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleAluno;
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleEditar;
    private rojeru_san.RSButtonRiple ButtonRipleLimpar;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private rojeru_san.RSButtonRiple ButtonRipleRegistrar;
    public static com.toedter.calendar.JDateChooser Data;
    public static javax.swing.JLabel JLABELcodigo_aluno;
    public static javax.swing.JLabel JLABELnome;
    public static rojeru_san.RSMTextFull MTextFullPesquisaCodigoAluno;
    public static javax.swing.JFormattedTextField jFormattedTextFieldHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCodigoAluno;
    private javax.swing.JLabel jLabelCodigo_Aluno;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabel_aluno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
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
