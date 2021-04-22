package Laundry;


import Laundry.menu_user;
import laundry.style.buttonRounded;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.geom.RoundRectangle2D;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KIMSUL
 */
public class menu_user extends javax.swing.JFrame {
   
Connection con;
    Statement stm;
    ResultSet rs;
   
    private int xx;
    private int xy;
    int timeRun = 0;
    ImageIcon imageicon;
    
    public menu_user() {
        initComponents();
        tglhariini();
        clock();
        setLocationRelativeTo(this);
        tabeluser();
        auto_us();
        tampilCombo();
        idu.disable();
         
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
         
  public void tabeluser(){
        Object header[]={"ID User","Nama User","Username","Password","ID Outlet","Role"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="select * from user order by id_user";
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
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        userpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        Clock = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        delet = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        idu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        nl = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        ps = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        rbadm = new javax.swing.JRadioButton();
        rbkasir = new javax.swing.JRadioButton();
        rbown = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(20, 20));
        setUndecorated(true);

        userpanel.setBackground(new java.awt.Color(129, 177, 231));
        userpanel.setPreferredSize(new java.awt.Dimension(1195, 550));
        userpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                userpanelMouseDragged(evt);
            }
        });
        userpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userpanelMousePressed(evt);
            }
        });
        userpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        userpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 530, 330));

        jTextField4.setBackground(new java.awt.Color(129, 177, 231));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        userpanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, 210, 50));

        Clock.setFont(new java.awt.Font("Engravers MT", 1, 17)); // NOI18N
        Clock.setForeground(new java.awt.Color(255, 255, 255));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("0 : 29 : 10 PM");
        userpanel.add(Clock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, -1));

        tanggal.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("kalender");
        userpanel.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 30));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/search.png"))); // NOI18N
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        userpanel.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 460, -1, 50));

        add.setBackground(new java.awt.Color(83, 148, 222));
        add.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        userpanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 90, 40));

        edit.setBackground(new java.awt.Color(83, 148, 222));
        edit.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        userpanel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 90, 40));

        cancel.setBackground(new java.awt.Color(83, 148, 222));
        cancel.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        userpanel.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, 40));

        delet.setBackground(new java.awt.Color(83, 148, 222));
        delet.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        delet.setForeground(new java.awt.Color(255, 255, 255));
        delet.setText("DELET");
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });
        userpanel.add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 40));

        jPanel1.setBackground(new java.awt.Color(143, 186, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukan Data User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ID User");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        idu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        idu.setForeground(new java.awt.Color(51, 51, 51));
        idu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idu.setBorder(null);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Nama Lengkap");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        nl.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nl.setForeground(new java.awt.Color(51, 51, 51));
        nl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nl.setBorder(null);
        nl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nlActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Username");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        us.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        us.setForeground(new java.awt.Color(51, 51, 51));
        us.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        us.setBorder(null);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Password");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        ps.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ps.setForeground(new java.awt.Color(51, 51, 51));
        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ps.setBorder(null);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("ID Outlet");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        jComboBox3.setBorder(null);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Role");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        rbadm.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(rbadm);
        rbadm.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbadm.setForeground(new java.awt.Color(255, 255, 255));
        rbadm.setText("Admin");
        rbadm.setBorder(null);
        rbadm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbadmActionPerformed(evt);
            }
        });

        rbkasir.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(rbkasir);
        rbkasir.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbkasir.setForeground(new java.awt.Color(255, 255, 255));
        rbkasir.setText("Kasir");
        rbkasir.setBorder(null);

        rbown.setBackground(new java.awt.Color(143, 186, 233));
        buttonGroup1.add(rbown);
        rbown.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbown.setForeground(new java.awt.Color(255, 255, 255));
        rbown.setText("Owner");
        rbown.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nl, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(us, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbadm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbkasir))
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbown)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(nl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(us, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbadm)
                    .addComponent(jLabel38)
                    .addComponent(rbkasir)
                    .addComponent(rbown))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        userpanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 510, 330));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Laundry/icon/pixlr-bg-result.png"))); // NOI18N
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        userpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 30, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        userpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, -1, 30));

        jLabel7.setFont(new java.awt.Font("Edwardian Script ITC", 3, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Data User Laundry");
        userpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 480, 80));

        jLabel8.setFont(new java.awt.Font("Edwardian Script ITC", 3, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mars Laundry");
        userpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        idu.setText(jTable1.getModel().getValueAt(baris, 0).toString());
        nl.setText(jTable1.getModel().getValueAt(baris, 1).toString());
        us.setText(jTable1.getModel().getValueAt(baris, 2).toString());
        ps.setText(jTable1.getModel().getValueAt(baris, 3).toString());
        jComboBox3.setSelectedItem(jTable1.getModel().getValueAt(baris, 4).toString());
        String role = jTable1.getModel().getValueAt(baris, 5).toString();
        if(role.equals("Admin")){
            rbadm.setSelected(true);
        }
        else if(role.equals("Kasir")){
            rbkasir.setSelected(true);
        }
        else {
            rbown.setSelected(true);
        }
        delet.setEnabled(true);
        cancel.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        Object header[]={"ID User","Nama Lengkap","Username","Password","ID Outlet", "Role"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setkoneksi();
        String sql="Select * from user where id_user like '%" + jTextField4.getText() + "%'" + "or nama_user like '%" +jTextField4.getText()+"%'";
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
            
            jTextField4.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel102MouseClicked

    private void rbadmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbadmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbadmActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       String role;
        if(rbadm.isSelected()){
            role = "Admin";
        }else if(rbkasir.isSelected()){
            role = "Kasir";
        }else{
            role = "Owner";
        }
        try{
            if(idu.getText().equals("") || jComboBox3.getSelectedItem().equals("Pilih") || nl.getText().equals("")
                || us.getText().equals("") || ps.getText().equals("")
                || !(rbadm.isSelected() | rbkasir.isSelected() | rbown.isSelected())  ){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idu.requestFocus();
            }else{
                setkoneksi();
                String sql="insert into user values('"+idu.getText()
                +"','"+nl.getText()
                +"','"+us.getText()
                +"','"+ps.getText()
                +"','"+jComboBox3.getSelectedItem()
                +"','"+role+"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Ditambahkan!");
                tabeluser();
                auto_us();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_us();
        nl.setText("");
        us.setText("");
        ps.setText("");
        jComboBox3.setSelectedItem("Pilih");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String role;
        if(rbadm.isSelected()){
            role = "Admin";
        }else if(rbkasir.isSelected()){
            role = "Kasir";
        }else{
            role = "Owner";
        }
        try{
            if(idu.getText().equals("") || jComboBox3.getSelectedItem().equals("Pilih") || nl.getText().equals("") || us.getText().equals("") || ps.getText().equals("")
                || !(rbadm.isSelected() | rbkasir.isSelected() | rbown.isSelected())  ){
                JOptionPane.showMessageDialog(rootPane, "Lengkapi Data terlebih dahulu!", "Pesan", JOptionPane.ERROR_MESSAGE);
                idu.requestFocus();
            }else{
                setkoneksi();
                String sql="update user set nama_user='"+nl.getText()
                +"',username='"+us.getText()
                +"',password='"+ps.getText()
                +"',id_outlet='"+jComboBox3.getSelectedItem()
                +"',role='"+ role +"' where id_user='"+idu.getText()+"'";;
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Diubah!");
                tabeluser();
                auto_us();
            }
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_us();
        nl.setText("");
        us.setText("");
        ps.setText("");
        jComboBox3.setSelectedItem("Pilih");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_editActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        auto_us();
        nl.setText("");
        us.setText("");
        ps.setText("");
        jComboBox3.setSelectedItem("Pilih");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_cancelActionPerformed

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        try{
            setkoneksi();
            String sql="DELETE FROM user WHERE id_user='"+idu.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus!");
            tabeluser();
            auto_us();
        }
        catch (HeadlessException | SQLException e) {
        }
        auto_us();
        nl.setText("");
        us.setText("");
        ps.setText("");
        jComboBox3.setSelectedItem("Pilih");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_deletActionPerformed

    private void userpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userpanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_userpanelMouseDragged

    private void userpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userpanelMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_userpanelMousePressed

    private void nlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nlActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delet;
    private javax.swing.JButton edit;
    private javax.swing.JTextField idu;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nl;
    private javax.swing.JTextField ps;
    private javax.swing.JRadioButton rbadm;
    private javax.swing.JRadioButton rbkasir;
    private javax.swing.JRadioButton rbown;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField us;
    private javax.swing.JPanel userpanel;
    // End of variables declaration//GEN-END:variables
}
