package com.company.forms;

import com.company.entities.Room;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RoomTableModel extends AbstractTableModel {

    private List<Room> list = new ArrayList<Room>();
    private String[] columnNames = {"Room Number", "Floor","Room Type","Status","Reason"};

    public void setList(List<Room> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getRoomNumber();
            case 1:
                return list.get(rowIndex).getFloor();
            case 2:
                return list.get(rowIndex).getRoomType().getDescription();
            case 3:
                if(list.get(rowIndex).getStatus().isAvailable()){
                    return "Available";
                }else{
                    return "Unavailable";
                }

            case 4:
                if(list.get(rowIndex).getStatus().isAvailable()){
                    return "--";
                }else{
                    return list.get(rowIndex).getStatus().getReaseon();
                }

            default:
                return null;
        }
    }

}
