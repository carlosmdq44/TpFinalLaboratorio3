package com.company.forms;
import com.company.*;
import com.company.entities.User;
import com.company.forms.*;

import javax.swing.*;
import com.company.database.DataBase;
import com.company.entities.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.database.DataBase;
import com.company.entities.Client;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.Struct;

import static java.awt.image.ImageObserver.WIDTH;

public class FrmPrincipal extends JFrame{
    public JPanel frmPrincipal;
    private JButton btnUser;
    private JButton btnClient;
    private JButton btnRoom;
    private JButton btnBooking;
    private JButton btnExit;
    private JLabel lblUser;
    private Object FrnPrincipal;


    public FrmPrincipal(){

       User user = DataBase.getUserLoggin();
       lblUser.setText("Bienvenido: " + user.getUserName() + " " + "Rol: " + user.getRol().getDescription());

       if(user.getRol().getDescription().equals("RECEPCIONIST")){
           btnUser.setVisible(false);
           btnRoom.setVisible(false);

       }
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Rooms");
                frame.setContentPane(new FrmRooms(frame).getPanel1());
               // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(1200,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

        btnBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event) {
                    System.exit(WIDTH);
            }
        });

        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Client");
                frame.setContentPane(new FrmClient(frame).pnlClient);
                frame.pack();
                //frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Users");
                frame.setContentPane(new FrmUser(frame).jPanelUser);
                frame.pack();
                frame.setSize(1000,700);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

        btnBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("FrmBooking");
                frame.setContentPane(new frmBooking().pnlprincipal);
                frame.pack();
                frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }






    public void closePrincipalForm(){
        this.setVisible(false);
        this.dispose();
    }

    public void setFrmPrincipal(JPanel frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("FrmPrincipal");
        frame.setContentPane(new FrmPrincipal().frmPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



}