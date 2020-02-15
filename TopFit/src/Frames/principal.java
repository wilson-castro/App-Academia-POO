package Frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import paineis.Home;
import Cambia.CambiaPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import necesario.RSAWTUtilities;
import FadeEffect.FadeEffect;

public class principal extends javax.swing.JFrame implements Runnable {

    private Thread tempo = null;
    private Timer t;

    public principal() {
        initComponents();

        this.setLocationRelativeTo(this);

        rsutilities.RSUtilities.setCentrarVentana(this);
        rsutilities.RSUtilities.setOpaqueVentana(this, false);
        rsutilities.RSUtilities.setMoverVentana(this);

        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new Home());

        ButtonCustomHome.setBackground(new Color(0, 0, 0, 0));
        ButtonCustomCadastro.setBackground(new Color(0, 0, 0, 0));
        ButtonCustomPesquisas.setBackground(new Color(0, 0, 0, 0));
        ButtonCustomFinanceiro.setBackground(new Color(0, 0, 0, 0));

        rSPopuMenuCadastro.add(rSPanelGradienteCadastro);
        rSPopuMenuPesquisar.add(rSPanelGradientePesquisas);
        rSPopuMenuFinanceiro.add(rSPanelGradienteFinanceiro);

        //Imagem no rodapé
        this.setIconImage(new ImageIcon(getClass().getResource("/img/academia.png")).getImage());
        this.setLocationRelativeTo(null);
        RSAWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrameSplash(this, 50, 0.1f);
        tempo = new Thread(this);
        tempo.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPopuMenuCadastro = new rojerusan.RSPopuMenu();
        rSPopuMenuFinanceiro = new rojerusan.RSPopuMenu();
        rSPanelGradienteFinanceiro = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomCaixa = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomContas = new rsbuttoncustom.RSButtonCustom();
        rSPanelGradienteCadastro = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomFuncionario = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomModalidade = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomAluno = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomMatricula = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomFrequência = new rsbuttoncustom.RSButtonCustom();
        rSPanelGradientePesquisas = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomPesquisarFuncionario = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomPesquisarModalidade = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomPesquisarAluno = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomPesquisarMatricula = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomPesquisarFrequência = new rsbuttoncustom.RSButtonCustom();
        rSPopuMenuPesquisar = new rojerusan.RSPopuMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        rSPanelGradiente2 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        pnlMenu = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        ButtonCustomHome = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomCadastro = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomPesquisas = new rsbuttoncustom.RSButtonCustom();
        ButtonCustomFinanceiro = new rsbuttoncustom.RSButtonCustom();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        rSPanelsSlider = new rojerusan.RSPanelsSlider();

        rSPanelGradienteFinanceiro.setColorPrimario(new java.awt.Color(102, 0, 0));
        rSPanelGradienteFinanceiro.setColorSecundario(new java.awt.Color(102, 0, 0));
        rSPanelGradienteFinanceiro.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.ESQUINA_3);

        ButtonCustomCaixa.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomCaixa.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomCaixa.setText("Caixa");
        ButtonCustomCaixa.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomCaixa.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomCaixaActionPerformed(evt);
            }
        });

        ButtonCustomContas.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomContas.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomContas.setText("Contas");
        ButtonCustomContas.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomContas.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomContasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradienteFinanceiroLayout = new javax.swing.GroupLayout(rSPanelGradienteFinanceiro);
        rSPanelGradienteFinanceiro.setLayout(rSPanelGradienteFinanceiroLayout);
        rSPanelGradienteFinanceiroLayout.setHorizontalGroup(
            rSPanelGradienteFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradienteFinanceiroLayout.createSequentialGroup()
                .addGroup(rSPanelGradienteFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCustomCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomContas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        rSPanelGradienteFinanceiroLayout.setVerticalGroup(
            rSPanelGradienteFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradienteFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCustomContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelGradienteCadastro.setColorPrimario(new java.awt.Color(102, 0, 0));
        rSPanelGradienteCadastro.setColorSecundario(new java.awt.Color(102, 0, 0));
        rSPanelGradienteCadastro.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.ESQUINA_3);

        ButtonCustomFuncionario.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomFuncionario.setText("Funcionario");
        ButtonCustomFuncionario.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomFuncionario.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomFuncionarioActionPerformed(evt);
            }
        });

        ButtonCustomModalidade.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomModalidade.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomModalidade.setText("Modalidades");
        ButtonCustomModalidade.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomModalidade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomModalidadeActionPerformed(evt);
            }
        });

        ButtonCustomAluno.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomAluno.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomAluno.setText("Aluno");
        ButtonCustomAluno.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomAlunoActionPerformed(evt);
            }
        });

        ButtonCustomMatricula.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomMatricula.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomMatricula.setText("Matricula");
        ButtonCustomMatricula.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomMatricula.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomMatriculaActionPerformed(evt);
            }
        });

        ButtonCustomFrequência.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomFrequência.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomFrequência.setText("Frequência");
        ButtonCustomFrequência.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomFrequência.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomFrequência.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomFrequênciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradienteCadastroLayout = new javax.swing.GroupLayout(rSPanelGradienteCadastro);
        rSPanelGradienteCadastro.setLayout(rSPanelGradienteCadastroLayout);
        rSPanelGradienteCadastroLayout.setHorizontalGroup(
            rSPanelGradienteCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradienteCadastroLayout.createSequentialGroup()
                .addGroup(rSPanelGradienteCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCustomModalidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCustomAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCustomMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomFrequência, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        rSPanelGradienteCadastroLayout.setVerticalGroup(
            rSPanelGradienteCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradienteCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCustomAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomFrequência, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        rSPanelGradientePesquisas.setColorPrimario(new java.awt.Color(102, 0, 0));
        rSPanelGradientePesquisas.setColorSecundario(new java.awt.Color(102, 0, 0));
        rSPanelGradientePesquisas.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.ESQUINA_3);

        ButtonCustomPesquisarFuncionario.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisarFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisarFuncionario.setText("Funcionario");
        ButtonCustomPesquisarFuncionario.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomPesquisarFuncionario.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomPesquisarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomPesquisarFuncionarioActionPerformed(evt);
            }
        });

        ButtonCustomPesquisarModalidade.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisarModalidade.setText("Modalidades");
        ButtonCustomPesquisarModalidade.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomPesquisarModalidade.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomPesquisarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomPesquisarModalidadeActionPerformed(evt);
            }
        });

        ButtonCustomPesquisarAluno.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisarAluno.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisarAluno.setText("Aluno");
        ButtonCustomPesquisarAluno.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomPesquisarAluno.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomPesquisarAlunoActionPerformed(evt);
            }
        });

        ButtonCustomPesquisarMatricula.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisarMatricula.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisarMatricula.setText("Matricula");
        ButtonCustomPesquisarMatricula.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomPesquisarMatricula.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomPesquisarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomPesquisarMatriculaActionPerformed(evt);
            }
        });

        ButtonCustomPesquisarFrequência.setBackground(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisarFrequência.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisarFrequência.setText("Frequência");
        ButtonCustomPesquisarFrequência.setColorMaterial(new java.awt.Color(0, 0, 0));
        ButtonCustomPesquisarFrequência.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonCustomPesquisarFrequência.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomPesquisarFrequênciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradientePesquisasLayout = new javax.swing.GroupLayout(rSPanelGradientePesquisas);
        rSPanelGradientePesquisas.setLayout(rSPanelGradientePesquisasLayout);
        rSPanelGradientePesquisasLayout.setHorizontalGroup(
            rSPanelGradientePesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradientePesquisasLayout.createSequentialGroup()
                .addGroup(rSPanelGradientePesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCustomPesquisarModalidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomPesquisarFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCustomPesquisarAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCustomPesquisarMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ButtonCustomPesquisarFrequência, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        rSPanelGradientePesquisasLayout.setVerticalGroup(
            rSPanelGradientePesquisasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradientePesquisasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonCustomPesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomPesquisarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomPesquisarModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomPesquisarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCustomPesquisarFrequência, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(1022, 775));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));

        rSPanelGradiente2.setBackground(new java.awt.Color(102, 102, 102));
        rSPanelGradiente2.setColorPrimario(new java.awt.Color(51, 51, 51));
        rSPanelGradiente2.setColorSecundario(new java.awt.Color(51, 51, 51));
        rSPanelGradiente2.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Academia");

        Data.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));

        Hora.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        Hora.setForeground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout rSPanelGradiente2Layout = new javax.swing.GroupLayout(rSPanelGradiente2);
        rSPanelGradiente2.setLayout(rSPanelGradiente2Layout);
        rSPanelGradiente2Layout.setHorizontalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelGradiente2Layout.setVerticalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 0, 0));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(0, 0, 0));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.HORIZONTAL);

        ButtonCustomHome.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomHome.setText("Home");
        ButtonCustomHome.setColorMaterial(new java.awt.Color(102, 0, 0));
        ButtonCustomHome.setFont(new java.awt.Font("Georgia", 3, 20)); // NOI18N
        ButtonCustomHome.setIconTextGap(15);
        ButtonCustomHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCustomHomeActionPerformed(evt);
            }
        });

        ButtonCustomCadastro.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomCadastro.setText("Cadastros");
        ButtonCustomCadastro.setColorMaterial(new java.awt.Color(102, 0, 0));
        ButtonCustomCadastro.setComponentPopupMenu(rSPopuMenuCadastro);
        ButtonCustomCadastro.setFont(new java.awt.Font("Georgia", 3, 20)); // NOI18N
        ButtonCustomCadastro.setIconTextGap(15);
        ButtonCustomCadastro.setInheritsPopupMenu(true);

        ButtonCustomPesquisas.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomPesquisas.setText("Pesquisa");
        ButtonCustomPesquisas.setColorMaterial(new java.awt.Color(102, 0, 0));
        ButtonCustomPesquisas.setComponentPopupMenu(rSPopuMenuPesquisar);
        ButtonCustomPesquisas.setFont(new java.awt.Font("Georgia", 3, 20)); // NOI18N
        ButtonCustomPesquisas.setIconTextGap(15);

        ButtonCustomFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCustomFinanceiro.setText("Finaceiro");
        ButtonCustomFinanceiro.setColorMaterial(new java.awt.Color(102, 0, 0));
        ButtonCustomFinanceiro.setComponentPopupMenu(rSPopuMenuFinanceiro);
        ButtonCustomFinanceiro.setFont(new java.awt.Font("Georgia", 3, 20)); // NOI18N
        ButtonCustomFinanceiro.setIconTextGap(15);

        rSPanelImage1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/img/academia.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ButtonCustomFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonCustomPesquisas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCustomCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCustomHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(78, 78, 78))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(ButtonCustomHome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(ButtonCustomCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(ButtonCustomPesquisas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(ButtonCustomFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSPanelsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSPanelsSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        this.setExtendedState(Integer.MAX_VALUE);

        Timer timer = new Timer(1000, new hora());
        timer.start();

        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Data.setText(formato.format(dataSistema));

    }//GEN-LAST:event_formWindowOpened

    private void ButtonCustomHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomHomeActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.Home());
    }//GEN-LAST:event_ButtonCustomHomeActionPerformed

    private void ButtonCustomFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomFuncionarioActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.CadastroFuncionario());
    }//GEN-LAST:event_ButtonCustomFuncionarioActionPerformed

    private void ButtonCustomModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomModalidadeActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.Modalidades());
    }//GEN-LAST:event_ButtonCustomModalidadeActionPerformed

    private void ButtonCustomAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomAlunoActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.CadastroAlunos());
    }//GEN-LAST:event_ButtonCustomAlunoActionPerformed

    private void ButtonCustomMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomMatriculaActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.Matricula());
    }//GEN-LAST:event_ButtonCustomMatriculaActionPerformed

    private void ButtonCustomFrequênciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomFrequênciaActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.Frequencia());
    }//GEN-LAST:event_ButtonCustomFrequênciaActionPerformed

    private void ButtonCustomPesquisarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomPesquisarFuncionarioActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.PesquisarFuncionario());
    }//GEN-LAST:event_ButtonCustomPesquisarFuncionarioActionPerformed

    private void ButtonCustomPesquisarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomPesquisarModalidadeActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.PesquisarModalidade());
    }//GEN-LAST:event_ButtonCustomPesquisarModalidadeActionPerformed

    private void ButtonCustomPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomPesquisarAlunoActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.PesquisarAluno());
    }//GEN-LAST:event_ButtonCustomPesquisarAlunoActionPerformed

    private void ButtonCustomPesquisarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomPesquisarMatriculaActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.PesquisarMatricula());
    }//GEN-LAST:event_ButtonCustomPesquisarMatriculaActionPerformed

    private void ButtonCustomPesquisarFrequênciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomPesquisarFrequênciaActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.PesquisarFrequencia());
    }//GEN-LAST:event_ButtonCustomPesquisarFrequênciaActionPerformed

    private void ButtonCustomCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomCaixaActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.Financeiro());
    }//GEN-LAST:event_ButtonCustomCaixaActionPerformed

    private void ButtonCustomContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCustomContasActionPerformed
        CambiaPanel cambiaPanel = new CambiaPanel(rSPanelsSlider, new paineis.FinanceiroCaixa());
    }//GEN-LAST:event_ButtonCustomContasActionPerformed

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(EditarAluno.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttoncustom.RSButtonCustom ButtonCustomAluno;
    private rsbuttoncustom.RSButtonCustom ButtonCustomCadastro;
    private rsbuttoncustom.RSButtonCustom ButtonCustomCaixa;
    private rsbuttoncustom.RSButtonCustom ButtonCustomContas;
    private rsbuttoncustom.RSButtonCustom ButtonCustomFinanceiro;
    private rsbuttoncustom.RSButtonCustom ButtonCustomFrequência;
    private rsbuttoncustom.RSButtonCustom ButtonCustomFuncionario;
    private rsbuttoncustom.RSButtonCustom ButtonCustomHome;
    private rsbuttoncustom.RSButtonCustom ButtonCustomMatricula;
    private rsbuttoncustom.RSButtonCustom ButtonCustomModalidade;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisarAluno;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisarFrequência;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisarFuncionario;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisarMatricula;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisarModalidade;
    private rsbuttoncustom.RSButtonCustom ButtonCustomPesquisas;
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel pnlMenu;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradienteCadastro;
    private rspanelgradiente.RSPanelGradiente rSPanelGradienteFinanceiro;
    private rspanelgradiente.RSPanelGradiente rSPanelGradientePesquisas;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelsSlider rSPanelsSlider;
    private rojerusan.RSPopuMenu rSPopuMenuCadastro;
    private rojerusan.RSPopuMenu rSPopuMenuFinanceiro;
    private rojerusan.RSPopuMenu rSPopuMenuPesquisar;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            Hora.setText(String.format("%1$tH:%1tM:%1$tS", now));
        }
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
