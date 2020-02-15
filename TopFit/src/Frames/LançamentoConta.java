
package Frames;

import Beans.BeansAluno;
import DAO.AlunoDAO;
import Beans.BeansConta;
import FadeEffect.FadeEffect;
import static controle.conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import necesario.RSAWTUtilities;

public class LançamentoConta extends javax.swing.JFrame implements Runnable{

    private BeansConta lançamento_conta = null;
    
        private Thread tempo = null;
        private Timer t;
        
    public LançamentoConta() {
        initComponents();
        this.setLocationRelativeTo(null);

        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);
                //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();
    

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
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel2 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel352 = new javax.swing.JLabel();
        Data_matricula_recebe = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        JLABELcodigo_aluno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLABELnome = new javax.swing.JLabel();
        jLabelCodigoModalidades = new javax.swing.JLabel();
        jLabelCodigoAluno = new javax.swing.JLabel();
        jLabelCodigoAluno2 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelModalidade = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MTextFulCodigoAluno = new rojeru_san.RSMTextFull();
        ButtonRipleAluno = new rojeru_san.RSButtonRiple();
        MTextFullModalidade = new rojeru_san.RSMTextFull();
        MTextFullPreço = new rojeru_san.RSMTextFull();
        jLabelCodigoValor = new javax.swing.JLabel();
        jLabelCodigoData = new javax.swing.JLabel();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        ButtonRipleLancar = new rojeru_san.RSButtonRiple();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 550));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        jLabel352.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel352.setText("Data do pagamento:");

        Data_matricula_recebe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Data_matricula_recebe.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        JLABELcodigo_aluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_aluno.setText("- - - - - - - - - -");

        jLabel6.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel6.setText("Codigo:");

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 16)); // NOI18N
        jLabel3.setText("Nome:");

        JLABELnome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELnome.setText("- - - - - - - - - -");

        jLabelCodigoModalidades.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoAluno.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoAluno2.setForeground(new java.awt.Color(255, 0, 0));

        jLabelNome.setForeground(new java.awt.Color(255, 0, 0));

        jLabelModalidade.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Lançamento de conta");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        MTextFulCodigoAluno.setForeground(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFulCodigoAluno.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFulCodigoAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFulCodigoAluno.setModoMaterial(true);
        MTextFulCodigoAluno.setPlaceholder("Codigo do aluno...");
        MTextFulCodigoAluno.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFulCodigoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MTextFulCodigoAlunoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFulCodigoAlunoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MTextFulCodigoAlunoKeyTyped(evt);
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
        MTextFullModalidade.setPlaceholder("Descrição da modalidade...");
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
        MTextFullPreço.setPlaceholder("Valor...");
        MTextFullPreço.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullPreço.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullPreçoKeyReleased(evt);
            }
        });

        jLabelCodigoValor.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoData.setForeground(new java.awt.Color(255, 0, 0));

        ButtonRipleMinimize.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleMinimize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonRipleMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize (1).png"))); // NOI18N
        ButtonRipleMinimize.setColorHover(new java.awt.Color(153, 153, 153));
        ButtonRipleMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleMinimizeActionPerformed(evt);
            }
        });

        ButtonRipleClose.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonRipleClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-cross (1).png"))); // NOI18N
        ButtonRipleClose.setColorHover(new java.awt.Color(153, 153, 153));
        ButtonRipleClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleCloseActionPerformed(evt);
            }
        });

        ButtonRipleLancar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleLancar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleLancar.setText("Lançar");
        ButtonRipleLancar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleLancar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleLancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleLancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(MTextFulCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel352)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCodigoData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Data_matricula_recebe, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(MTextFullPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodigoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                    .addGap(180, 180, 180)
                                    .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ButtonRipleLancar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MTextFulCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MTextFullModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigoModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel352, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigoData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodigoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Data_matricula_recebe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MTextFullPreço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(ButtonRipleLancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rSPanelShadow1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
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

    private void botão_matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botão_matriculaActionPerformed
        if (MTextFulCodigoAluno.getText().trim().isEmpty()) {
            jLabelCodigoAluno.setText("*");
        }
        if (JLABELcodigo_aluno.getText().equals("- - - - - - - - - -")) {
            jLabelCodigoAluno2.setText("*");
        }
        if (JLABELnome.getText().equals("- - - - - - - - - -")) {
            jLabelNome.setText("*");
        }
        if (MTextFullPreço.getText().trim().isEmpty()) {
            jLabelCodigoValor.setText("*");
        }
        if (Data_matricula_recebe.getDate() == null) {
            jLabelCodigoData.setText("*");
        }
        else{
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO pagamentos(id_aluno,descricao,valor,data,hora,data_vencimento)VALUES(?,?,?,?,?,?)");

                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
            
                SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
                String date = dc.format(Data_matricula_recebe.getDate());

                ps.setString(1, JLABELcodigo_aluno.getText());
                ps.setString(2,MTextFulCodigoAluno.getText());
                ps.setString(3, MTextFullPreço.getText());
                ps.setString(4, data.format(new Date()));
                ps.setString(5, hora.format(new Date()));

                ps.setString(6, date);               
              
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Conta lançada com sucesso!");           
                        this.dispose();

            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Dados não inseridos");
            }
        }
        
    }//GEN-LAST:event_botão_matriculaActionPerformed

    private void MTextFulCodigoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFulCodigoAlunoKeyReleased
        jLabelCodigoAluno.setText("");

        if (!MTextFulCodigoAluno.getText().isEmpty()) {
            searchAluno(MTextFulCodigoAluno.getText());
        } else{
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFulCodigoAlunoKeyReleased

    private void ButtonRipleAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAlunoActionPerformed
        new TabelaAlunos().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAlunoActionPerformed

    private void MTextFullModalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullModalidadeKeyReleased
        jLabelCodigoModalidades.setText("");
    }//GEN-LAST:event_MTextFullModalidadeKeyReleased

    private void MTextFullPreçoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullPreçoKeyReleased
        jLabelCodigoValor.setText("");
    }//GEN-LAST:event_MTextFullPreçoKeyReleased

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(TabelaAlunos.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    private void ButtonRipleLancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleLancarActionPerformed
    if (MTextFulCodigoAluno.getText().trim().isEmpty()) {
            jLabelCodigoAluno.setText("*");
        }
        if (JLABELcodigo_aluno.getText().equals("- - - - - - - - - -")) {
            jLabelCodigoAluno2.setText("*");
        }
        if (JLABELnome.getText().equals("- - - - - - - - - -")) {
            jLabelNome.setText("*");
        }
        if (MTextFullPreço.getText().trim().isEmpty()) {
            jLabelCodigoValor.setText("*");
        }
        if (Data_matricula_recebe.getDate() == null) {
            jLabelCodigoData.setText("*");
        }
        else{
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO pagamentos(id_aluno,descricao,valor,data,hora,data_vencimento)VALUES(?,?,?,?,?,?)");

                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
            
                SimpleDateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
                String date = dc.format(Data_matricula_recebe.getDate());

                ps.setString(1, JLABELcodigo_aluno.getText());
                ps.setString(2,MTextFulCodigoAluno.getText());
                ps.setString(3, MTextFullPreço.getText());
                ps.setString(4, data.format(new Date()));
                ps.setString(5, hora.format(new Date()));

                ps.setString(6, date);               
              
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Conta lançada com sucesso!");           
                        this.dispose();
                        
                        

            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Dados não inseridos");
            }
        }
    }//GEN-LAST:event_ButtonRipleLancarActionPerformed

    private void MTextFulCodigoAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFulCodigoAlunoKeyPressed
        jLabelCodigoAluno.setText("");

        if (!MTextFulCodigoAluno.getText().isEmpty()) {
            searchAluno(MTextFulCodigoAluno.getText());
        } else{
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }    }//GEN-LAST:event_MTextFulCodigoAlunoKeyPressed

    private void MTextFulCodigoAlunoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFulCodigoAlunoKeyTyped
        jLabelCodigoAluno.setText("");

        if (!MTextFulCodigoAluno.getText().isEmpty()) {
            searchAluno(MTextFulCodigoAluno.getText());
        } else{
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }
    }//GEN-LAST:event_MTextFulCodigoAlunoKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LançamentoConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleAluno;
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleLancar;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private com.toedter.calendar.JDateChooser Data_matricula_recebe;
    private javax.swing.JLabel JLABELcodigo_aluno;
    private javax.swing.JLabel JLABELnome;
    private rojeru_san.RSMTextFull MTextFulCodigoAluno;
    private rojeru_san.RSMTextFull MTextFullModalidade;
    private rojeru_san.RSMTextFull MTextFullPreço;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCodigoAluno;
    private javax.swing.JLabel jLabelCodigoAluno2;
    private javax.swing.JLabel jLabelCodigoData;
    private javax.swing.JLabel jLabelCodigoModalidades;
    private javax.swing.JLabel jLabelCodigoValor;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables

    public void recebendo_aluno(String recebe_aluno){
        MTextFulCodigoAluno.setText(recebe_aluno);
    }

    public void recebendo_nome(String recebe_nome) {
        JLABELnome.setText(recebe_nome);
    }

    public void recebendo_codigo(String recebe_codigo) {
        JLABELcodigo_aluno.setText(recebe_codigo);
    }

    public void recebendo_modalidade(String recebe_modalidade){
        MTextFullModalidade.setText(recebe_modalidade);
    }
    public void recebendo_preço(String recebendo_preço){
        MTextFullPreço.setText(recebendo_preço);
    }
    
    public void recebendo_data(Date recebe_data){
        Data_matricula_recebe.setDate(recebe_data);
        
    }
    public void run() {
        try {
            Thread.sleep(7000);
            //FadeEffect.fadeOutFrameSplash1(this, 50, 0.1f);
        } catch (InterruptedException ex) {
            Logger.getLogger(opening.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
