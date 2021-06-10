package com.company.forms;

import com.company.database.DataBase;
import com.company.entities.Client;
import com.company.entities.Rol;
import com.company.entities.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmUser extends JFrame{
    private JTable table;
    private JTextField txt_name;
    private JTextField txt_lastName;
    private JTextField txt_Dni;
    private JTextField txt_Username;
    private JPasswordField txt_password;
    private JComboBox comboBoxRol;
    private JButton btnUpdate;
    private JButton btnExit;
    private JButton btnAccept;
    private JLabel lblName;
    private JLabel lblDni;
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JLabel lblRol;
    private JPanel JPanel;
    public JPanel jPanelUser;

    public FrmUser(JFrame _frame) {



        comboBoxRol.addItem("ADMIN");//ADMIN,RECEPCIONISTA,PASAJERO
        comboBoxRol.addItem("RECEPCIONIST");
        comboBoxRol.addItem("GUEST");
        UserTableModel tableModel = new UserTableModel();
        tableModel.setList(DataBase.getListUser());
        table.setModel(tableModel);

        btnAccept.addActionListener(new ActionListener() {
            User user;
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String lastName =txt_lastName.getText();
                String dni = txt_Dni.getText();
                String userName = txt_Username.getText();
                String password = String.valueOf(txt_password.getPassword());
                Rol rol = new Rol((String)comboBoxRol.getSelectedItem());

                this.user = new User(name,lastName,dni,password,userName,rol);
                //System.out.println(user.toString());
                if(DataBase.saveUser(user)){
                    //mostrar un mensaje se guardo correctamente
                    JOptionPane.showMessageDialog(null, "El Usuario se cargo con exito ", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    tableModel.setList(DataBase.getListUser());

                }else{
                    //mostrar un mensaje que hubo un error
                    JOptionPane.showMessageDialog(null, "Vuelva a cargar el cliente", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPrincipal open = new FrmPrincipal();
                closeUser();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _frame.dispose();
            }
        });
    }

    public void closeUser(){
        this.setVisible(false);
        dispose();
    }
}
