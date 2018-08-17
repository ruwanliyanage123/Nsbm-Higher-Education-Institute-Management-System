package nsbm_higher_education.student;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StudentDashboard extends javax.swing.JFrame {
public InputStream pic = this.getClass().getResourceAsStream("studentDash.jpg");
    public StudentDashboard() {
        //for add background image for dashboard
        initComponents();
        showImage(display,pic);
        setVisible(true);
    }
public void showImage(javax.swing.JDesktopPane desktopPane, InputStream fileImage){
        try{
        BufferedImage image = ImageIO.read(fileImage);
        desktopPane.setBorder(new AddDashboardBackround(image));
        }
        catch(Exception e){System.err.print(e+"image no display");}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JDesktopPane();
        addUndergraduate = new javax.swing.JButton();
        home = new javax.swing.JButton();
        addPostGraduate = new javax.swing.JButton();
        results = new javax.swing.JButton();
        personal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 730));

        display.setPreferredSize(new java.awt.Dimension(1350, 730));

        addUndergraduate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/undergra.jpg"))); // NOI18N
        addUndergraduate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUndergraduateActionPerformed(evt);
            }
        });

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.jpg"))); // NOI18N

        addPostGraduate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UNDER.jpg"))); // NOI18N
        addPostGraduate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostGraduateActionPerformed(evt);
            }
        });

        results.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/results.jpg"))); // NOI18N
        results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsActionPerformed(evt);
            }
        });

        personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/personal.jpg"))); // NOI18N

        display.setLayer(addUndergraduate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        display.setLayer(home, javax.swing.JLayeredPane.DEFAULT_LAYER);
        display.setLayer(addPostGraduate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        display.setLayer(results, javax.swing.JLayeredPane.DEFAULT_LAYER);
        display.setLayer(personal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(addPostGraduate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(addUndergraduate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(results, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(personal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addGroup(displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUndergraduate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPostGraduate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(results, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 463, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPostGraduateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPostGraduateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPostGraduateActionPerformed

    private void resultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultsActionPerformed

    private void addUndergraduateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUndergraduateActionPerformed
        display.removeAll();
        AddUndergraduate addUndergraduate = new AddUndergraduate();
        display.add(addUndergraduate).setVisible(true);
    }//GEN-LAST:event_addUndergraduateActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPostGraduate;
    private javax.swing.JButton addUndergraduate;
    private javax.swing.JDesktopPane display;
    private javax.swing.JButton home;
    private javax.swing.JButton personal;
    private javax.swing.JButton results;
    // End of variables declaration//GEN-END:variables
}
