/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerApp;
import Controller.ControllerConversa;
import Controller.ObservadoConversa;
import Controller.ObservadorConversa;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Jessica
 */
public class Conversa extends javax.swing.JFrame implements ObservadorConversa {

    private ObservadoConversa controller;
    private ControllerApp controllerApp;

    /**
     * Creates new form snakke
     */
    public Conversa(ObservadoConversa controller, ControllerApp app) {
        this.controller = controller;
        this.controller.addObservador(this);
        controllerApp = app;
        initComponents();
        controller.nomeUsuario();
        setTitle("Snakke");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void onClose() {
        this.controllerApp.removerJanelaConversa(this);
    }

    public JLabel getjLNomePessoa() {
        return jLNomePessoa;
    }

    public JTextArea getjTextAreaConversa() {
        return jTextAreaConversa;
    }

    public JTextArea getjTextAreaMensagem() {
        return jTextAreaMensagem;
    }

    public ObservadoConversa getController() {
        return controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNomePessoa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaConversa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMensagem = new javax.swing.JTextArea();
        jButtonEnviar = new javax.swing.JButton();
        jArquivo = new javax.swing.JLabel();
        jAudio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLNomePessoa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLNomePessoa.setText("Fulano da silva");

        jTextAreaConversa.setEditable(false);
        jTextAreaConversa.setColumns(20);
        jTextAreaConversa.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaConversa.setRows(5);
        jScrollPane1.setViewportView(jTextAreaConversa);

        jTextAreaMensagem.setColumns(25);
        jTextAreaMensagem.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextAreaMensagem.setRows(3);
        jScrollPane2.setViewportView(jTextAreaMensagem);

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anexo.png"))); // NOI18N
        jArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jArquivoMouseClicked(evt);
            }
        });

        jAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/audio.png"))); // NOI18N
        jAudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAudioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        onClose();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        controller.onEnviarMsg(getjTextAreaMensagem().getText());
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jArquivoMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle("Escolha o arquivo");
        
        if (chooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
                File fileSelected = chooser.getSelectedFile();
                controller.enviarArquivo(fileSelected);
        }
    }//GEN-LAST:event_jArquivoMouseClicked

    private void jAudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAudioMouseClicked
        Audio audio = new Audio(this.controller.getUsuario(), this.controller);
        controller.onEnviarAudio();
    }//GEN-LAST:event_jAudioMouseClicked

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
            java.util.logging.Logger.getLogger(Conversa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conversa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conversa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conversa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jArquivo;
    private javax.swing.JLabel jAudio;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLNomePessoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaConversa;
    private javax.swing.JTextArea jTextAreaMensagem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizarNome(String nome) {
        getjLNomePessoa().setText(nome);
    }

    @Override
    public void atualizarTela(String msg) {
        getjTextAreaConversa().append(msg + "\n");
        getjTextAreaMensagem().setText("");
    }
}
