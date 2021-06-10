package com.company.forms;

import com.company.database.DataBase;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.RoomType;
import com.company.entities.StatusRoom;
import com.company.entities.Hotel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class FrmRooms extends JFrame {
    private JPanel panel1;
    private JTextField txt_RoomNumber;
    private JLabel lblRoomNumber;
    private JTextField txt_Floor;
    private JLabel lblFloor;
    private JLabel lblRoomType;
    private JLabel lblEstate;
    private JPanel pnlDataRoom;
    private JPanel pnlListRoom;
    private JTable table;
    private JButton acceptButton;
    private JButton btnCancel;
    private JButton btnExit;
    private JComboBox cmbRoom;
    private JComboBox cmbStatus;
    private JLabel lblmotivo;
    private JTextField txtmotivo;
    private JButton btnListar;
    private JComboBox cmbListar;

    private JFrame frame;

    public FrmRooms(JFrame frame) {

        Hotel hotel = new Hotel();
        this.frame=frame;
   /*     super("Client");
        this.setContentPane(panel1);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);*/
        cmbRoom.addItem("Single");
        cmbRoom.addItem("Double");
        cmbStatus.addItem("Available");
        cmbStatus.addItem("UnAvailable");
        cmbListar.addItem("All");
        cmbListar.addItem("Available");
        cmbListar.addItem("UnAvailable");

        txtmotivo.setEnabled(false);
        RoomTableModel tableModel = new RoomTableModel();
        tableModel.setList(DataBase.getListRoom());
        table.setModel(tableModel);



        cmbRoom.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){

                    String seleccionado =(String)cmbRoom.getSelectedItem();
                    System.out.println(seleccionado );
                }

            }
        });
        cmbStatus.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){

                    String seleccionado =(String)cmbStatus.getSelectedItem();
                    if(seleccionado.equals("UnAvailable")){
                        txtmotivo.setEnabled(true);
                    }
                    System.out.println(seleccionado );
                }

            }
        });




        acceptButton.addActionListener(new ActionListener() {
            Room room;
            @Override
            public void actionPerformed(ActionEvent e) {

           /*        public Room(int roomNumber, int floor, RoomType roomType, StatusRoom status) {
                    this.roomNumber = roomNumber;
                    this.floor = floor;
                    this.roomType = roomType;
                    this.status = status;
                }*/

                int roomNumber = Integer.parseInt(txt_RoomNumber.getText());
                int floor = Integer.parseInt(txt_Floor.getText());
                RoomType type = new RoomType((String)cmbRoom.getSelectedItem());
               // String typeRoom =(String)cmbRoom.getSelectedItem();

                RoomType typeRoom = new RoomType((String)cmbRoom.getSelectedItem());
                //String status =(String)cmbStatus.getSelectedItem();
                StatusRoom status;
                if (cmbStatus.getSelectedItem().equals("Available")){
                  status =  new StatusRoom(true,"--");
                }else{
                    status =  new StatusRoom(false,txtmotivo.getText().toString());
                }


                room = new Room(roomNumber,floor,typeRoom,status);
                //this.client = new Client(name,lastName,dni,phone,email,address);
                //System.out.println(client.toString());

                if(DataBase.RoomSave(room)){
                    //mostrar un mensaje se guardo correctamente
                    JOptionPane.showMessageDialog(null, "Room Load Succesfuly", "Message", JOptionPane.INFORMATION_MESSAGE);
                    tableModel.setList(DataBase.getListRoom());

                }else{
                    //mostrar un mensaje que hubo un error
                    JOptionPane.showMessageDialog(null, "Error loading", "Message", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado =(String)cmbListar.getSelectedItem();
                if(seleccionado.equals("Available")){

                    tableModel.setList(hotel.listRoomAvailable());
                }else if(seleccionado.equals("UnAvailable")) {
                    tableModel.setList(hotel.listRoomUnAvailable());
                }else{
                    tableModel.setList(DataBase.getListRoom());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public static void main(String[] args) {

   /*     JFrame frame = new JFrame("FrmRooms");
        frame.setContentPane(new FrmRooms().panel1);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        DataBase.iniciar();*/
    }


}
