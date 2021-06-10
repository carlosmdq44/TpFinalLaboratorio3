package com.company.entities;

import com.company.database.DataBase;
import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Hotel {

    private  ArrayList<Room> listRoom;

    private  ArrayList<Booking> listBooking;
   //Book
    public ArrayList<Room> listRoomUnAvailable(){

        listRoom= DataBase.getListRoom();
        ArrayList<Room> listRooms = new ArrayList<Room>();
        for (Room room :listRoom){

            if(!room.getStatus().isAvailable()){
                listRooms.add(room);
            }

        }



        return listRooms;

    }

    public ArrayList<Room> listRoomAvailable(){

        listRoom= DataBase.getListRoom();
        ArrayList<Room> listRooms = new ArrayList<Room>();
        for (Room room :listRoom){

            if(room.getStatus().isAvailable()){
                listRooms.add(room);
            }

        }



        return listRooms;

    }

    //This mhetod execute in Booking
    public ArrayList<Room> listRoomAvailableDates(Date _start, Date _end){

        ArrayList<Room> listRoomUnvailable = new ArrayList<Room>();
        ArrayList<Room> listRoomAvailable = listRoomAvailable();
        for (Booking book :getListBooking()) { //recorro las listas de reservas

            if(book.getStatus()==ReserveStatus.CONFIRM || book.getStatus()==ReserveStatus.CHECKIN ){


            DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();

            int cmpStart = dateTimeComparator.compare(_start, book.getStartDate());
            int cmpStartEnd = dateTimeComparator.compare(_start, book.getEndDate());
            int cmpEnd = dateTimeComparator.compare(_end, book.getStartDate());
            int cmpEndEnd =dateTimeComparator.compare(_end, book.getEndDate());


            //Coincide con la reserva
            if( (cmpStart < 0 && cmpEndEnd > 0) || (cmpStart >=0 && cmpStartEnd<0) ||( cmpEnd>0 && cmpEndEnd<=0) ){

                for (Room room :book.getRoomList()) {
                    listRoomUnvailable.add(room);
                }
            }

            }

        }

        HashSet<Room> hSetNumbers = new HashSet(listRoomUnvailable);
        listRoomUnvailable.clear();
        listRoomUnvailable.addAll(hSetNumbers);//remove duplicates

        listRoomAvailable.removeAll(listRoomUnvailable);

        return listRoomAvailable;
    }

    public ArrayList<Booking> getListBooking() {

        listBooking =DataBase.getBookings();
        return listBooking;
    }


    public ArrayList<Booking> searchBookings(String param){

        ArrayList<Booking> search = new ArrayList<Booking>();
        for (Booking book:getListBooking()) {
            if ( book.getClient().getName().toLowerCase().contains(param.toLowerCase()) || book.getClient().getLastName().toLowerCase().contains(param.toLowerCase()) ||
                    book.getClient().getDni().toLowerCase().contains(param.toLowerCase())){
                search.add(book);

            }

        }
        return search;
    }
}
