package com.Pro150.Casino;

import java.util.ArrayList;

public class Account {

    String username;
    String password;
    int currency;

    ArrayList<Ticket> tickets = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

}
