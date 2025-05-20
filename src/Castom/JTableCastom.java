
package Castom;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.event.ComponentListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class JTableCastom extends JTable {

    public JTableCastom() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        
        // Custom Header Renderer
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                JLabel header = new JLabel(value.toString());
                header.setOpaque(true);
                header.setBackground(new Color(240, 240, 240));
                header.setFont(header.getFont().deriveFont(Font.BOLD));
                header.setBorder(BorderFactory.createEtchedBorder());
                if (column == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                } else {
                    header.setHorizontalAlignment(JLabel.LEFT);
                }
                return header;
            }
        });

        // Custom Cell Renderer
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    cell.setForeground(new Color(15, 89, 140));
                } else {
                    cell.setForeground(new Color(102, 102, 102));
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
