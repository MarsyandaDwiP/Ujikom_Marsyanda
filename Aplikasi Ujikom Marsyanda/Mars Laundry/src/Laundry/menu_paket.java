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

/**
 *
 * @author Windows Marsyanda 10
 */
public class menu_paket extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;
    
    public menu_paket() {
        initComponents();
        tglhariini();
        clock();
        setLocationRelativeTo(this);
        tabelpaket();
        auto_pak();
        tampilComboO();
        tampilComboJ();
        idp.disable();
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

 public void tabelpaket(){
        Object header[]={"ID Paket","ID Outlet","Jenis Paket","Nama Paket","Harga"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="select * from paket order by id_paket";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
}
  private void tampilComboO(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_outlet from outlet order by id_outlet asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
               ido.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    private void tampilComboJ(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select jenis from outlet order by jenis asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
               ido.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
 public void auto_pak(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_paket,4)) as no from paket";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                idp.setText("P0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                idp.setText("P" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(menu_paket.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlpaket = new javax.swing.JPanel();
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
        paketpanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        idp = new javax.swing.JTextField();
        ido = new javax.swing.JComboBox<>();
        jenis = new javax.swing.JComboBox<>();
        nmpkt = new javax.swing.JTextField();
        hrg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlpaket.setBackground(new java.awt.Color(129, 177, 231));
        pnlpaket.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlpaketMouseDragged(evt);
            }
        });
        pnlpaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlpaketMousePressed(evt);
            }
        });
        pnlpaket.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField4.setBackground(new java.awt.Color(129, 177, 231));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlpaket.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 454, 210, -1));

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        pnlpaket.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        pnlpaket.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        pnlpaket.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 450, -1, 50));

        add.setBackground(new java.awt.Color(83, 148, 222));
        add.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        pnlpaket.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 90, 40));

        edit.setBackground(new java.awt.Color(83, 148, 222));
        edit.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        pnlpaket.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 90, 40));

        cancel.setBackground(new java.awt.Color(83, 148, 222));
        cancel.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        pnlpaket.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, -1, 40));

        delet.setBackground(new java.awt.Color(83, 148, 222));
        delet.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        delet.setForeground(new java.awt.Color(255, 255, 255));
        delet.setText("DELET");
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });
        pnlpaket.add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, 40));

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

        pnlpaket.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 530, 330));

        paketpanel.setBackground(new java.awt.Color(143, 186, 233));
        paketpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data Paket", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID Paket");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("ID Outlet");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Jenis");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nama Paket");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Harga");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        idp.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idp.setForeground(new java.awt.Color(51, 51, 51));
        idp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idp.setBorder(null);

        ido.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ido.setForeground(new java.awt.Color(51, 51, 51));
        ido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        ido.setBorder(null);
        ido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idoActionPerformed(evt);
            }
        });

        jenis.setBackground(new java.awt.Color(168, 207, 255));
        jenis.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jenis.setForeground(new java.awt.Color(51, 51, 51));
        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Kiloan", "Selimut", "Bed Cover", "Kaos", "Lainnya" }));
        jenis.setBorder(null);

        nmpkt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nmpkt.setForeground(new java.awt.Color(51, 51, 51));
        nmpkt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nmpkt.setBorder(null);

        hrg.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        hrg.setForeground(new java.awt.Color(51, 51, 51));
        hrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hrg.setBorder(null);

        javax.swing.GroupLayout paketpanelLayout = new javax.swing.GroupLayout(paketpanel);
        paketpanel.setLayout(paketpanelLayout);
        paketpanelLayout.setHorizontalGroup(
            paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paketpanelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmpkt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        paketpanelLayout.setVerticalGroup(
            paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paketpanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmpkt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(46, 46, 46))
        );

        pnlpaket.add(paketpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 510, 330));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlpaket.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        pnlpaket.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, -1, 30));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mars Laundry");
        pnlpaket.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 280, -1));

        jLabel8.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Paket Laundry");
        pnlpaket.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 480, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlpaket, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlpaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlpaketMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpaketMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlpaketMousePressed

    private void pnlpaketMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpaketMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnlpaketMouseDragged

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void idoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idoActionPerformed

    }//GEN-LAST:event_idoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        idp.setText(jTable1.getModel().getValueAt(baris, 0).toString());
        ido.setSelectedItem(jTable1.getModel().getValueAt(baris, 1).toString());
        jenis.setSelectedItem(jTable1.getModel().getValueAt(baris, 2).toString());
        nmpkt.setText(jTable1.getModel().getValueAt(baris, 3).toString());
        hrg.setText(jTable1.getModel().getValueAt(baris, 4).toString());
        delet.setEnabled(true);
        edit.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        try{
            setkoneksi();
            String sql="DELETE FROM paket WHERE id_paket='"+idp.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus!");
            tabelpaket();
            auto_pak();
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_pak();
        ido.setSelectedItem("Pilih");
        jenis.setSelectedItem("Pilih");
        nmpkt.setText("");
        hrg.setText("");
    }//GEN-LAST:event_deletActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        auto_pak();
        ido.setSelectedItem("Pilih");
        jenis.setSelectedItem("Pilih");
        nmpkt.setText("");
        hrg.setText("");
    }//GEN-LAST:event_cancelActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try{
            if(idp.getText().equals("") || ido.getSelectedItem().equals("Pilih") || jenis.getSelectedItem().equals("Pilih") || nmpkt.getText().equals("") || hrg.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idp.requestFocus();
            }else{
                setkoneksi();
                String sql="update paket set id_outlet='"+ido.getSelectedItem()
                +"',jenis='"+jenis.getSelectedItem()
                +"',nama_paket='"+nmpkt.getText()
                +"',harga='"+hrg.getText()  +"' where id_paket='"+idp.getText()+"'";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");
                tabelpaket();
                auto_pak();

            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_pak();
        ido.setSelectedItem("Pilih");
        jenis.setSelectedItem("Pilih");
        nmpkt.setText("");
        hrg.setText("");
    }//GEN-LAST:event_editActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try{
            if(idp.getText().equals("") || ido.getSelectedItem().equals("Pilih") || jenis.getSelectedItem().equals("Pilih") || nmpkt.getText().equals("") || hrg.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idp.requestFocus();
            }else{
                setkoneksi();
                String sql="insert into paket values('"+idp.getText()
                +"','"+ido.getSelectedItem()
                +"','"+jenis.getSelectedItem()
                +"','"+nmpkt.getText()
                +"','"+hrg.getText()  +"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Ditambahkan!");
                tabelpaket();
                auto_pak();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_pak();
        ido.setSelectedItem("Pilih");
        jenis.setSelectedItem("Pilih");
        nmpkt.setText("");
        hrg.setText("");

    }//GEN-LAST:event_addActionPerformed

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        Object header[]={"ID Paket","ID Outlet","Jenis Paket","Nama Paket","Harga"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="Select * from paket where id_paket like '%" + jTextField4.getText() + "%'" + "or nama_paket like '%" +jTextField4.getText()+"%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);

            }

            jTextField4.setText("");

        } catch (Exception e) {
        }
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
            java.util.logging.Logger.getLogger(menu_paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_paket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delet;
    private javax.swing.JButton edit;
    private javax.swing.JTextField hrg;
    private javax.swing.JComboBox<String> ido;
    private javax.swing.JTextField idp;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField nmpkt;
    private javax.swing.JPanel paketpanel;
    private javax.swing.JPanel pnlpaket;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
