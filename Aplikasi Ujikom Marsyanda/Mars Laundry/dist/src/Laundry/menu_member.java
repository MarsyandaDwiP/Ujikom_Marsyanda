
package Laundry;

import Laundry.tabel_member;
import Laundry.menu_member;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class menu_member extends javax.swing.JFrame {
    
     Connection con;
    Statement stm;
    ResultSet rs;
    
    private int xx;
    private int xy;
    int timeRun = 0;

    public menu_member() {
        initComponents();
        tglhariini();
        clock();
        setLocationRelativeTo(this);
        auto_memb();
        id.disable();
    }
    
         public void clock()
            {
                new Thread()
        {
            public void run()
            {
                while (timeRun == 0)
                {
                    Calendar cal = new GregorianCalendar();
                    
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                    String day_night = "";
                    
                    if(AM_PM == 1)
                    {
                        day_night = " PM";
                    }
                    else
                    {
                        day_night = " AM";
                    }
                    
                    
                    String time = hour + " : " + min + " : " + sec + " " + day_night;
                    Clock.setText(time);                }
            }
        }.start();
            }
    
    
   
    
 
        private void tglhariini()
{
    Date now = new Date();
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd  MMMM  yyyy ");
    String tgl = simpleDateFormat.format(now);
    tanggal.setText(tgl);
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
     
 public void auto_memb(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_member,4)) as no from member";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                id.setText("M0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                id.setText("M" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(menu_member.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlmember = new javax.swing.JPanel();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        regis = new javax.swing.JButton();
        prin = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        memberpanel = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel42 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel102 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlmember.setBackground(new java.awt.Color(129, 177, 231));
        pnlmember.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlmemberMouseDragged(evt);
            }
        });
        pnlmember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlmemberMousePressed(evt);
            }
        });
        pnlmember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        pnlmember.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        pnlmember.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 30));

        regis.setBackground(new java.awt.Color(83, 148, 222));
        regis.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        regis.setForeground(new java.awt.Color(255, 255, 255));
        regis.setText("REGIS");
        regis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisActionPerformed(evt);
            }
        });
        pnlmember.add(regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 90, 40));

        prin.setBackground(new java.awt.Color(83, 148, 222));
        prin.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        prin.setForeground(new java.awt.Color(255, 255, 255));
        prin.setText("PRINT");
        prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prinActionPerformed(evt);
            }
        });
        pnlmember.add(prin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 90, 40));

        clear.setBackground(new java.awt.Color(83, 148, 222));
        clear.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        pnlmember.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, 40));

        memberpanel.setBackground(new java.awt.Color(143, 186, 233));
        memberpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("ID Member");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        id.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setBorder(null);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Nama Terang");
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        nama.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nama.setForeground(new java.awt.Color(51, 51, 51));
        nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nama.setBorder(null);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Alamat Lengkap");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        alamat.setForeground(new java.awt.Color(51, 51, 51));
        alamat.setLineWrap(true);
        alamat.setRows(5);
        alamat.setBorder(null);
        jScrollPane2.setViewportView(alamat);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Jenis Kelamin");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jRadioButton1.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Laki - Laki");
        jRadioButton1.setBorder(null);

        jRadioButton2.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Perempuan");
        jRadioButton2.setBorder(null);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Nomor Telepon");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(51, 51, 51));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(null);

        javax.swing.GroupLayout memberpanelLayout = new javax.swing.GroupLayout(memberpanel);
        memberpanel.setLayout(memberpanelLayout);
        memberpanelLayout.setHorizontalGroup(
            memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberpanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(memberpanelLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        memberpanelLayout.setVerticalGroup(
            memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberpanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel39))
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel40))
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel41))
                    .addGroup(memberpanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2)))))
                .addGap(13, 13, 13)
                .addGroup(memberpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlmember.add(memberpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 510, 330));

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mars Laundry");
        pnlmember.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 350, 70));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlmember.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        pnlmember.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, -1, 30));

        jScrollPane6.setForeground(new java.awt.Color(51, 51, 51));

        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        pnlmember.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 450, 330));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/data_laundry-removebg-preview.png"))); // NOI18N
        jLabel102.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        pnlmember.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 240, -1, 50));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data Member Laundry");
        pnlmember.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 530, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlmember, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlmember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisActionPerformed
    String jk;
        if(jRadioButton1.isSelected()){
            jk = "L";
        }else{
            jk = "P";
        }
        try{
            if(id.getText().equals("") || nama.getText().equals("") || alamat.getText().equals("") || jTextField3.getText().equals("")
                || !(jRadioButton1.isSelected() | jRadioButton2.isSelected())  ){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                id.requestFocus();
            }else{
                setkoneksi();
                String sql="insert into member values('"+id.getText()
                +"','"+nama.getText()
                +"','"+alamat.getText()
                +"','"+jk
                +"','"+jTextField3.getText() +"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Member Didaftarkan!");
                jTextArea2.append("\t\t Mars Laundry System Member Card "+

                    "ID Member :\t\t\t" + id.getText() + "\n"
                    + "\n Nama Member :\t\t" + nama.getText() + "\n"
                    + "\n Alamat :\t\t\t" + alamat.getText() + "\n"
                    + "\n Jenis Kelamin :\t\t" + jk + "\n"
                    + "\n Telepon :\t\t\t" + jTextField3.getText() + "\n");

                auto_memb();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_memb();
        nama.setText("");
        alamat.setText("");
        jTextField3.setText("");
        buttonGroup1.clearSelection();    
    }//GEN-LAST:event_regisActionPerformed

    private void prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prinActionPerformed
         try {
       jTextArea2.print();
    }catch (PrinterException ex) {
             Logger.getLogger(menu_member.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_prinActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
         auto_memb();
         nama.setText("");
         alamat.setText("");
         jTextField3.setText("");
         buttonGroup1.clearSelection();
         jTextArea2.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void pnlmemberMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmemberMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnlmemberMouseDragged

    private void pnlmemberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlmemberMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlmemberMousePressed

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
       new tabel_member().setVisible(true);
    }//GEN-LAST:event_jLabel102MouseClicked

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
            java.util.logging.Logger.getLogger(menu_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JTextArea alamat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel memberpanel;
    private javax.swing.JTextField nama;
    private javax.swing.JPanel pnlmember;
    private javax.swing.JButton prin;
    private javax.swing.JButton regis;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
