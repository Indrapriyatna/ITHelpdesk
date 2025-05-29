
package Main;

import View.FormLogin;
import View.MenuDashboard;
import View.MenuPegawai;
import View.MenuPengguna;
import View.MenuPerangkat;
import config.Database;
import java.awt.Color;
import java.sql.Connection;

/**
 *
 * @author Draaa
 */
public class MenuUtama extends javax.swing.JFrame {
  Connection conn;
    int xx, xy;
        private String userRole;

    
    public MenuUtama(String role) {
        this.userRole = role;
        initComponents();
        // Initialize database connection
        conn = Database.getConnection();
        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Koneksi database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        pn_utama.removeAll();
        pn_utama.add(new MenuDashboard());
        pn_utama.repaint();
        pn_utama.revalidate();
        setAccessControl();
    }
        private void setAccessControl() {
        if ("user".equals(userRole)) {
            // Disable Master Data menus
            pn_btnPengguna.setEnabled(true);
            pn_btnPerangkat.setEnabled(false);
            pn_btnkategori.setEnabled(false);
            // Disable Laporan menus
            pn_btnLaporanTiket.setEnabled(false);
            pn_btnLaporanPeminjaman.setEnabled(false);
            pn_btnLaporanPengadaan.setEnabled(false);
        }
        // Admin role gets full access, so no need to disable anything
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
        pn_btnpegawai = new javax.swing.JPanel();
        pn_line1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JLabel();
        pn_btnPerangkat = new javax.swing.JPanel();
        pn_line2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnPerangkat = new javax.swing.JLabel();
        pn_btnkategori = new javax.swing.JPanel();
        pn_line3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnKategori = new javax.swing.JLabel();
        Transaksi = new javax.swing.JLabel();
        pn_btntiket = new javax.swing.JPanel();
        pn_line4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnTiket = new javax.swing.JLabel();
        pn_btnpeminjaman = new javax.swing.JPanel();
        pn_line5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_peminjaman = new javax.swing.JLabel();
        pn_btnpengadaan = new javax.swing.JPanel();
        pn_line6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_penggadaan = new javax.swing.JLabel();
        Laporan = new javax.swing.JLabel();
        pn_btnLaporanTiket = new javax.swing.JPanel();
        pn_line7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_laporantiket = new javax.swing.JLabel();
        pn_btnLaporanPeminjaman = new javax.swing.JPanel();
        pn_line8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btn_laporanpeminjaman = new javax.swing.JLabel();
        pn_btnLaporanPengadaan = new javax.swing.JPanel();
        pn_line9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btn_laporanpengadaan = new javax.swing.JLabel();
        jButtonCustom5 = new Castom.JButtonCustom();
        pn_btnPengguna = new javax.swing.JPanel();
        pn_line10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnPengguna = new javax.swing.JLabel();
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
        pn_btndashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_btndashboardMouseClicked(evt);
            }
        });

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
                .addGap(10, 10, 10))
        );

        pn_btnpegawai.setBackground(new java.awt.Color(255, 255, 255));
        pn_btnpegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_btnpegawaiMouseClicked(evt);
            }
        });

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

        btnPegawai.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPegawai.setForeground(new java.awt.Color(102, 102, 102));
        btnPegawai.setText("Pegawai");
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPegawaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnpegawaiLayout = new javax.swing.GroupLayout(pn_btnpegawai);
        pn_btnpegawai.setLayout(pn_btnpegawaiLayout);
        pn_btnpegawaiLayout.setHorizontalGroup(
            pn_btnpegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpegawaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnpegawaiLayout.setVerticalGroup(
            pn_btnpegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpegawaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnpegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnpegawaiLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnPerangkat.setBackground(new java.awt.Color(255, 255, 255));

        pn_line2.setBackground(new java.awt.Color(255, 255, 255));
        pn_line2.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line2Layout = new javax.swing.GroupLayout(pn_line2);
        pn_line2.setLayout(pn_line2Layout);
        pn_line2Layout.setHorizontalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line2Layout.setVerticalGroup(
            pn_line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perangkatit.png"))); // NOI18N

        btnPerangkat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPerangkat.setForeground(new java.awt.Color(102, 102, 102));
        btnPerangkat.setText("Perangkat IT");
        btnPerangkat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerangkatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerangkatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerangkatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPerangkatLayout = new javax.swing.GroupLayout(pn_btnPerangkat);
        pn_btnPerangkat.setLayout(pn_btnPerangkatLayout);
        pn_btnPerangkatLayout.setHorizontalGroup(
            pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btnPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPerangkatLayout.setVerticalGroup(
            pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPerangkatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPerangkatLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnPerangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnkategori.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kategori.png"))); // NOI18N

        btnKategori.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnKategori.setForeground(new java.awt.Color(102, 102, 102));
        btnKategori.setText("Kategori Masalah");
        btnKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKategoriMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKategoriMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKategoriMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnkategoriLayout = new javax.swing.GroupLayout(pn_btnkategori);
        pn_btnkategori.setLayout(pn_btnkategoriLayout);
        pn_btnkategoriLayout.setHorizontalGroup(
            pn_btnkategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnkategoriLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnkategoriLayout.setVerticalGroup(
            pn_btnkategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnkategoriLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnkategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnkategoriLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        Transaksi.setForeground(new java.awt.Color(153, 153, 153));
        Transaksi.setText("TRANSAKSI");

        pn_btntiket.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiket.png"))); // NOI18N

        btnTiket.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnTiket.setForeground(new java.awt.Color(102, 102, 102));
        btnTiket.setText("Tiket Helpdesk");
        btnTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiketMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTiketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTiketMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btntiketLayout = new javax.swing.GroupLayout(pn_btntiket);
        pn_btntiket.setLayout(pn_btntiketLayout);
        pn_btntiketLayout.setHorizontalGroup(
            pn_btntiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btntiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btntiketLayout.setVerticalGroup(
            pn_btntiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btntiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btntiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btntiketLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnTiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnpeminjaman.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pinjam.png"))); // NOI18N

        btn_peminjaman.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_peminjaman.setForeground(new java.awt.Color(102, 102, 102));
        btn_peminjaman.setText("Peminjaman Perangkat");
        btn_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnpeminjamanLayout = new javax.swing.GroupLayout(pn_btnpeminjaman);
        pn_btnpeminjaman.setLayout(pn_btnpeminjamanLayout);
        pn_btnpeminjamanLayout.setHorizontalGroup(
            pn_btnpeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(btn_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnpeminjamanLayout.setVerticalGroup(
            pn_btnpeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnpeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnpeminjamanLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnpengadaan.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pengadaanbarang.png"))); // NOI18N

        btn_penggadaan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_penggadaan.setForeground(new java.awt.Color(102, 102, 102));
        btn_penggadaan.setText("Pengadaan Barang");
        btn_penggadaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_penggadaanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_penggadaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_penggadaanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnpengadaanLayout = new javax.swing.GroupLayout(pn_btnpengadaan);
        pn_btnpengadaan.setLayout(pn_btnpengadaanLayout);
        pn_btnpengadaanLayout.setHorizontalGroup(
            pn_btnpengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(btn_penggadaan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnpengadaanLayout.setVerticalGroup(
            pn_btnpengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnpengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnpengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnpengadaanLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_penggadaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        Laporan.setForeground(new java.awt.Color(153, 153, 153));
        Laporan.setText("LAPORAN");

        pn_btnLaporanTiket.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporantiket.png"))); // NOI18N

        btn_laporantiket.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_laporantiket.setForeground(new java.awt.Color(102, 102, 102));
        btn_laporantiket.setText("Laporan Tiket");
        btn_laporantiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporantiketMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_laporantiketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_laporantiketMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanTiketLayout = new javax.swing.GroupLayout(pn_btnLaporanTiket);
        pn_btnLaporanTiket.setLayout(pn_btnLaporanTiketLayout);
        pn_btnLaporanTiketLayout.setHorizontalGroup(
            pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(btn_laporantiket, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnLaporanTiketLayout.setVerticalGroup(
            pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanTiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanTiketLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_laporantiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnLaporanPeminjaman.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporanpeminjaman.png"))); // NOI18N

        btn_laporanpeminjaman.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_laporanpeminjaman.setForeground(new java.awt.Color(102, 102, 102));
        btn_laporanpeminjaman.setText("Laporan Peminjaman");
        btn_laporanpeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanpeminjamanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_laporanpeminjamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_laporanpeminjamanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanPeminjamanLayout = new javax.swing.GroupLayout(pn_btnLaporanPeminjaman);
        pn_btnLaporanPeminjaman.setLayout(pn_btnLaporanPeminjamanLayout);
        pn_btnLaporanPeminjamanLayout.setHorizontalGroup(
            pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(btn_laporanpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnLaporanPeminjamanLayout.setVerticalGroup(
            pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanPeminjamanLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_laporanpeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pn_btnLaporanPengadaan.setBackground(new java.awt.Color(255, 255, 255));

        pn_line9.setBackground(new java.awt.Color(255, 255, 255));
        pn_line9.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line9Layout = new javax.swing.GroupLayout(pn_line9);
        pn_line9.setLayout(pn_line9Layout);
        pn_line9Layout.setHorizontalGroup(
            pn_line9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line9Layout.setVerticalGroup(
            pn_line9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/laporanpengadaan.png"))); // NOI18N

        btn_laporanpengadaan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_laporanpengadaan.setForeground(new java.awt.Color(102, 102, 102));
        btn_laporanpengadaan.setText("Laporan Pengadaan");
        btn_laporanpengadaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanpengadaanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_laporanpengadaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_laporanpengadaanMouseExited(evt);
            }
        });

        jButtonCustom5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/switch (1).png"))); // NOI18N
        jButtonCustom5.setText("Logout");
        jButtonCustom5.setFillClick(new java.awt.Color(153, 0, 51));
        jButtonCustom5.setFillOriginal(new java.awt.Color(255, 0, 51));
        jButtonCustom5.setFillOver(new java.awt.Color(204, 0, 51));
        jButtonCustom5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustom5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLaporanPengadaanLayout = new javax.swing.GroupLayout(pn_btnLaporanPengadaan);
        pn_btnLaporanPengadaan.setLayout(pn_btnLaporanPengadaanLayout);
        pn_btnLaporanPengadaanLayout.setHorizontalGroup(
            pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCustom5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(btn_laporanpengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        pn_btnLaporanPengadaanLayout.setVerticalGroup(
            pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnLaporanPengadaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnLaporanPengadaanLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_laporanpengadaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jButtonCustom5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_btnPengguna.setBackground(new java.awt.Color(255, 255, 255));

        pn_line10.setBackground(new java.awt.Color(255, 255, 255));
        pn_line10.setPreferredSize(new java.awt.Dimension(5, 35));

        javax.swing.GroupLayout pn_line10Layout = new javax.swing.GroupLayout(pn_line10);
        pn_line10.setLayout(pn_line10Layout);
        pn_line10Layout.setHorizontalGroup(
            pn_line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_line10Layout.setVerticalGroup(
            pn_line10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N

        btnPengguna.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPengguna.setForeground(new java.awt.Color(102, 102, 102));
        btnPengguna.setText("Pengguna");
        btnPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_btnPenggunaLayout = new javax.swing.GroupLayout(pn_btnPengguna);
        pn_btnPengguna.setLayout(pn_btnPenggunaLayout);
        pn_btnPenggunaLayout.setHorizontalGroup(
            pn_btnPenggunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPenggunaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_line10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(btnPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pn_btnPenggunaLayout.setVerticalGroup(
            pn_btnPenggunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnPenggunaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_btnPenggunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_line10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(pn_btnPenggunaLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(Transaksi))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pn_btnkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btntiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btndashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(pn_kiriLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(pn_btnPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnpengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_btnPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pn_btnLaporanTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_btnLaporanPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_btnLaporanPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Laporan)))
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
                .addGap(5, 5, 5)
                .addComponent(pn_btnpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pn_btnPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_btnPerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Transaksi)
                .addGap(15, 15, 15)
                .addComponent(pn_btntiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_btnpengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Laporan)
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
            .addGap(0, 1167, Short.MAX_VALUE)
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
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pn_dasarLayout.setVerticalGroup(
            pn_dasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
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
        pn_utama.add(new MenuDashboard());
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

    private void btnPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseClicked
        pn_btnpegawai.setBackground(new Color(240, 240, 240 ));
        pn_line1.setBackground(new Color(0, 102, 153));
        
        pn_utama.removeAll();
        pn_utama.add(new MenuPegawai());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnPegawaiMouseClicked

    private void btnPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseEntered
        pn_btnpegawai.setBackground(new Color(250, 250, 250 ));
        pn_line1.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnPegawaiMouseEntered

    private void btnPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMouseExited
        pn_btnpegawai.setBackground(new Color(255, 255, 255 ));
        pn_line1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnPegawaiMouseExited

    private void btnTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiketMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiketMouseClicked

    private void btnTiketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiketMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiketMouseEntered

    private void btnTiketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiketMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTiketMouseExited

    private void btnKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategoriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriMouseClicked

    private void btnKategoriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategoriMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriMouseEntered

    private void btnKategoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKategoriMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKategoriMouseExited

    private void btnPerangkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerangkatMouseClicked
         pn_btnPerangkat.setBackground(new Color(240, 240, 240 ));
         pn_line2.setBackground(new Color(0, 102, 153));
         
        pn_utama.removeAll();
        pn_utama.add(new MenuPerangkat());
        pn_utama.repaint();
        pn_utama.revalidate();
    }//GEN-LAST:event_btnPerangkatMouseClicked

    private void btnPerangkatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerangkatMouseEntered
         pn_btnPerangkat.setBackground(new Color(250, 250, 250 ));
         pn_line2.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnPerangkatMouseEntered

    private void btnPerangkatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerangkatMouseExited
         pn_btnPerangkat.setBackground(new Color(255, 255, 255 ));
         pn_line2.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnPerangkatMouseExited

    private void btn_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_peminjamanMouseClicked

    private void btn_peminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_peminjamanMouseEntered

    private void btn_peminjamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_peminjamanMouseExited

    private void btn_penggadaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_penggadaanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_penggadaanMouseClicked

    private void btn_penggadaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_penggadaanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_penggadaanMouseEntered

    private void btn_penggadaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_penggadaanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_penggadaanMouseExited

    private void btn_laporantiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporantiketMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporantiketMouseClicked

    private void btn_laporantiketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporantiketMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporantiketMouseEntered

    private void btn_laporantiketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporantiketMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporantiketMouseExited

    private void btn_laporanpeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpeminjamanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpeminjamanMouseClicked

    private void btn_laporanpeminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpeminjamanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpeminjamanMouseEntered

    private void btn_laporanpeminjamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpeminjamanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpeminjamanMouseExited

    private void btn_laporanpengadaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpengadaanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpengadaanMouseClicked

    private void btn_laporanpengadaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpengadaanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpengadaanMouseEntered

    private void btn_laporanpengadaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanpengadaanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_laporanpengadaanMouseExited

    private void btnPenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseClicked
        // TODO add your handling code here:
        pn_btnPengguna.setBackground(new Color(240, 240, 240));
        pn_line10.setBackground(new Color(0, 102, 153));
        
        pn_utama.removeAll();
        MenuPengguna pengguna = new MenuPengguna();
//        pengguna.setConnection(conn); // Assuming MenuPengguna has a setConnection method
        pn_utama.add(pengguna);
        pn_utama.repaint();
    }//GEN-LAST:event_btnPenggunaMouseClicked

    private void btnPenggunaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseEntered
        // TODO add your handling code here:
           pn_btnPengguna.setBackground(new Color(250, 250, 250 ));
         pn_line10.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnPenggunaMouseEntered

    private void btnPenggunaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseExited
        // TODO add your handling code here:
             pn_btnPengguna.setBackground(new Color(255, 255, 255 ));
         pn_line10.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnPenggunaMouseExited

    private void pn_btndashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_btndashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_btndashboardMouseClicked

    private void pn_btnpegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_btnpegawaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_btnpegawaiMouseClicked

    private void jButtonCustom5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustom5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    
    // Membuka kembali LoginForm
    FormLogin login = new FormLogin();
    login.setVisible(true);
    }//GEN-LAST:event_jButtonCustom5ActionPerformed

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
                new MenuUtama("admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Laporan;
    private javax.swing.JLabel Transaksi;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnKategori;
    private javax.swing.JLabel btnPegawai;
    private javax.swing.JLabel btnPengguna;
    private javax.swing.JLabel btnPerangkat;
    private javax.swing.JLabel btnTiket;
    private javax.swing.JLabel btn_laporanpeminjaman;
    private javax.swing.JLabel btn_laporanpengadaan;
    private javax.swing.JLabel btn_laporantiket;
    private javax.swing.JLabel btn_peminjaman;
    private javax.swing.JLabel btn_penggadaan;
    private Castom.JButtonCustom jButtonCustom5;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel pn_btnLaporanPeminjaman;
    private javax.swing.JPanel pn_btnLaporanPengadaan;
    private javax.swing.JPanel pn_btnLaporanTiket;
    private javax.swing.JPanel pn_btnPengguna;
    private javax.swing.JPanel pn_btnPerangkat;
    private javax.swing.JPanel pn_btndashboard;
    private javax.swing.JPanel pn_btnkategori;
    private javax.swing.JPanel pn_btnpegawai;
    private javax.swing.JPanel pn_btnpeminjaman;
    private javax.swing.JPanel pn_btnpengadaan;
    private javax.swing.JPanel pn_btntiket;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kiri;
    private javax.swing.JPanel pn_line;
    private javax.swing.JPanel pn_line1;
    private javax.swing.JPanel pn_line10;
    private javax.swing.JPanel pn_line2;
    private javax.swing.JPanel pn_line3;
    private javax.swing.JPanel pn_line4;
    private javax.swing.JPanel pn_line5;
    private javax.swing.JPanel pn_line6;
    private javax.swing.JPanel pn_line7;
    private javax.swing.JPanel pn_line8;
    private javax.swing.JPanel pn_line9;
    private javax.swing.JPanel pn_utama;
    // End of variables declaration//GEN-END:variables
}
