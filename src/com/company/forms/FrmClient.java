package com.company.forms;
import com.company.database.DataBase;
import com.company.entities.Booking;
import com.company.entities.Client;
import com.company.entities.ReserveStatus;
import com.company.forms.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FrmClient extends JFrame{
    public JPanel pnlClient;
    private JLabel lblName;
    private JTextField txt_Name;
    private JLabel lblLastName;
    private JTextField txt_LastName;
    private JLabel lblDni;
    private JTextField txt_Dni;
    private JTextField txt_Phone;
    private JLabel lblPhone;
    private JTextField txt_Address;
    private JLabel lblAddress;
    private JTextField txt_Email;
    private JLabel lblEmail;
    private JButton btnAccept;
    private JButton btnSearch;
    private JButton btnModify;
    private JButton btnRemove;
    private JButton btnExit;
    private JTextField txt_search;
    private JTable table;
    private JButton btnActulizar;

    private boolean actualizar= false;

    private int rowActualizar=0;
    public FrmClient(JFrame frame) {



        ClientTableModel tableModel = new ClientTableModel();
        tableModel.setList(DataBase.getListClient());
        table.setModel(tableModel);

        btnAccept.addActionListener(new ActionListener() {
            Client client;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_Name.getText();
                String lastName =txt_LastName.getText();
                String dni = txt_Dni.getText();
                String phone = txt_Phone.getText();
                String email = txt_Email.getText();
                String address = txt_Address.getText();
                this.client = new Client(name,lastName,dni,phone,email,address);
                //System.out.println(client.toString());

             if(actualizar){

                 ArrayList<Client> listClients = DataBase.getListClient();
                 Client client = listClients.get(rowActualizar);
                 client.setName(name);
                 client.setLastName(lastName);
                 client.setDni(dni);
                 client.setPhone(phone);
                 client.setEmail(email);
                 client.setAdress(address);
                 DataBase.clientUpdate(listClients);
                 tableModel.setList(listClients);
                 btnAccept.setText("ACCEPT");
              actualizar = false;
             }else{

                 if(DataBase.clientSave(client)){
                     //mostrar un mensaje se guardo correctamente
                     JOptionPane.showMessageDialog(null, "El cliente se cargo con exito ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                     tableModel.setList(DataBase.getListClient());

                 }else{
                     //mostrar un mensaje que hubo un error
                     JOptionPane.showMessageDialog(null, "Vuelva a cargar el cliente", "Mensaje", JOptionPane.WARNING_MESSAGE);

                 }
             }

                txt_Name.setText("");
               txt_LastName.setText("");
               txt_Dni.setText("");
                txt_Phone.setText("");
                 txt_Email.setText("");
                txt_Address.setText("");




            }
        });



        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Select a Client ");
                    return;
                }
                ArrayList<Client> listClients = DataBase.getListClient();
                Client client = listClients.get(row);
                txt_Name.setText(client.getName());
                txt_LastName.setText(client.getLastName());
                txt_Dni.setText(client.getDni());
                txt_Phone.setText(client.getPhone());
                txt_Email.setText(client.getEmail());
                txt_Address.setText(client.getAdress());
                btnAccept.setText("UPDATE");
                actualizar=true;
                rowActualizar=row;

            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();//0
                if(row==-1){
                    JOptionPane.showMessageDialog(null,"Select a client  ");
                    return;
                }
                ArrayList<Client> clients = DataBase.getListClient();
                Client client = clients.get(row);


                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete  " + client.name(), "Confirm Delete...",JOptionPane.YES_NO_CANCEL_OPTION);

                if ( input ==0) {
                    clients.remove(row);
                    DataBase.clientUpdate(clients);
                    tableModel.setList(clients);
                }


            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });


        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String search = txt_search.getText().toLowerCase();

                ArrayList<Client> listClients = new ArrayList<Client>();
                for (Client client: DataBase.getListClient()) {
                    if ( client.getName().toLowerCase().contains(search) || client.getLastName().toLowerCase().contains(search) ||
                            client.getDni().toLowerCase().contains(search)){
                        listClients.add(client);

                    }

                }
                tableModel.setList(listClients);
            }
        });
    }

    public void closeClient(){
        this.setVisible(false);
        dispose();
    }

    public JPanel getPnlClient() {
        return pnlClient;
    }

    public void setPnlClient(JPanel pnlClient) {
        this.pnlClient = pnlClient;
    }






}
