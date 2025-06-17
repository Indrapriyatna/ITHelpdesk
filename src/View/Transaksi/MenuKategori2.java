
package View.Transaksi;

import View.Transaksi.MenuTiket;
import config.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import model.Master.KategoriModelDB;
import model.Master.KategoriModelDB2;


/**
 *
 * @author Draaa
 */
public class MenuKategori2 extends javax.swing.JFrame {
private TableRowSorter sorter;
    private boolean isEditMode = false;
    private int editCategoryId = -1;
    KategoriModelDB2 model = new KategoriModelDB2();
    public MenuKategori2() {
         initComponents();
       tableKategori.setModel(model);
        tampilData();
        setKolomTabel();
        
        filter();
        
    }
    private String idKategori, namaKategori, deskripsi, prioritas;
    public String getIdKategori() {
        return idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPrioritas() {
        return prioritas;
    }
    
    public void filter() {
       sorter = new TableRowSorter<KategoriModelDB2>(model);
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
                RowFilter<KategoriModelDB2, Object> rf = null;
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
        for (int i = 0; i < 4; i++) {
            column = tableKategori.getColumnModel().getColumn(i);
            switch (i) {
                case 0: column.setPreferredWidth(50); break;
                case 1: column.setPreferredWidth(100); break;
                case 2: column.setPreferredWidth(150); break;
                case 3: column.setPreferredWidth(100); break;
                
                           }
        }
    }
    private void tampilData() {
       model.removeAllRows();
    try (Connection c = Database.getConnection();
         Statement s = c.createStatement();
         ResultSet r = s.executeQuery("SELECT * FROM kategori_masalah")) {
        while (r.next()) {
            Object[] o = new Object[4];
            o[0] = r.getString("id_kategori");
            o[1] = r.getString("nama_kategori");
            o[2] = r.getString("deskripsi");
            o[3] = r.getString("prioritas");
            
            model.addRow(Arrays.asList(o));
        }
    } catch (SQLException e) {
        System.err.println("Error loading data: " + e.getMessage());
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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

        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Searching = new Castom.JtextCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKategori = new Castom.JTable_Custom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Data Kategori");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pegawaii.png"))); // NOI18N

        Searching.setText("Search");
        Searching.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        Searching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchingActionPerformed(evt);
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
        tableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKategori);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(963, 963, 963))
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelView, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchingActionPerformed

    private void tableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKategoriMouseClicked
        int i = tableKategori.getSelectedRow();
        
        String id = tableKategori.getValueAt(i, 0).toString();
        String nama = tableKategori.getValueAt(i, 1).toString();
        String deskripsi = tableKategori.getValueAt(i, 2).toString();
        String prioritas = tableKategori.getValueAt(i, 3).toString();
        MenuTiket.txtIdKategori.setText(id);
        MenuTiket.txtKategori.setText(nama);
        MenuTiket.txtDeskripsi.setText(deskripsi);
        MenuTiket.txtPrioritas.setText(prioritas);
        
        this.dispose();
    
    }//GEN-LAST:event_tableKategoriMouseClicked

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
            java.util.logging.Logger.getLogger(MenuKategori2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuKategori2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuKategori2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuKategori2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuKategori2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Castom.JtextCustom Searching;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelView;
    private Castom.JTable_Custom tableKategori;
    // End of variables declaration//GEN-END:variables
}
