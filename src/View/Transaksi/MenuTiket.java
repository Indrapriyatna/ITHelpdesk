
package View.Transaksi;

import config.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.Master.PerangkatModelDB;

/**
 *
 * @author Draaa
 */
public class MenuTiket extends javax.swing.JPanel {
  private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editDeviceId = -1;
    PerangkatModelDB model = new PerangkatModelDB();
    /**
     * Creates new form menuDashboard
     */
    public MenuTiket() {
        initComponents();
         tableTiket.setModel(model);
        tampilData();
        setKolomTabel();
        filter();
        
    }
    
    private void simpanTiket() {
    String nip = txtIdPegawai.getText();
    String idKategori = txtIdKategori.getText();
    String deskripsi = txtKategori.getText();
    String status = cboStatus.getSelectedItem().toString();

    try (Connection c = Database.getConnection();
         PreparedStatement ps = c.prepareStatement("INSERT INTO tikett (nip, id_kategori, deskripsi, status) VALUES (?, ?, ?, ?)")) {

        ps.setString(1, nip);
        ps.setInt(2, Integer.parseInt(idKategori));
        ps.setString(3, deskripsi);
        ps.setString(4, status);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Tiket berhasil disimpan.");
        loadDataTiket(); // Refresh table
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
    private void loadDataTiket() {
    DefaultTableModel model = (DefaultTableModel) tabelData.getModel();
    model.setRowCount(0);

    try (Connection c = Database.getConnection();
         Statement s = c.createStatement();
         ResultSet r = s.executeQuery("SELECT t.id_tiket, p.nama, k.nama_kategori, t.status FROM tikett t JOIN pegawai p ON t.nip = p.nip JOIN kategori_masalah k ON t.id_kategori = k.id_kategori")) {

        while (r.next()) {
            model.addRow(new Object[]{
                r.getInt("id_tiket"),
                r.getString("nama"),
                r.getString("nama_kategori"),
                r.getString("status")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public class DialogPegawai extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private String nip, nama, jabatan, no_telp;

    public DialogPegawai(JFrame parent) {
        super(parent, "Pilih Pegawai", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);

        model = new DefaultTableModel(new String[]{"NIP", "Nama", "Jabatan", "Telpon"}, 0);
        table = new JTable(model);
        loadData();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                nip = model.getValueAt(row, 0).toString();
                nama = model.getValueAt(row, 1).toString();
                jabatan = model.getValueAt(row, 2).toString();
                no_telp = model.getValueAt(row, 3).toString();
                dispose(); // Tutup dialog
            }
        });

        add(new JScrollPane(table));
    }

    private void loadData() {
        try (Connection c = Database.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM pegawai")) {

            while (r.next()) {
                model.addRow(new Object[]{
                    r.getString("nip"),
                    r.getString("nama"),
                    r.getString("jabatan"),
                    r.getString("no_telp")
                });
            }
        } catch (SQLException e) {
            
        }
    }

    public String getNip() { return nip; }
    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }
    public String getTelpon() { return no_telp; }
}
    public class DialogKategori extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private int idKategori;
    private String namaKategori, deskripsi, prioritas;

    public DialogKategori(JFrame parent) {
        super(parent, "Pilih Kategori", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);

        model = new DefaultTableModel(new String[]{"ID", "Kategori", "Deskripsi", "Prioritas"}, 0);
        table = new JTable(model);
        loadData();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idKategori = Integer.parseInt(model.getValueAt(row, 0).toString());
                namaKategori = model.getValueAt(row, 1).toString();
                deskripsi = model.getValueAt(row, 2).toString();
                prioritas = model.getValueAt(row, 3).toString();
                dispose();
            }
        });

        add(new JScrollPane(table));
    }

    private void loadData() {
        try (Connection c = Database.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM kategori_masalah")) {

            while (r.next()) {
                model.addRow(new Object[]{
                    r.getInt("id_kategori"),
                    r.getString("nama_kategori"),
                    r.getString("deskripsi"),
                    r.getString("prioritas")
                });
            }
        } catch (SQLException e) {
            
        }
    }

    public int getIdKategori() { return idKategori; }
    public String getNamaKategori() { return namaKategori; }
    public String getDeskripsi() { return deskripsi; }
    public String getPrioritas() { return prioritas; }
}
    
    



    
    public void filter() {
        sorter = new TableRowSorter<PerangkatModelDB>(model);
        tableTiket.setRowSorter(sorter);

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
                    // Filter pada kolom Nama (1), Tipe (2), dan Status (3)
                    rf = RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(searchText), 1, 2, 7);
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

  private void simpanDataKategori() {
    String id = txtIdKategori.getText();
    String nama = txtKategori.getText();
    String deskripsi = txtDeskripsi.getText();
    String prioritas = txtPrioritas.getText().toString();
    String status = cboStatus.getSelectedItem().toString();

    String sql = "INSERT INTO data_sementara (id_kategori, nama_kategori, deskripsi, prioritas, status) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, id);
        ps.setString(2, nama);
        ps.setString(3, deskripsi);
        ps.setString(4, prioritas);
        ps.setString(5, status);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        // Refresh tabel setelah insert
        loadDataKategori();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + ex.getMessage());
    }
}  
    
  
    
    DefaultTableModel modelKategori;

private void loadDataKategori() {
    modelKategori = new DefaultTableModel();
    modelKategori.addColumn("ID Kategori");
    modelKategori.addColumn("Kategori");
    modelKategori.addColumn("Deskripsi");
    modelKategori.addColumn("Prioritas");
    modelKategori.addColumn("Status");

    tabelData.setModel(modelKategori);

    try (Connection conn = Database.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM data_sementara")) {

        while (rs.next()) {
            modelKategori.addRow(new Object[]{
                rs.getString("id_kategori"),
                rs.getString("nama_kategori"),
                rs.getString("deskripsi"),
                rs.getString("prioritas"),
                rs.getString("status")
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + ex.getMessage());
    }
}




    
    private void filterStatus() {
    String selected = cboStatus.getSelectedItem().toString();

    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelKategori);
    tabelData.setRowSorter(sorter);

    if (selected.equalsIgnoreCase("Semua Status")) {
        sorter.setRowFilter(null); // tampilkan semua
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + selected, 4)); // kolom ke-5 (index 4)
    }

    lbStatus.setText(selected);
}

    private void setComboBoxListener() {
    cboStatus.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            filterStatus();
        }
    });
}

    
    
    
    
    public void setKolomTabel() {
        // Mengatur lebar kolom untuk masing-masing kolom
        TableColumn column = null;
        for (int i = 0; i < 8; i++) {
            column = tableTiket.getColumnModel().getColumn(i);
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
                System.out.println("Berhasil memuat " + rowCount + " baris data dari tabel perangkats.");
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



    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTambah = new Castom.JButtonCustom();
        btnHapus = new Castom.JButtonCustom();
        Searching = new Castom.JtextCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTiket = new Castom.JTable_Custom();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSimpan = new Castom.JButtonCustom();
        btnBatal = new Castom.JButtonCustom();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIdPegawai = new Castom.JtextCustom();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNama = new Castom.JtextCustom();
        txtJabatan = new Castom.JtextCustom();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTelpon = new Castom.JtextCustom();
        btnSetPegawai = new javax.swing.JButton();
        panelCustom1 = new Castom.PanelCustom();
        txt_ID = new Castom.JtextCustom();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnSetKetegori = new javax.swing.JButton();
        txtIdKategori = new Castom.JtextCustom();
        txtKategori = new Castom.JtextCustom();
        txtDeskripsi = new Castom.JtextCustom();
        txtPrioritas = new Castom.JtextCustom();
        jLabel28 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        btnTambah1 = new Castom.JButtonCustom();
        jLabel29 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new Castom.JTable_Custom();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Tiket");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Transaksi > Tiket");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

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
        btnHapus.setText("BATAL");
        btnHapus.setFillClick(new java.awt.Color(153, 0, 51));
        btnHapus.setFillOriginal(new java.awt.Color(255, 0, 51));
        btnHapus.setFillOver(new java.awt.Color(204, 0, 51));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        Searching.setText("Search");
        Searching.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

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
        jScrollPane3.setViewportView(tableTiket);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 922, Short.MAX_VALUE)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
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
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))))
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Tiket");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Transaksi  > Tiket");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tiket.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tiket.png"))); // NOI18N

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

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));

        txtIdPegawai.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("NIP");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Nama");

        txtNama.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        txtJabatan.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Jabatan");

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Telpon");

        txtTelpon.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        btnSetPegawai.setText("...");
        btnSetPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSetPegawaiMouseClicked(evt);
            }
        });
        btnSetPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetPegawaiActionPerformed(evt);
            }
        });

        panelCustom1.setRoundBottomLeft(20);
        panelCustom1.setRoundBottomRight(20);
        panelCustom1.setRoundTopLeft(20);
        panelCustom1.setRoundTopRight(20);

        txt_ID.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("ID");

        javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
        panelCustom1.setLayout(panelCustom1Layout);
        panelCustom1Layout.setHorizontalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(56, 56, 56)
                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCustom1Layout.setVerticalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("ID Kategori");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Kategori");

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Deskripsi");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Prioritas");

        btnSetKetegori.setText("...");
        btnSetKetegori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetKetegoriActionPerformed(evt);
            }
        });

        txtIdKategori.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        txtKategori.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        txtDeskripsi.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        txtPrioritas.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Status");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua Status", "Terbuka", "Dalam Proses", "Selesai", "Tertutup", " " }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        btnTambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add .png"))); // NOI18N
        btnTambah1.setText("TAMBAH");
        btnTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah1ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Status");

        lbStatus.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(102, 102, 102));
        lbStatus.setText("Status");

        tabelData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelData);

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                        .addComponent(txtTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(jLabel16))
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSetPegawai)))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtIdKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDeskripsi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSetKetegori)
                                .addGap(162, 162, 162)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboStatus, 0, 383, Short.MAX_VALUE)
                                    .addGroup(panelAddLayout.createSequentialGroup()
                                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29)
                                            .addComponent(lbStatus))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(32, 32, 32))
                            .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1446, Short.MAX_VALUE))))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSetPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSetKetegori, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(19, 19, 19)
                                .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrioritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)))
                            .addGroup(panelAddLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbStatus))
                            .addComponent(jLabel24)))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
       
        isEditMode = false;
        editDeviceId = -1;
        jLabel5.setText("Tambah Data Perangkat");
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

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
        int index = tableTiket.getSelectedRow();

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
            javax.swing.JOptionPane.showMessageDialog(this, "ID perangkat tidak valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hapus data dari database
        try {
            Connection c = Database.getConnection();
            if (c == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "DELETE FROM perangkat WHERE device_id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            int rowsDeleted = p.executeUpdate();
            p.close();
            c.close();

            if (rowsDeleted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data perangkat berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tampilData(); // Muat ulang data dari database
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data perangkat!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error menghapus data dari database: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah1ActionPerformed
        loadDataKategori();
        setComboBoxListener();  
        simpanDataKategori();
    }//GEN-LAST:event_btnTambah1ActionPerformed

    private void btnSetPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetPegawaiActionPerformed
    MenuPegawai2 a = new MenuPegawai2();
    a.setVisible(true);

    txtIdPegawai.setText(a.getNip());
    txtNama.setText(a.getNama());
    txtJabatan.setText(a.getJabatan());
    txtTelpon.setText(a.getTelpon());

    txtIdPegawai.setEnabled(false);
    txtNama.setEnabled(false);
    txtJabatan.setEnabled(false);
    txtTelpon.setEnabled(false);

    }//GEN-LAST:event_btnSetPegawaiActionPerformed

    private void btnSetKetegoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetKetegoriActionPerformed
        MenuKategori2 a = new MenuKategori2();
        a.setVisible(true);

    txtIdKategori.setText(a.getIdKategori());
    txtKategori.setText(a.getNamaKategori());
    txtDeskripsi.setText(a.getDeskripsi());
    txtPrioritas.setText(a.getPrioritas());

    txtIdKategori.setEnabled(false);
    txtKategori.setEnabled(false);
    txtDeskripsi.setEnabled(false);
    txtPrioritas.setEnabled(false);


    }//GEN-LAST:event_btnSetKetegoriActionPerformed

    private void btnSetPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetPegawaiMouseClicked
        
    }//GEN-LAST:event_btnSetPegawaiMouseClicked

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        String selectedStatus = cboStatus.getSelectedItem().toString();
        lbStatus.setText(selectedStatus);
    }//GEN-LAST:event_cboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private Castom.JButtonCustom btnBatal;
    private Castom.JButtonCustom btnHapus;
    private javax.swing.JButton btnSetKetegori;
    private javax.swing.JButton btnSetPegawai;
    private Castom.JButtonCustom btnSimpan;
    private Castom.JButtonCustom btnTambah;
    private Castom.JButtonCustom btnTambah1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboStatus;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel panelAdd;
    private Castom.PanelCustom panelCustom1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private Castom.JTable_Custom tabelData;
    private Castom.JTable_Custom tableTiket;
    public static Castom.JtextCustom txtDeskripsi;
    public static Castom.JtextCustom txtIdKategori;
    public static Castom.JtextCustom txtIdPegawai;
    public static Castom.JtextCustom txtJabatan;
    public static Castom.JtextCustom txtKategori;
    public static Castom.JtextCustom txtNama;
    public static Castom.JtextCustom txtPrioritas;
    public static Castom.JtextCustom txtTelpon;
    private Castom.JtextCustom txt_ID;
    // End of variables declaration//GEN-END:variables
}
