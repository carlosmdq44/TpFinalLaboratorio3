package com.company.forms;

import com.company.entities.Booking;
import com.company.entities.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class viewBooking extends  JFrame {
    public JPanel pnlView;
    private JTextField txtUser;
    private JTextArea txtPassangers;
    private JLabel txtStatus1;
    private JLabel Client;
    private JTextField txtStartDate;
    private JLabel txtEndDate1;
    private JTextField txtCheckin;
    private JTextField txtCheckout;
    private JTextField txtnpassagenrs;
    private JTextArea txtRooms;
    private JTextField txtClient;
    private JTextField txtEndDate;
    private JButton btnAceptar;
    private JTextField txtStatus;

    public viewBooking(Booking booking, JFrame frame){


       txtUser.setText(booking.getUser().getUserName() + " " + booking.getUser().getRol().getDescription() );
       txtClient.setText(booking.getClient().name());
       txtStatus.setText(booking.getStatus().toString());
       txtStartDate.setText(booking.getStartDate().toString());
       txtEndDate.setText(booking.getEndDate().toString());
       if(booking.getCheckIn() !=null){
           txtCheckin.setText(booking.getCheckIn().toString());
       }else{
           txtCheckin.setText("NOT CHECKING");
       }
        if(booking.getCheckOut() !=null){
            txtCheckout.setText(booking.getCheckOut().toString());
        }else{
            txtCheckout.setText("NOT CHECKOUT");
        }

        for (Room room:booking.getRoomList()) {
            txtRooms.append(room.toString() + " ");
        }

        for (com.company.entities.Client client: booking.getListPassengers()) {
            txtPassangers.append(client.name() + " ");
        }
        txtnpassagenrs.setText(""+booking.getNumberOfGuests());

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
