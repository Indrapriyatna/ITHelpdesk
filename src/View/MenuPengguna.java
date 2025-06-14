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
import java.sql.Timestamp;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.PenggunaModelDB;

/**
 *
 * @author Draaa
 */
public final class MenuPengguna extends javax.swing.JPanel {
    private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editUserId = -1;
      PenggunaModelDB model = new PenggunaModelDB();
  
    /**
     * Creates new form menuDashboard
     */
    public MenuPengguna() {
        initComponents();
//            
           
            tablePengguna.setModel(model);
         tampilData();
              setKolomTabel();
              clearFields();
              filter();
              
       
             
    }
    
    public void filter(){
               sorter = new TableRowSorter<PenggunaModelDB>(model);
    tablePengguna.setRowSorter(sorter);
    
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
                RowFilter<PenggunaModelDB, Object> rf = null;
    String searchText = Searching.getText();
    
    // Jangan filter jika teks adalah placeholder atau kosong
    if (searchText.equals("Search") || searchText.isEmpty()) {
        sorter.setRowFilter(null);
        return;
    }

    try {
        // Filter pada kolom username (1), full_name (4), dan email (5)
        // Gunakan (?i) untuk case-insensitive
        rf = RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(searchText), 1, 4, 5);
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
    // mengatur lebar kolom untuk masing-masing kolom
    TableColumn column = null;
    for (int i = 0; i < 7; i++) {
        column = tablePengguna.getColumnModel().getColumn(i);
        switch(i) {
            case 0: column.setPreferredWidth(50); break;
            case 1: column.setPreferredWidth(50); break;
            case 2: column.setPreferredWidth(50); break;
            case 3: column.setPreferredWidth(50); break;
            case 4: column.setPreferredWidth(50); break;
            case 5: column.setPreferredWidth(50); break;
            case 6: column.setPreferredWidth(50); break;
        }
    }
}
       
  
        
private void tampilData() {
  model.removeAllRows();

        // melakukan koneksi ke database dan tabel via KoneksiDB
        try {
            Connection c = Database.getConnection();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                // lakukan penelusuran baris
                Object[] o = new Object[7];
                o[0] = r.getString("user_id");
                o[1] = r.getString("username");
                o[2] = r.getString("password");
                o[3] = r.getString("role");
                o[4] = r.getString("full_name");
                o[5] = r.getString("email");
                o[6] = r.getString("created_at");
   

                model.addRow(Arrays.asList(o));
            }
        } catch (SQLException e) {
            System.out.println("Terjadi error menampilkan data di tabel!");
        }
}

         private void clearFields() { //mengosongkan isian pada form
      txt_username.setText("");
        txt_nama.setText("");
          txt_password.setText("");
        cboRole.setSelectedIndex(0);
        txt_email.setText("");
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
        btnTambah = new Castom.JButtonCustom();
        btnEdit = new Castom.JButtonCustom();
        Searching = new Castom.JtextCustom();
        btnHapus = new Castom.JButtonCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengguna = new Castom.JTableCastom1();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelAdd = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new Castom.JButtonCustom();
        btnBatal = new Castom.JButtonCustom();
        txt_username = new Castom.JtextCustom();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_password = new Castom.JtextCustom();
        jLabel11 = new javax.swing.JLabel();
        txt_email = new Castom.JtextCustom();
        jLabel16 = new javax.swing.JLabel();
        txt_nama = new Castom.JtextCustom();
        jLabel14 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

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

        tablePengguna.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePengguna);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Pengguna");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/perangkatit.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data > Pengguna");

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addGap(21, 21, 21)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelView, "card2");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tambah Data Pengguna");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Master Data > Pengguna");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

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

        txt_username.setToolTipText("");
        txt_username.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Username");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Password");

        txt_password.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passwordFocusLost(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email");

        txt_email.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Nama");

        txt_nama.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        txt_nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_namaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_namaFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Role");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(600, 600, 600)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel14)
                .addGap(4, 4, 4)
                .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card2");

        add(panelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.revalidate();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
    // TODO add your handling code here:
    // mengambil nilai-nilai isian pada form
String username = txt_username.getText();
    String password = txt_password.getText();
    String nama = txt_nama.getText();
    String role = cboRole.getSelectedItem().toString();
    String email = txt_email.getText();

    // Validasi input
    if (username.isEmpty() || password.isEmpty() || nama.isEmpty() || role.isEmpty() || email.isEmpty() || email.equals("Email")) {
        javax.swing.JOptionPane.showMessageDialog(this, "Semua kolom harus diisi dengan data yang valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validasi format email
    if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        javax.swing.JOptionPane.showMessageDialog(this, "Format email tidak valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Connection c = Database.getConnection();
        if (c == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isEditMode) {
            // Mode edit: update data
            String sql = "UPDATE users SET username = ?, password = ?, full_name = ?, role = ?, email = ?, created_at = ? WHERE user_id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            p.setString(3, nama);
            p.setString(4, role);
            p.setString(5, email);
            p.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            p.setInt(7, editUserId);
            int rowsUpdated = p.executeUpdate();
            p.close();

            if (rowsUpdated > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data pengguna berhasil diperbarui!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal memperbarui data pengguna!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mode tambah: insert data
            String sql = "INSERT INTO users (username, password, full_name, role, email, created_at) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            p.setString(3, nama);
            p.setString(4, role);
            p.setString(5, email);
            p.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            int rowsInserted = p.executeUpdate();
            p.close();

            if (rowsInserted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data pengguna berhasil ditambahkan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Perbarui tabel dan kembali ke panelView
        tampilData();
        clearFields();
        isEditMode = false;
        editUserId = -1;
        jLabel5.setText("Tambah Data Pengguna");
        panelMain.removeAll();
        panelMain.add(panelView);
        panelMain.revalidate();
    } catch (SQLException e) {
        System.err.println("Error saat " + (isEditMode ? "memperbarui" : "menambah") + " data ke database: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal " + (isEditMode ? "memperbarui" : "menambah") + " data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusGained
        // TODO add your handling code here:
        txt_email.setText("Email");
               if (txt_email.getText().equals("Email")) {
                txt_email.setText("");
            }
    }//GEN-LAST:event_txt_emailFocusGained

    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusLost
        // TODO add your handling code here:
               if (txt_email.getText().isEmpty()) {
                txt_email.setText("Email");
            }
    }//GEN-LAST:event_txt_emailFocusLost

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
int index = tablePengguna.getSelectedRow();

    // Jika tidak ada baris terseleksi, tampilkan peringatan
    if (index == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ambil data dari baris yang dipilih
    editUserId = Integer.parseInt(model.getValueAt(index, 0).toString()); // user_id
    String username = model.getValueAt(index, 1).toString();
    String password = model.getValueAt(index, 2).toString();
    String role = model.getValueAt(index, 3).toString();
    String fullName = model.getValueAt(index, 4).toString();
    String email = model.getValueAt(index, 5).toString();

    // Isi field input dengan data
    txt_username.setText(username);
    txt_password.setText(password);
    txt_nama.setText(fullName);
    cboRole.setSelectedItem(role);
    txt_email.setText(email);

    // Ubah judul panel dan beralih ke panelAdd
    isEditMode = true;
    jLabel5.setText("Edit Data Pengguna");
    panelMain.removeAll();
    panelMain.add(panelAdd);
    panelMain.revalidate();


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
int index = tablePengguna.getSelectedRow();

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

    // Ambil user_id dari baris yang dipilih
    int userId;
    try {
        userId = Integer.parseInt(model.getValueAt(index, 0).toString());
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "ID pengguna tidak valid!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Hapus data dari database
    try {
        Connection c = Database.getConnection();
        if (c == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setInt(1, userId);
        int rowsDeleted = p.executeUpdate();
        p.close();

        if (rowsDeleted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Data pengguna berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            tampilData(); // Muat ulang data dari database
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data pengguna!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        System.err.println("Error menghapus data dari database: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void txt_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusGained

    }//GEN-LAST:event_txt_usernameFocusGained
    
    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost

    }//GEN-LAST:event_txt_usernameFocusLost

    private void txt_namaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namaFocusGained

    }//GEN-LAST:event_txt_namaFocusGained

    private void txt_namaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_namaFocusLost

    }//GEN-LAST:event_txt_namaFocusLost

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained

    }//GEN-LAST:event_txt_passwordFocusGained

    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusLost

    }//GEN-LAST:event_txt_passwordFocusLost

    private void SearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchingActionPerformed
      
    }//GEN-LAST:event_SearchingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private Castom.JButtonCustom btnBatal;
    private Castom.JButtonCustom btnEdit;
    private Castom.JButtonCustom btnHapus;
    private Castom.JButtonCustom btnSimpan;
    private Castom.JButtonCustom btnTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private Castom.JTableCastom1 tablePengguna;
    private Castom.JtextCustom txt_email;
    private Castom.JtextCustom txt_nama;
    private Castom.JtextCustom txt_password;
    private Castom.JtextCustom txt_username;
    // End of variables declaration//GEN-END:variables
}
