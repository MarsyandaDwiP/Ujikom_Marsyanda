
package Laundry;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class registrasi_laundry extends javax.swing.JFrame {
Connection con;
    Statement stm;
    ResultSet rs;
   
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;
    
    public registrasi_laundry() {
        initComponents();
        auto_us();
        tampilCombo();
        setLocationRelativeTo(this);
    }

public Connection setkoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/marslaundry","root","");
            stm=(com.mysql.jdbc.Statement) con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return con; 
    }

            public void auto_us(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_user,4)) as no from user";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                idu.setText("U0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                idu.setText("U" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(menu_user.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
            
            private void tampilCombo(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_outlet from outlet order by id_outlet asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                jComboBox3.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        idu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        nl = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        rbkasir = new javax.swing.JRadioButton();
        rbown = new javax.swing.JRadioButton();
        jPasswordField2 = new javax.swing.JPasswordField();
        cb_pass = new javax.swing.JCheckBox();
        clear = new javax.swing.JButton();
        regis = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(490, 577));

        jPanel1.setBackground(new java.awt.Color(129, 177, 231));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan data Anda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(490, 577));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ID User");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, -1));

        idu.setEditable(false);
        idu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idu.setForeground(new java.awt.Color(51, 51, 51));
        idu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idu.setBorder(null);
        jPanel1.add(idu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 114, 30));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Nama Lengkap");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 120, -1));

        nl.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nl.setForeground(new java.awt.Color(51, 51, 51));
        nl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nl.setBorder(null);
        nl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nlActionPerformed(evt);
            }
        });
        jPanel1.add(nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 180, 30));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Username");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 120, -1));

        us.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        us.setForeground(new java.awt.Color(51, 51, 51));
        us.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        us.setBorder(null);
        jPanel1.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 180, 30));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Password");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 120, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("ID Outlet");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 120, -1));

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jComboBox3.setBorder(null);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 110, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Role");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 120, -1));

        rbkasir.setBackground(new java.awt.Color(129, 177, 231));
        buttonGroup1.add(rbkasir);
        rbkasir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbkasir.setForeground(new java.awt.Color(255, 255, 255));
        rbkasir.setText("Kasir");
        rbkasir.setBorder(null);
        jPanel1.add(rbkasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        rbown.setBackground(new java.awt.Color(129, 177, 231));
        buttonGroup1.add(rbown);
        rbown.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbown.setForeground(new java.awt.Color(255, 255, 255));
        rbown.setText("Owner");
        rbown.setBorder(null);
        jPanel1.add(rbown, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        jPasswordField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 180, 30));

        cb_pass.setBackground(new java.awt.Color(255, 255, 255));
        cb_pass.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cb_pass.setForeground(new java.awt.Color(51, 51, 51));
        cb_pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cb_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_passActionPerformed(evt);
            }
        });
        jPanel1.add(cb_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, 31));

        clear.setBackground(new java.awt.Color(83, 148, 222));
        clear.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("BACK");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, 40));

        regis.setBackground(new java.awt.Color(83, 148, 222));
        regis.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        regis.setForeground(new java.awt.Color(255, 255, 255));
        regis.setText("REGIS");
        regis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisActionPerformed(evt);
            }
        });
        jPanel1.add(regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 90, 40));

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel23.setText("X");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 30, 30));

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("X");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 30));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registrasi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, 50));

        jLabel8.setFont(new java.awt.Font("Edwardian Script ITC", 3, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mars Laundry");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisActionPerformed
       String role;
          if(rbkasir.isSelected()){
            role = "Kasir";
        }else{
            role = "Owner";
        }
        try{
            if(idu.getText().equals("") || jComboBox3.getSelectedItem().equals("Pilih") || nl.getText().equals("")
                || us.getText().equals("")
                || !(rbkasir.isSelected()| rbown.isSelected())  ){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idu.requestFocus();
            }else{
                setkoneksi();
                String sql="insert into user values('"+idu.getText()
                +"','"+nl.getText()
                +"','"+us.getText()
                +"','"+jPasswordField2.getText()     
                +"','"+jComboBox3.getSelectedItem()
                +"','"+role+"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Ditambahkan!");
                auto_us();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_us();
        nl.setText("");
        us.setText("");
        jPasswordField2.setText("");
        jComboBox3.setSelectedItem("Pilih");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_regisActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
               this.setVisible(true);
        new Login_Laundry().setVisible(true);
        dispose();
    }//GEN-LAST:event_clearActionPerformed

    private void nlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nlActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
         int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void cb_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_passActionPerformed

        if(cb_pass.isSelected()){
            jPasswordField2.setEchoChar((char)0);
        }else{
            jPasswordField2.setEchoChar('*');
        }
    }//GEN-LAST:event_cb_passActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

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
            java.util.logging.Logger.getLogger(registrasi_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrasi_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrasi_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrasi_laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrasi_laundry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cb_pass;
    private javax.swing.JButton clear;
    private javax.swing.JTextField idu;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField nl;
    private javax.swing.JRadioButton rbkasir;
    private javax.swing.JRadioButton rbown;
    private javax.swing.JButton regis;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
