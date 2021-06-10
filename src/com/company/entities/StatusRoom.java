package com.company.entities;

public class StatusRoom {

    private boolean available;
    private String reason;

    public StatusRoom(boolean available, String reaseon) {
        this.available = available;
        this.reason = reaseon;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getReaseon() {
        return reason;
    }

    public void setReaseon(String reaseon) {
        this.reason = reaseon;
    }
}
