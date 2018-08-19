package nsbm_higher_education;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Instructor extends javax.swing.JFrame {
    Connection connection = null;
    public Instructor() {
        connection = DatabaseConnection.getDatabaseConnection();
        initComponents();
    }
    
    /**
     *function 1
     * add function for add `instructors` 
     */
    void addInstructors(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "INSERT INTO `instructors`(`nic`, `name`, `address`, `phone_number`, `degree`, `course`) VALUES(?,?,?,?,?,?)";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, nic.getText());
            ps.setString(2, name.getText());
            ps.setString(3, address.getText());
            ps.setString(4, phone_number.getText());
            ps.setString(5, degree.getText());
            ps.setString(6, course.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    /**
     *function 2
     * add function for delete instructors
     */
    void deleteInstructors(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "DELETE FROM `instructors` WHERE  nic=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, nic.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    /**
     *function 3
     * add function for update instructors
     */
    void updateInstructors(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "UPDATE `instructors` SET `name`=?,`address`=?,`phone_number`=?,`degree`=?,`course`=? WHERE nic=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, name.getText());
            ps.setString(2, address.getText());
            ps.setString(3, phone_number.getText());
            ps.setString(4, degree.getText());
            ps.setString(5, course.getText());
            ps.setString(6, nic.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    /**
     *function 4
     * add function for search instructors
     */
    void searchInstructors(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "SELECT * FROM `instructors` where nic=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, nic.getText());
            rs = ps.executeQuery();
            if(rs.next()){
                name.setText(rs.getString(2));
                address.setText(rs.getString(3));
                phone_number.setText(rs.getString(4));
                degree.setText(rs.getString(5));
                course.setText(rs.getString(6));
            }
        }
        catch(NumberFormatException | SQLException e){
        }
    }
    
    
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        degree = new javax.swing.JTextField();
        course = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        SEARCH = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 730));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NAME");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(500, 210, 50, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ADDRESS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 250, 80, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("PHONE NUMER");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(450, 290, 100, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("COURSE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(490, 370, 60, 14);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DEGREE");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(490, 330, 60, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("NIC");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(520, 170, 30, 14);

        name.setForeground(new java.awt.Color(255, 0, 255));
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name);
        name.setBounds(570, 200, 360, 30);

        address.setForeground(new java.awt.Color(255, 0, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(570, 240, 360, 30);

        phone_number.setForeground(new java.awt.Color(255, 0, 255));
        phone_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone_number.setBorder(null);
        phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_numberActionPerformed(evt);
            }
        });
        jPanel1.add(phone_number);
        phone_number.setBounds(570, 280, 360, 30);

        degree.setForeground(new java.awt.Color(255, 0, 255));
        degree.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        degree.setBorder(null);
        degree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeActionPerformed(evt);
            }
        });
        jPanel1.add(degree);
        degree.setBounds(570, 320, 360, 30);

        course.setForeground(new java.awt.Color(255, 0, 255));
        course.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        course.setBorder(null);
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course);
        course.setBounds(570, 360, 360, 30);

        nic.setForeground(new java.awt.Color(255, 0, 255));
        nic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        jPanel1.add(nic);
        nic.setBounds(570, 160, 360, 30);

        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        DELETE.setAlignmentY(0.0F);
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel1.add(DELETE);
        DELETE.setBounds(620, 430, 100, 100);

        UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-8.jpg"))); // NOI18N
        UPDATE.setAlignmentY(0.0F);
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        jPanel1.add(UPDATE);
        UPDATE.setBounds(750, 430, 100, 100);

        SEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.jpg"))); // NOI18N
        SEARCH.setAlignmentY(0.0F);
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });
        jPanel1.add(SEARCH);
        SEARCH.setBounds(870, 430, 100, 100);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BASK.jpg"))); // NOI18N
        BACK.setAlignmentY(0.0F);
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        jPanel1.add(BACK);
        BACK.setBounds(590, 550, 100, 100);

        CLEAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.jpg"))); // NOI18N
        CLEAR.setAlignmentY(0.0F);
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });
        jPanel1.add(CLEAR);
        CLEAR.setBounds(750, 550, 100, 100);

        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        ADD.setAlignmentY(0.0F);
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel1.add(ADD);
        ADD.setBounds(480, 430, 100, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/instructor.jpg"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void phone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_numberActionPerformed

    private void degreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_degreeActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
       addInstructors();
    }//GEN-LAST:event_ADDActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        deleteInstructors();
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        updateInstructors();
    }//GEN-LAST:event_UPDATEActionPerformed

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
        searchInstructors();
    }//GEN-LAST:event_SEARCHActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
                nic.setText("");
                name.setText("");
                address.setText("");
                phone_number.setText("");
                degree.setText("");
                course.setText("");
    }//GEN-LAST:event_CLEARActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        DashBoard dash = new DashBoard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BACKActionPerformed

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
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instructor().setVisible(true);
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
    private javax.swing.JTextField address;
    private javax.swing.JTextField course;
    private javax.swing.JTextField degree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField phone_number;
    // End of variables declaration//GEN-END:variables
}
