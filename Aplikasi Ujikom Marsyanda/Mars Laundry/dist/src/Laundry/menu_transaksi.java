
package Laundry;

import Laundry.menu_detail_transaksi;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
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


public class menu_transaksi extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;

    public menu_transaksi() {
        initComponents();
        tglhariini();
        clock();
        
        tampilCombo_trx();
        tampilCombo();
        tampilCombox();
        tampilCombox2();
        
        auto_trans();
        
        idtrx.disable();
        biayatambahan.disable();
        diskon.disable();
        harga.disable();
        biayatambahan1.disable();
        biayatambahan3.disable();
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
  
public void auto_trans(){
        try{
        setkoneksi();
        stm = con.createStatement();
        String sql = "select max(right(id_transaksi,4)) as no from transaksi";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.first() == false){
                idtrx.setText("T0001");
                        }else{
                rs.last();
                int set_id = rs.getInt(1)+1;
                String no = String.valueOf(set_id);
                int id_next = no.length();
                for (int a = 0 ; a <4 - id_next; a++){
                    no = "0" + no;
                }
                idtrx.setText("T" + no);
            }
        }
                }catch(SQLException ex){
                    Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
 
 private void tampilCombo_trx(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_outlet from outlet order by id_outlet asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                idoutlet.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void tampilCombo(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_member from member order by id_member asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                idmember.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void tampilCombox(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select id_user from user order by id_user asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                iduser.addItem((String) ob[0]);
            }
            rs.close(); stm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private void tampilCombox2(){
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select nama_paket from paket order by nama_paket asc";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Object[] ob=new Object[3];
                ob[0]=rs.getString(1);
                jComboBox1.addItem((String) ob[0]);
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
        pnloutlet = new javax.swing.JPanel();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        outletpanel = new javax.swing.JPanel();
        idtrx = new javax.swing.JTextField();
        idoutlet = new javax.swing.JComboBox<>();
        invoice = new javax.swing.JTextField();
        idmember = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        harga = new javax.swing.JTextField();
        tglLaundry = new com.toedter.calendar.JDateChooser();
        bataswaktu = new com.toedter.calendar.JDateChooser();
        tglbyar = new com.toedter.calendar.JDateChooser();
        jLabel198 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        biayatambahan = new javax.swing.JTextField();
        diskon = new javax.swing.JTextField();
        pajak = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        sudah = new javax.swing.JRadioButton();
        belum = new javax.swing.JRadioButton();
        iduser = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        qty = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        biayatambahan1 = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        biayatambahan2 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        biayatambahan3 = new javax.swing.JTextField();
        hasil = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        regis = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        pnloutlet.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        pnloutlet.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        outletpanel.setBackground(new java.awt.Color(143, 186, 233));
        outletpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        idtrx.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idtrx.setForeground(new java.awt.Color(51, 51, 51));
        idtrx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idtrx.setBorder(null);

        idoutlet.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idoutlet.setForeground(new java.awt.Color(51, 51, 51));
        idoutlet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        idoutlet.setBorder(null);

        invoice.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        invoice.setForeground(new java.awt.Color(51, 51, 51));
        invoice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invoice.setBorder(null);

        idmember.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idmember.setForeground(new java.awt.Color(51, 51, 51));
        idmember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        idmember.setBorder(null);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        harga.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(51, 51, 51));
        harga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        harga.setBorder(null);

        tglLaundry.setBackground(new java.awt.Color(255, 255, 255));
        tglLaundry.setForeground(new java.awt.Color(51, 51, 51));
        tglLaundry.setDateFormatString("yyyy-MM-dd");
        tglLaundry.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglLaundryPropertyChange(evt);
            }
        });

        bataswaktu.setBackground(new java.awt.Color(255, 255, 255));
        bataswaktu.setForeground(new java.awt.Color(51, 51, 51));
        bataswaktu.setDateFormatString("yyyy-MM-dd");
        bataswaktu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bataswaktuPropertyChange(evt);
            }
        });

        tglbyar.setBackground(new java.awt.Color(255, 255, 255));
        tglbyar.setForeground(new java.awt.Color(51, 51, 51));
        tglbyar.setDateFormatString("yyyy-MM-dd");
        tglbyar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglbyarPropertyChange(evt);
            }
        });

        jLabel198.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setText("/kg");
        jLabel198.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("ID Transaksi");
        jLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("ID Outlet");
        jLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel87.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Kode Invoice");
        jLabel87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel88.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("ID Member");
        jLabel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel89.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Paket");
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Harga");
        jLabel90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel91.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Tanggal Laundry");
        jLabel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel92.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Batas Waktu");
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Tanggal Bayar");
        jLabel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Biaya Tambahan");
        jLabel94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Diskon");
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel96.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Pajak");
        jLabel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel97.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("Status");
        jLabel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel98.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("Keterangan");
        jLabel98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel99.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("ID User");
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel146.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setText("Metode");
        jLabel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel197.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setText("Quantity");
        jLabel197.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel199.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("kg");
        jLabel199.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        biayatambahan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        biayatambahan.setForeground(new java.awt.Color(51, 51, 51));
        biayatambahan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        biayatambahan.setBorder(null);
        biayatambahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayatambahanActionPerformed(evt);
            }
        });

        diskon.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        diskon.setForeground(new java.awt.Color(51, 51, 51));
        diskon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        diskon.setBorder(null);

        pajak.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pajak.setForeground(new java.awt.Color(51, 51, 51));
        pajak.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pajak.setBorder(null);

        status.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(51, 51, 51));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Baru", "Proses", "Selesai", "Diambil" }));
        status.setBorder(null);

        sudah.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(sudah);
        sudah.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sudah.setForeground(new java.awt.Color(255, 255, 255));
        sudah.setText("Dibayar");
        sudah.setBorder(null);

        belum.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(belum);
        belum.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        belum.setForeground(new java.awt.Color(255, 255, 255));
        belum.setText("Belum Dibayar");
        belum.setBorder(null);

        iduser.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        iduser.setForeground(new java.awt.Color(51, 51, 51));
        iduser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        iduser.setBorder(null);
        iduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iduserActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Antar", "Ambil" }));
        jComboBox2.setBorder(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        qty.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        qty.setForeground(new java.awt.Color(51, 51, 51));
        qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty.setBorder(null);
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setText("Total Bayar");
        jLabel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        biayatambahan1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        biayatambahan1.setForeground(new java.awt.Color(51, 51, 51));
        biayatambahan1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        biayatambahan1.setBorder(null);
        biayatambahan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayatambahan1ActionPerformed(evt);
            }
        });

        jLabel150.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setText("Nominal Bayar");
        jLabel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        biayatambahan2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        biayatambahan2.setForeground(new java.awt.Color(51, 51, 51));
        biayatambahan2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        biayatambahan2.setBorder(null);
        biayatambahan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayatambahan2ActionPerformed(evt);
            }
        });
        biayatambahan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                biayatambahan2KeyReleased(evt);
            }
        });

        jLabel151.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setText("Kembalian");
        jLabel151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        biayatambahan3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        biayatambahan3.setForeground(new java.awt.Color(51, 51, 51));
        biayatambahan3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        biayatambahan3.setBorder(null);
        biayatambahan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayatambahan3ActionPerformed(evt);
            }
        });

        hasil.setBackground(new java.awt.Color(83, 148, 222));
        hasil.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N
        hasil.setForeground(new java.awt.Color(255, 255, 255));
        hasil.setText("HASIL");
        hasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outletpanelLayout = new javax.swing.GroupLayout(outletpanel);
        outletpanel.setLayout(outletpanelLayout);
        outletpanelLayout.setHorizontalGroup(
            outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outletpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel198))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(tglLaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(bataswaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel150, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jLabel149, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(biayatambahan2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addComponent(iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hasil))
                    .addComponent(biayatambahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(outletpanelLayout.createSequentialGroup()
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(idtrx, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel199))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idmember, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addComponent(sudah)
                                .addGap(10, 10, 10)
                                .addComponent(belum))))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglbyar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(biayatambahan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(biayatambahan3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(idoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diskon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pajak, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        outletpanelLayout.setVerticalGroup(
            outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outletpanelLayout.createSequentialGroup()
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel53))
                    .addComponent(idtrx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel197)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel199))
                .addGap(9, 9, 9)
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idoutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diskon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel95))))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel87)
                                    .addComponent(pajak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel96)))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel88)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel89))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addComponent(idmember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel97)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel98))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sudah)
                            .addComponent(belum))))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel90))
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel198))
                            .addComponent(hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglLaundry, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel149)))))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(biayatambahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel92))
                            .addComponent(bataswaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel150))))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(biayatambahan2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(outletpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel93)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel146)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel94))
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addComponent(tglbyar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(biayatambahan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(outletpanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(biayatambahan3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(outletpanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel151))))
        );

        pnloutlet.add(outletpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 710, 490));

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

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(51, 51, 51));
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        pnloutlet.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 400, 390));

        regis.setBackground(new java.awt.Color(83, 148, 222));
        regis.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        regis.setForeground(new java.awt.Color(255, 255, 255));
        regis.setText("REGIS");
        regis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regisMouseClicked(evt);
            }
        });
        regis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisActionPerformed(evt);
            }
        });
        pnloutlet.add(regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 90, 40));

        print.setBackground(new java.awt.Color(83, 148, 222));
        print.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("PRINT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        pnloutlet.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 90, 40));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/data_laundry-removebg-preview.png"))); // NOI18N
        jLabel144.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel144.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel144MouseClicked(evt);
            }
        });
        pnloutlet.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 230, 40, 50));

        clear1.setBackground(new java.awt.Color(83, 148, 222));
        clear1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        clear1.setForeground(new java.awt.Color(255, 255, 255));
        clear1.setText("CLEAR");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });
        pnloutlet.add(clear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, -1, 40));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 45)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data Member Laundry");
        pnloutlet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 380, 60));

        jLabel8.setFont(new java.awt.Font("Edwardian Script ITC", 3, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mars Laundry");
        pnloutlet.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 230, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnloutlet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnloutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        try{
            setkoneksi();
            stm=con.createStatement();
            String sql="select * from paket where nama_paket='"+jComboBox1.getSelectedItem()+"'";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                harga.setText(rs.getString("harga"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void tglLaundryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglLaundryPropertyChange
        // TODO add your handling code here:
        if(tglLaundry.getDate()!=null){
            SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
            String tgl = tanggal.format(tglLaundry.getDate());
        }
    }//GEN-LAST:event_tglLaundryPropertyChange

    private void bataswaktuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bataswaktuPropertyChange
        // TODO add your handling code here:
        if(bataswaktu.getDate()!=null){
            SimpleDateFormat batas = new SimpleDateFormat("yyyy-MM-dd");
            String bts = batas.format(bataswaktu.getDate());
        }
    }//GEN-LAST:event_bataswaktuPropertyChange

    private void tglbyarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglbyarPropertyChange
        // TODO add your handling code here:
        if(tglbyar.getDate()!=null){
            SimpleDateFormat bayar = new SimpleDateFormat("yyyy-MM-dd");
            String byr = bayar.format(tglbyar.getDate());
        }
    }//GEN-LAST:event_tglbyarPropertyChange

    private void biayatambahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayatambahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayatambahanActionPerformed

    private void iduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iduserActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        if(jComboBox2.getSelectedItem().equals("Pilih")){
            JOptionPane.showMessageDialog(null, "Pilih Metode Pengembalian");
        }else if(jComboBox2.getSelectedItem().equals("Antar")){
            biayatambahan.setText("5000");
        }else{
            biayatambahan.setText("0");
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        String quantity = qty.getText();
        String hargakg = harga.getText();
        float  berat = Float.valueOf(quantity);
        float  perkilo = Float.valueOf(hargakg);
        String discount;

        float bayar = berat*perkilo;
        if(bayar>20000 && bayar<50000){
            discount = "10";
            diskon.setText(""+discount);
        }
        else if(bayar>50000 && bayar<100000){
            discount = "30";
            diskon.setText(""+discount);
        }
        else if(bayar>100000){
            discount = "50";
            diskon.setText(""+discount);
        }
        else{
            diskon.setText("0");
        }
    }//GEN-LAST:event_qtyKeyReleased

    private void biayatambahan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayatambahan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayatambahan1ActionPerformed

    private void biayatambahan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayatambahan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayatambahan2ActionPerformed

    private void biayatambahan2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_biayatambahan2KeyReleased
        String uang = biayatambahan2.getText();
        String total = biayatambahan1.getText();

        float nominal = Float.valueOf(uang);
        float total_bayar = Float.valueOf(total);
        float kembalian = nominal-total_bayar;
        biayatambahan3.setText(Float.toString(kembalian));
    }//GEN-LAST:event_biayatambahan2KeyReleased

    private void biayatambahan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayatambahan3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayatambahan3ActionPerformed

    private void regisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisActionPerformed
     
    }//GEN-LAST:event_regisActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            jTextArea1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(menu_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

    private void hasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasilActionPerformed
        String d = diskon.getText();
        String pj = pajak.getText();
        String harg = harga.getText();
        String bt = biayatambahan.getText();
        String quan = qty.getText();
        
        float di = Float.valueOf(d);
        float pjk = Float.valueOf(pj);
        float hrga = Float.valueOf(harg);
        float byt = Float.valueOf(bt);
        float tity = Float.valueOf(quan);
      
        float disk = di/100*hrga;
        float total_bayar = ((hrga*tity)-(byt+disk))+pjk;
        biayatambahan1.setText(Float.toString(total_bayar));
    }//GEN-LAST:event_hasilActionPerformed

    private void jLabel144MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel144MouseClicked
        new tabel_transaksi().setVisible(true);
    }//GEN-LAST:event_jLabel144MouseClicked

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        auto_trans();
        qty.setText("");
        idoutlet.setSelectedItem("Pilih");
        invoice.setText("");
        idmember.setSelectedItem("Pilih");
        tglLaundry.setDate(null);
        bataswaktu.setDate(null);
        tglbyar.setDate(null);
        biayatambahan.setText("");
        diskon.setText("");
        pajak.setText("");
        status.setSelectedItem("Pilih");
        iduser.setSelectedItem("Pilih");
        harga.setText("");
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedItem("Pilih");
        jTextArea1.setText("");
    }//GEN-LAST:event_clear1ActionPerformed

    private void regisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regisMouseClicked
    SimpleDateFormat date;
            date = new SimpleDateFormat("yyyy-MM-dd");
            String tgl = date.format(tglLaundry.getDate());
            String bts = date.format(bataswaktu.getDate());
            String byr = date.format(tglbyar.getDate());
            String ket;
            if(sudah.isSelected()){
        ket = "dibayar";
    }else{
                ket = "belum dibayar";
            }
        try{
            if(idtrx.getText().equals("") || idoutlet.getSelectedItem().equals("Pilih") || invoice.getText().equals("")
                    || jComboBox1.getSelectedItem().equals("Pilih") || harga.getText().equals("")
                || idmember.getSelectedItem().equals("Pilih") || biayatambahan.getText().equals("") || diskon.getText().equals("")
                    || pajak.getText().equals("") || status.getSelectedItem().equals("Pilih") || iduser.getSelectedItem().equals("Pilih")
                     || !(sudah.isSelected() | belum.isSelected()) || tglLaundry.getDate() == null || bataswaktu.getDate() == null
                    || tglbyar.getDate() == null || biayatambahan2.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Lengkapi Data Transaksi terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
        idtrx.requestFocus();
             }else{
        setkoneksi();
            String sql="insert into transaksi values('"+idtrx.getText()
                    +"','"+idoutlet.getSelectedItem()
                    +"','"+invoice.getText()
                    +"','"+idmember.getSelectedItem()
                    +"','"+tgl
                    +"','"+bts
                    +"','"+byr
                    +"','"+biayatambahan.getText()
                    +"','"+diskon.getText()
                    +"','"+pajak.getText()
                    +"','"+status.getSelectedItem()
                    +"','"+ket
                    +"','"+iduser.getSelectedItem()+"')";
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"TRANSAKSI BERHASIL");
        
            jTextArea1.append("\t BUKTI PEMBAYARAN TRANSAKSI MARS LAUNDRY SISTEM \n\n"+
                
                  "ID Transaksi :\t\t\t" + idtrx.getText()
                + "\n ID Outlet :\t\t\t" + idoutlet.getSelectedItem()
                + "\n Kode Invoice :\t\t\t" + invoice.getText()
                + "\n ID Member :\t\t\t" + idmember.getSelectedItem()
                + "\n===================================================="
                + "\n Tanggal Laundry :\t\t" + tglLaundry.getDate()
                + "\n Batas Waktu :\t\t\t" + bataswaktu.getDate()
                + "\n Tanggal Pembayaran :\t\t" + tglbyar.getDate()
                + "\n Metode Pengembalian :\t\t" + jComboBox2.getSelectedItem()
                + "\n Biaya Tambahan :\t\t" + biayatambahan.getText()
                + "\n===================================================="
                + "\n Kuantitas :\t\t\t" + qty.getText() + "Kg"
                + "\n Diskon :\t\t\t" + diskon.getText() + "%"
                + "\n Pajak :\t\t\t" + pajak.getText()
                + "\n Status :\t\t\t" + status.getSelectedItem()
                + "\n Keterangan :\t\t\t" + ket + "\n"
                + "\n====================================================="
                + "\n ID User :\t\t\t" + iduser.getSelectedItem()
                + "\n\n TOTAL BAYAR :\t\t\t" + biayatambahan1.getText()
                + "\n\n NOMINAL BAYAR :\t\t" + biayatambahan2.getText()
                + "\n\n KEMBALIAN :\t\t\t" + biayatambahan3.getText()
                + "\n====================================================="
                + "\n====================================================="
                + "\n \t ==TERIMAKASIH SUDAH MENGGUNAKAN LAUNDRY KAMI== \n");
            
            auto_trans();
            new menu_detail_transaksi().setVisible(true);
            }
        }
            catch (HeadlessException | SQLException e) {
        }
        auto_trans();
        qty.setText("");
        idoutlet.setSelectedItem("Pilih");
        invoice.setText("");
        idmember.setSelectedItem("Pilih");
        tglLaundry.setDate(null);
        bataswaktu.setDate(null);
        tglbyar.setDate(null);
        biayatambahan.setText("");
        diskon.setText("");
        pajak.setText("");
        status.setSelectedItem("Pilih");
        iduser.setSelectedItem("Pilih");
        harga.setText("");
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedItem("Pilih");
        biayatambahan1.setText("");
        biayatambahan2.setText("");
        biayatambahan3.setText("");
    }//GEN-LAST:event_regisMouseClicked

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
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private com.toedter.calendar.JDateChooser bataswaktu;
    private javax.swing.JRadioButton belum;
    private javax.swing.JTextField biayatambahan;
    private javax.swing.JTextField biayatambahan1;
    private javax.swing.JTextField biayatambahan2;
    private javax.swing.JTextField biayatambahan3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear1;
    private javax.swing.JTextField diskon;
    private javax.swing.JTextField harga;
    private javax.swing.JButton hasil;
    private javax.swing.JComboBox<String> idmember;
    private javax.swing.JComboBox<String> idoutlet;
    private javax.swing.JTextField idtrx;
    private javax.swing.JComboBox<String> iduser;
    private javax.swing.JTextField invoice;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel outletpanel;
    private javax.swing.JTextField pajak;
    private javax.swing.JPanel pnloutlet;
    private javax.swing.JButton print;
    private javax.swing.JTextField qty;
    private javax.swing.JButton regis;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JRadioButton sudah;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JDateChooser tglLaundry;
    private com.toedter.calendar.JDateChooser tglbyar;
    // End of variables declaration//GEN-END:variables


}
