package com.jinx.casino.Documents;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.jinx.casino.Models.Player;
import com.jinx.casino.Models.Ticket;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;

@Document("Account")
public class Account {

    @Id
    String Id;

    Player player;
    String email;
    String username;
    String password;
    int currency;

    int BlackJackWins;
    int RoultteWins;
    int BacklashWins;
    int PokerWins;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

}
