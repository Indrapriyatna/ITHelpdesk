
package model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TiketModelDB extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = {
        "ID", "Subjek", "Tiket Baru", "Urgensi", "Status", "Perkiraan Selesai", "Created At"
    };

    public TiketModelDB() {
        super(new Object[0][7], COLUMN_NAMES);
    }

    public void addRow(List<Object> rowData) {
        super.addRow(rowData.toArray());
    }

    public void removeAllRows() {
        setRowCount(0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) return Integer.class;
        return String.class;
    }
}
