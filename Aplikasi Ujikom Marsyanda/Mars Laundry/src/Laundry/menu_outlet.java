/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laundry;

import java.awt.HeadlessException;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class menu_outlet extends javax.swing.JFrame {
    Connection con;
    Statement stm;
    ResultSet rs;
    
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;
    
    public menu_outlet() {
        initComponents();
        tglhariini();
        clock();
        setLocationRelativeTo(this);
        auto_out();
        tabeloutlet();
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
     
      public void auto_out(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_outlet,4)) as no from outlet";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                idou1.setText("O0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                idou1.setText("O" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(menu_outlet.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
      
       public void tabeloutlet(){
        Object header[]={"ID Outlet","Nama Outlet","Alamat Outlet","Kontak"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="select * from outlet order by id_outlet";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnloutlet = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        delet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        outletpanel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        kontak1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        aou1 = new javax.swing.JTextArea();
        nou1 = new javax.swing.JTextField();
        idou1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnloutlet.setBackground(new java.awt.Color(129, 177, 231));
        pnloutlet.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnloutletMouseDragged(evt);
            }
        });
        pnloutlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnloutletMousePressed(evt);
            }
        });
        pnloutlet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField4.setBackground(new java.awt.Color(129, 177, 231));
        jTextField4.setForeground(new java.awt.Color(51, 51, 51));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnloutlet.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 210, -1));

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        pnloutlet.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        pnloutlet.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        pnloutlet.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 440, -1, 50));

        add.setBackground(new java.awt.Color(83, 148, 222));
        add.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        pnloutlet.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 90, 40));

        edit.setBackground(new java.awt.Color(83, 148, 222));
        edit.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        pnloutlet.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 90, 40));

        cancel.setBackground(new java.awt.Color(83, 148, 222));
        cancel.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        pnloutlet.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, 40));

        delet.setBackground(new java.awt.Color(83, 148, 222));
        delet.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        delet.setForeground(new java.awt.Color(255, 255, 255));
        delet.setText("DELET");
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });
        pnloutlet.add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pnloutlet.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 550, 330));

        outletpanel.setBackground(new java.awt.Color(143, 186, 233));
        outletpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data Outlet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("ID Outlet");
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nama Outlet");
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Alamat Outlet");
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Kontak Outlet");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        kontak1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        kontak1.setForeground(new java.awt.Color(51, 51, 51));
        kontak1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        aou1.setColumns(20);
        aou1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        aou1.setForeground(new java.awt.Color(51, 51, 51));
        aou1.setLineWrap(true);
        aou1.setRows(5);
        jScrollPane3.setViewportView(aou1);

        nou1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nou1.setForeground(new java.awt.Color(51, 51, 51));
        nou1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        idou1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idou1.setForeground(new java.awt.Color(51, 51, 51));
        idou1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout outletpanelLayout = new javax.swing.GroupLayout(outletpanel);
        outletpanel.setLayout(outletpanelLayout);
        outletpanelLayout.setHorizontalGroup(
            outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outletpanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kontak1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nou1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idou1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        outletpanelLayout.setVerticalGroup(
            outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outletpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idou1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nou1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kontak1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel47)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnloutlet.add(outletpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 510, 330));

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mars Laundry");
        pnloutlet.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 280, 70));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnloutlet.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        pnloutlet.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, 30));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data Outlet Laundry");
        pnloutlet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 480, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnloutlet, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnloutlet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        Object header[]={"ID Outlet","Nama Outlet","Alamat Outlet","Kontak"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="Select * from outlet where id_outlet like '%" + jTextField4.getText() + "%'" + "or nama_outlet like '%" +jTextField4.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                

                String kolom[]={kolom1,kolom2,kolom3,kolom4};
                data.addRow(kolom);
                
            }

            jTextField4.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel102MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try{
            if(idou1.getText().equals("") || nou1.getText().equals("") || aou1.getText().equals("") || kontak1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idou1.requestFocus();
            }else{
                setkoneksi();
                String sql="insert into outlet values('"+idou1.getText()
                +"','"+nou1.getText()
                +"','"+aou1.getText()
                +"','"+kontak1.getText() +"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Ditambahkan!");
                auto_out();
                tabeloutlet();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_out();
        nou1.setText("");
        aou1.setText("");
        kontak1.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try{
            if(idou1.getText().equals("") || nou1.getText().equals("") || aou1.getText().equals("") || kontak1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idou1.requestFocus();
            }else{
                setkoneksi();
                String sql="update outlet set nama_outlet='"+nou1.getText()
                +"',alamat='"+aou1.getText()
                +"',tlp='"+kontak1.getText() +"' where id_outlet='"+idou1.getText()+"'";;
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");
                auto_out();
                tabeloutlet();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_out();
        nou1.setText("");
        aou1.setText("");
        kontak1.setText("");
    }//GEN-LAST:event_editActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        auto_out();
        nou1.setText("");
        aou1.setText("");
        kontak1.setText("");
    }//GEN-LAST:event_cancelActionPerformed

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        try{
            setkoneksi();
            String sql="DELETE FROM outlet WHERE id_outlet='"+idou1.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus!");
            auto_out();
            tabeloutlet();
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_out();
        nou1.setText("");
        aou1.setText("");
        kontak1.setText("");
    }//GEN-LAST:event_deletActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        idou1.setText(jTable1.getModel().getValueAt(baris, 0).toString());
        nou1.setText(jTable1.getModel().getValueAt(baris, 1).toString());
        aou1.setText(jTable1.getModel().getValueAt(baris, 2).toString());
        kontak1.setText(jTable1.getModel().getValueAt(baris, 3).toString());
        delet.setEnabled(true);
        cancel.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void pnloutletMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnloutletMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnloutletMouseDragged

    private void pnloutletMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnloutletMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnloutletMousePressed

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
            java.util.logging.Logger.getLogger(menu_outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_outlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_outlet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton add;
    private javax.swing.JTextArea aou1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delet;
    private javax.swing.JButton edit;
    private javax.swing.JTextField idou1;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField kontak1;
    private javax.swing.JTextField nou1;
    private javax.swing.JPanel outletpanel;
    private javax.swing.JPanel pnloutlet;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
