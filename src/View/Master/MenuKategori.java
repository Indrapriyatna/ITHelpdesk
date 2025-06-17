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
import java.sql.Timestamp;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.Master.KategoriModelDB;
/**
 *
 * @author Draaa
 */
public final class MenuKategori extends javax.swing.JPanel {
    private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editCategoryId = -1;
    KategoriModelDB model = new KategoriModelDB();
  
    /**
     * Creates new form menuDashboard
     */
    public MenuKategori() {
        initComponents();
       tableKategori.setModel(model);
        tampilData();
        setKolomTabel();
        clearFields();
        filter();
        
    }
    
 public void filter() {
        sorter = new TableRowSorter<KategoriModelDB>(model);
        tableKategori.setRowSorter(sorter);

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
                RowFilter<KategoriModelDB, Object> rf = null;
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
                    rf = RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(searchText), 0, 1, 2, 3, 4);
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
        for (int i = 0; i < 6; i++) {
            column = tableKategori.getColumnModel().getColumn(i);
            switch (i) {
                case 0: column.setPreferredWidth(50); break;
                case 1: column.setPreferredWidth(100); break;
                case 2: column.setPreferredWidth(150); break;
                case 3: column.setPreferredWidth(100); break;
                case 4: column.setPreferredWidth(100); break;
                case 5: column.setPreferredWidth(80); break;
                           }
        }
    }

    private void tampilData() {
  model.removeAllRows();
    try (Connection c = Database.getConnection();
         Statement s = c.createStatement();
         ResultSet r = s.executeQuery("SELECT * FROM kategori_masalah")) {
        while (r.next()) {
            Object[] o = new Object[6];
            o[0] = r.getString("id_kategori");
            o[1] = r.getString("nama_kategori");
            o[2] = r.getString("deskripsi");
            o[3] = r.getString("prioritas");
            o[4] = r.getString("sla_jam");
            o[5] = r.getString("created_at");
            model.addRow(Arrays.asList(o));
        }
    } catch (SQLException e) {
        System.err.println("Error loading data: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }

    private void clearFields() { // Mengosongkan isian pada form
    txt_sla.setText("");
    txt_deskripsi.setText("");
    cboKategori.setSelectedIndex(0);
    cboPrioritas.setSelectedIndex(0);
                          }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKategori = new Castom.JTable_Custom();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSimpan = new Castom.JButtonCustom();
        btnBatal = new Castom.JButtonCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_deskripsi = new Castom.JtextCustom();
        jLabel11 = new javax.swing.JLabel();
        cboPrioritas = new javax.swing.JComboBox<>();
        cboKategori = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_sla = new Castom.JtextCustom();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Katgegori Masalah");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Kategori");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kategori.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kategori.png"))); // NOI18N

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

        tableKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableKategori);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(27, 27, 27)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Kategori Masalah");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Kategori");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kategori.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kategori.png"))); // NOI18N

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

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Kategori");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Deskripsi");

        txt_deskripsi.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_deskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_deskripsiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Prioritas");

        cboPrioritas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi", "Kritis" }));

        cboKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perangkat Keras", "Perangkat Lunak", "Jaringan", " " }));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("SLA");

        txt_sla.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_sla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_slaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
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
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_deskripsi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_sla, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        clearFields();
        isEditMode = false;
        editCategoryId = -1;
        jLabel5.setText("Tambah Data Kategori");
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

    private void txt_deskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deskripsiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
String deskripsi = txt_deskripsi.getText().trim();
    String kategori = cboKategori.getSelectedItem().toString();
    String prioritas = cboPrioritas.getSelectedItem().toString();
    String sla = txt_sla.getText().trim();

    // Validate inputs
    if (kategori.equals(" ") || deskripsi.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Nama kategori dan deskripsi harus diisi!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!sla.matches("\\d+")) { // Ensure sla is a positive number as string
        javax.swing.JOptionPane.showMessageDialog(this, "SLA harus berupa angka positif!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection c = Database.getConnection()) {
        if (c == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql;
        PreparedStatement p;
        if (isEditMode) {
            sql = "UPDATE kategori_masalah SET nama_kategori = ?, deskripsi = ?, prioritas = ?, sla_jam = ?, created_at = ? WHERE id_kategori = ?";
            p = c.prepareStatement(sql);
            p.setString(1, kategori);
            p.setString(2, deskripsi);
            p.setString(3, prioritas);
            p.setString(4, sla);
            p.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            p.setInt(6, editCategoryId);
            int rowsUpdated = p.executeUpdate();
            if (rowsUpdated > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data kategori berhasil diperbarui!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal memperbarui data kategori!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            sql = "INSERT INTO kategori_masalah (nama_kategori, deskripsi, prioritas, sla_jam, created_at) VALUES (?, ?, ?, ?, ?)";
            p = c.prepareStatement(sql);
            p.setString(1, kategori);
            p.setString(2, deskripsi);
            p.setString(3, prioritas);
            p.setString(4, sla);
            p.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            int rowsInserted = p.executeUpdate();
            if (rowsInserted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data kategori berhasil ditambahkan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menambahkan data kategori!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        tampilData();
        clearFields();
        isEditMode = false;
        editCategoryId = -1;
        jLabel5.setText("Tambah Data Kategori");
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.revalidate();
        panelMain.repaint();
    } catch (SQLException e) {
        System.err.println("Error saat " + (isEditMode ? "memperbarui" : "menambah") + " data: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal " + (isEditMode ? "memperbarui" : "menambah") + " data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
      int index = tableKategori.getSelectedRow();

        // Jika tidak ada baris terseleksi, tampilkan peringatan
        if (index == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        editCategoryId = Integer.parseInt(model.getValueAt(index, 0).toString()); // id
        String kategori = model.getValueAt(index, 1).toString();
        String deskripsi = model.getValueAt(index, 2).toString();
        String prioritas = model.getValueAt(index, 3).toString();
        String sla = model.getValueAt(index, 4).toString();


        // Isi field input dengan data
            cboKategori.setSelectedItem(kategori);
            cboPrioritas.setSelectedItem(prioritas);
        txt_deskripsi.setText(deskripsi);
        txt_sla.setText(sla);
        
        

        // Ubah judul panel dan beralih ke panelAdd
        isEditMode = true;
        jLabel5.setText("Edit Data Kategori");
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int index = tableKategori.getSelectedRow();

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
            javax.swing.JOptionPane.showMessageDialog(this, "ID kategori tidak valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hapus data dari database
        try {
            Connection c = Database.getConnection();
            if (c == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "DELETE FROM kategori_masalah WHERE id_kategori = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            int rowsDeleted = p.executeUpdate();
            p.close();
            c.close();

            if (rowsDeleted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data kategori berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tampilData(); // Muat ulang data dari database
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data kategori!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error menghapus data dari database: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txt_slaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_slaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_slaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private Castom.JButtonCustom btnBatal;
    private Castom.JButtonCustom btnEdit;
    private Castom.JButtonCustom btnHapus;
    private Castom.JButtonCustom btnSimpan;
    private Castom.JButtonCustom btnTambah;
    private javax.swing.JComboBox<String> cboKategori;
    private javax.swing.JComboBox<String> cboPrioritas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private Castom.JTable_Custom tableKategori;
    private Castom.JtextCustom txt_deskripsi;
    private Castom.JtextCustom txt_sla;
    // End of variables declaration//GEN-END:variables
}
