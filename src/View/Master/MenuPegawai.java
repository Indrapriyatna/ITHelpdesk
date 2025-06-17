/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Master;

import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.Master.PegawaiModelDB;
/**
 *
 * @author Draaa
 */
public final class MenuPegawai extends javax.swing.JPanel {
    private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editUserId = -1;
    PegawaiModelDB model = new PegawaiModelDB();
  
    /**
     * Creates new form menuDashboard
     */
    public MenuPegawai() {
        initComponents();
       tablePegawai.setModel(model);
        tampilData();
        setKolomTabel();
        clearFields();
        filter();
        
    }
    
 public void filter() {
        sorter = new TableRowSorter<PegawaiModelDB>(model);
        tablePegawai.setRowSorter(sorter);

        // Tambahkan DocumentListener untuk filtering real-time
        Searching.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter();
            }

            private void newFilter() {
                RowFilter<PegawaiModelDB, Object> rf = null;
                String searchText = Searching.getText();

                // Jangan filter jika teks adalah placeholder atau kosong
                if (searchText.equals("Search") || searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                    return;
                }

                // Tambahkan pengecekan apakah model kosong
                if (model.getRowCount() == 0) {
                    sorter.setRowFilter(null); // Jangan terapkan filter jika tidak ada data
                    return;
                }

                try {
                    // Filter pada kolom NIP (1), Nama (2), dan Jabatan (3)
                    rf = RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(searchText), 1, 2, 3);
                } catch (java.util.regex.PatternSyntaxException e) {
                    System.err.println("Error pada pola regex: " + e.getMessage());
                    return;
                }
                sorter.setRowFilter(rf);
            }
        });

        // Atur placeholder untuk Searching
        Searching.setText("Search");
        Searching.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Searching.getText().equals("Search")) {
                    Searching.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Searching.getText().isEmpty()) {
                    Searching.setText("Search");
                }
            }
        });
    }

    public void setKolomTabel() {
        // Mengatur lebar kolom untuk masing-masing kolom
        TableColumn column = null;
        for (int i = 0; i < 7; i++) {
            column = tablePegawai.getColumnModel().getColumn(i);
            switch (i) {
                case 0: column.setPreferredWidth(50); break;
                case 1: column.setPreferredWidth(100); break;
                case 2: column.setPreferredWidth(150); break;
                case 3: column.setPreferredWidth(100); break;
                case 4: column.setPreferredWidth(100); break;
                case 5: column.setPreferredWidth(80); break;
                case 6: column.setPreferredWidth(100); break;
            }
        }
    }

    private void tampilData() {
        model.removeAllRows();
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = Database.getConnection();
            if (c == null) {
                System.err.println("Koneksi database gagal! Periksa konfigurasi database.");
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal terhubung ke database!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            s = c.createStatement();
            String sql = "SELECT * FROM pegawai";
            r = s.executeQuery(sql);

            int rowCount = 0;
            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("id");
                o[1] = r.getString("nip");
                o[2] = r.getString("nama_pegawai");
                o[3] = r.getString("jabatan");
                o[4] = r.getString("no_telp");
                o[5] = r.getString("jenis_kelamin");
                o[6] = r.getString("join_date");
                model.addRow(Arrays.asList(o));
                rowCount++;
            }
            if (rowCount == 0) {
                System.out.println("Tabel pegawai kosong atau tidak ada data yang ditemukan.");
            } else {
                System.out.println("Berhasil memuat " + rowCount + " baris data dari tabel pegawai.");
            }
        } catch (SQLException e) {
            System.err.println("Terjadi error menampilkan data di tabel: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (r != null) r.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }

    private void clearFields() { // Mengosongkan isian pada form
        txt_nip.setText("");
        txt_nama.setText("");
        txt_jabatan.setText("");
        txt_telepon.setText("");
        date_join.setDate(null);
        rb_Laki.setSelected(false);
        rb_perempuan.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_Kelamin = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTambah = new Castom.JButtonCustom();
        btnEdit = new Castom.JButtonCustom();
        Searching = new Castom.JtextCustom();
        btnHapus = new Castom.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new Castom.JTable_Custom();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSimpan = new Castom.JButtonCustom();
        btnBatal = new Castom.JButtonCustom();
        txt_nip = new Castom.JtextCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_jabatan = new Castom.JtextCustom();
        jLabel12 = new javax.swing.JLabel();
        txt_telepon = new Castom.JtextCustom();
        jLabel13 = new javax.swing.JLabel();
        rb_Laki = new javax.swing.JRadioButton();
        rb_perempuan = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_nama = new Castom.JtextCustom();
        date_join = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setPreferredSize(new java.awt.Dimension(1784, 889));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setPreferredSize(new java.awt.Dimension(1784, 889));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Pegawai");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Pegawai");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add .png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit (2).png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setFillClick(new java.awt.Color(0, 153, 51));
        btnEdit.setFillOriginal(new java.awt.Color(0, 255, 51));
        btnEdit.setFillOver(new java.awt.Color(0, 153, 0));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        Searching.setText("Search");
        Searching.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        Searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchingActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trash (1).png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setFillClick(new java.awt.Color(153, 0, 51));
        btnHapus.setFillOriginal(new java.awt.Color(255, 0, 51));
        btnHapus.setFillOver(new java.awt.Color(204, 0, 51));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePegawai);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1137, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218)
                                .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));
        panelAdd.setPreferredSize(new java.awt.Dimension(1784, 889));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Pegawai");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Pegawai");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save1.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.setFillOriginal(new java.awt.Color(0, 153, 255));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close1.png"))); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.setFillClick(new java.awt.Color(153, 0, 51));
        btnBatal.setFillOriginal(new java.awt.Color(255, 102, 0));
        btnBatal.setFillOver(new java.awt.Color(204, 102, 0));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txt_nip.setToolTipText("");
        txt_nip.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("NIP");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Jabatan");

        txt_jabatan.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jabatanActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Telepon");

        txt_telepon.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Jenis Kelamin");

        rb_Laki.setBackground(new java.awt.Color(255, 255, 255));
        rb_Kelamin.add(rb_Laki);
        rb_Laki.setText("Laki-Laki");

        rb_perempuan.setBackground(new java.awt.Color(255, 255, 255));
        rb_Kelamin.add(rb_perempuan);
        rb_perempuan.setText("Perempuan");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Tanggal Bergabung");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Nama");

        txt_nama.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(600, 600, 600)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_jabatan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(rb_Laki)
                            .addComponent(jLabel15)
                            .addComponent(date_join, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(rb_perempuan)))))
                .addGap(20, 20, 20))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(txt_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_Laki)
                    .addComponent(rb_perempuan))
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_join, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        clearFields();
        isEditMode = false;
        editUserId = -1;
        jLabel5.setText("Tambah Data Pegawai");
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void SearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchingActionPerformed

    private void txt_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jabatanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
  String nip = txt_nip.getText();
        String nama = txt_nama.getText();
        String jabatan = txt_jabatan.getText();
        String telepon = txt_telepon.getText();
        String gender = rb_Laki.isSelected() ? "Laki-Laki" : (rb_perempuan.isSelected() ? "Perempuan" : "");
        java.util.Date joinDate = date_join.getDate();

        // Validasi input
        if (nip.isEmpty() || nama.isEmpty() || jabatan.isEmpty() || telepon.isEmpty() || joinDate == null || gender.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Semua kolom harus diisi dengan data yang valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi format nomor telepon (hanya angka, minimal 10 digit)
        if (!telepon.matches("^[0-9]{10,13}$")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nomor telepon harus berupa angka dan memiliki 10-13 digit!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Database.getConnection();
            if (c == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql;
            if (isEditMode) {
                sql = "UPDATE pegawai SET nip = ?, nama_pegawai = ?, jabatan = ?, no_telp = ?, jenis_kelamin = ?, join_date = ? WHERE id = ?";
                p = c.prepareStatement(sql);
                p.setString(1, nip);
                p.setString(2, nama);
                p.setString(3, jabatan);
                p.setString(4, telepon);
                p.setString(5, gender);
                p.setDate(6, new java.sql.Date(joinDate.getTime()));
                p.setInt(7, editUserId);
                int rowsUpdated = p.executeUpdate();
                if (rowsUpdated > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data pegawai berhasil diperbarui!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Gagal memperbarui data pegawai!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                sql = "INSERT INTO pegawai (nip, nama_pegawai, jabatan, no_telp, jenis_kelamin, join_date) VALUES (?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, nip);
                p.setString(2, nama);
                p.setString(3, jabatan);
                p.setString(4, telepon);
                p.setString(5, gender);
                p.setDate(6, new java.sql.Date(joinDate.getTime()));
                int rowsInserted = p.executeUpdate();
                if (rowsInserted > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data pegawai berhasil ditambahkan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Gagal menambahkan data pegawai!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            tampilData();
            clearFields();
            isEditMode = false;
            editUserId = -1;
            jLabel5.setText("Tambah Data Pegawai");
            panelMain.removeAll();
            panelMain.add(panelView);
            panelMain.revalidate();
            panelMain.repaint();
        } catch (SQLException e) {
            System.err.println("Error saat " + (isEditMode ? "memperbarui" : "menambah") + " data ke database: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal " + (isEditMode ? "memperbarui" : "menambah") + " data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (p != null) p.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      int index = tablePegawai.getSelectedRow();

        // Jika tidak ada baris terseleksi, tampilkan peringatan
        if (index == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        editUserId = Integer.parseInt(model.getValueAt(index, 0).toString()); // id
        String nip = model.getValueAt(index, 1).toString();
        String nama = model.getValueAt(index, 2).toString();
        String jabatan = model.getValueAt(index, 3).toString();
        String telepon = model.getValueAt(index, 4).toString();
        String jenisKelamin = model.getValueAt(index, 5).toString();
        String joinDate = model.getValueAt(index, 6).toString();

        // Isi field input dengan data
        txt_nip.setText(nip);
        txt_nama.setText(nama);
        txt_jabatan.setText(jabatan);
        txt_telepon.setText(telepon);
        if ("Laki-Laki".equals(jenisKelamin)) {
            rb_Laki.setSelected(true);
        } else if ("Perempuan".equals(jenisKelamin)) {
            rb_perempuan.setSelected(true);
        }
        try {
            date_join.setDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(joinDate));
        } catch (java.text.ParseException e) {
            date_join.setDate(null);
        }

        // Ubah judul panel dan beralih ke panelAdd
        isEditMode = true;
        jLabel5.setText("Edit Data Pegawai");
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int index = tablePegawai.getSelectedRow();

        // Jika tidak ada baris terseleksi, tampilkan peringatan
        if (index == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Konfirmasi penghapusan
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        // Ambil id dari baris yang dipilih
        int id;
        try {
            id = Integer.parseInt(model.getValueAt(index, 0).toString());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID pegawai tidak valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hapus data dari database
        try {
            Connection c = Database.getConnection();
            if (c == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "DELETE FROM pegawai WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            int rowsDeleted = p.executeUpdate();
            p.close();
            c.close();

            if (rowsDeleted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data pegawai berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tampilData(); // Muat ulang data dari database
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data pegawai!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error menghapus data dari database: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private Castom.JButtonCustom btnBatal;
    private Castom.JButtonCustom btnEdit;
    private Castom.JButtonCustom btnHapus;
    private Castom.JButtonCustom btnSimpan;
    private Castom.JButtonCustom btnTambah;
    private com.toedter.calendar.JDateChooser date_join;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.ButtonGroup rb_Kelamin;
    private javax.swing.JRadioButton rb_Laki;
    private javax.swing.JRadioButton rb_perempuan;
    private Castom.JTable_Custom tablePegawai;
    private Castom.JtextCustom txt_jabatan;
    private Castom.JtextCustom txt_nama;
    private Castom.JtextCustom txt_nip;
    private Castom.JtextCustom txt_telepon;
    // End of variables declaration//GEN-END:variables
}
