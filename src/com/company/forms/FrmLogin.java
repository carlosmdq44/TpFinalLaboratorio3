package com.company.forms;
import com.company.database.DataBase;
import com.company.entities.Client;
import com.company.entities.User;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class FrmLogin extends JFrame {
    private JLabel lblPassword;
    private JLabel lblUser;
    private JTextField txt_User;
    private JTextField txt_Password;
    private JButton btnLogin;
    public JPanel panelControl;
    private JComboBox comboUsers;
    public boolean estado;
    JFrame frame;
    public FrmLogin(JFrame _frame) {

        this.frame=_frame;
  /*      super("init");
        this.setContentPane(panelControl);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);*/

        for (User u : DataBase.getListUser()) {
            comboUsers.addItem(u.getUserName());
        }

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = txt_Password.getText();
                if (validar(password) == true) {
                    openPrincipal();
                    closeInit();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta ", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    //closeInit();
                }
            }
        });
    }

    public void openPrincipal() {


        JFrame frame = new JFrame("FrmPrincipal");
        frame.setContentPane(new FrmPrincipal().frmPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public void closeInit() {
        //this.setVisible(false);
        frame.dispose();
    }

    private void txt_Users(String listClient) {
    }

    public boolean validar(String pass) {
        ArrayList<com.company.entities.User> listUser = DataBase.getListUser();
        for (User user1 : listUser) {
            if (comboUsers.getSelectedItem() == user1.getUserName() && pass.equals(user1.getPassword())) {

                DataBase.setUserLoggin(user1);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        DataBase.iniciar();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new FrmLogin(frame).panelControl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
