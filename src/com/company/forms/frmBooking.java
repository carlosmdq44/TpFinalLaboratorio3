package com.company.forms;

import com.company.database.DataBase;
import com.company.entities.Booking;
import com.company.entities.Hotel;
import com.company.entities.ReserveStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;


public class frmBooking extends JFrame {
    public JPanel pnlprincipal;
    private JLabel lblReserva;

    private JButton btnBook;
    private JButton btnCheckOut;
    private JButton btnCheckin;
    private JButton btnCancel;
    private JTextField txtSearch;
    private JButton searchButton;
    private JTable table;
    Hotel hotel;
    public frmBooking()  {
        ReservaTableModel tableModel = new ReservaTableModel();
        tableModel.setList(DataBase.getBookings());
        table.setModel(tableModel);
        hotel = new Hotel();
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("AddBooking");
                frame.setContentPane(new addBooking(frame).pnlPrincipal);
                frame.pack();
                frame.setSize(600,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        tableModel.setList(DataBase.getBookings());
                        table.setModel(tableModel);
                    }
                });
            }
        });
        btnCheckin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Select a booking ");
                    return;
                }
                ArrayList<Booking> bookings = DataBase.getBookings();
                Booking book = bookings.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to Check in " + book.getClient(), "Confirm Booking...",JOptionPane.YES_NO_CANCEL_OPTION);

                if ( input ==0) {
                    book.setStatus(ReserveStatus.CHECKIN);
                    book.setCheckIn(new Date());
                    DataBase.bookingUpdate(bookings);
                    tableModel.setList(bookings);
                }

            }
        });


        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable)me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    ArrayList<Booking> bookings = DataBase.getBookings();
                    Booking book = bookings.get(row);
                    JFrame frame = new JFrame("ViewBooking");
                    frame.setContentPane(new viewBooking(book,frame).pnlView);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                   /* int column = target.getSelectedColumn(); // select a column
                    JOptionPane.showMessageDialog(null, table.getValueAt(row, column)); // get the value of a row and column.*/
                }
            }
        });



        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Select a booking  ");
                    return;
                }
                ArrayList<Booking> bookings = DataBase.getBookings();
                Booking book = bookings.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to Check out " + book.getClient(), "Confirm Booking...",JOptionPane.YES_NO_CANCEL_OPTION);

                if ( input ==0) {
                    book.setStatus(ReserveStatus.CHECKOUT);
                    book.setCheckOut(new Date());
                    DataBase.bookingUpdate(bookings);
                    tableModel.setList(bookings);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Booking> bookings = hotel.searchBookings(txtSearch.getText().toString());
                tableModel.setList(bookings);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Select a booking  ");
                    return;
                }
                ArrayList<Booking> bookings = DataBase.getBookings();
                Booking book = bookings.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel the booking " + book.getClient(), "Confirm Booking...",JOptionPane.YES_NO_CANCEL_OPTION);

                if ( input ==0) {
                    book.setStatus(ReserveStatus.CANCEL);
                    DataBase.bookingUpdate(bookings);
                    tableModel.setList(bookings);
                }
            }
        });
    }

    public static void main(String[] args) {

        DataBase.iniciar();
        JFrame frame = new JFrame("FrmBooking");
        frame.setContentPane(new frmBooking().pnlprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
