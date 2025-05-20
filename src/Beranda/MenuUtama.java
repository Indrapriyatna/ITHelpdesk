
package Beranda;

import java.awt.Color;

/**
 *
 * @author Draaa
 */
public class MenuUtama extends javax.swing.JFrame {

    int xx, xy;
    
    public MenuUtama() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_kiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_btndashboard = new javax.swing.JPanel();
        pn_line = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        pn_btnPegawai = new javax.swing.JPanel();
        pn_line1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_Pegawai = new javax.swing.JLabel();
        pn_btnTikethelpdesk = new javax.swing.JPanel();
        pn_line3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_dashboard2 = new javax.swing.JLabel();
        pn_btnKategori = new javax.swing.JPanel();
        pn_line4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_dashboard3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pn_btnPerangkat = new javax.swing.JPanel();
        pn_line5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_dashboard4 = new javax.swing.JLabel();
        pn_btnPeminjaman = new javax.swing.JPanel();
        pn_line6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_dashboard5 = new javax.swing.JLabel();
        pn_btnPengadaan = new javax.swing.JPanel();
        pn_line7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_dashboard6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pn_btnLaporanTiket = new javax.swing.JPanel();
        pn_line8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_dashboard7 = new javax.swing.JLabel();
        pn_btnLaporanPeminjaman = new javax.swing.JPanel();
        pn_line11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btn_dashboard10 = new javax.swing.JLabel();
        pn_btnLaporanPengadaan = new javax.swing.JPanel();
        pn_line12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btn_dashboard11 = new javax.swing.JLabel();
        pn_kanan = new javax.swing.JPanel();
        jPGradienpane1 = new JPpanelGradien.JPGradienpane();
        pn_dasar = new javax.swing.JPanel();
        pn_utama = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        pn_kiri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IT Helpdesk icon.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("  IT Helpdesk");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("MASTER DATA");

        pn_btndashboard.setBackground(new java.awt.Color(255, 255, 255));

        pn_line.setBackground(new java.awt.Color(255, 255, 255));
        pn_line.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_lineLayout = new javax.swing.GroupLayout(pn_line);
        pn_line.setLayout(pn_lineLayout);
        pn_lineLayout.setHorizontalGroup(
            pn_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_lineLayout.setVerticalGroup(
            pn_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard (1).png"))); // NOI18N

        btnDashboard.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(102, 102, 102));
        btnDashboard.setText(" Dashboard");
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardMouseExited(evt);
            }
        });

        pn_btnPegawai.setBackground(new java.awt.Color(255, 255, 255));

        pn_line1.setBackground(new java.awt.Color(255, 255, 255));
        pn_line1.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line1Layout = new javax.swing.GroupLayout(pn_line1);
        pn_line1.setLayout(pn_line1Layout);
        pn_line1Layout.setHorizontalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line1Layout.setVerticalGroup(
            pn_line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pegawaii.png"))); // NOI18N

        btn_Pegawai.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_Pegawai.setForeground(new java.awt.Color(102, 102, 102));
        btn_Pegawai.setText("Pegawai");
        btn_Pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_PegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_PegawaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPegawaiLayout = new javax.swing.GroupLayout(pn_btnPegawai);
        pn_btnPegawai.setLayout(pn_btnPegawaiLayout);
        pn_btnPegawaiLayout.setHorizontalGroup(
            pn_btnPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPegawaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btn_Pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPegawaiLayout.setVerticalGroup(
            pn_btnPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPegawaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPegawaiLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_Pegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout pn_btndashboardLayout = new javax.swing.GroupLayout(pn_btndashboard);
        pn_btndashboard.setLayout(pn_btndashboardLayout);
        pn_btndashboardLayout.setHorizontalGroup(
            pn_btndashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btndashboardLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(pn_btnPegawai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pn_btndashboardLayout.setVerticalGroup(
            pn_btndashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btndashboardLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btndashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btndashboardLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(pn_btnPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_btnTikethelpdesk.setBackground(new java.awt.Color(255, 255, 255));

        pn_line3.setBackground(new java.awt.Color(255, 255, 255));
        pn_line3.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line3Layout = new javax.swing.GroupLayout(pn_line3);
        pn_line3.setLayout(pn_line3Layout);
        pn_line3Layout.setHorizontalGroup(
            pn_line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line3Layout.setVerticalGroup(
            pn_line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiket.png"))); // NOI18N

        btn_dashboard2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard2.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard2.setText("Tiket Helpdesk");
        btn_dashboard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnTikethelpdeskLayout = new javax.swing.GroupLayout(pn_btnTikethelpdesk);
        pn_btnTikethelpdesk.setLayout(pn_btnTikethelpdeskLayout);
        pn_btnTikethelpdeskLayout.setHorizontalGroup(
            pn_btnTikethelpdeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnTikethelpdeskLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnTikethelpdeskLayout.setVerticalGroup(
            pn_btnTikethelpdeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnTikethelpdeskLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnTikethelpdeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnTikethelpdeskLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnKategori.setBackground(new java.awt.Color(255, 255, 255));

        pn_line4.setBackground(new java.awt.Color(255, 255, 255));
        pn_line4.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line4Layout = new javax.swing.GroupLayout(pn_line4);
        pn_line4.setLayout(pn_line4Layout);
        pn_line4Layout.setHorizontalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line4Layout.setVerticalGroup(
            pn_line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kategori.png"))); // NOI18N

        btn_dashboard3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard3.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard3.setText("Kategori Masalah");
        btn_dashboard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnKategoriLayout = new javax.swing.GroupLayout(pn_btnKategori);
        pn_btnKategori.setLayout(pn_btnKategoriLayout);
        pn_btnKategoriLayout.setHorizontalGroup(
            pn_btnKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnKategoriLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnKategoriLayout.setVerticalGroup(
            pn_btnKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnKategoriLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnKategoriLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("TRANSAKSI");

        pn_btnPerangkat.setBackground(new java.awt.Color(255, 255, 255));

        pn_line5.setBackground(new java.awt.Color(255, 255, 255));
        pn_line5.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line5Layout = new javax.swing.GroupLayout(pn_line5);
        pn_line5.setLayout(pn_line5Layout);
        pn_line5Layout.setHorizontalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line5Layout.setVerticalGroup(
            pn_line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perangkatit.png"))); // NOI18N

        btn_dashboard4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard4.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard4.setText("Perangkat IT");
        btn_dashboard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPerangkatLayout = new javax.swing.GroupLayout(pn_btnPerangkat);
        pn_btnPerangkat.setLayout(pn_btnPerangkatLayout);
        pn_btnPerangkatLayout.setHorizontalGroup(
            pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPerangkatLayout.setVerticalGroup(
            pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnPeminjaman.setBackground(new java.awt.Color(255, 255, 255));

        pn_line6.setBackground(new java.awt.Color(255, 255, 255));
        pn_line6.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line6Layout = new javax.swing.GroupLayout(pn_line6);
        pn_line6.setLayout(pn_line6Layout);
        pn_line6Layout.setHorizontalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line6Layout.setVerticalGroup(
            pn_line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pinjam.png"))); // NOI18N

        btn_dashboard5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard5.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard5.setText("Peminjaman Perangkat");
        btn_dashboard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPeminjamanLayout = new javax.swing.GroupLayout(pn_btnPeminjaman);
        pn_btnPeminjaman.setLayout(pn_btnPeminjamanLayout);
        pn_btnPeminjamanLayout.setHorizontalGroup(
            pn_btnPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPeminjamanLayout.setVerticalGroup(
            pn_btnPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPeminjamanLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnPengadaan.setBackground(new java.awt.Color(255, 255, 255));

        pn_line7.setBackground(new java.awt.Color(255, 255, 255));
        pn_line7.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line7Layout = new javax.swing.GroupLayout(pn_line7);
        pn_line7.setLayout(pn_line7Layout);
        pn_line7Layout.setHorizontalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line7Layout.setVerticalGroup(
            pn_line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pengadaanbarang.png"))); // NOI18N

        btn_dashboard6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard6.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard6.setText("Pengadaan Barang");
        btn_dashboard6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPengadaanLayout = new javax.swing.GroupLayout(pn_btnPengadaan);
        pn_btnPengadaan.setLayout(pn_btnPengadaanLayout);
        pn_btnPengadaanLayout.setHorizontalGroup(
            pn_btnPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPengadaanLayout.setVerticalGroup(
            pn_btnPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPengadaanLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("LAPORAN");

        pn_btnLaporanTiket.setBackground(new java.awt.Color(255, 255, 255));

        pn_line8.setBackground(new java.awt.Color(255, 255, 255));
        pn_line8.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line8Layout = new javax.swing.GroupLayout(pn_line8);
        pn_line8.setLayout(pn_line8Layout);
        pn_line8Layout.setHorizontalGroup(
            pn_line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line8Layout.setVerticalGroup(
            pn_line8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporantiket.png"))); // NOI18N

        btn_dashboard7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard7.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard7.setText("Laporan Tiket");
        btn_dashboard7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanTiketLayout = new javax.swing.GroupLayout(pn_btnLaporanTiket);
        pn_btnLaporanTiket.setLayout(pn_btnLaporanTiketLayout);
        pn_btnLaporanTiketLayout.setHorizontalGroup(
            pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnLaporanTiketLayout.setVerticalGroup(
            pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnLaporanPeminjaman.setBackground(new java.awt.Color(255, 255, 255));

        pn_line11.setBackground(new java.awt.Color(255, 255, 255));
        pn_line11.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line11Layout = new javax.swing.GroupLayout(pn_line11);
        pn_line11.setLayout(pn_line11Layout);
        pn_line11Layout.setHorizontalGroup(
            pn_line11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line11Layout.setVerticalGroup(
            pn_line11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporanpeminjaman.png"))); // NOI18N

        btn_dashboard10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard10.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard10.setText("Laporan Peminjaman");
        btn_dashboard10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanPeminjamanLayout = new javax.swing.GroupLayout(pn_btnLaporanPeminjaman);
        pn_btnLaporanPeminjaman.setLayout(pn_btnLaporanPeminjamanLayout);
        pn_btnLaporanPeminjamanLayout.setHorizontalGroup(
            pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnLaporanPeminjamanLayout.setVerticalGroup(
            pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnLaporanPengadaan.setBackground(new java.awt.Color(255, 255, 255));

        pn_line12.setBackground(new java.awt.Color(255, 255, 255));
        pn_line12.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line12Layout = new javax.swing.GroupLayout(pn_line12);
        pn_line12.setLayout(pn_line12Layout);
        pn_line12Layout.setHorizontalGroup(
            pn_line12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line12Layout.setVerticalGroup(
            pn_line12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporanpengadaan.png"))); // NOI18N

        btn_dashboard11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_dashboard11.setForeground(new java.awt.Color(102, 102, 102));
        btn_dashboard11.setText("Laporan Pengadaan");
        btn_dashboard11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dashboard11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dashboard11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dashboard11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanPengadaanLayout = new javax.swing.GroupLayout(pn_btnLaporanPengadaan);
        pn_btnLaporanPengadaan.setLayout(pn_btnLaporanPengadaanLayout);
        pn_btnLaporanPengadaanLayout.setHorizontalGroup(
            pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(btn_dashboard11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnLaporanPengadaanLayout.setVerticalGroup(
            pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line12, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_dashboard11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pn_btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnTikethelpdesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btndashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(pn_kiriLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(pn_btnPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pn_btnLaporanTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_btnLaporanPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_btnLaporanPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(pn_btndashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(15, 15, 15)
                .addComponent(pn_btnTikethelpdesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(pn_btnLaporanTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_btnLaporanPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_btnLaporanPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(pn_kiri, java.awt.BorderLayout.LINE_START);

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        jPGradienpane1.setColorEnd(new java.awt.Color(102, 204, 255));
        jPGradienpane1.setColorStart(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPGradienpane1Layout = new javax.swing.GroupLayout(jPGradienpane1);
        jPGradienpane1.setLayout(jPGradienpane1Layout);
        jPGradienpane1Layout.setHorizontalGroup(
            jPGradienpane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        jPGradienpane1Layout.setVerticalGroup(
            jPGradienpane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pn_kanan.add(jPGradienpane1, java.awt.BorderLayout.PAGE_START);

        pn_dasar.setBackground(new java.awt.Color(250, 250, 250));

        pn_utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_utama.setPreferredSize(new java.awt.Dimension(1136, 692));
        pn_utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_dasarLayout = new javax.swing.GroupLayout(pn_dasar);
        pn_dasar.setLayout(pn_dasarLayout);
        pn_dasarLayout.setHorizontalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pn_kanan.add(pn_dasar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pn_kanan, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseEntered
        pn_btndashboard.setBackground(new Color(250, 250, 250 ));
        pn_line.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnDashboardMouseEntered

    private void btnDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseExited
         pn_btndashboard.setBackground(new Color(255, 255, 255 ));
         pn_line.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnDashboardMouseExited

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        pn_btndashboard.setBackground(new Color(240, 240, 240 ));
        pn_line.setBackground(new Color(0, 102, 153));
        
        pn_utama.removeAll();
        pn_utama.add(new menuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
       xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void btn_PegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PegawaiMouseClicked
        pn_btnPegawai.setBackground(new Color(240, 240, 240 ));
        pn_line1.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btn_PegawaiMouseClicked

    private void btn_PegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PegawaiMouseEntered
        pn_btnPegawai.setBackground(new Color(250, 250, 250 ));
        pn_line1.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btn_PegawaiMouseEntered

    private void btn_PegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PegawaiMouseExited
       pn_btnPegawai.setBackground(new Color(255, 255, 255 ));
         pn_line1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_PegawaiMouseExited

    private void btn_dashboard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard2MouseClicked

    private void btn_dashboard2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard2MouseEntered

    private void btn_dashboard2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard2MouseExited

    private void btn_dashboard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard3MouseClicked

    private void btn_dashboard3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard3MouseEntered

    private void btn_dashboard3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard3MouseExited

    private void btn_dashboard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard4MouseClicked

    private void btn_dashboard4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard4MouseEntered

    private void btn_dashboard4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard4MouseExited

    private void btn_dashboard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard5MouseClicked

    private void btn_dashboard5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard5MouseEntered

    private void btn_dashboard5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard5MouseExited

    private void btn_dashboard6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard6MouseClicked

    private void btn_dashboard6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard6MouseEntered

    private void btn_dashboard6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard6MouseExited

    private void btn_dashboard7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard7MouseClicked

    private void btn_dashboard7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard7MouseEntered

    private void btn_dashboard7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard7MouseExited

    private void btn_dashboard10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard10MouseClicked

    private void btn_dashboard10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard10MouseEntered

    private void btn_dashboard10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard10MouseExited

    private void btn_dashboard11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard11MouseClicked

    private void btn_dashboard11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard11MouseEntered

    private void btn_dashboard11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashboard11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dashboard11MouseExited

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btn_Pegawai;
    private javax.swing.JLabel btn_dashboard10;
    private javax.swing.JLabel btn_dashboard11;
    private javax.swing.JLabel btn_dashboard2;
    private javax.swing.JLabel btn_dashboard3;
    private javax.swing.JLabel btn_dashboard4;
    private javax.swing.JLabel btn_dashboard5;
    private javax.swing.JLabel btn_dashboard6;
    private javax.swing.JLabel btn_dashboard7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private JPpanelGradien.JPGradienpane jPGradienpane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pn_btnKategori;
    private javax.swing.JPanel pn_btnLaporanPeminjaman;
    private javax.swing.JPanel pn_btnLaporanPengadaan;
    private javax.swing.JPanel pn_btnLaporanTiket;
    private javax.swing.JPanel pn_btnPegawai;
    private javax.swing.JPanel pn_btnPeminjaman;
    private javax.swing.JPanel pn_btnPengadaan;
    private javax.swing.JPanel pn_btnPerangkat;
    private javax.swing.JPanel pn_btnTikethelpdesk;
    private javax.swing.JPanel pn_btndashboard;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kiri;
    private javax.swing.JPanel pn_line;
    private javax.swing.JPanel pn_line1;
    private javax.swing.JPanel pn_line11;
    private javax.swing.JPanel pn_line12;
    private javax.swing.JPanel pn_line3;
    private javax.swing.JPanel pn_line4;
    private javax.swing.JPanel pn_line5;
    private javax.swing.JPanel pn_line6;
    private javax.swing.JPanel pn_line7;
    private javax.swing.JPanel pn_line8;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
