package com.company.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Rol {

    private String description; //  ADMIN,RECEPCIONISTA,PASAJERO
    ArrayList<Permit> permits;

    public Rol(String description, ArrayList<Permit> permits) {
        this.description = description;
        this.permits = permits;
    }

    public Rol(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Permit> getPermits() {
        return permits;
    }

    public void setPermits(ArrayList<Permit> permits) {
        this.permits = permits;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "description='" + description + '\'' +
                ", permits=" + permits +
                '}';
    }
}

