package paineis;

import Beans.BeansAluno;
import Frames.TabelaAlunos;
import DAO.ContaDAO;
import DAO.AlunoDAO;
import DAO.FrequenciaDAO;
import Beans.BeansConta;
import Beans.BeansFrequencia;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frequencia extends javax.swing.JPanel {

    private BeansFrequencia aluno_frequencia = null;

    public Frequencia() {
        initComponents();

        DefaultTableModel modeloPagamentos = (DefaultTableModel) TableMetroFrequencia.getModel();
        TableMetroFrequencia.setRowSorter(new TableRowSorter(modeloPagamentos));

        readTabelaPagamentos();

        JLABELresult.setForeground(Color.blue);
    }


    public void readTabelaPagamentos() {

        DefaultTableModel modeloPagamentos = (DefaultTableModel) TableMetroFrequencia.getModel();
        modeloPagamentos.setNumRows(0);
        ContaDAO dao = new ContaDAO();

        for (BeansConta aluno : dao.readAll()) {
            modeloPagamentos.addRow(new Object[]{
                aluno.getRecibo(),
                aluno.getDescricao(),
                aluno.getData(),
                aluno.getHora(),
                aluno.getData_venc(),
                aluno.getDataPagamento(),});
        }
    }

    public ImageIcon ResizeImage(ImageIcon myImg) {
        Image img = myImg.getImage();
        Image img2 = img.getScaledInstance(LabelImage.getWidth(), LabelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);

        return image;

    }

    public void search(String id) {
        AlunoDAO dao = new AlunoDAO();

        BeansAluno result = dao.readForId(id);
        if (result != null) {
            JLABELnome.setText(result.getNome());
            JLABELcodigo_aluno.setText(result.getId_aluno());

            LabelImage.setIcon(ResizeImage(new ImageIcon(result.getPicture())));

            if (TableMetroFrequencia.getRowCount() == 0) {
                aluno_frequencia = new BeansFrequencia();
                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

                aluno_frequencia.setId_aluno(result.getId_aluno());
                aluno_frequencia.setNome(result.getNome());
                aluno_frequencia.setData(data.format(new Date()));
                aluno_frequencia.setHora(hora.format(new Date()));

                JLABELresult.setText("Acesso Liberado");
                JLABELresult.setForeground(Color.green);

            }
        } else {
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel4 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        JLABELresult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JLABELcodigo_aluno = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        JLABELnome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        MTextFullPesquisaCodigoAluno = new rojeru_san.RSMTextFull();
        ButtonRipleAluno = new rojeru_san.RSButtonRiple();
        jLabelCodigoAluno = new javax.swing.JLabel();
        jLabel_aluno = new javax.swing.JLabel();
        jLabelCodigoAluno2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMetroFrequencia = new rojerusan.RSTableMetro();
        jSeparator5 = new javax.swing.JSeparator();
        ButtonRipleRegistrar = new rojeru_san.RSButtonRiple();
        LabelImage = new rojerusan.RSLabelImage();

        setPreferredSize(new java.awt.Dimension(870, 815));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(838, 624));

        rSPanelShadow1.setPreferredSize(new java.awt.Dimension(838, 624));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(838, 624));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(204, 204, 204));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(838, 624));

        JLABELresult.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        JLABELresult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLABELresult.setText("Aguardando entrada...");

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel1.setText("Frequência");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel7.setText("Codigo:");

        JLABELcodigo_aluno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELcodigo_aluno.setText("- - - - - - - - - - - -");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        JLABELnome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JLABELnome.setText("- - - - - - - - - - - -");

        jLabel4.setFont(new java.awt.Font("Georgia", 2, 18)); // NOI18N
        jLabel4.setText("Nome:");

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

        jLabelCodigoAluno.setForeground(new java.awt.Color(255, 0, 0));

        jLabel_aluno.setForeground(new java.awt.Color(255, 0, 0));

        jLabelCodigoAluno2.setForeground(new java.awt.Color(255, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        TableMetroFrequencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descrição", "Data", "Hora", "Data venc.", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroFrequencia.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        TableMetroFrequencia.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroFrequencia.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        TableMetroFrequencia.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        TableMetroFrequencia.setColorSelBackgound(new java.awt.Color(51, 51, 51));
        TableMetroFrequencia.setFont(new java.awt.Font("Georgia", 2, 12)); // NOI18N
        TableMetroFrequencia.setFuenteFilas(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroFrequencia.setFuenteFilasSelect(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroFrequencia.setFuenteHead(new java.awt.Font("Georgia", 3, 15)); // NOI18N
        TableMetroFrequencia.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(TableMetroFrequencia);

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        ButtonRipleRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        ButtonRipleRegistrar.setText("Registrar");
        ButtonRipleRegistrar.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleRegistrar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleRegistrarActionPerformed(evt);
            }
        });

        LabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        LabelImage.setForeground(new java.awt.Color(255, 0, 0));
        LabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/people.png"))); // NOI18N
        LabelImage.setText("");
        LabelImage.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(MTextFullPesquisaCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(148, 148, 148)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(JLABELnome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(23, 23, 23))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLABELresult, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(595, Short.MAX_VALUE)
                .addComponent(ButtonRipleRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MTextFullPesquisaCodigoAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonRipleAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelCodigoAluno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLABELnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLABELcodigo_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLABELresult, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonRipleRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        rSPanelShadow1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MTextFullPesquisaCodigoAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullPesquisaCodigoAlunoKeyReleased
        if (!MTextFullPesquisaCodigoAluno.getText().isEmpty()) {
            search(MTextFullPesquisaCodigoAluno.getText());
        } else{
            JLABELresult.setText("Aguardando entrada...");
            JLABELresult.setForeground(Color.blue);

            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
            LabelImage.setIcon( new ImageIcon(getClass().getResource("/img/people.png")));
        }
    }//GEN-LAST:event_MTextFullPesquisaCodigoAlunoKeyReleased

    private void ButtonRipleAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleAlunoActionPerformed
        new TabelaAlunos().setVisible(true);
    }//GEN-LAST:event_ButtonRipleAlunoActionPerformed

    private void ButtonRipleRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleRegistrarActionPerformed
         if (aluno_frequencia != null) {
            FrequenciaDAO.registrar(aluno_frequencia);
            readTabelaPagamentos();
            
            JLABELnome.setText("- - - - - - - - - -");
            JLABELcodigo_aluno.setText("- - - - - - - - - -");
            LabelImage.setIcon( new ImageIcon(getClass().getResource("/img/people.png")));
            MTextFullPesquisaCodigoAluno.setText("");
            
            JLABELresult.setText("Aguardando Entrada...");
            JLABELresult.setForeground(Color.blue);
        }
        aluno_frequencia = null;
    }//GEN-LAST:event_ButtonRipleRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleAluno;
    private rojeru_san.RSButtonRiple ButtonRipleRegistrar;
    private javax.swing.JLabel JLABELcodigo_aluno;
    private javax.swing.JLabel JLABELnome;
    private javax.swing.JLabel JLABELresult;
    private rojerusan.RSLabelImage LabelImage;
    private rojeru_san.RSMTextFull MTextFullPesquisaCodigoAluno;
    private rojerusan.RSTableMetro TableMetroFrequencia;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCodigoAluno;
    private javax.swing.JLabel jLabelCodigoAluno2;
    private javax.swing.JLabel jLabel_aluno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
