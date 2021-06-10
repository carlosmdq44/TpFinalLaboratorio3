package com.company.forms;

import com.company.entities.Booking;
import com.company.entities.Room;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ReservaTableModel extends AbstractTableModel {

    private List<Booking> list = new ArrayList<Booking>();
    private String[] columnNames = {"Dni","Client", "Start Date","End Date","Status"};

    public void setList(List<Booking> list) {
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
                return list.get(rowIndex).getDni();
            case 1:
                return list.get(rowIndex).getClient().name();
            case 2:
                return list.get(rowIndex).getStartDate();
            case 3:
                return list.get(rowIndex).getEndDate();

            case 4:
                 return list.get(rowIndex).getStatus();

            default:
                return null;
        }
    }
}
