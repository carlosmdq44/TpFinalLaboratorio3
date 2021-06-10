package com.company.forms;

import com.company.entities.Client;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {

    private List<Client> list = new ArrayList<Client>();
    private String[] columnNames = {"Name", "LastName","Dni","Phone","Adress","Email"};

    public void setList(List<Client> list) {
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
                return list.get(rowIndex).getName();
            case 1:
                return list.get(rowIndex).getLastName();
            case 2:
                return list.get(rowIndex).getDni();
                case 3:
                return list.get(rowIndex).getPhone();
                case 4:
                return list.get(rowIndex).getAdress();
                case 5:
                return list.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
}
