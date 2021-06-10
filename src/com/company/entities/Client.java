package com.company.entities;

import java.io.Serializable;

public class Client extends Person {
    private String phone;
    private String email;
    private String adress;


    public Client(){
        super();
    }

    public Client(String phone, String email, String adress) {
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public Client(String name, String lastName, String dni, String phone, String email, String adress) {
        super(name, lastName, dni);
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDni() {
        return super.getDni();
    }

    public String name(){

        return super.getName() + " " +super.getLastName();
    }
}
