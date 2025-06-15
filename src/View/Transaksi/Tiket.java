package View.Transaksi;

import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.TiketModelDB;

public class Tiket extends javax.swing.JPanel {
    private TableRowSorter<TiketModelDB> sorter;
    private boolean isEditMode = false;
    private int editTicketId = -1;
    private TiketModelDB model = new TiketModelDB();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Tiket() {
        initComponents();
        tableTiket.setModel(model);
        tampilData();
        setKolomTabel();
        clearFields();
        filter();
        populateTiketBaruCombo();
        populateUserCombo();
    }

    private void populateTiketBaruCombo() {
        cboTiket.removeAllItems();
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("SELECT id_kategori, nama_kategori FROM kategori_masalah")) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                cboTiket.addItem(new KategoriItem(r.getInt("id_kategori"), r.getString("nama_kategori")));
            }
        } catch (SQLException e) {
            System.err.println("Error loading categories: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat kategori: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        cboTiket.setEditable(true);
        if (cboTiket.getEditor() != null && cboTiket.getEditor().getEditorComponent() != null) {
            cboTiket.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    String text = cboTiket.getEditor().getItem().toString().toLowerCase();
                    cboTiket.removeAllItems();
                    try (Connection c = Database.getConnection();
                         PreparedStatement p = c.prepareStatement("SELECT id_kategori, nama_kategori FROM kategori_masalah WHERE nama_kategori LIKE ?")) {
                        p.setString(1, "%" + text + "%");
                        ResultSet r = p.executeQuery();
                        while (r.next()) {
                            cboTiket.addItem(new KategoriItem(r.getInt("id_kategori"), r.getString("nama_kategori")));
                        }
                    } catch (SQLException e) {
                        System.err.println("Error filtering categories: " + e.getMessage());
                    }
                }
            });
        }
        cboTiket.addActionListener(evt -> updateUrgensiAndSla());
    }

    private void populateUserCombo() {
        cboUser.removeAllItems();
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("SELECT username FROM users")) {
            ResultSet r = p.executeQuery();
            while (r.next()) {
                cboUser.addItem(r.getString("username"));
            }
        } catch (SQLException e) {
            System.err.println("Error loading users: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat pengguna: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUrgensiAndSla() {
        KategoriItem selected = (KategoriItem) cboTiket.getSelectedItem();
        if (selected == null) return;
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("SELECT prioritas, sla_jam FROM kategori_masalah WHERE id_kategori = ?")) {
            p.setInt(1, selected.getId());
            ResultSet r = p.executeQuery();
            if (r.next()) {
                cboUrgen.setSelectedItem(r.getString("prioritas"));
                calculatePerkiraanSelesai();
            }
        } catch (SQLException e) {
            System.err.println("Error updating urgensi: " + e.getMessage());
        }
    }

    private void calculatePerkiraanSelesai() {
        KategoriItem selected = (KategoriItem) cboTiket.getSelectedItem();
        if (selected == null) return;
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("SELECT sla_jam FROM kategori_masalah WHERE id_kategori = ?")) {
            p.setInt(1, selected.getId());
            ResultSet r = p.executeQuery();
            if (r.next()) {
                int slaHours = Integer.parseInt(r.getString("sla_jam"));
                java.util.Date created = new java.util.Date();
                long millis = created.getTime() + (slaHours * 60 * 60 * 1000L);
                Tempo.setDate(new java.util.Date(millis));
            }
        } catch (SQLException | NumberFormatException e) {
            System.err.println("Error calculating perkiraan selesai: " + e.getMessage());
        }
    }

    private void filter() {
        sorter = new TableRowSorter<>(model);
        tableTiket.setRowSorter(sorter);
        Searching.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { newFilter(); }
            @Override
            public void removeUpdate(DocumentEvent e) { newFilter(); }
            @Override
            public void changedUpdate(DocumentEvent e) { newFilter(); }

            private void newFilter() {
                String searchText = Searching.getText().trim();
                if (searchText.equals("Search") || searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                    return;
                }
                try {
                    RowFilter<TiketModelDB, Object> rf = RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(searchText), 1, 2, 3, 7);
                    sorter.setRowFilter(rf);
                } catch (java.util.regex.PatternSyntaxException e) {
                    System.err.println("Regex error: " + e.getMessage());
                }
            }
        });
        Searching.setText("Search");
        Searching.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Searching.getText().equals("Search")) Searching.setText("");
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Searching.getText().isEmpty()) Searching.setText("Search");
            }
        });
    }

    private void setKolomTabel() {
        TableColumn column;
        for (int i = 0; i < 8; i++) {
            column = tableTiket.getColumnModel().getColumn(i);
            switch (i) {
                case 0: column.setPreferredWidth(50); break;  // ID
                case 1: column.setPreferredWidth(150); break; // Subjek
                case 2: column.setPreferredWidth(100); break; // Tiket Baru
                case 3: column.setPreferredWidth(100); break; // Urgensi
                case 4: column.setPreferredWidth(100); break; // Status
                case 5: column.setPreferredWidth(150); break; // Perkiraan Selesai
                case 6: column.setPreferredWidth(150); break; // Created At
                case 7: column.setPreferredWidth(100); break; // User
            }
        }
    }

    private void tampilData() {
        model.removeAllRows();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Database.getConnection();
            if (c == null) {
                System.err.println("Koneksi database gagal! Periksa konfigurasi database.");
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal terhubung ke database!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            String sql = "SELECT t.id_tiket, t.subjek, k.nama_kategori, t.prioritas, t.status, t.perkiraan_selesai, t.created_at, t.user " +
                         "FROM tiket t JOIN kategori_masalah k ON t.id_kategori = k.id_kategori";
            p = c.prepareStatement(sql);
            r = p.executeQuery();

            int rowCount = 0;
            while (r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getInt("id_tiket");
                o[1] = r.getString("subjek") != null ? r.getString("subjek") : "";
                o[2] = r.getString("nama_kategori");
                o[3] = r.getString("prioritas");
                o[4] = r.getString("status");
                o[5] = r.getString("perkiraan_selesai") != null ? r.getString("perkiraan_selesai") : "";
                o[6] = r.getString("created_at");
                o[7] = r.getString("user");
                model.addRow(Arrays.asList(o));
                rowCount++;
            }
            if (rowCount == 0) {
                System.out.println("Tabel tiket kosong atau tidak ada data yang ditemukan.");
            } else {
                System.out.println("Berhasil memuat " + rowCount + " baris data dari tabel tiket.");
            }
        } catch (SQLException e) {
            System.err.println("Terjadi error menampilkan data di tabel: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (r != null) r.close();
                if (p != null) p.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }

    private void clearFields() {
        txtSubjek.setText("");
        txtDeskripsi.setText("");
        cboTiket.setSelectedIndex(-1);
        cboUrgen.setSelectedIndex(0);
        cboUser.setSelectedIndex(0);
        Tempo.setDate(null);
        txtCatatan.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTiket = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboUrgen = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Tempo = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_catatan = new javax.swing.JTextArea();
        btnBuat = new Castom.JButtonCustom();
        btnEdit = new Castom.JButtonCustom();
        btnHapus = new Castom.JButtonCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTiket = new Castom.JTableCastom1();
        Searching = new Castom.JtextCustom();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tiket");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tiket Baru");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Urgensi");

        cboUrgen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi", "Kritis" }));
        cboUrgen.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Jatuh Tempo");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Catatan");

        txt_catatan.setColumns(20);
        txt_catatan.setRows(5);
        jScrollPane1.setViewportView(txt_catatan);

        btnBuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add .png"))); // NOI18N
        btnBuat.setText("Buat Tiket");
        btnBuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatActionPerformed(evt);
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

        tableTiket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableTiket);

        Searching.setText("Search");
        Searching.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        Searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelViewLayout.createSequentialGroup()
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuat, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1))
                        .addComponent(cboTiket, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboUrgen, javax.swing.GroupLayout.Alignment.LEADING, 0, 961, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tempo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(44, Short.MAX_VALUE))
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
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboUrgen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panelMain.add(panelView, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatActionPerformed
         String tiketBaru = ((KategoriItem) cboTiket.getSelectedItem()).toString();
        String urgensi = cboUrgen.getSelectedItem().toString();
        java.util.Date jatuhTempo = Tempo.getDate();
        String catatan = txt_catatan.getText().trim();
        if (tiketBaru.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Tiket Baru harus diisi!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection c = Database.getConnection()) {
            String sql = isEditMode ? "UPDATE tiket SET id_kategori = (SELECT id_kategori FROM kategori_masalah WHERE nama_kategori = ?), prioritas = ?, jatuh_tempo = ?, catatan = ? WHERE id_tiket = ?"
                                   : "INSERT INTO tiket (id_kategori, prioritas, jatuh_tempo, catatan, created_at) VALUES ((SELECT id_kategori FROM kategori_masalah WHERE nama_kategori = ?), ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, tiketBaru);
            p.setString(2, urgensi);
            p.setTimestamp(3, jatuhTempo != null ? new Timestamp(jatuhTempo.getTime()) : null);
            p.setString(4, catatan);
            if (isEditMode) p.setInt(5, editTicketId);
            else p.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            int rowsAffected = p.executeUpdate();
            if (rowsAffected > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Tiket " + (isEditMode ? "diperbarui" : "ditambahkan") + " berhasil!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tampilData();
                clearFields();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal " + (isEditMode ? "memperbarui" : "menambahkan") + " tiket!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error saving ticket: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menyimpan tiket: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuatActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
            int index = tableTiket.getSelectedRow();
        if (index == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih tiket yang akan diedit!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        editTicketId = Integer.parseInt(model.getValueAt(index, 0).toString());
        String tiketBaru = model.getValueAt(index, 2).toString();
        cboUrgen.setSelectedItem(model.getValueAt(index, 3).toString());
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("SELECT catatan, jatuh_tempo FROM tiket WHERE id_tiket = ?")) {
            p.setInt(1, editTicketId);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                txt_catatan.setText(r.getString("catatan"));
                if (r.getTimestamp("jatuh_tempo") != null) {
                    Tempo.setDate(new java.util.Date(r.getTimestamp("jatuh_tempo").getTime()));
                }
                for (int i = 0; i < cboTiket.getItemCount(); i++) {
                    if (cboTiket.getItemAt(i).toString().equals(tiketBaru)) {
                        cboTiket.setSelectedIndex(i);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error loading ticket details: " + e.getMessage());
        }
        isEditMode = true;
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
       int index = tableTiket.getSelectedRow();
        if (index == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih tiket yang akan dihapus!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus tiket ini?", "Konfirmasi Hapus", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm != javax.swing.JOptionPane.YES_OPTION) return;
        int id = Integer.parseInt(model.getValueAt(index, 0).toString());
        try (Connection c = Database.getConnection();
             PreparedStatement p = c.prepareStatement("DELETE FROM tiket WHERE id_tiket = ?")) {
            p.setInt(1, id);
            int rowsDeleted = p.executeUpdate();
            if (rowsDeleted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Tiket berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tampilData();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus tiket!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting ticket: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus tiket: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed
    
    
    
    private void SearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchingActionPerformed

    }//GEN-LAST:event_SearchingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private com.toedter.calendar.JDateChooser Tempo;
    private Castom.JButtonCustom btnBuat;
    private Castom.JButtonCustom btnEdit;
    private Castom.JButtonCustom btnHapus;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTiket;
    private javax.swing.JComboBox<String> cboUrgen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private Castom.JTableCastom1 tableTiket;
    private javax.swing.JTextArea txt_catatan;
    // End of variables declaration//GEN-END:variables
}
