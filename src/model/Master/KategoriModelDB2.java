package model.Master;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class KategoriModelDB2 extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = {
        "ID Kategori", "Nama Kategori", "Deskripsi", "Prioritas"
    };

    public KategoriModelDB2() {
        super(new Object[0][6], COLUMN_NAMES); // Initialize with empty data and column names
    }

    public void addRow(List<Object> rowData) {
        super.addRow(rowData.toArray());
    }

    public void removeAllRows() {
        setRowCount(0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Make table non-editable
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class; // id_kategori
        }
        return String.class; // Other columns are strings
    }
}