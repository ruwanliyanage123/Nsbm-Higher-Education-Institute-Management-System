package nsbm_higher_education.student;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import nsbm_higher_education.DatabaseConnection;

public class AddPost extends javax.swing.JInternalFrame {
    private String findCourseForIdNumber ="";
    private String idNumber;
    Connection connection = null;
    public AddPost() {
        initComponents();
        connection = DatabaseConnection.getDatabaseConnection();
    }
    
    /*
    funtion 01
    calculate the id number
    **/
    String calculateIdNumber(){
        idNumber ="UN"+findCourseForIdNumber;
        PreparedStatement ps;
        ResultSet rs;
        int updatingNumber =0;
        try{
            String query = "SELECT number FROM postgraduate_update_details";
            ps = (PreparedStatement) connection.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                updatingNumber = Integer.parseInt(rs.getString(1))+1;
            }
            query = "UPDATE `postgraduate_update_details` SET `number`=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1,updatingNumber);
            ps.executeUpdate();
            //create id number
            idNumber += Integer.toString(updatingNumber);
            
        }
        catch(NumberFormatException | SQLException e){
        }
        return idNumber;
    }
    
    
    /*
    funtion 02
    add details for the database
    **/
    void addForPostGraduateBasicDetails(){ 
        PreparedStatement ps;
        try{
            String query = "INSERT INTO `postgraduate_basic_details`( `id`,`name`, `address`, `nic`, `phone_number`, `email`, `dob`)"+ 
                    "VALUES('"+nic.getText()+"','"+name.getText()+"','"+address.getText()+"','"+nic.getText()+"','"+phone_number.getText()+"','"+email.getText()+"','"+dob.getText()+"') ";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.executeUpdate();
        }
        catch(SQLException e){
        }
    
    }
    
    /*
    funtion 03
    add details for the undergraduate_al_details table
    **/
    void addForPostGraduateAlDetails(){ 
        PreparedStatement ps;
        try{
            String query = "INSERT INTO `postgraduate_extra_details`( `id`,`institute`,`qualification`, `year`)"+ 
                    "VALUES('"+idNumber+"','"+institute1.getText()+"','"+qualification1.getText()+"','"+year1.getText()+"'),"
                    + "('"+idNumber+"','"+institute2.getText()+"','"+qualification2.getText()+"','"+year2.getText()+"')";
                    
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        COMPUTING = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BUSINESS = new javax.swing.JButton();
        ENGINEERING3 = new javax.swing.JButton();
        ENGINEER = new javax.swing.JButton();
        ENGINEERING5 = new javax.swing.JButton();
        institute1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        institute2 = new javax.swing.JTextField();
        year1 = new javax.swing.JTextField();
        qualification2 = new javax.swing.JTextField();
        year2 = new javax.swing.JTextField();
        message1 = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        message2 = new javax.swing.JTextField();
        qualification1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(null);

        COMPUTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/COMPU.jpg"))); // NOI18N
        COMPUTING.setAlignmentY(0.0F);
        COMPUTING.setBorder(null);
        COMPUTING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMPUTINGActionPerformed(evt);
            }
        });
        jPanel1.add(COMPUTING);
        COMPUTING.setBounds(520, 470, 100, 100);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("NAME");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 80, 130, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ADDRESS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 120, 100, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DOB");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 160, 60, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("INSTITUTE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 340, 120, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NIC");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 210, 60, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("EMAIL");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 250, 60, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("SELECT YOUR COURSE");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(280, 440, 190, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("YEAR");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(530, 340, 120, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("PHONE NUMBER");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(70, 290, 120, 15);

        BUSINESS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BUSI.jpg"))); // NOI18N
        BUSINESS.setAlignmentY(0.0F);
        BUSINESS.setBorder(null);
        BUSINESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSINESSActionPerformed(evt);
            }
        });
        jPanel1.add(BUSINESS);
        BUSINESS.setBounds(360, 470, 100, 100);

        ENGINEERING3.setAlignmentY(0.0F);
        ENGINEERING3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENGINEERING3ActionPerformed(evt);
            }
        });
        jPanel1.add(ENGINEERING3);
        ENGINEERING3.setBounds(440, 580, 100, 80);

        ENGINEER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ENGINEE.jpg"))); // NOI18N
        ENGINEER.setAlignmentY(0.0F);
        ENGINEER.setBorder(null);
        ENGINEER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENGINEERActionPerformed(evt);
            }
        });
        jPanel1.add(ENGINEER);
        ENGINEER.setBounds(200, 470, 100, 100);

        ENGINEERING5.setAlignmentY(0.0F);
        ENGINEERING5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENGINEERING5ActionPerformed(evt);
            }
        });
        jPanel1.add(ENGINEERING5);
        ENGINEERING5.setBounds(270, 580, 100, 80);

        institute1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        institute1.setForeground(new java.awt.Color(255, 0, 0));
        institute1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        institute1.setBorder(null);
        institute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute1ActionPerformed(evt);
            }
        });
        jPanel1.add(institute1);
        institute1.setBounds(60, 360, 200, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("QUALIFICQTION");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(350, 340, 120, 15);

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(255, 0, 0));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(210, 240, 380, 30);

        institute2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        institute2.setForeground(new java.awt.Color(255, 0, 0));
        institute2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        institute2.setBorder(null);
        institute2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                institute2ActionPerformed(evt);
            }
        });
        jPanel1.add(institute2);
        institute2.setBounds(60, 400, 200, 30);

        year1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        year1.setForeground(new java.awt.Color(255, 0, 0));
        year1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        year1.setBorder(null);
        year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year1ActionPerformed(evt);
            }
        });
        jPanel1.add(year1);
        year1.setBounds(580, 360, 110, 30);

        qualification2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qualification2.setForeground(new java.awt.Color(255, 0, 0));
        qualification2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qualification2.setBorder(null);
        qualification2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualification2ActionPerformed(evt);
            }
        });
        jPanel1.add(qualification2);
        qualification2.setBounds(290, 400, 250, 30);

        year2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        year2.setForeground(new java.awt.Color(255, 0, 0));
        year2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        year2.setBorder(null);
        year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year2ActionPerformed(evt);
            }
        });
        jPanel1.add(year2);
        year2.setBounds(580, 400, 110, 30);

        message1.setBackground(new java.awt.Color(0, 0, 0));
        message1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        message1.setForeground(new java.awt.Color(255, 204, 0));
        message1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        message1.setBorder(null);
        message1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message1ActionPerformed(evt);
            }
        });
        jPanel1.add(message1);
        message1.setBounds(890, 80, 220, 30);

        nic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nic.setForeground(new java.awt.Color(255, 0, 0));
        nic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        jPanel1.add(nic);
        nic.setBounds(210, 200, 380, 30);

        dob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dob.setForeground(new java.awt.Color(255, 0, 0));
        dob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dob.setBorder(null);
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });
        jPanel1.add(dob);
        dob.setBounds(210, 160, 380, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        address.setForeground(new java.awt.Color(255, 0, 0));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(210, 120, 380, 30);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 0, 0));
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name);
        name.setBounds(210, 80, 380, 30);

        phone_number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phone_number.setForeground(new java.awt.Color(255, 0, 0));
        phone_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone_number.setBorder(null);
        phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_numberActionPerformed(evt);
            }
        });
        jPanel1.add(phone_number);
        phone_number.setBounds(210, 280, 380, 30);

        message2.setBackground(new java.awt.Color(0, 0, 0));
        message2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 0, 0));
        message2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        message2.setBorder(null);
        message2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message2ActionPerformed(evt);
            }
        });
        jPanel1.add(message2);
        message2.setBounds(1120, 80, 80, 30);

        qualification1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qualification1.setForeground(new java.awt.Color(255, 0, 0));
        qualification1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qualification1.setBorder(null);
        qualification1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualification1ActionPerformed(evt);
            }
        });
        jPanel1.add(qualification1);
        qualification1.setBounds(290, 360, 250, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/post.jpg"))); // NOI18N
        jLabel3.setAlignmentY(0.0F);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 1350, 730);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(849, 849, 849)
                .addComponent(jButton1)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 391, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void COMPUTINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPUTINGActionPerformed
       findCourseForIdNumber = "CO";
       calculateIdNumber();
       message1.setText("HI! "+name.getText()+" your id number is :");
       message2.setText(idNumber);
       addForPostGraduateBasicDetails();
       addForPostGraduateAlDetails();
    }//GEN-LAST:event_COMPUTINGActionPerformed

    private void BUSINESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSINESSActionPerformed
       findCourseForIdNumber = "BU";
       calculateIdNumber();
       message1.setText("HI! "+name.getText()+" your id number is :");
       message2.setText(idNumber);
       addForPostGraduateBasicDetails();
       addForPostGraduateAlDetails();
    }//GEN-LAST:event_BUSINESSActionPerformed

    private void ENGINEERING3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENGINEERING3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ENGINEERING3ActionPerformed

    private void ENGINEERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENGINEERActionPerformed
       findCourseForIdNumber = "EN";
       calculateIdNumber();
       message1.setText("HI! "+name.getText()+" your id number is :");
       message2.setText(idNumber);
       addForPostGraduateBasicDetails();
       addForPostGraduateAlDetails();
    }//GEN-LAST:event_ENGINEERActionPerformed

    private void ENGINEERING5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENGINEERING5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ENGINEERING5ActionPerformed

    private void institute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute1ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void institute2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_institute2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_institute2ActionPerformed

    private void year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year1ActionPerformed

    private void qualification2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualification2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualification2ActionPerformed

    private void year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year2ActionPerformed

    private void message1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message1ActionPerformed

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void phone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_numberActionPerformed

    private void message2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message2ActionPerformed

    private void qualification1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualification1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualification1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSINESS;
    private javax.swing.JButton COMPUTING;
    private javax.swing.JButton ENGINEER;
    private javax.swing.JButton ENGINEERING3;
    private javax.swing.JButton ENGINEERING5;
    private javax.swing.JTextField address;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField institute1;
    private javax.swing.JTextField institute2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField message1;
    private javax.swing.JTextField message2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField phone_number;
    private javax.swing.JTextField qualification1;
    private javax.swing.JTextField qualification2;
    private javax.swing.JTextField year1;
    private javax.swing.JTextField year2;
    // End of variables declaration//GEN-END:variables
}
