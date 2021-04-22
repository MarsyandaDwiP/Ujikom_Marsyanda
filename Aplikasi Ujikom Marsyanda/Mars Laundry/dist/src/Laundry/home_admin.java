package Laundry;



import java.awt.Color;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
 


import javax.swing.JFrame;
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

/**
 *
 * @author KIMSUL
 */
public class home_admin extends javax.swing.JFrame {
    Connection con;
    java.sql.Statement stm;
    ResultSet rs;
    ImageIcon imageicon;
    private int xx;
    private int xy;
    int timeRun = 0;
    

    public home_admin(String parameter){
        initComponents();
        }
   
    public home_admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        tglhariini();
        clock();
        pHomeX();
     
       
        prosesid1.disable();
        prosespkt1.disable();
        prosesmemb1.disable();
        prosestgl1.disable();
        prosesbayar1.disable();
        
        prosesid2.disable();
        prosespkt2.disable();
        prosesmemb2.disable();
        prosestgl2.disable();
        prosesbayar2.disable();
        
         prosesid3.disable();
        prosespkt3.disable();
        prosesmemb3.disable();
        prosestgl3.disable();
        prosesbayar3.disable();
        
        prosesid4.disable();
        prosespkt4.disable();
        prosesmemb4.disable();
        prosestgl4.disable();
        prosesbayar4.disable();
        
        tampiltabelbaru();
        tampiltabelproses();
        tampiltabelselesai();
        tampiltabelambil();
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
        
public void pHomeX()  {
        
     Thread th=new Thread(){
            @Override
            public void run (){
                try{
                    for(int a=0;a<=14;a++){
                        Thread.sleep(400);
                        if (a==1){pHome.setText("W");}
                        if (a==2){pHome.setText("We");}
                        if (a==3){pHome.setText("Wel");}
                        if (a==4){pHome.setText("Welc");}
                        if (a==5){pHome.setText("Welco");}
                        if (a==6){pHome.setText("Welcom");}
                        if (a==7){pHome.setText("Welcome");}
                        if (a==8){pHome.setText("Welcome T");}
                        if (a==9){pHome.setText("Welcome To");}
                        if (a==10){pHome.setText("Welcome To A");}
                        if (a==11){pHome.setText("Welcome To Ad");}
                        if (a==12){pHome.setText("Welcome To Adm");}
                        if (a==13){pHome.setText("Welcome To Admi");}
                        if (a==14){pHome.setText("Welcome To Admin");}
                    }
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        };th.start();
}

 public void tampiltabelbaru(){
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelbaru.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` WHERE status = 'baru'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    
    public void tampiltabelproses(){
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelproses.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` WHERE status = 'proses'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    
    public void tampiltabelselesai(){
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelselesai.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` WHERE status = 'selesai'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    
    public void tampiltabelambil(){
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelambil.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` WHERE status = 'diambil'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        panelbaru = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        panelproses = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        panelselesai = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        panelambil = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        panelhome = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        mainprogpnl = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        prosescari_txt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel192 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        barupnl = new javax.swing.JPanel();
        barucari_txt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel161 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelbaru = new javax.swing.JTable();
        jLabel162 = new javax.swing.JLabel();
        prosesid1 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        prosesmemb1 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        prosespkt1 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        prosestgl1 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        prosesbayar1 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        status1 = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        progresspnl = new javax.swing.JPanel();
        cariprog_txt = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel197 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabelproses = new javax.swing.JTable();
        jLabel198 = new javax.swing.JLabel();
        prosesid2 = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        prosesmemb2 = new javax.swing.JTextField();
        jLabel200 = new javax.swing.JLabel();
        prosespkt2 = new javax.swing.JTextField();
        jLabel201 = new javax.swing.JLabel();
        prosestgl2 = new javax.swing.JTextField();
        jLabel202 = new javax.swing.JLabel();
        prosesbayar2 = new javax.swing.JTextField();
        jLabel203 = new javax.swing.JLabel();
        status2 = new javax.swing.JComboBox<>();
        add1 = new javax.swing.JButton();
        ambilpnl = new javax.swing.JPanel();
        ambilcari_txt = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabelambil = new javax.swing.JTable();
        jLabel186 = new javax.swing.JLabel();
        prosesid4 = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        prosesmemb4 = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        prosespkt4 = new javax.swing.JTextField();
        prosestgl4 = new javax.swing.JTextField();
        prosesbayar4 = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        status4 = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        add2 = new javax.swing.JButton();
        add3 = new javax.swing.JButton();
        selesaipnl = new javax.swing.JPanel();
        selesaicari_txt1 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel168 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelselesai = new javax.swing.JTable();
        jLabel169 = new javax.swing.JLabel();
        prosesid3 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        prosesmemb3 = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        prosespkt3 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        prosestgl3 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        prosesbayar3 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        status3 = new javax.swing.JComboBox<>();
        add4 = new javax.swing.JButton();
        pHome = new javax.swing.JLabel();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        outlet = new javax.swing.JMenu();
        paket = new javax.swing.JMenu();
        user = new javax.swing.JMenu();
        member = new javax.swing.JMenu();
        transaksi = new javax.swing.JMenu();
        laporan = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        info = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(321, 74));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(178, 195, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1195, 500));
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

        jPanel2.setBackground(new java.awt.Color(129, 177, 231));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memeriksa Proses Kerja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(168, 207, 255));

        panelbaru.setBackground(new java.awt.Color(142, 193, 254));
        panelbaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbaruMouseClicked(evt);
            }
        });

        jLabel153.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setText("     BARU");
        jLabel153.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel153MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelbaruLayout = new javax.swing.GroupLayout(panelbaru);
        panelbaru.setLayout(panelbaruLayout);
        panelbaruLayout.setHorizontalGroup(
            panelbaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelbaruLayout.setVerticalGroup(
            panelbaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        panelproses.setBackground(new java.awt.Color(142, 193, 254));
        panelproses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelprosesMouseClicked(evt);
            }
        });

        jLabel156.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setText("   PROSES");
        jLabel156.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel156MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelprosesLayout = new javax.swing.GroupLayout(panelproses);
        panelproses.setLayout(panelprosesLayout);
        panelprosesLayout.setHorizontalGroup(
            panelprosesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel156, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelprosesLayout.setVerticalGroup(
            panelprosesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel156, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        panelselesai.setBackground(new java.awt.Color(142, 193, 254));
        panelselesai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelselesaiMouseClicked(evt);
            }
        });

        jLabel158.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setText("   SELESAI");
        jLabel158.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel158MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelselesaiLayout = new javax.swing.GroupLayout(panelselesai);
        panelselesai.setLayout(panelselesaiLayout);
        panelselesaiLayout.setHorizontalGroup(
            panelselesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel158, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        );
        panelselesaiLayout.setVerticalGroup(
            panelselesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel158, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        panelambil.setBackground(new java.awt.Color(142, 193, 254));

        jLabel160.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setText("  DIAMBIL");
        jLabel160.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel160MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelambilLayout = new javax.swing.GroupLayout(panelambil);
        panelambil.setLayout(panelambilLayout);
        panelambilLayout.setHorizontalGroup(
            panelambilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelambilLayout.setVerticalGroup(
            panelambilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        panelhome.setBackground(new java.awt.Color(142, 193, 254));
        panelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelhomeMouseClicked(evt);
            }
        });

        jLabel191.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setText("     HOME");
        jLabel191.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel191MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelhomeLayout = new javax.swing.GroupLayout(panelhome);
        panelhome.setLayout(panelhomeLayout);
        panelhomeLayout.setHorizontalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel191, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelhomeLayout.setVerticalGroup(
            panelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel191, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelproses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelselesai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelambil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelbaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(panelhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelbaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelproses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(panelselesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelambil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        mainprogpnl.setLayout(new java.awt.CardLayout());

        dashboard.setBackground(new java.awt.Color(142, 193, 254));
        dashboard.setMinimumSize(new java.awt.Dimension(726, 334));
        dashboard.setPreferredSize(new java.awt.Dimension(750, 371));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prosescari_txt.setBackground(new java.awt.Color(168, 207, 255));
        prosescari_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosescari_txt.setBorder(null);
        dashboard.add(prosescari_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 19, 275, 30));
        dashboard.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 62, 275, 10));

        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel192.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel192.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel192MouseClicked(evt);
            }
        });
        dashboard.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 19, -1, 37));

        jTextArea4.setBackground(new java.awt.Color(168, 207, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea4.setRows(5);
        jScrollPane14.setViewportView(jTextArea4);

        dashboard.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 610, 240));

        mainprogpnl.add(dashboard, "card6");

        barupnl.setBackground(new java.awt.Color(142, 193, 254));
        barupnl.setMinimumSize(new java.awt.Dimension(726, 334));
        barupnl.setPreferredSize(new java.awt.Dimension(750, 371));
        barupnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barucari_txt.setBackground(new java.awt.Color(168, 207, 255));
        barucari_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        barucari_txt.setForeground(new java.awt.Color(255, 255, 255));
        barucari_txt.setBorder(null);
        barupnl.add(barucari_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 20, 260, 30));
        barupnl.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 58, 260, 10));

        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel161.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel161.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel161MouseClicked(evt);
            }
        });
        barupnl.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 37, 42));

        tabelbaru.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelbaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbaruMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelbaru);

        barupnl.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 360, 220));

        jLabel162.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setText("ID Transaksi");
        jLabel162.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, -1));

        prosesid1.setBackground(new java.awt.Color(168, 207, 255));
        prosesid1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesid1.setForeground(new java.awt.Color(255, 255, 255));
        prosesid1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesid1.setBorder(null);
        barupnl.add(prosesid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 126, 32));

        jLabel163.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setText("ID Outlet");
        jLabel163.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 110, -1));

        prosesmemb1.setBackground(new java.awt.Color(168, 207, 255));
        prosesmemb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesmemb1.setForeground(new java.awt.Color(255, 255, 255));
        prosesmemb1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesmemb1.setBorder(null);
        barupnl.add(prosesmemb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 126, 32));

        jLabel164.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setText("ID Member");
        jLabel164.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 110, -1));

        prosespkt1.setBackground(new java.awt.Color(168, 207, 255));
        prosespkt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosespkt1.setForeground(new java.awt.Color(255, 255, 255));
        prosespkt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosespkt1.setBorder(null);
        barupnl.add(prosespkt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 126, 32));

        jLabel165.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setText("Tanggal Laundry");
        jLabel165.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        prosestgl1.setBackground(new java.awt.Color(168, 207, 255));
        prosestgl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosestgl1.setForeground(new java.awt.Color(255, 255, 255));
        prosestgl1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosestgl1.setBorder(null);
        barupnl.add(prosestgl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 126, 32));

        jLabel166.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setText("Keterangan");
        jLabel166.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 108, -1));

        prosesbayar1.setBackground(new java.awt.Color(168, 207, 255));
        prosesbayar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesbayar1.setForeground(new java.awt.Color(255, 255, 255));
        prosesbayar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesbayar1.setBorder(null);
        barupnl.add(prosesbayar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 126, 32));

        jLabel167.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setText("Status");
        jLabel167.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        barupnl.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 108, -1));

        status1.setBackground(new java.awt.Color(168, 207, 255));
        status1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status1.setForeground(new java.awt.Color(255, 255, 255));
        status1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Baru", "Proses", "Selesai", "Diambil" }));
        status1.setBorder(null);
        barupnl.add(status1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 103, 30));

        add.setBackground(new java.awt.Color(83, 148, 222));
        add.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        barupnl.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 90, 40));

        mainprogpnl.add(barupnl, "card3");

        progresspnl.setBackground(new java.awt.Color(142, 193, 254));
        progresspnl.setMinimumSize(new java.awt.Dimension(740, 334));
        progresspnl.setPreferredSize(new java.awt.Dimension(750, 371));
        progresspnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cariprog_txt.setBackground(new java.awt.Color(168, 207, 255));
        cariprog_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cariprog_txt.setForeground(new java.awt.Color(255, 255, 255));
        cariprog_txt.setBorder(null);
        progresspnl.add(cariprog_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 20, 260, 32));
        progresspnl.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 60, 260, 10));

        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel197.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel197.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel197MouseClicked(evt);
            }
        });
        progresspnl.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tabelproses.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelproses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelprosesMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tabelproses);

        progresspnl.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 420, 230));

        jLabel198.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setText("ID Transaksi");
        jLabel198.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 110, -1));

        prosesid2.setBackground(new java.awt.Color(168, 207, 255));
        prosesid2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesid2.setForeground(new java.awt.Color(255, 255, 255));
        prosesid2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesid2.setBorder(null);
        progresspnl.add(prosesid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 126, 32));

        jLabel199.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("ID Outlet");
        jLabel199.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 110, -1));

        prosesmemb2.setBackground(new java.awt.Color(168, 207, 255));
        prosesmemb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesmemb2.setForeground(new java.awt.Color(255, 255, 255));
        prosesmemb2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesmemb2.setBorder(null);
        progresspnl.add(prosesmemb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 126, 32));

        jLabel200.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setText("ID Member");
        jLabel200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 110, -1));

        prosespkt2.setBackground(new java.awt.Color(168, 207, 255));
        prosespkt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosespkt2.setForeground(new java.awt.Color(255, 255, 255));
        prosespkt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosespkt2.setBorder(null);
        progresspnl.add(prosespkt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 126, 32));

        jLabel201.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setText("Tanggal Laundry");
        jLabel201.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        prosestgl2.setBackground(new java.awt.Color(168, 207, 255));
        prosestgl2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosestgl2.setForeground(new java.awt.Color(255, 255, 255));
        prosestgl2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosestgl2.setBorder(null);
        prosestgl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosestgl2ActionPerformed(evt);
            }
        });
        progresspnl.add(prosestgl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 126, 32));

        jLabel202.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("Keterangan");
        jLabel202.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 108, -1));

        prosesbayar2.setBackground(new java.awt.Color(168, 207, 255));
        prosesbayar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesbayar2.setForeground(new java.awt.Color(255, 255, 255));
        prosesbayar2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesbayar2.setBorder(null);
        progresspnl.add(prosesbayar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 126, 32));

        jLabel203.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setText("Status");
        jLabel203.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        progresspnl.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 108, -1));

        status2.setBackground(new java.awt.Color(168, 207, 255));
        status2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status2.setForeground(new java.awt.Color(255, 255, 255));
        status2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Baru", "Proses", "Selesai", "Diambil" }));
        status2.setBorder(null);
        progresspnl.add(status2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 103, 30));

        add1.setBackground(new java.awt.Color(83, 148, 222));
        add1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setText("ADD");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        progresspnl.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 90, 40));

        mainprogpnl.add(progresspnl, "card3");

        ambilpnl.setBackground(new java.awt.Color(142, 193, 254));
        ambilpnl.setMinimumSize(new java.awt.Dimension(726, 334));
        ambilpnl.setPreferredSize(new java.awt.Dimension(750, 371));
        ambilpnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ambilcari_txt.setBackground(new java.awt.Color(168, 207, 255));
        ambilcari_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ambilcari_txt.setForeground(new java.awt.Color(255, 255, 255));
        ambilcari_txt.setBorder(null);
        ambilpnl.add(ambilcari_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 11, 260, 32));

        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel185.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel185.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel185MouseClicked(evt);
            }
        });
        ambilpnl.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 11, 31, -1));
        ambilpnl.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 51, 260, 10));

        tabelambil.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelambil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelambilMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabelambil);

        ambilpnl.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 411, 222));

        jLabel186.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setText("ID Transaksi");
        jLabel186.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 21, 108, -1));

        prosesid4.setBackground(new java.awt.Color(168, 207, 255));
        prosesid4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesid4.setForeground(new java.awt.Color(255, 255, 255));
        prosesid4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesid4.setBorder(null);
        ambilpnl.add(prosesid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 16, 160, 32));

        jLabel187.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setText("ID Outlet");
        jLabel187.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 60, 108, -1));

        prosesmemb4.setBackground(new java.awt.Color(168, 207, 255));
        prosesmemb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesmemb4.setForeground(new java.awt.Color(255, 255, 255));
        prosesmemb4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesmemb4.setBorder(null);
        ambilpnl.add(prosesmemb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 54, 160, 32));

        jLabel188.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setText("ID Member");
        jLabel188.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 97, 108, -1));

        prosespkt4.setBackground(new java.awt.Color(168, 207, 255));
        prosespkt4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosespkt4.setForeground(new java.awt.Color(255, 255, 255));
        prosespkt4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosespkt4.setBorder(null);
        ambilpnl.add(prosespkt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 91, 160, 32));

        prosestgl4.setBackground(new java.awt.Color(168, 207, 255));
        prosestgl4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosestgl4.setForeground(new java.awt.Color(255, 255, 255));
        prosestgl4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosestgl4.setBorder(null);
        ambilpnl.add(prosestgl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 129, 160, 32));

        prosesbayar4.setBackground(new java.awt.Color(168, 207, 255));
        prosesbayar4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesbayar4.setForeground(new java.awt.Color(255, 255, 255));
        prosesbayar4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesbayar4.setBorder(null);
        ambilpnl.add(prosesbayar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 172, 160, 32));

        jLabel189.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setText("Keterangan");
        jLabel189.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 178, 108, -1));

        jLabel193.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setText("Tanggal Laundry");
        jLabel193.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 135, -1, -1));

        jLabel194.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setText("Status");
        jLabel194.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ambilpnl.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 216, 108, -1));

        status4.setBackground(new java.awt.Color(168, 207, 255));
        status4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status4.setForeground(new java.awt.Color(255, 255, 255));
        status4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "baru", "proses", "selesai", "diambil" }));
        status4.setBorder(null);
        ambilpnl.add(status4, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 210, 84, 30));

        jTextArea3.setBackground(new java.awt.Color(168, 207, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane12.setViewportView(jTextArea3);

        ambilpnl.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 246, 216, 118));

        add2.setBackground(new java.awt.Color(83, 148, 222));
        add2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add2.setForeground(new java.awt.Color(255, 255, 255));
        add2.setText("ADD");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });
        ambilpnl.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 312, 90, 40));

        add3.setBackground(new java.awt.Color(83, 148, 222));
        add3.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add3.setForeground(new java.awt.Color(255, 255, 255));
        add3.setText("PRINT");
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });
        ambilpnl.add(add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 312, 90, 40));

        mainprogpnl.add(ambilpnl, "card6");

        selesaipnl.setBackground(new java.awt.Color(142, 193, 254));
        selesaipnl.setMinimumSize(new java.awt.Dimension(726, 334));
        selesaipnl.setPreferredSize(new java.awt.Dimension(750, 371));
        selesaipnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selesaicari_txt1.setBackground(new java.awt.Color(168, 207, 255));
        selesaicari_txt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selesaicari_txt1.setForeground(new java.awt.Color(255, 255, 255));
        selesaicari_txt1.setBorder(null);
        selesaipnl.add(selesaicari_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 20, 260, 30));
        selesaipnl.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 58, 260, 10));

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel168.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel168.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel168MouseClicked(evt);
            }
        });
        selesaipnl.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 37, 42));

        tabelselesai.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelselesai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelselesaiMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tabelselesai);

        selesaipnl.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 380, 210));

        jLabel169.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setText("ID Transaksi");
        jLabel169.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, -1));

        prosesid3.setBackground(new java.awt.Color(168, 207, 255));
        prosesid3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesid3.setForeground(new java.awt.Color(255, 255, 255));
        prosesid3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesid3.setBorder(null);
        prosesid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesid3ActionPerformed(evt);
            }
        });
        selesaipnl.add(prosesid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 126, 32));

        jLabel170.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("ID Outlet");
        jLabel170.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 110, -1));

        prosesmemb3.setBackground(new java.awt.Color(168, 207, 255));
        prosesmemb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesmemb3.setForeground(new java.awt.Color(255, 255, 255));
        prosesmemb3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesmemb3.setBorder(null);
        selesaipnl.add(prosesmemb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 126, 32));

        jLabel171.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setText("ID Member");
        jLabel171.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 110, -1));

        prosespkt3.setBackground(new java.awt.Color(168, 207, 255));
        prosespkt3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosespkt3.setForeground(new java.awt.Color(255, 255, 255));
        prosespkt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosespkt3.setBorder(null);
        selesaipnl.add(prosespkt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 126, 32));

        jLabel172.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setText("Tanggal Laundry");
        jLabel172.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        prosestgl3.setBackground(new java.awt.Color(168, 207, 255));
        prosestgl3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosestgl3.setForeground(new java.awt.Color(255, 255, 255));
        prosestgl3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosestgl3.setBorder(null);
        selesaipnl.add(prosestgl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 126, 32));

        jLabel173.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setText("Keterangan");
        jLabel173.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 108, -1));

        prosesbayar3.setBackground(new java.awt.Color(168, 207, 255));
        prosesbayar3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prosesbayar3.setForeground(new java.awt.Color(255, 255, 255));
        prosesbayar3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prosesbayar3.setBorder(null);
        selesaipnl.add(prosesbayar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 126, 32));

        jLabel174.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setText("Status");
        jLabel174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selesaipnl.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 108, -1));

        status3.setBackground(new java.awt.Color(168, 207, 255));
        status3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status3.setForeground(new java.awt.Color(255, 255, 255));
        status3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Baru", "Proses", "Selesai", "Diambil" }));
        status3.setBorder(null);
        selesaipnl.add(status3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 103, 30));

        add4.setBackground(new java.awt.Color(83, 148, 222));
        add4.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add4.setForeground(new java.awt.Color(255, 255, 255));
        add4.setText("ADD");
        add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add4ActionPerformed(evt);
            }
        });
        selesaipnl.add(add4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 90, 40));

        mainprogpnl.add(selesaipnl, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(771, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(mainprogpnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(mainprogpnl, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 880, 410));

        pHome.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        pHome.setForeground(new java.awt.Color(255, 255, 255));
        pHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pHome.setText("-");
        jPanel1.add(pHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 590, 50));

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        jPanel1.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 190, 20));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 220, 40));

        jLabel2.setFont(new java.awt.Font("Edwardian Script ITC", 3, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Laundry");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 140, 70));

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mars ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 140, 49));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jenis Laundry :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 100, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("=> Cucian Kiloan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 350, 110, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("=> Selimut ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 370, 110, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("=> Bed Cover");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 110, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("=> Kaos");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 410, 110, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("=> DLL.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 430, 110, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mars Launry Stor");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, 110, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/kal.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/jam-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 60, 60));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Jl.Galanggang Ds.Neglasari Kec.Batujajar Kab.Bandung Barat");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 380, 28));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/B3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 500));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(550, 50));

        outlet.setText("Data Outlet     ");
        outlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                outletMousePressed(evt);
            }
        });
        jMenuBar1.add(outlet);

        paket.setText("Data Paket     ");
        paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paketMousePressed(evt);
            }
        });
        jMenuBar1.add(paket);

        user.setText("Data User     ");
        user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userMousePressed(evt);
            }
        });
        jMenuBar1.add(user);

        member.setText("Registrasi Member     ");
        member.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                memberMenuSelected(evt);
            }
        });
        member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                memberMousePressed(evt);
            }
        });
        jMenuBar1.add(member);

        transaksi.setText("Data Transaksi     ");
        transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transaksiMousePressed(evt);
            }
        });
        jMenuBar1.add(transaksi);

        laporan.setText("Laporan     ");
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                laporanMousePressed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Laporan Data Outlet");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        laporan.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Laporan Data Paket");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        laporan.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Laporan Data Member");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        laporan.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Laporan Data Transaksi");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        laporan.add(jMenuItem7);

        jMenuBar1.add(laporan);

        info.setText("Info                                                                                                                                                                                                         ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Tentang");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        info.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Lagout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        info.add(jMenuItem2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Exit");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        info.add(jMenuItem8);

        jMenuBar1.add(info);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/exit.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMousePressed
        this.setVisible(true);
        new menu_user().setVisible(true);
    }//GEN-LAST:event_userMousePressed

    private void memberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberMousePressed
        this.setVisible(true);
        new menu_member().setVisible(true);
    }//GEN-LAST:event_memberMousePressed

    private void paketMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paketMousePressed
        this.setVisible(true);
        new menu_paket().setVisible(true);
    }//GEN-LAST:event_paketMousePressed

    private void transaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiMousePressed
        this.setVisible(true);
        new menu_transaksi().setVisible(true);
    }//GEN-LAST:event_transaksiMousePressed

    private void laporanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMousePressed

    }//GEN-LAST:event_laporanMousePressed

    private void outletMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outletMousePressed
       this.setVisible(true);
        new menu_outlet().setVisible(true);
    }//GEN-LAST:event_outletMousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void memberMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_memberMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_memberMenuSelected

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       this.setVisible(true);
        new Login_Laundry().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      this.setVisible(true);
        new menu_info().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
   
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed

    }//GEN-LAST:event_jMenu1MousePressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
         dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jLabel161MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel161MouseClicked
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelbaru.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` where id_transaksi like '%" + barucari_txt.getText() + "%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
            barucari_txt.setText("");

        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jLabel161MouseClicked

    private void tabelbaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbaruMouseClicked
        int baris = tabelbaru.getSelectedRow();
        prosesid1.setText(tabelbaru.getModel().getValueAt(baris, 0).toString());
        prosespkt1.setText(tabelbaru.getModel().getValueAt(baris, 1).toString());
        prosesmemb1.setText(tabelbaru.getModel().getValueAt(baris, 2).toString());
        prosestgl1.setText(tabelbaru.getModel().getValueAt(baris, 3).toString());
        prosesbayar1.setText(tabelbaru.getModel().getValueAt(baris, 4).toString());
        status1.setSelectedItem(tabelbaru.getModel().getValueAt(baris, 5).toString());
        jLabel161.setEnabled(true);
    }//GEN-LAST:event_tabelbaruMouseClicked

    private void jLabel185MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel185MouseClicked
        Object header[]={"ID Transaksi","ID Outlet","ID Member","Tanggal Laundry","Keterangan","Status"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabelambil.setModel(data);
        setkoneksi();
        String sql="SELECT `id_transaksi`, `id_outlet`, `id_member`, `tgl`, `dibayar`, `status` FROM `transaksi` where id_transaksi like '%" + ambilcari_txt.getText() + "%'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom6=rs.getString(6);

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
            ambilcari_txt.setText("");

        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jLabel185MouseClicked

    private void tabelambilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelambilMouseClicked
        int baris = tabelambil.getSelectedRow();
        prosesid4.setText(tabelambil.getModel().getValueAt(baris, 0).toString());
        prosespkt4.setText(tabelambil.getModel().getValueAt(baris, 1).toString());
        prosesmemb4.setText(tabelambil.getModel().getValueAt(baris, 2).toString());
        prosestgl4.setText(tabelambil.getModel().getValueAt(baris, 3).toString());
        prosesbayar4.setText(tabelambil.getModel().getValueAt(baris, 4).toString());
        status4.setSelectedItem(tabelambil.getModel().getValueAt(baris, 5).toString());
        jLabel185.setEnabled(true);

    }//GEN-LAST:event_tabelambilMouseClicked

    private void jLabel197MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel197MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel197MouseClicked

    private void tabelprosesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelprosesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelprosesMouseClicked

    private void prosestgl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosestgl2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prosestgl2ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
 try{
            setkoneksi();
            String sql="update transaksi set status='"+status1.getSelectedItem() +"' where id_transaksi='"+prosesid1.getText()+"'";;
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");
            tampiltabelbaru();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelambil();
        }
        catch (HeadlessException | SQLException e) {
        }
        prosesid1.setText("");
        prosespkt1.setText("");
        prosesmemb1.setText("");
        prosestgl1.setText("");
        prosesbayar1.setText("");
        status1.setSelectedItem("Pilih");
    }//GEN-LAST:event_addActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
                try{
        setkoneksi();
            String sql="update transaksi set status='"+status2.getSelectedItem() +"' where id_transaksi='"+prosesid2.getText()+"'";;
            stm.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelbaru();
            tampiltabelambil();
        }
            catch (HeadlessException | SQLException e) {
        }
        prosesid2.setText("");
        prosespkt2.setText("");
        prosesmemb2.setText("");
        prosestgl2.setText("");
        prosesbayar2.setText("");
        status2.setSelectedItem("Pilih");
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
                try{
            setkoneksi();
            String sql="update transaksi set status='"+status4.getSelectedItem() +"' where id_transaksi='"+prosesid4.getText()+"'";;
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");

            jTextArea3.append("\t\t STRUK PENGAMBILAN BARANG MLS \n\n"+

                "ID Transaksi :\t\t\t" + prosesid4.getText() + "\n"
                + "\n ID Outlet :\t\t" + prosespkt4.getText() + "\n"
                + "\n ID Member :\t\t\t" + prosesmemb4.getText() + "\n"
                + "\n Tanggal Laundry :\t\t" + prosestgl4.getText() + "\n"
                + "\n Keterangan :\t\t\t" + prosesbayar4.getText() + "\n"
                + "\n Tanggal Pengambilan :\t\t\t" +status4 .getSelectedItem() + "\n");
            tampiltabelambil();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelbaru();
        }
        catch (HeadlessException | SQLException e) {
        }
        prosesid4.setText("");
        prosespkt4.setText("");
        prosesmemb4.setText("");
        prosestgl4.setText("");
        prosesbayar4.setText("");
        status4.setSelectedItem("Pilih");
    }//GEN-LAST:event_add2ActionPerformed

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
      try {
            jTextArea3.print();
        } catch (PrinterException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add3ActionPerformed

    private void panelhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseClicked
       
    }//GEN-LAST:event_panelhomeMouseClicked

    private void panelbaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbaruMouseClicked
        
    }//GEN-LAST:event_panelbaruMouseClicked

    private void panelprosesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelprosesMouseClicked
        
    }//GEN-LAST:event_panelprosesMouseClicked

    private void panelselesaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelselesaiMouseClicked
         
    }//GEN-LAST:event_panelselesaiMouseClicked

    private void jLabel160MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel160MouseClicked
        mainprogpnl.removeAll();
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        mainprogpnl.add(ambilpnl);
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        panelhome.setBackground(new Color(142,193,254));
        panelselesai.setBackground(new Color(142,193,254));
        panelproses.setBackground(new Color(142,193,254));
        panelbaru.setBackground(new Color(142,193,254));
        panelambil.setBackground(new Color(142,193,254));
        tampiltabelbaru();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelambil();
    }//GEN-LAST:event_jLabel160MouseClicked

    private void jLabel191MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel191MouseClicked
        mainprogpnl.removeAll();
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        mainprogpnl.add(dashboard);
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        panelbaru.setBackground(new Color(142,193,254));
        panelhome.setBackground(new Color(142,193,254));
        panelproses.setBackground(new Color(142,193,254));
        panelselesai.setBackground(new Color(142,193,254));
        panelambil.setBackground(new Color(142,193,254));
    }//GEN-LAST:event_jLabel191MouseClicked

    private void jLabel153MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel153MouseClicked
        mainprogpnl.removeAll();
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        mainprogpnl.add(barupnl);
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        panelhome.setBackground(new Color(142,193,254));
        panelbaru.setBackground(new Color(142,193,254));
        panelproses.setBackground(new Color(142,193,254));
        panelselesai.setBackground(new Color(142,193,254));
        panelambil.setBackground(new Color(142,193,254));
        tampiltabelbaru();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelambil();
    }//GEN-LAST:event_jLabel153MouseClicked

    private void jLabel156MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel156MouseClicked
        mainprogpnl.removeAll();
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        mainprogpnl.add(progresspnl);
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        panelhome.setBackground(new Color(142,193,254));
        panelproses.setBackground(new Color(142,193,254));
        panelbaru.setBackground(new Color(142,193,254));
        panelselesai.setBackground(new Color(142,193,254));
        panelambil.setBackground(new Color(142,193,254));
        tampiltabelbaru();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelambil();
    }//GEN-LAST:event_jLabel156MouseClicked

    private void jLabel158MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel158MouseClicked
       mainprogpnl.removeAll();
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        mainprogpnl.add(selesaipnl);
        mainprogpnl.repaint();
        mainprogpnl.revalidate();
        panelhome.setBackground(new Color(142,193,254));
        panelselesai.setBackground(new Color(142,193,254));
        panelproses.setBackground(new Color(142,193,254));
        panelbaru.setBackground(new Color(142,193,254));
        panelambil.setBackground(new Color(142,193,254));
        tampiltabelbaru();
            tampiltabelproses();
            tampiltabelselesai();
            tampiltabelambil();
    }//GEN-LAST:event_jLabel158MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try{
       setkoneksi();
       String reportPath = "C:\\Users\\Windows Marsyanda 10\\Documents\\NetBeansProjects\\Mars Laundry\\src\\Laundry\\laporan\\Lpmember.jrxml";
       File file = new File(reportPath);
       JasperDesign jd = JRXmlLoader.load(file);
       JasperReport jr = JasperCompileManager.compileReport(jd);
       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
       JasperViewer.viewReport(jp,false);
       con.close();
   } catch (SQLException ex) {
        Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (JRException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         try{
       setkoneksi();
       String reportPath = "C:\\Users\\Windows Marsyanda 10\\Documents\\NetBeansProjects\\Mars Laundry\\src\\Laundry\\laporan\\Lppaket.jrxml";
       File file = new File(reportPath);
       JasperDesign jd = JRXmlLoader.load(file);
       JasperReport jr = JasperCompileManager.compileReport(jd);
       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
       JasperViewer.viewReport(jp,false);
       con.close();
   } catch (SQLException ex) {
        Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (JRException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      try{
       setkoneksi();
       String reportPath = "C:\\Users\\Windows Marsyanda 10\\Documents\\NetBeansProjects\\Mars Laundry\\src\\Laundry\\laporan\\Lpoutlet.jrxml";
       File file = new File(reportPath);
       JasperDesign jd = JRXmlLoader.load(file);
       JasperReport jr = JasperCompileManager.compileReport(jd);
       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
       JasperViewer.viewReport(jp,false);
       con.close();
   } catch (SQLException ex) {
        Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (JRException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
     try{
       setkoneksi();
       String reportPath = "C:\\Users\\Windows Marsyanda 10\\Documents\\NetBeansProjects\\Mars Laundry\\src\\Laundry\\laporan\\Lptransaksi1.jrxml";
       File file = new File(reportPath);
       JasperDesign jd = JRXmlLoader.load(file);
       JasperReport jr = JasperCompileManager.compileReport(jd);
       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
       JasperViewer.viewReport(jp,false);
       con.close();
   } catch (SQLException ex) {
        Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (JRException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     try{
       setkoneksi();
       String reportPath = "C:\\Users\\Windows Marsyanda 10\\Documents\\NetBeansProjects\\Mars Laundry\\src\\Laundry\\laporan\\Lptransaksi2.jrxml";
       File file = new File(reportPath);
       JasperDesign jd = JRXmlLoader.load(file);
       JasperReport jr = JasperCompileManager.compileReport(jd);
       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
       JasperViewer.viewReport(jp,false);
       con.close();
   } catch (SQLException ex) {
        Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (JRException ex) {
            Logger.getLogger(home_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jLabel192MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel192MouseClicked
        try{
            jTextArea4.setText("");
            setkoneksi();
            stm=con.createStatement();
            String sql="select * from transaksi where id_transaksi='"+prosescari_txt.getText()+"'";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                jTextArea4.append("\t\t\t BARANG BERSTATUS \n\n" + "\t\t\t" + rs.getString("status"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jLabel192MouseClicked

    private void jLabel168MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel168MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel168MouseClicked

    private void tabelselesaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelselesaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelselesaiMouseClicked

    private void add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add4ActionPerformed

    private void prosesid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prosesid3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(home_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JTextField ambilcari_txt;
    private javax.swing.JPanel ambilpnl;
    private javax.swing.JTextField barucari_txt;
    private javax.swing.JPanel barupnl;
    private javax.swing.JTextField cariprog_txt;
    private javax.swing.JPanel dashboard;
    private javax.swing.JMenu info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JMenu laporan;
    private javax.swing.JPanel mainprogpnl;
    private javax.swing.JMenu member;
    private javax.swing.JMenu outlet;
    private javax.swing.JLabel pHome;
    private javax.swing.JMenu paket;
    private javax.swing.JPanel panelambil;
    private javax.swing.JPanel panelbaru;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelproses;
    private javax.swing.JPanel panelselesai;
    private javax.swing.JPanel progresspnl;
    private javax.swing.JTextField prosesbayar1;
    private javax.swing.JTextField prosesbayar2;
    private javax.swing.JTextField prosesbayar3;
    private javax.swing.JTextField prosesbayar4;
    private javax.swing.JTextField prosescari_txt;
    private javax.swing.JTextField prosesid1;
    private javax.swing.JTextField prosesid2;
    private javax.swing.JTextField prosesid3;
    private javax.swing.JTextField prosesid4;
    private javax.swing.JTextField prosesmemb1;
    private javax.swing.JTextField prosesmemb2;
    private javax.swing.JTextField prosesmemb3;
    private javax.swing.JTextField prosesmemb4;
    private javax.swing.JTextField prosespkt1;
    private javax.swing.JTextField prosespkt2;
    private javax.swing.JTextField prosespkt3;
    private javax.swing.JTextField prosespkt4;
    private javax.swing.JTextField prosestgl1;
    private javax.swing.JTextField prosestgl2;
    private javax.swing.JTextField prosestgl3;
    private javax.swing.JTextField prosestgl4;
    private javax.swing.JTextField selesaicari_txt1;
    private javax.swing.JPanel selesaipnl;
    private javax.swing.JComboBox<String> status1;
    private javax.swing.JComboBox<String> status2;
    private javax.swing.JComboBox<String> status3;
    private javax.swing.JComboBox<String> status4;
    private javax.swing.JTable tabelambil;
    private javax.swing.JTable tabelbaru;
    private javax.swing.JTable tabelproses;
    private javax.swing.JTable tabelselesai;
    private javax.swing.JLabel tanggal;
    private javax.swing.JMenu transaksi;
    public javax.swing.JMenu user;
    // End of variables declaration//GEN-END:variables
}
