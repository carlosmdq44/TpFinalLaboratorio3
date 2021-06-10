package com.company.entities;

public class Room {
    private int roomNumber;
    private int floor;
    private RoomType roomType;
    private StatusRoom status;

    public Room(int roomNumber, int floor, RoomType roomType, StatusRoom status) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomType = roomType;
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public StatusRoom getStatus() {
        return status;
    }

    public void setStatus(StatusRoom status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Room)) {
            return false;
        }

        Room otherMember = (Room)anObject;
        if(otherMember.getRoomNumber()== this.getRoomNumber() && otherMember.getFloor()==this.getFloor()){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return
                "Number=" + roomNumber +
                " Floor=" + floor +
                " RoomType=" + roomType.getDescription();
    }
}
