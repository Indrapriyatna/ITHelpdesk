package Castom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTable_Custom extends JTable {

    private int selectedRow = -1;

    public JTable_Custom() {
        // Tampilan umum
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getTableHeader().setReorderingAllowed(false);

        // Kustom header
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TablezHeader header = new TablezHeader(value.toString());
                header.setHorizontalAlignment(JLabel.CENTER);  // Teks header rata tengah
                return header;
            }
        });

        // Kustom sel (isi tabel)
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBorder(noFocusBorder);
                com.setBackground(isSelected ? new Color(52, 152, 219) : Color.WHITE);
                com.setForeground(isSelected ? new Color(255,255,255) : new Color(102, 102, 102));
                return com;
            }
        });

        // Klik baris untuk toggle seleksi
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                if (row == selectedRow) {
                    clearSelection();
                    selectedRow = -1;
                } else {
                    selectedRow = row;
                }
            }
        });
    }

    // Menambahkan baris ke model tabel
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    // Kelas header kustom
    private class TablezHeader extends JLabel {
        public TablezHeader(String text) {
            super(text);
            setOpaque(true);
            setBackground(new Color(52, 152, 219)); // Warna background header
            setFont(new Font("Segoe UI", Font.BOLD, 14));
            setForeground(Color.WHITE); // warna tulisan header
            setBorder(new EmptyBorder(10, 5, 10, 5));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(200, 200, 200)); // Garis bawah header
            g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
    }
}
