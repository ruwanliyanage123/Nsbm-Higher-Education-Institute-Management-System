package nsbm_higher_education.student;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import nsbm_higher_education.DashBoard;
import nsbm_higher_education.DatabaseConnection;

public class Result extends javax.swing.JFrame {
    public float totalMarks =0;
    public String grad;
    Connection connection = null;
    public Result() {
        initComponents();
        connection = DatabaseConnection.getDatabaseConnection();
    }
    /*
    function 1
    add addAssignment function
    **/
    void addAssignment(){
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "INSERT INTO `assignment_marks`(`id`, `subject_code`, `assignment`, `marks`)  VALUES(?,?,?,?)";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.setString(2, subject_code.getText());
            ps.setString(3, assignment_number.getText());
            ps.setString(4, assignment_marks.getText());
          
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    
    }
    
     
    /*
    funtion 02
    show assignment marks
    **/
    void showValues(){
        PreparedStatement ps;
        ResultSet rs;
        try{
            
            String query = "select `assignment`, `marks` from assignment_marks where id =? and subject_code  =?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1,id.getText());
            ps.setString(2,subject_code.getText());
           
            rs = ps.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel();
            Object[] column = new Object[2];
            column[0] = "assignment";
            column[1] = "marks";
            
            model.setColumnIdentifiers(column);
            Object[] row = new Object[2];
            while(rs.next()){
                
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
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
    find total assignment marks
    **/
    float findTotalAssignmentMarks(){
        PreparedStatement ps;
        ResultSet rs;
        int total = 0;
        int numberOfAssignment=0;
        float averageTotal =0;
        try{ 
            String query = "select `marks` from assignment_marks where id =? and subject_code  =?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1,id.getText());
            ps.setString(2,subject_code.getText());
            rs = ps.executeQuery();
            while(rs.next()){
                total += Integer.parseInt(rs.getString(1));
                numberOfAssignment++;
            }
            averageTotal = (float)(total/numberOfAssignment);
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
        
        return averageTotal;
    }
    /*
    funtion 04
    find total marks
    **/
    float findTotalMarks(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        int examMarks =0;
        int assignmentPercent =0;
        int examPercent =0;
        float assignmentTotal =0;
        try{ 
            examMarks = Integer.parseInt(exam_marks.getText());
            assignmentPercent =Integer.parseInt(assignment_percentage.getText());
            examPercent =Integer.parseInt(exam_percentage.getText()); 
            assignmentTotal = findTotalAssignmentMarks();//get total value
            totalMarks = (float)(((examPercent*examMarks)/100)+((assignmentTotal*assignmentPercent)/100));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return totalMarks;
    }
    
    /*
    funtion 05
    find total marks
    **/
    public String getGrade(float marks){
        if((90<=marks)&&(marks<=100)){return "A+";}
        if((80<=marks)&&(marks<=89)){return "A";}
        if((75<=marks)&&(marks<=79)){return "A-";}
        if((70<=marks)&&(marks<=74)){return "B+";}
        
        if((65<=marks)&&(marks<=69)){return "B";}
        if((60<=marks)&&(marks<=64)){return "B-";}
        if((55<=marks)&&(marks<=59)){return "C+";}
        if((50<=marks)&&(marks<=54)){return "C";}
        if((45<=marks)&&(marks<=49)){return "C-";}
        if((40<=marks)&&(marks<=44)){return "D+";}
        if((30<=marks)&&(marks<=39)){return "D";}
        if((20<=marks)&&(marks<=29)){return "D-";}
        if((00<=marks)&&(marks<=19)){return "E";}
        else{
            return "false";
        }
    }
     /*
    funtion 06
    add final marks for database
    **/
    void addForExamMarks(){
        PreparedStatement ps;
        ResultSet rs;
        String totalMarksAsString;
        totalMarksAsString  =  Float.toString(totalMarks); 
        try{
            String query = "INSERT INTO `exam_marks`(`id`, `subject_code`, `marks`, `grade`)  VALUES(?,?,?,?)";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.setString(2, subject_code.getText());
            ps.setString(3, totalMarksAsString);
            ps.setString(4, grad);
          
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    /**
     *function 07
     * add function for search subjects 
     */
    void searchSubjects(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "SELECT * FROM `exam_marks` where subject_code=? and id =?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, subject_code.getText());
            ps.setString(2, id.getText());
            rs = ps.executeQuery();
            if(rs.next()){
                message1.setText(rs.getString(3));
                message2.setText(rs.getString(4));
            }
        }
        catch(NumberFormatException | SQLException e){
        }
    }
    /**
     *function 08
     * add function for delete exam_marks 
     */
    void deleteExam_marks(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "DELETE FROM `exam_marks` WHERE  id=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
     /**
     *function 09
     * add function for delete assignment_marks
     */
    void deleteAssignment_marks(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            String query = "DELETE FROM `assignment_marks` WHERE  id=?";
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.executeUpdate();
        }
        catch(NumberFormatException | SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        add_assignment = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        message2 = new javax.swing.JTextField();
        assignment_marks = new javax.swing.JTextField();
        exam_percentage = new javax.swing.JTextField();
        subject_code = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        assignment_percentage = new javax.swing.JTextField();
        exam_marks = new javax.swing.JTextField();
        delete_result = new javax.swing.JButton();
        view_result = new javax.swing.JButton();
        add_result = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        message1 = new javax.swing.JTextField();
        assignment_number = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        clear_assignment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setPreferredSize(new java.awt.Dimension(1350, 730));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SUBJECT CODE");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(470, 150, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STUDENT ID");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(500, 110, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ASSIGNMENT MARKS");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(550, 420, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FINAL MARKS");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(590, 320, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EXAM MARKS");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(270, 470, 80, 30);

        add_assignment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adding.jpg"))); // NOI18N
        add_assignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_assignmentActionPerformed(evt);
            }
        });
        jPanel2.add(add_assignment);
        add_assignment.setBounds(840, 420, 80, 50);

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.jpg"))); // NOI18N
        clear.setAlignmentY(0.0F);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear);
        clear.setBounds(840, 550, 100, 100);

        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(102, 0, 204));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setBorder(null);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel2.add(id);
        id.setBounds(600, 110, 180, 30);

        message2.setBackground(new java.awt.Color(0, 0, 0));
        message2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 255, 0));
        message2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        message2.setAlignmentX(0.0F);
        message2.setAlignmentY(0.0F);
        message2.setBorder(null);
        message2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message2ActionPerformed(evt);
            }
        });
        jPanel2.add(message2);
        message2.setBounds(690, 350, 70, 30);

        assignment_marks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        assignment_marks.setForeground(new java.awt.Color(102, 0, 204));
        assignment_marks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        assignment_marks.setBorder(null);
        assignment_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_marksActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_marks);
        assignment_marks.setBounds(680, 420, 120, 30);

        exam_percentage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exam_percentage.setForeground(new java.awt.Color(102, 0, 204));
        exam_percentage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        exam_percentage.setBorder(null);
        exam_percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exam_percentageActionPerformed(evt);
            }
        });
        jPanel2.add(exam_percentage);
        exam_percentage.setBounds(680, 480, 120, 30);

        subject_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subject_code.setForeground(new java.awt.Color(102, 0, 204));
        subject_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subject_code.setBorder(null);
        subject_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_codeActionPerformed(evt);
            }
        });
        jPanel2.add(subject_code);
        subject_code.setBounds(600, 150, 180, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EXAM PERCENTAGE");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(560, 480, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ASSIGNMENT PRECENTAGE");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(830, 480, 150, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ASSIGNMENT NUMBER");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(230, 420, 130, 30);

        assignment_percentage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        assignment_percentage.setForeground(new java.awt.Color(102, 0, 204));
        assignment_percentage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        assignment_percentage.setBorder(null);
        assignment_percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_percentageActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_percentage);
        assignment_percentage.setBounds(990, 480, 130, 30);

        exam_marks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exam_marks.setForeground(new java.awt.Color(102, 0, 204));
        exam_marks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        exam_marks.setBorder(null);
        exam_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exam_marksActionPerformed(evt);
            }
        });
        jPanel2.add(exam_marks);
        exam_marks.setBounds(380, 470, 130, 30);

        delete_result.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete_result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        delete_result.setAlignmentY(0.0F);
        delete_result.setBorder(null);
        delete_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_resultActionPerformed(evt);
            }
        });
        jPanel2.add(delete_result);
        delete_result.setBounds(620, 550, 100, 100);

        view_result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.jpg"))); // NOI18N
        view_result.setAlignmentY(0.0F);
        view_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_resultActionPerformed(evt);
            }
        });
        jPanel2.add(view_result);
        view_result.setBounds(730, 550, 100, 100);

        add_result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.jpg"))); // NOI18N
        add_result.setAlignmentY(0.0F);
        add_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_resultActionPerformed(evt);
            }
        });
        jPanel2.add(add_result);
        add_result.setBounds(510, 550, 100, 100);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BASK.jpg"))); // NOI18N
        back.setAlignmentY(0.0F);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(400, 550, 100, 100);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ASSIGNMENT", "MARKS"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(460, 200, 452, 120);

        message1.setBackground(new java.awt.Color(0, 0, 0));
        message1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        message1.setForeground(new java.awt.Color(255, 0, 153));
        message1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        message1.setAlignmentX(0.0F);
        message1.setAlignmentY(0.0F);
        message1.setBorder(null);
        message1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message1ActionPerformed(evt);
            }
        });
        jPanel2.add(message1);
        message1.setBounds(590, 350, 80, 30);

        assignment_number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        assignment_number.setForeground(new java.awt.Color(102, 0, 204));
        assignment_number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        assignment_number.setBorder(null);
        assignment_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_numberActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_number);
        assignment_number.setBounds(380, 420, 130, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GRADE");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(700, 320, 60, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ABOUT ASSIGNMENTS");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(600, 380, 140, 30);

        clear_assignment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cleaning.jpg"))); // NOI18N
        clear_assignment.setAlignmentY(0.0F);
        clear_assignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_assignmentActionPerformed(evt);
            }
        });
        jPanel2.add(clear_assignment);
        clear_assignment.setBounds(970, 420, 80, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reuslting.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void message2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message2ActionPerformed

    private void assignment_marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignment_marksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignment_marksActionPerformed

    private void exam_percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exam_percentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exam_percentageActionPerformed

    private void subject_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subject_codeActionPerformed

    private void add_assignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_assignmentActionPerformed
        addAssignment();
        showValues();
    }//GEN-LAST:event_add_assignmentActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        message1.setText("");
        message2.setText("");
        id.setText("");
        subject_code.setText("");
        assignment_marks.setText("");
        exam_marks.setText("");
        assignment_percentage.setText("");
        exam_percentage.setText("");
        assignment_number.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void assignment_percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignment_percentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignment_percentageActionPerformed

    private void exam_marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exam_marksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exam_marksActionPerformed

    private void delete_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_resultActionPerformed
       deleteExam_marks();
       deleteAssignment_marks();
    }//GEN-LAST:event_delete_resultActionPerformed

    private void view_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_resultActionPerformed
        showValues();
        searchSubjects();
    }//GEN-LAST:event_view_resultActionPerformed

    private void add_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_resultActionPerformed
        float totalMark = findTotalMarks();
        String num = Float.toString(totalMark);
        message1.setText("tolal:"+num);
        grad = getGrade(totalMark);
        message2.setText(grad);
        addForExamMarks();
    }//GEN-LAST:event_add_resultActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        DashBoard dash = new DashBoard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void message1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message1ActionPerformed

    private void assignment_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignment_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignment_numberActionPerformed

    private void clear_assignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_assignmentActionPerformed
        assignment_marks.setText("");
        assignment_number.setText("");
    }//GEN-LAST:event_clear_assignmentActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_assignment;
    private javax.swing.JButton add_result;
    private javax.swing.JTextField assignment_marks;
    private javax.swing.JTextField assignment_number;
    private javax.swing.JTextField assignment_percentage;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear_assignment;
    private javax.swing.JButton delete_result;
    private javax.swing.JTextField exam_marks;
    private javax.swing.JTextField exam_percentage;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message1;
    private javax.swing.JTextField message2;
    private javax.swing.JTextField subject_code;
    private javax.swing.JTable table;
    private javax.swing.JButton view_result;
    // End of variables declaration//GEN-END:variables
}
