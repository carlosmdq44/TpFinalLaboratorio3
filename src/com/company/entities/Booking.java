package com.company.entities;

import java.util.Date;
import java.util.List;

public class Booking {

    private User user; //Login--> en la bd(txt) guarda el usuario actual.
    private Client client; //Client that make the reserve.
    private Date startDate; //un calendar
    private Date endDate;
    private Date checkIn;
    private Date checkOut;
    private List<Room> roomList; //esto es con un comboBox
    private List<Client> listPassengers;
    private int numberOfGuests; //Quantity of guests.
    private ReserveStatus status; //Reserve, confirm, cancel

    public Booking(User user, Client client, Date startDate, Date endDate, List<Room> roomList, List<Client> listPassengers, int numberOfGuests) {
        this.user = user;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomList = roomList;
        this.listPassengers = listPassengers;
        this.numberOfGuests = numberOfGuests;
        this.status=ReserveStatus.CONFIRM;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Client> getListPassengers() {
        return listPassengers;
    }

    public void setListPassengers(List<Client> listPassengers) {
        this.listPassengers = listPassengers;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public ReserveStatus getStatus() {
        return status;
    }

    public void setStatus(ReserveStatus status) {
        this.status = status;
    }

    public String getDni(){
        return getClient().getDni();

    }


/*    public Booking(User user, List<Room> roomList, Date startDate, Date endDate, int passengersNumber, Client client, List<Client> listPassengers, int numberOfGuests) {
        this.user = user;
        this.roomList = roomList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.passengersNumber = passengersNumber;
        this.client = client;
        this.listPassengers = listPassengers;
        this.numberOfGuests = numberOfGuests;
        this.status=ReserveStatus.CONFIRM;
    }*/
}
