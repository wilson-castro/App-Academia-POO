
package Frames;

import paineis.Matricula;
import DAO.PesquisarAlunosDAO;
import Beans.BeansAluno;
import Beans.BeansBuscarAluno;
import FadeEffect.FadeEffect;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import necesario.RSAWTUtilities;
import javax.swing.Timer;

public class TabelaAlunos extends javax.swing.JFrame implements Runnable{
    
    Matricula enviarId;

    private Boolean confirmado = false;
    private BeansAluno profissao;
    private Thread tempo = null;
    private Timer t;
    
    public TabelaAlunos() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        DefaultTableModel modelos = (DefaultTableModel) TableMetroAlunos.getModel();
        TableMetroAlunos.setRowSorter(new TableRowSorter(modelos));
        
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
    
        readtabelaAluno();
    }
    
    
    public void readtabelaAluno() {

        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readA()) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
            });

        }

    }

    public void readtabelaForDescId(String desc) {
        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescId(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
            });

        }
    }

    public void readtabelaForDescNome(String desc) {

        DefaultTableModel buscarAluno = (DefaultTableModel) TableMetroAlunos.getModel();
        buscarAluno.setNumRows(0);
        PesquisarAlunosDAO dao = new PesquisarAlunosDAO();

        for (BeansBuscarAluno aluno : dao.readForDescNome(desc)) {

            buscarAluno.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
            });

        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel4 = new javax.swing.JPanel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        ComboMetroPesquisar = new rojerusan.RSComboMetro();
        MTextFullPesquisa = new rojeru_san.RSMTextFull();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMetroAlunos = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        ButtonRipleMinimize = new rojeru_san.RSButtonRiple();
        ButtonRipleClose = new rojeru_san.RSButtonRiple();
        ButtonRipleTodos = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setVerifyInputWhenFocusTarget(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(51, 0, 0));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 0, 0));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.ESQUINA_3);

        ComboMetroPesquisar.setEditable(true);
        ComboMetroPesquisar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pesquisar por ", "Codigo", "Nome" }));
        ComboMetroPesquisar.setColorArrow(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorBorde(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setColorFondo(new java.awt.Color(0, 0, 0));
        ComboMetroPesquisar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N

        MTextFullPesquisa.setForeground(new java.awt.Color(0, 0, 0));
        MTextFullPesquisa.setBordeColorFocus(new java.awt.Color(102, 102, 102));
        MTextFullPesquisa.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        MTextFullPesquisa.setBotonColor(new java.awt.Color(0, 0, 0));
        MTextFullPesquisa.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        MTextFullPesquisa.setModoMaterial(true);
        MTextFullPesquisa.setPlaceholder("Digite...");
        MTextFullPesquisa.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        MTextFullPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MTextFullPesquisaKeyReleased(evt);
            }
        });

        TableMetroAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMetroAlunos.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        TableMetroAlunos.setColorBordeHead(new java.awt.Color(255, 255, 255));
        TableMetroAlunos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        TableMetroAlunos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        TableMetroAlunos.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        TableMetroAlunos.setFuenteFilas(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        TableMetroAlunos.setFuenteFilasSelect(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        TableMetroAlunos.setFuenteHead(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        TableMetroAlunos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(TableMetroAlunos);

        jLabel2.setFont(new java.awt.Font("Georgia", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alunos");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        ButtonRipleMinimize.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleMinimize.setBorder(null);
        ButtonRipleMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize (1).png"))); // NOI18N
        ButtonRipleMinimize.setColorHover(new java.awt.Color(204, 204, 204));
        ButtonRipleMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleMinimizeActionPerformed(evt);
            }
        });

        ButtonRipleClose.setBackground(new java.awt.Color(204, 204, 204));
        ButtonRipleClose.setBorder(null);
        ButtonRipleClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close-cross (1).png"))); // NOI18N
        ButtonRipleClose.setColorHover(new java.awt.Color(204, 204, 204));
        ButtonRipleClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRipleClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleCloseActionPerformed(evt);
            }
        });

        ButtonRipleTodos.setBackground(new java.awt.Color(0, 0, 0));
        ButtonRipleTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        ButtonRipleTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
        ButtonRipleTodos.setText("Todos");
        ButtonRipleTodos.setColorHover(new java.awt.Color(102, 102, 102));
        ButtonRipleTodos.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        ButtonRipleTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRipleTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(MTextFullPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonRipleMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonRipleClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(ComboMetroPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MTextFullPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRipleTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rSPanelShadow1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public BeansAluno getProfissao() {
        return profissao;
    }

    public void setProfissao(BeansAluno profissao) {
        this.profissao = profissao;
    }
    public Boolean isConfirmado(){
        return confirmado;
    }

    
    private void TodosAlunos1BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosAlunos1BTActionPerformed
        readtabelaAluno();
        MTextFullPesquisa.setText("");
    }//GEN-LAST:event_TodosAlunos1BTActionPerformed

    private void MTextFullPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MTextFullPesquisaKeyReleased
        if (ComboMetroPesquisar.getSelectedItem().equals("Codigo")) {
            readtabelaForDescId(MTextFullPesquisa.getText());

        } else if (ComboMetroPesquisar.getSelectedItem().equals("Nome")) {
            readtabelaForDescNome(MTextFullPesquisa.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");
            MTextFullPesquisa.setText("");

        }
    }//GEN-LAST:event_MTextFullPesquisaKeyReleased

    private void ButtonRipleMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleMinimizeActionPerformed
        this.setState(TabelaAlunos.ICONIFIED);
    }//GEN-LAST:event_ButtonRipleMinimizeActionPerformed

    private void ButtonRipleCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleCloseActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_ButtonRipleCloseActionPerformed

    private void ButtonRipleTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRipleTodosActionPerformed

        readtabelaAluno();
        MTextFullPesquisa.setText("");
    }//GEN-LAST:event_ButtonRipleTodosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple ButtonRipleClose;
    private rojeru_san.RSButtonRiple ButtonRipleMinimize;
    private rojeru_san.RSButtonRiple ButtonRipleTodos;
    private rojerusan.RSComboMetro ComboMetroPesquisar;
    private rojeru_san.RSMTextFull MTextFullPesquisa;
    private rojerusan.RSTableMetro TableMetroAlunos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
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
