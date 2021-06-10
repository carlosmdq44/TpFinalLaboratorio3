package com.company.database;

import com.company.entities.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataBase {

    private static DataBase ourInstance = new DataBase();

    private  static ArrayList<Client> listClient= new ArrayList<>();
    private  static ArrayList<User> listUser= new ArrayList<>();
    private  static ArrayList<Room> listRoom= new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
     private static User userLoggin; //store the user that was loggin

    public static void setUserLoggin(User userLoggin) {
        DataBase.userLoggin = userLoggin;
    }

    public static DataBase getInstance() {
        return ourInstance;
    }


    public static User getUserLoggin(){
       return userLoggin;
    }

    public static ArrayList<User> getListUser() {
        return listUser;
    }

    public static ArrayList<Client> getListClient() { return listClient;}

    public static ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public static ArrayList<Booking> getBookings() {return bookings;}

    public static void setBookings(ArrayList<Booking> bookings) {
        DataBase.bookings = bookings;
    }

    public static void setListUser(ArrayList<User> listUser) {
        DataBase.listUser = listUser;
    }

    public static void iniciar(){
        System.out.println("Initialize DB");
        System.out.println("------------------------------------------");
        System.out.println("Loading clients");
        readClient();
        System.out.println("Loading users");
        readUser();
        System.out.println("Loading rooms");
        readRoom();
        System.out.println("Loading books");
        readBooking();
        System.out.println("-------------------------------------------");
    }



    //Metodo para leer la Lista de clientes

    //Method to save bookings


    private static void readBooking() {
        try{
            Type userListType = new TypeToken<ArrayList<Booking>>(){}.getType();
            bookings = new WriterJson<Booking>().read("booking.json",userListType);
//            for (Client cust:listClient) {
//                System.out.println(cust.toString());
//            }

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    public static boolean bookingSave(Booking booking) {
        if(bookings == null){
            bookings = new ArrayList<Booking>();
            bookings.add(booking);
        }else{
            bookings.add(booking);
        }
        try{
            new WriterJson<Booking>().write(bookings,"booking.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    public static boolean bookingUpdate(ArrayList<Booking> booking) {

        try{
            new WriterJson<Booking>().write(bookings,"booking.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }



    public static boolean clientUpdate(ArrayList<Client> listClient) {

        try{
            new WriterJson<Client>().write(listClient,"Client.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }














    public static boolean clientSave(Client customer) {
        if(listClient == null){
            listClient = new ArrayList<Client>();
            listClient.add(customer);
        }else{
            listClient.add(customer);
        }
        try{
            new WriterJson<Client>().write(listClient,"Client.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readClient() {
        try{
            Type userListType = new TypeToken<ArrayList<Client>>(){}.getType();
            listClient = new WriterJson<Client>().read("client.json",userListType);
//            for (Client cust:listClient) {
//                System.out.println(cust.toString());
//            }

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    public static boolean RoomSave(Room room) {
        if(listRoom == null){
            listRoom = new ArrayList<Room>();
            listRoom.add(room);
        }else{
            listRoom.add(room);
        }

        try{
            new WriterJson<Room>().write(listRoom,"Room.json");

            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readRoom() {

        try{

            Type RoomListType = new TypeToken<ArrayList<Room>>(){}.getType();
            listRoom = new WriterJson<Room>().read("Room.json",RoomListType);
            for (Room room1:listRoom) {
                System.out.println(room1.toString());
            }

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    public static boolean saveUser(User user) {
        if(listUser == null){
            listUser = new ArrayList<User>();
            listUser.add(user);
        }else{
            listUser.add(user);
        }
        try{
            new WriterJson<User>().write(listUser,"Users.json");

            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readUser() {

        try{
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            listUser = new WriterJson<User>().read("users.json",userListType);
         /*   for (User user1:listUser) {
                System.out.println(user1.toString());
            }*/

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }


    private static void adminCreate(){
        Permit permiso = new Permit("RESERVATION");//permiso para el modulo reserva
        Permit permiso1 = new Permit("CUSTOMER");//permiso para el modulo clientes
        ArrayList<Permit> permitsADmin = new  ArrayList<Permit>();
        permitsADmin.add(permiso);
        permitsADmin.add(permiso1);
        Rol rolAdmin = new Rol("ADMIN",permitsADmin);
        User userAdmin= new User("Carlos","Figueroa","23321123","1234","Carlos",rolAdmin);
      ///  User userAdmin1= new User("Lucas","luduena","23321123","1234","Lucas",rolAdmin);
        saveUser(userAdmin);
      ///  saveUser(userAdmin1);
    }

    public static boolean userRoom(Room room) {
        listRoom.add(room);
        try{

          /// RoomSave(listRoom);

            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }
    }
    private DataBase() {
    }


}
