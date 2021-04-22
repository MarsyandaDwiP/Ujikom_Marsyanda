
package Laundry;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


public class menu_detail_transaksi extends javax.swing.JFrame {

        Connection con;
        Statement stm;
        ResultSet rs;
        PreparedStatement ps;
        String sql;
        
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;
    
    public menu_detail_transaksi() {
        initComponents();
        tglhariini();
        clock();
        setLocationRelativeTo(this);
        tampilCombo1();
        tampilCombo2();
        tabel();
        idDT.disable();
        auto_dtrans();
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
    
    
   
    public void doexit()
    {
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Apakah anda yakin ingin keluar dari program?", "Tutup Aplikasi",
                JOptionPane.YES_NO_OPTION);    
        
        if (confirm == JOptionPane.YES_OPTION){
        System.exit(0);
    }
    
    }
 
        private void tglhariini()
{
    Date now = new Date();
    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd  MMMM  yyyy ");
    String tgl = simpleDateFormat.format(now);
    tanggal.setText(tgl);
}
        
      public void tabel(){
        Object header[]={"ID Detail Transaksi","ID Transaksi","ID Paket","Quantity","Keterangan"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tbDT.setModel(data);
        setkoneksi();
        String sql="select * from detail_transaksi order by id_detail_transaksi";
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
        } catch (SQLException e) {
        }
}
    
      private void tampilCombo1(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_transaksi from transaksi order by id_transaksi asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                idT.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void tampilCombo2(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_paket from paket order by id_paket asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                idP.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
     public void auto_dtrans(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_detail_transaksi,4)) as no from detail_transaksi";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                idDT.setText("DT0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                idDT.setText("DT" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(menu_detail_transaksi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlpaket = new javax.swing.JPanel();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        paketpanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idDT = new javax.swing.JTextField();
        idT = new javax.swing.JComboBox<>();
        idP = new javax.swing.JComboBox<>();
        ket = new javax.swing.JComboBox<>();
        qtydet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDT = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

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

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        pnlpaket.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        pnlpaket.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 30));

        add.setBackground(new java.awt.Color(83, 148, 222));
        add.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ENTRY DATA");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        pnlpaket.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 150, 40));

        paketpanel.setBackground(new java.awt.Color(143, 186, 233));
        paketpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data Detai Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        paketpanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID Detail Transaksi");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID Transaksi");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Paket");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Keterangan");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        idDT.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idDT.setForeground(new java.awt.Color(51, 51, 51));
        idDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        idT.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idT.setForeground(new java.awt.Color(51, 51, 51));
        idT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));

        idP.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idP.setForeground(new java.awt.Color(51, 51, 51));
        idP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));

        ket.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ket.setForeground(new java.awt.Color(51, 51, 51));
        ket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Antar", "Ambil" }));

        qtydet.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        qtydet.setForeground(new java.awt.Color(51, 51, 51));
        qtydet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qtydet.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantity");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        javax.swing.GroupLayout paketpanelLayout = new javax.swing.GroupLayout(paketpanel);
        paketpanel.setLayout(paketpanelLayout);
        paketpanelLayout.setHorizontalGroup(
            paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paketpanelLayout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(38, 38, 38)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idT, 0, 130, Short.MAX_VALUE)
                        .addComponent(idDT)
                        .addComponent(idP, 0, 130, Short.MAX_VALUE)
                        .addComponent(ket, 0, 130, Short.MAX_VALUE)
                        .addComponent(qtydet))
                    .addContainerGap(97, Short.MAX_VALUE)))
        );
        paketpanelLayout.setVerticalGroup(
            paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
            .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paketpanelLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idDT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGap(18, 18, 18)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGap(18, 18, 18)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qtydet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGap(18, 18, 18)
                    .addGroup(paketpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ket, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        pnlpaket.add(paketpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 510, 330));

        jLabel2.setFont(new java.awt.Font("Edwardian Script ITC", 3, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Laundry");
        pnlpaket.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 140, 70));

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Entry Detail Transaksi ");
        pnlpaket.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 530, 80));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlpaket.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        pnlpaket.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 30));

        tbDT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbDT);

        pnlpaket.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 400, 370));

        jLabel12.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mars ");
        pnlpaket.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 140, 49));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlpaket, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlpaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
          try{
            setkoneksi();
            String sql="insert into detail_transaksi values('"+idDT.getText()
            +"','"+idT.getSelectedItem()
            +"','"+idP.getSelectedItem()
            +"','"+qtydet.getText()
            +"','"+ket.getSelectedItem()  +"')";
            stm.executeUpdate(sql);
            tabel();
            auto_dtrans();
            JOptionPane.showMessageDialog(null,"Entry Berhasil");
            this.dispose();
        }
        catch (HeadlessException | SQLException e) {
        }
    }//GEN-LAST:event_addActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void pnlpaketMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpaketMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_pnlpaketMouseDragged

    private void pnlpaketMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlpaketMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlpaketMousePressed

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
            java.util.logging.Logger.getLogger(menu_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_detail_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton add;
    private javax.swing.JTextField idDT;
    private javax.swing.JComboBox<String> idP;
    private javax.swing.JComboBox<String> idT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> ket;
    private javax.swing.JPanel paketpanel;
    private javax.swing.JPanel pnlpaket;
    private javax.swing.JTextField qtydet;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTable tbDT;
    // End of variables declaration//GEN-END:variables


}
