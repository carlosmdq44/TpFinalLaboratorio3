package com.company.entities;

public class User extends Person{
    private String userName;
    private String password;
    private Rol rol;

    public User(String name, String lastName, String dni,String password, String userName, Rol rol) {
        super(name, lastName, dni);
        this.password = password;
        this.userName = userName;
        this.rol = rol;
    }

    public User(String name, String lastName, String dni, String userName,String password) {
        super(name, lastName, dni);
        this.password = password;
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String  password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User{" +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", rol=" + rol +
                "} " + super.toString();
    }

    public void chargeUser() {

    }

}
