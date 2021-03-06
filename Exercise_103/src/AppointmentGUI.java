
import java.io.File;
import javax.swing.JOptionPane;

public class AppointmentGUI extends javax.swing.JFrame {

    public static AppaintmentModel bl = new AppaintmentModel();
    private File f = new File("./appointments.ser");

    public AppointmentGUI() {
        initComponents();
        liOut.setModel(bl);
        try {
            bl.load(new File("./appointments.ser"));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something wrent wrong at loading the data!");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jmAdd = new javax.swing.JMenuItem();
        jmDelete = new javax.swing.JMenuItem();
        jmChange = new javax.swing.JMenuItem();
        jmSortName = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        liOut = new javax.swing.JList<>();

        jMenu1.setText("Termin");

        jmAdd.setText("hinzufügen");
        jmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddActionPerformed(evt);
            }
        });
        jMenu1.add(jmAdd);

        jmDelete.setText("löschen");
        jmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(jmDelete);

        jmChange.setText("ändern");
        jmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmChangeActionPerformed(evt);
            }
        });
        jMenu1.add(jmChange);

        jPopupMenu1.add(jMenu1);

        jmSortName.setText("SortByName");
        jmSortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSortNameActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmSortName);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        liOut.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointments"));
        liOut.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(liOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddActionPerformed
        AppointmentDlg dialog = new AppointmentDlg(this, true);
        dialog.setVisible(true);
        if (dialog.isOK()) {
            Appointment a = dialog.getA();
            bl.add(a);
        }


    }//GEN-LAST:event_jmAddActionPerformed

    private void jmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDeleteActionPerformed
        try {
            bl.remove(liOut.getSelectedValue());
        } catch (IndexOutOfBoundsException ix) {
            JOptionPane.showMessageDialog(null, "You can't delete nothing!");
        }
    }//GEN-LAST:event_jmDeleteActionPerformed

    private void jmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmChangeActionPerformed
        AppointmentDlg dialog = new AppointmentDlg(this, true, liOut.getSelectedValue());
        dialog.setVisible(true);
        if (dialog.isOK()) {
            Appointment a = dialog.getA();
            bl.add(a);
        }
    }//GEN-LAST:event_jmChangeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            bl.safe(new File("./appointments.ser"));
        } catch (Exception ex) {
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Something wrent wrong while saving!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void jmSortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSortNameActionPerformed
        bl.sortName();
    }//GEN-LAST:event_jmSortNameActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmAdd;
    private javax.swing.JMenuItem jmChange;
    private javax.swing.JMenuItem jmDelete;
    private javax.swing.JMenuItem jmSortName;
    private javax.swing.JList<Appointment> liOut;
    // End of variables declaration//GEN-END:variables
}
