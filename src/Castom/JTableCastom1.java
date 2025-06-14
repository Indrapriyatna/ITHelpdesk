package Castom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableCastom1 extends JTable {

    public JTableCastom1() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);

        // Custom Header Renderer (kolom 1–10 rata kiri)
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                JLabel header = new JLabel(value != null ? value.toString() : "");
                header.setOpaque(true);
                header.setBackground(new Color(240, 240, 240));
                header.setFont(header.getFont().deriveFont(Font.BOLD));
                header.setBorder(BorderFactory.createEtchedBorder());

                // Kolom 0 sampai 9 (1-10) rata kiri
                if (column >= 0 && column <= 9) {
                    header.setHorizontalAlignment(JLabel.LEFT);
                } else {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }

                return header;
            }
        });

        // Custom Cell Renderer (isi data rata kiri)
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setHorizontalAlignment(JLabel.LEFT); // rata kiri semua isi
                cell.setBackground(Color.WHITE);
                if (isSelected) {
                    cell.setForeground(new Color(15, 89, 140)); // dipilih
                } else {
                    cell.setForeground(new Color(102, 102, 102)); // default
                }
                return cell;
            }
        });
    }

    // Fungsi untuk menambahkan baris
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
