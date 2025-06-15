/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Master;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp5cd
 */
public class PenggunaModelDB extends AbstractTableModel {
    
    private List<String> columnNames = new ArrayList();
    private List<List> data = new ArrayList();
    
    {
        columnNames.add("Id");
        columnNames.add("Username");
        columnNames.add("Password");
        columnNames.add("Role");
        columnNames.add("Nama");
        columnNames.add("Email");
        columnNames.add("Created At");
        
    }
    
 public void addRow(List rowData){
     data.add(rowData);
     fireTableRowsInserted(data.size() -1, data.size()-1);
 }
  
 public void removeRow(int rowIndex){
     data.remove(rowIndex);
     fireTableRowsDeleted(rowIndex, rowIndex);
 }
 
 public void removeAllRows(){
     int rows = getRowCount();
     if(rows == 0)
         return;
     
     data.clear();
     fireTableRowsDeleted(0, rows -1);
 }

    @Override
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col){
        try{
            return columnNames.get(col);
        
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public int getColumnCount() {
      return columnNames.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
        
    }
    
    public void setValueAt(Object value, int row, int col){
        data.get(row).set(col, value);
        fireTableDataChanged();
       
    }
    
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }
}
