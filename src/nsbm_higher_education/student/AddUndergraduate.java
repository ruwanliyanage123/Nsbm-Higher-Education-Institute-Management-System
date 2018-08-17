package nsbm_higher_education.student;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import nsbm_higher_education.DatabaseConnection;

public class AddUndergraduate extends javax.swing.JInternalFrame {
    private String findCourseForIdNumber ="";
    private String idNumber;
    Connection connection = null;
    public AddUndergraduate() {
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
            String query = "SELECT number FROM undergraduate_update_details";
            ps = (PreparedStatement) connection.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                updatingNumber = Integer.parseInt(rs.getString(1))+1;
            }
            query = "UPDATE `undergraduate_update_details` SET `number`=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1,updatingNumber);
            ps.executeUpdate();
            //create id number
            idNumber += Integer.toString(updatingNumber);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return idNumber;
    }
    
    /*
    funtion 02
    add details for the database
    **/
    void addForUnderGraduateBasicDetails(){ 
        PreparedStatement ps;
        try{
            String query = "INSERT INTO `undergraduate_basic_details`( `id`,`name`, `address`, `nic`, `phone_number`, `email`, `dob`, `a/l index`, `island_rank`)"+ 
                    "VALUES('"+nic.getText()+"','"+name.getText()+"','"+address.getText()+"','"+nic.getText()+"','"+phone_number.getText()+"','"+email.getText()+"','"+dob.getText()+"','"+al_index.getText()+"','"+island_rank1.getText()+"') ";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    /*
    funtion 03
    add details for the undergraduate_al_details table
    **/
    void addForUnderGraduateAlDetails(){ 
        PreparedStatement ps;
        try{
            String query = "INSERT INTO `undergraduate_al_details`( `al_index`,`al_subject`, `grade`)"+ 
                    "VALUES('"+al_index.getText()+"','"+al_subject1.getText()+"','"+grade1.getText()+"'),"
                    + "('"+al_index.getText()+"','"+al_subject2.getText()+"','"+grade2.getText()+"'),"
                     + "('"+al_index.getText()+"','"+al_subject3.getText()+"','"+grade3.getText()+"') ";
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        BUSINESS = new javax.swing.JButton();
        nic = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        al_subject1 = new javax.swing.JTextField();
        message_box = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        al_subject2 = new javax.swing.JTextField();
        al_subject3 = new javax.swing.JTextField();
        grade1 = new javax.swing.JTextField();
        grade2 = new javax.swing.JTextField();
        grade3 = new javax.swing.JTextField();
        al_index = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ENGINEERING = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        COMPUTING = new javax.swing.JButton();
        island_rank1 = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(1350, 730));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 730));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NAME");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 120, 30, 13);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ADDRESS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 170, 70, 13);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(140, 360, 50, 0);
        jPanel1.add(jLabel28);
        jLabel28.setBounds(400, 470, 100, 0);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NIC");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 210, 30, 13);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PHONE NUMBER");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(110, 250, 90, 13);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("EMAIL");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(160, 280, 40, 13);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DATE OF BIRTH");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 330, 100, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ISLAND RANK");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(440, 400, 90, 13);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 0));
        jLabel16.setText("GRADE");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(460, 430, 90, 13);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("A/L INDEX");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 400, 60, 13);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("select your course");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(380, 570, 100, 20);

        address.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        address.setForeground(new java.awt.Color(0, 51, 255));
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address);
        address.setBounds(230, 160, 410, 30);

        BUSINESS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BUSI.jpg"))); // NOI18N
        BUSINESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSINESSActionPerformed(evt);
            }
        });
        jPanel1.add(BUSINESS);
        BUSINESS.setBounds(390, 590, 100, 100);

        nic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nic.setForeground(new java.awt.Color(0, 51, 255));
        nic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        jPanel1.add(nic);
        nic.setBounds(230, 200, 410, 30);

        phone_number.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phone_number.setForeground(new java.awt.Color(0, 51, 255));
        phone_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_numberActionPerformed(evt);
            }
        });
        jPanel1.add(phone_number);
        phone_number.setBounds(230, 240, 410, 30);

        email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 255));
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(230, 280, 410, 30);

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name.setForeground(new java.awt.Color(0, 51, 255));
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name);
        name.setBounds(230, 120, 410, 30);

        al_subject1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        al_subject1.setForeground(new java.awt.Color(0, 51, 255));
        al_subject1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        al_subject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al_subject1ActionPerformed(evt);
            }
        });
        jPanel1.add(al_subject1);
        al_subject1.setBounds(230, 450, 170, 30);

        message_box.setBackground(new java.awt.Color(0, 0, 0));
        message_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        message_box.setForeground(new java.awt.Color(255, 255, 0));
        message_box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        message_box.setBorder(null);
        message_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message_boxActionPerformed(evt);
            }
        });
        jPanel1.add(message_box);
        message_box.setBounds(880, 140, 290, 30);

        dob.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(0, 51, 255));
        dob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobActionPerformed(evt);
            }
        });
        jPanel1.add(dob);
        dob.setBounds(230, 320, 410, 30);

        al_subject2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        al_subject2.setForeground(new java.awt.Color(0, 51, 255));
        al_subject2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        al_subject2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al_subject2ActionPerformed(evt);
            }
        });
        jPanel1.add(al_subject2);
        al_subject2.setBounds(230, 490, 170, 30);

        al_subject3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        al_subject3.setForeground(new java.awt.Color(0, 51, 255));
        al_subject3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        al_subject3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al_subject3ActionPerformed(evt);
            }
        });
        jPanel1.add(al_subject3);
        al_subject3.setBounds(230, 530, 170, 30);

        grade1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grade1.setForeground(new java.awt.Color(0, 51, 255));
        grade1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade1ActionPerformed(evt);
            }
        });
        jPanel1.add(grade1);
        grade1.setBounds(460, 450, 60, 30);

        grade2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grade2.setForeground(new java.awt.Color(0, 51, 255));
        grade2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade2ActionPerformed(evt);
            }
        });
        jPanel1.add(grade2);
        grade2.setBounds(460, 490, 60, 30);

        grade3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grade3.setForeground(new java.awt.Color(0, 51, 255));
        grade3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        grade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade3ActionPerformed(evt);
            }
        });
        jPanel1.add(grade3);
        grade3.setBounds(460, 530, 60, 30);

        al_index.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        al_index.setForeground(new java.awt.Color(0, 51, 255));
        al_index.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        al_index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al_indexActionPerformed(evt);
            }
        });
        jPanel1.add(al_index);
        al_index.setBounds(230, 390, 170, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 0));
        jLabel12.setText("SUBJECT");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(290, 430, 70, 10);

        ENGINEERING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ENGINEE.jpg"))); // NOI18N
        ENGINEERING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENGINEERINGActionPerformed(evt);
            }
        });
        jPanel1.add(ENGINEERING);
        ENGINEERING.setBounds(230, 590, 100, 100);

        submit.setText("submit");
        jPanel1.add(submit);
        submit.setBounds(780, 690, 63, 23);

        COMPUTING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/COMPU.jpg"))); // NOI18N
        COMPUTING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMPUTINGActionPerformed(evt);
            }
        });
        jPanel1.add(COMPUTING);
        COMPUTING.setBounds(540, 590, 100, 100);

        island_rank1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        island_rank1.setForeground(new java.awt.Color(0, 51, 255));
        island_rank1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        island_rank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                island_rank1ActionPerformed(evt);
            }
        });
        jPanel1.add(island_rank1);
        island_rank1.setBounds(550, 390, 90, 30);

        reset.setText("reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(910, 690, 57, 23);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/app.jpg"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 20, 2010, 740);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -40, 1580, 870);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        
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

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void al_subject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al_subject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al_subject1ActionPerformed

    private void dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobActionPerformed

    private void message_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message_boxActionPerformed

    private void al_subject2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al_subject2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al_subject2ActionPerformed

    private void al_subject3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al_subject3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al_subject3ActionPerformed

    private void grade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grade1ActionPerformed

    private void grade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grade2ActionPerformed

    private void grade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grade3ActionPerformed

    private void al_indexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al_indexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al_indexActionPerformed

    private void island_rank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_island_rank1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_island_rank1ActionPerformed

    private void ENGINEERINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENGINEERINGActionPerformed
       findCourseForIdNumber = "EN";
       calculateIdNumber();
       message_box.setText("HI! "+name.getText()+" your id number is :"+idNumber);
       addForUnderGraduateBasicDetails();
       addForUnderGraduateAlDetails();
       
    }//GEN-LAST:event_ENGINEERINGActionPerformed

    private void BUSINESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSINESSActionPerformed
        findCourseForIdNumber ="BU";
        calculateIdNumber();
        message_box.setText("HI! "+name.getText()+" your id number is :"+idNumber);
        addForUnderGraduateBasicDetails();
        addForUnderGraduateAlDetails();
        
    }//GEN-LAST:event_BUSINESSActionPerformed

    private void COMPUTINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPUTINGActionPerformed
        findCourseForIdNumber = "CO";
        calculateIdNumber();
        message_box.setText("HI! "+name.getText()+" your id number is :"+idNumber);
        addForUnderGraduateBasicDetails();
        addForUnderGraduateAlDetails();
        
    }//GEN-LAST:event_COMPUTINGActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        name.setText("");
        address.setText("");
        email.setText("");
        phone_number.setText("");
        dob.setText("");
        grade1.setText("");
        grade2.setText("");
        grade3.setText("");
        al_subject1.setText("");
        al_subject2.setText("");
        al_subject3.setText("");
        island_rank1.setText("");
        al_index.setText("");
        message_box.setText("");
        nic.setText("");
        idNumber ="";
    }//GEN-LAST:event_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSINESS;
    private javax.swing.JButton COMPUTING;
    private javax.swing.JButton ENGINEERING;
    private javax.swing.JTextField address;
    private javax.swing.JTextField al_index;
    private javax.swing.JTextField al_subject1;
    private javax.swing.JTextField al_subject2;
    private javax.swing.JTextField al_subject3;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField grade1;
    private javax.swing.JTextField grade2;
    private javax.swing.JTextField grade3;
    private javax.swing.JTextField island_rank1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField message_box;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField phone_number;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
