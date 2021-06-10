package com.company.forms;

import com.company.database.DataBase;
import com.company.entities.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class addBooking extends JFrame{
    public JPanel pnlPrincipal;
    private JComboBox cmbClientes;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JTextField txtnumberPassengers;
    private JComboBox cmbRoom;
    private JButton addRoomButton;
    private JTextArea txtAreaRooms;
    private JComboBox cmbPassengers;
    private JButton btnPassangers;
    private JTextArea txtAreaPassangers;
    private JButton btnAceptar;
    private JButton btnViewRooms;
    private JButton btnAddClient;
    private JPanel pnldate1;
    private JPanel pnldate2;
    private JPanel pnldate;

    public ArrayList<Client> listClients = new ArrayList<Client>();
    public ArrayList<Room> listRooms = new ArrayList<Room>();
    public JDateChooser dentrada;
    public JDateChooser dsalida;
    public Hotel hotel ;
    public Date fechaEntrada;
    public Date fechaSalida;
    JFrame myFrame;

    public addBooking(JFrame frame){

        myFrame=frame;
        hotel = new Hotel();

       dentrada= new JDateChooser();
        dsalida= new JDateChooser();
        jpanel2.add(dentrada);
        jpanel1.add(dsalida);

        for (Client cli : DataBase.getListClient()) {
            cmbClientes.addItem(cli);
            cmbPassengers.addItem(cli);
        }



        btnPassangers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbPassengers.getSelectedItem()!=null){
                    Client client = ((Client)cmbPassengers.getSelectedItem());
                    listClients.add(client);
                    txtAreaPassangers.append(client.toString()+"\n");
                }

            }
        });
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbRoom.getSelectedItem()!=null){
                    Room room = ((Room)cmbRoom.getSelectedItem());
                    listRooms.add(room);
                    txtAreaRooms.append(room.toString()+"\n");
                }
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             User user = DataBase.getUserLoggin();
                fechaEntrada = dentrada.getDate();
                fechaSalida= dsalida.getDate();
                int passengers= parseInt(txtnumberPassengers.getText());
                Client client = ((Client)cmbClientes.getSelectedItem());

                Booking booking = new Booking(user,client,fechaEntrada,fechaSalida,listRooms,listClients,passengers);
                DataBase.bookingSave(booking);


            }
        });
        btnViewRooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaEntrada = dentrada.getDate();
                fechaSalida= dsalida.getDate();

                cmbRoom.removeAllItems();
                for (Room room: hotel.listRoomAvailableDates(fechaEntrada,fechaSalida)) {
                    cmbRoom.addItem(room);
                }
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    public static void main(String[] args) {

        DataBase.iniciar();
        JFrame frame = new JFrame("Add Booking");
        frame.setContentPane(new addBooking(frame).pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



}


