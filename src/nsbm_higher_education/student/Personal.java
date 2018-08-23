package nsbm_higher_education.student;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import nsbm_higher_education.DatabaseConnection;
import nsbm_higher_education.email.ForSendEmail;

public class Personal extends javax.swing.JFrame {
    Connection connection;
    public Personal() {
        connection = connection = DatabaseConnection.getDatabaseConnection();
        initComponents();
    }
    
    /** 
     *function 01
     * add function for search students
     */
    void searchStudents(String checkGrasuation){
        String firstTwoLetters = checkGrasuation.substring(0,2);
        PreparedStatement ps;
        ResultSet rs;
        String query ="";
        try{
            if(firstTwoLetters.equals("UN")){
                query = "SELECT * FROM `undergraduate_basic_details` where id=?";
            }
            else{
                query = "SELECT * FROM `postgraduate_basic_details` where id=?";
            }
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            rs = ps.executeQuery();
            if(rs.next()){
                //id.setText(firstTwoLetters);
                name.setText(rs.getString(2));
                address.setText(rs.getString(3));
                nic.setText(rs.getString(4));
                phone_number.setText(rs.getString(5));
                email.setText(rs.getString(6));
                dob.setText(rs.getString(7));
            }
        }
        catch(NumberFormatException | SQLException e){
           e.printStackTrace();
        }
    }
    
    /**
     *function 2
     * add function for delete instructors
     */
    void deleteStudents(String checking){
        String getFirstTwo = checking.substring(0,2);
        PreparedStatement ps;
        ResultSet rs;
        String query;
        try{
            if(getFirstTwo.equals("UN")){
                query = "DELETE FROM `undergraduate_basic_details` WHERE  id=?";
            }
            else{
                query = "DELETE FROM `postgraduate_basic_details` WHERE  id=?";
            }
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
     /**
     *function 3
     * add function for update students
     */
    void updateStudents(String checking){
        String getFirstTwo = checking.substring(0,2);
        PreparedStatement ps;
        ResultSet rs;
        String query;
        try{
            if(getFirstTwo.equals("UN")){
             query= "UPDATE `undergraduate_basic_details` SET `name`=?,`address`=?,`nic`=?,`phone_number`=?,`email`=?,`dob`=? WHERE id=?";
            }
            else{
                query ="UPDATE `postgraduate_basic_details` SET `name`=?,`address`=?,`nic`=?,`phone_number`=?,`email`=?,`dob`=? WHERE id=?";
            }
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, name.getText());
            ps.setString(2, address.getText());
            ps.setString(3, nic.getText());
            ps.setString(4, phone_number.getText());
            ps.setString(5, email.getText());
            ps.setString(6, dob.getText());
            ps.setString(7, id.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    /*
    funtion 02
    show exam marks and grades
    **/
    void showValues(){
        PreparedStatement ps;
        ResultSet rs;
        try{
            
            String query = "select  `subject_code`, `marks`, `grade` from `exam_marks` where id =? ";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1,id.getText());
            
           
            rs = ps.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel();
            Object[] column = new Object[3];
            column[0] = "subject_code";
            column[1] = "marks";
            column[2] = "grade";
            
            model.setColumnIdentifiers(column);
            Object[] row = new Object[3];
            while(rs.next()){
                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
            table.setModel(model);
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }
    
    /*
    funtion 03
   clear table
    **/
    void clearTable(){
        
        try{
            DefaultTableModel model = new DefaultTableModel();
            Object[] column = new Object[3];
            column[0] = "subject code";
            column[1] = "marks";
            column[2] = "grade";
            
            model.setColumnIdentifiers(column);
            Object[] row = new Object[3];
            
                row[0] = "";
                row[1] = "";
                row[2] = "";
                
                model.addRow(row);
            
            table.setModel(model);
        }
        catch(Exception e){
            System.err.println(e);
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
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        send_mail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NAME");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(430, 130, 60, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ADDRESS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 170, 80, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NIC");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(430, 210, 60, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PHONE NUMBER");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(360, 240, 130, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DOB");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 330, 60, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ID");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(430, 90, 60, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("YOUR RESULTS FOR THE PAST EXAMINATION");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 360, 330, 17);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(153, 153, 153));
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setAlignmentX(0.0F);
        name.setAlignmentY(0.0F);
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name);
        name.setBounds(530, 120, 370, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        address.setForeground(new java.awt.Color(153, 153, 153));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setAlignmentX(0.0F);
        address.setAlignmentY(0.0F);
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(530, 160, 370, 30);

        nic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nic.setForeground(new java.awt.Color(153, 153, 153));
        nic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nic.setAlignmentX(0.0F);
        nic.setAlignmentY(0.0F);
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        jPanel1.add(nic);
        nic.setBounds(530, 200, 370, 30);

        phone_number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(153, 153, 153));
        phone_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone_number.setAlignmentX(0.0F);
        phone_number.setAlignmentY(0.0F);
        phone_number.setBorder(null);
        phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_numberActionPerformed(evt);
            }
        });
        jPanel1.add(phone_number);
        phone_number.setBounds(530, 240, 370, 30);

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setAlignmentX(0.0F);
        email.setAlignmentY(0.0F);
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(530, 280, 370, 30);

        dob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dob.setForeground(new java.awt.Color(153, 153, 153));
        dob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dob.setAlignmentX(0.0F);
        dob.setAlignmentY(0.0F);
        dob.setBorder(null);
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });
        jPanel1.add(dob);
        dob.setBounds(530, 320, 370, 30);

        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(153, 153, 153));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setAlignmentX(0.0F);
        id.setAlignmentY(0.0F);
        id.setBorder(null);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id);
        id.setBounds(530, 80, 370, 30);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        delete.setAlignmentY(0.0F);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(670, 600, 100, 100);

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.jpg"))); // NOI18N
        clear.setAlignmentY(0.0F);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear);
        clear.setBounds(910, 600, 100, 100);

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-8.jpg"))); // NOI18N
        update.setAlignmentY(0.0F);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(550, 600, 100, 100);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BASK.jpg"))); // NOI18N
        back.setAlignmentY(0.0F);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(420, 600, 100, 100);

        send_mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/email.jpg"))); // NOI18N
        send_mail.setAlignmentY(0.0F);
        send_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_mailActionPerformed(evt);
            }
        });
        jPanel1.add(send_mail);
        send_mail.setBounds(670, 490, 100, 100);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "              subject_code", "              marks", "              grade"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(480, 380, 452, 100);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("EMAIL");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(430, 280, 60, 17);

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.jpg"))); // NOI18N
        search.setAlignmentY(0.0F);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(790, 600, 100, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reuslting.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 730);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void phone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_numberActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deleteStudents(id.getText());
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
                clearTable();
                id.setText("");
                name.setText("");
                address.setText("");
                nic.setText("");
                phone_number.setText("");
                email.setText("");
                dob.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updateStudents(id.getText());
    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       StudentDashboard stu = new StudentDashboard();
       stu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void send_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_mailActionPerformed
       SendEmail email = new SendEmail();
       String a = "primehit2018@gmail.com";
       String b = "result";
       String c = "your result is A B C D";
       String d = "primehit2018@gmail.com";
       String e = "0772308519";
       email.send(a,b,c,d,e);
    }//GEN-LAST:event_send_mailActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        searchStudents(id.getText());
        showValues();
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField phone_number;
    private javax.swing.JButton search;
    private javax.swing.JButton send_mail;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
