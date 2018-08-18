package nsbm_higher_education.subjects;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import nsbm_higher_education.DatabaseConnection;

public class SubjectsDetails extends javax.swing.JFrame {
    Connection connection = null;
    
    public SubjectsDetails() {
        connection = DatabaseConnection.getDatabaseConnection();
        initComponents();
    }

    /**
     *function 1
     * add function for search subjects 
     */
    void searchSubjects(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "SELECT * FROM `subjects` where subject_code=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, subject_code.getText());
            rs = ps.executeQuery();
            if(rs.next()){
                subject_name.setText(rs.getString(2));
                number_of_credits.setText(rs.getString(3));
                fee.setText(rs.getString(4));
                semester.setText(rs.getString(5));
                
            }
        }
        catch(NumberFormatException | SQLException e){
        }
    }
    /**
     *function 1
     * add function for search subjects 
     */
    void deleteSubjects(){
        
        PreparedStatement ps;
        ResultSet rs;
        int updatingNumber =0;
        try{
            String query = "DELETE FROM `subjects` WHERE  subject_code=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, subject_code.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        number_of_credits = new javax.swing.JTextField();
        semester = new javax.swing.JTextField();
        subject_name = new javax.swing.JTextField();
        subject_code = new javax.swing.JTextField();
        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        SEARCH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SUBJECT_CODE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(460, 170, 110, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NUMBER OF CREDIT");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(430, 270, 140, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("AMOUNT");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 390, 80, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SEMEMTER");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(470, 330, 100, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SUBJECT_NAME");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(470, 220, 100, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CPMPUTING    |   ENGINEERING  |   BUSINESS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(470, 110, 460, 40);

        fee.setForeground(new java.awt.Color(255, 0, 51));
        fee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fee.setAlignmentY(0.0F);
        fee.setBorder(null);
        fee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeActionPerformed(evt);
            }
        });
        jPanel1.add(fee);
        fee.setBounds(610, 390, 290, 30);

        number_of_credits.setForeground(new java.awt.Color(255, 0, 51));
        number_of_credits.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number_of_credits.setAlignmentY(0.0F);
        number_of_credits.setBorder(null);
        number_of_credits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                number_of_creditsActionPerformed(evt);
            }
        });
        jPanel1.add(number_of_credits);
        number_of_credits.setBounds(610, 270, 290, 30);

        semester.setForeground(new java.awt.Color(255, 0, 51));
        semester.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        semester.setAlignmentY(0.0F);
        semester.setBorder(null);
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });
        jPanel1.add(semester);
        semester.setBounds(610, 330, 290, 30);

        subject_name.setForeground(new java.awt.Color(255, 0, 51));
        subject_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subject_name.setAlignmentY(0.0F);
        subject_name.setBorder(null);
        subject_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_nameActionPerformed(evt);
            }
        });
        jPanel1.add(subject_name);
        subject_name.setBounds(610, 220, 290, 30);

        subject_code.setForeground(new java.awt.Color(255, 0, 51));
        subject_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subject_code.setAlignmentY(0.0F);
        subject_code.setBorder(null);
        subject_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_codeActionPerformed(evt);
            }
        });
        jPanel1.add(subject_code);
        subject_code.setBounds(610, 170, 290, 30);

        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel1.add(DELETE);
        DELETE.setBounds(570, 450, 100, 100);

        UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-8.jpg"))); // NOI18N
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        jPanel1.add(UPDATE);
        UPDATE.setBounds(700, 450, 100, 100);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BASK.jpg"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        jPanel1.add(BACK);
        BACK.setBounds(570, 570, 100, 100);

        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel1.add(ADD);
        ADD.setBounds(440, 450, 100, 100);

        CLEAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.jpg"))); // NOI18N
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });
        jPanel1.add(CLEAR);
        CLEAR.setBounds(710, 570, 100, 100);

        SEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.jpg"))); // NOI18N
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });
        jPanel1.add(SEARCH);
        SEARCH.setBounds(820, 450, 100, 100);

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/subjects.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -30, 1350, 790);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void feeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeActionPerformed

    private void number_of_creditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number_of_creditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_number_of_creditsActionPerformed

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void subject_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_nameActionPerformed

    private void subject_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_codeActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UPDATEActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BACKActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
                subject_code.setText("");
                subject_name.setText("");
                number_of_credits.setText("");
                fee.setText("");
                semester.setText("");
    }//GEN-LAST:event_CLEARActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        deleteSubjects();
    }//GEN-LAST:event_DELETEActionPerformed

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
       searchSubjects();
    }//GEN-LAST:event_SEARCHActionPerformed

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
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectsDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton BACK;
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton SEARCH;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField fee;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField number_of_credits;
    private javax.swing.JTextField semester;
    private javax.swing.JTextField subject_code;
    private javax.swing.JTextField subject_name;
    // End of variables declaration//GEN-END:variables
}
