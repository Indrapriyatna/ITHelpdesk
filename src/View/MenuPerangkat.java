/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import model.PegawaiModelDB;
import model.PerangkatModelDB;

/**
 *
 * @author Draaa
 */
public class MenuPerangkat extends javax.swing.JPanel {
  private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editUserId = -1;
    PerangkatModelDB model = new PerangkatModelDB();
    /**
     * Creates new form menuDashboard
     */
    public MenuPerangkat() {
        initComponents();
         tablePerangkat.setModel(model);
        tampilData();
        setKolomTabel();
        clearFields();
        filter();
        
    }
    
    public void filter() {
        sorter = new TableRowSorter<PerangkatModelDB>(model);
        tablePerangkat.setRowSorter(sorter);

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
                RowFilter<PerangkatModelDB, Object> rf = null;
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
        for (int i = 0; i < 8; i++) {
            column = tablePerangkat.getColumnModel().getColumn(i);
            switch (i) {
                case 0: column.setPreferredWidth(50); break;
                case 1: column.setPreferredWidth(100); break;
                case 2: column.setPreferredWidth(150); break;
                case 3: column.setPreferredWidth(100); break;
                case 4: column.setPreferredWidth(100); break;
                case 5: column.setPreferredWidth(80); break;
                case 6: column.setPreferredWidth(100); break;
                  case 7: column.setPreferredWidth(100); break;
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
            String sql = "SELECT * FROM perangkat";
            r = s.executeQuery(sql);

            int rowCount = 0;
            while (r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("device_id");
                o[1] = r.getString("nama_perangkat");
                o[2] = r.getString("device_type");
                o[3] = r.getString("serial_number");
                o[4] = r.getString("merk");
                o[5] = r.getString("model");
                o[6] = r.getString("tgl_pembelian");
                o[7] = r.getString("status");
                model.addRow(Arrays.asList(o));
                rowCount++;
            }
            if (rowCount == 0) {
                System.out.println("Tabel perangkat kosong atau tidak ada data yang ditemukan.");
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
        txt_nama.setText("");
        txt_serial.setText("");
        txt_merk.setText("");
        txt_model.setText("");
        txt_status.setText("");
        tanggal.setDate(null);
     cboTipe.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePerangkat = new Castom.JTableCastom();
        jLabel4 = new javax.swing.JLabel();
        btnTambah = new Castom.JButtonCustom();
        btnHapus = new Castom.JButtonCustom();
        Searching = new Castom.JtextCustom();
        btnEdit = new Castom.JButtonCustom();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSimpan = new Castom.JButtonCustom();
        btnBatal = new Castom.JButtonCustom();
        txt_nama = new Castom.JtextCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_merk = new Castom.JtextCustom();
        jLabel11 = new javax.swing.JLabel();
        txt_model = new Castom.JtextCustom();
        jLabel12 = new javax.swing.JLabel();
        txt_status = new Castom.JtextCustom();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_serial = new Castom.JtextCustom();
        jLabel14 = new javax.swing.JLabel();
        cboTipe = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Perangkat");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Perangkat");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        tablePerangkat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane2.setViewportView(tablePerangkat);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add .png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trash (1).png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.setFillClick(new java.awt.Color(153, 0, 51));
        btnHapus.setFillOriginal(new java.awt.Color(255, 0, 51));
        btnHapus.setFillOver(new java.awt.Color(204, 0, 51));

        Searching.setText("Search");
        Searching.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit (2).png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setFillClick(new java.awt.Color(0, 153, 51));
        btnEdit.setFillOriginal(new java.awt.Color(0, 255, 51));
        btnEdit.setFillOver(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(Searching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Perangkat");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Perangkat");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save1.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.setFillOriginal(new java.awt.Color(0, 204, 255));
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

        txt_nama.setText("Nama Perangkat");
        txt_nama.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nama Perangkat");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Merk");

        txt_merk.setText("Merk");
        txt_merk.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Model");

        txt_model.setText("Model");
        txt_model.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Tanggal pembelian");

        txt_status.setText("Status Perangkat");
        txt_status.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Status Perangkat");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));

        txt_serial.setText("Nomor SN");
        txt_serial.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Jenis Perangkat");

        cboTipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hardware", "accessories", "Network", "Other" }));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Nomor SN");

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(txt_serial, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_merk, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_model, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
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
                        .addComponent(txt_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(txt_serial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_merk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(txt_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.revalidate();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String nama = txt_nama.getText();
        String serial = txt_serial.getText();
        String tipe = cboTipe.getSelectedItem().toString();
        String merk = txt_merk.getText();
        String model_perangkat = txt_model.getText();
        String status = txt_status.getText();
        java.util.Date tanggal_beli = tanggal.getDate();

        // Validasi input
        if (nama.isEmpty() || serial.isEmpty() || tipe.isEmpty() || merk.isEmpty() || model_perangkat.isEmpty() || tanggal_beli == null || status.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Semua kolom harus diisi dengan data yang valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
                sql = "UPDATE perangkat SET nama_perangkat = ?, device_type = ?, serial_number = ?, merk = ?, model = ?, tgl_pembelian = ?, status = ? WHERE id = ?";
                p = c.prepareStatement(sql);
                p.setString(1, nama);
                p.setString(2, tipe);
                p.setString(3, serial);
                p.setString(4, merk);
                p.setString(5, model_perangkat);
                p.setDate(6, new java.sql.Date(tanggal_beli.getTime()));
                p.setString(7, status);
                p.setInt(8, editUserId);
                int rowsUpdated = p.executeUpdate();
                if (rowsUpdated > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data pegawai berhasil diperbarui!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Gagal memperbarui data pegawai!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                sql = "INSERT INTO perangkat (nama_perangkat, device_type, serial_number, merk, model, tgl_pembelian, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);
                p.setString(1, nama);
                p.setString(2, tipe);
                p.setString(3, serial);
                p.setString(4, merk);
                p.setString(5, model_perangkat);
                p.setDate(6, new java.sql.Date(tanggal_beli.getTime()));
                p.setString(7, status);
                int rowsInserted = p.executeUpdate();
                if (rowsInserted > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Data perangkat berhasil ditambahkan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Gagal menambahkan data perangkat!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            tampilData();
            clearFields();
            isEditMode = false;
            editUserId = -1;
            jLabel5.setText("Tambah Data Perangkat");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private Castom.JButtonCustom btnBatal;
    private Castom.JButtonCustom btnEdit;
    private Castom.JButtonCustom btnHapus;
    private Castom.JButtonCustom btnSimpan;
    private Castom.JButtonCustom btnTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private Castom.JTableCastom tablePerangkat;
    private com.toedter.calendar.JDateChooser tanggal;
    private Castom.JtextCustom txt_merk;
    private Castom.JtextCustom txt_model;
    private Castom.JtextCustom txt_nama;
    private Castom.JtextCustom txt_serial;
    private Castom.JtextCustom txt_status;
    // End of variables declaration//GEN-END:variables
}
