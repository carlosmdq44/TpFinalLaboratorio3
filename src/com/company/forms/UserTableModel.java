package com.company.forms;

import com.company.entities.Client;
import com.company.entities.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private List<User> list = new ArrayList<User>();
    private String[] columnNames = {"Username", "Name","LastName","Rol"};

    public void setList(List<User> list) {
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
                return list.get(rowIndex).getUserName();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getLastName();
            case 3:
                return list.get(rowIndex).getRol().getDescription();
                  default:
                return null;
        }
    }
}
