package nsbm_higher_education.student;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import nsbm_higher_education.DatabaseConnection;

public class Result extends javax.swing.JFrame {
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

        jLabel2.setText("SUBJECT CODE");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(454, 120, 80, 14);

        jLabel3.setText("STUDENT ID");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(470, 160, 70, 20);

        jLabel4.setText("ASSIGNMENT MARKS");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(570, 440, 110, 14);

        jLabel5.setText("FINAL MARKS");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(490, 340, 80, 14);

        jLabel7.setText("EXAM MARKS");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(290, 490, 64, 14);

        add_assignment.setText("ADD ASSIGNMENT");
        add_assignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_assignmentActionPerformed(evt);
            }
        });
        jPanel2.add(add_assignment);
        add_assignment.setBounds(840, 433, 130, 30);

        clear.setText("clear");
        clear.setAlignmentY(0.0F);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear);
        clear.setBounds(380, 590, 100, 100);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel2.add(id);
        id.setBounds(600, 150, 180, 30);

        message2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message2ActionPerformed(evt);
            }
        });
        jPanel2.add(message2);
        message2.setBounds(710, 360, 200, 30);

        assignment_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_marksActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_marks);
        assignment_marks.setBounds(680, 430, 120, 30);

        exam_percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exam_percentageActionPerformed(evt);
            }
        });
        jPanel2.add(exam_percentage);
        exam_percentage.setBounds(680, 490, 120, 30);

        subject_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_codeActionPerformed(evt);
            }
        });
        jPanel2.add(subject_code);
        subject_code.setBounds(600, 110, 180, 30);

        jLabel8.setText("EXAM PERCENTAGE");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(570, 500, 95, 14);

        jLabel9.setText("ASSIGNMENT PRECENTAGE");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(830, 500, 140, 14);

        jLabel10.setText("ASSIGNMENT NUMBER");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(250, 440, 108, 14);

        assignment_percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_percentageActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_percentage);
        assignment_percentage.setBounds(990, 490, 130, 30);

        exam_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exam_marksActionPerformed(evt);
            }
        });
        jPanel2.add(exam_marks);
        exam_marks.setBounds(380, 480, 130, 30);

        delete_result.setText("delete_result");
        delete_result.setAlignmentY(0.0F);
        delete_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_resultActionPerformed(evt);
            }
        });
        jPanel2.add(delete_result);
        delete_result.setBounds(520, 590, 100, 100);

        view_result.setText("view_result");
        view_result.setAlignmentY(0.0F);
        view_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_resultActionPerformed(evt);
            }
        });
        jPanel2.add(view_result);
        view_result.setBounds(770, 590, 100, 100);

        add_result.setText("add_result");
        add_result.setAlignmentY(0.0F);
        add_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_resultActionPerformed(evt);
            }
        });
        jPanel2.add(add_result);
        add_result.setBounds(950, 590, 100, 100);

        back.setText("back");
        back.setAlignmentY(0.0F);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(240, 590, 100, 100);

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

        message1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message1ActionPerformed(evt);
            }
        });
        jPanel2.add(message1);
        message1.setBounds(460, 360, 200, 30);

        assignment_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignment_numberActionPerformed(evt);
            }
        });
        jPanel2.add(assignment_number);
        assignment_number.setBounds(380, 430, 130, 30);

        jLabel11.setText("GRADE");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(820, 340, 60, 14);

        jLabel12.setText("ABOUT ASSIGNMENTS");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(630, 400, 110, 14);

        clear_assignment.setText("clear");
        clear_assignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_assignmentActionPerformed(evt);
            }
        });
        jPanel2.add(clear_assignment);
        clear_assignment.setBounds(1013, 433, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reuslting.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, -10, 1360, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void assignment_percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignment_percentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignment_percentageActionPerformed

    private void exam_marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exam_marksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exam_marksActionPerformed

    private void delete_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_resultActionPerformed

    private void view_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_resultActionPerformed
        showValues();
    }//GEN-LAST:event_view_resultActionPerformed

    private void add_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_resultActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
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
