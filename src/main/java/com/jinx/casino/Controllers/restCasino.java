package com.jinx.casino.Controllers;

import com.jinx.casino.Documents.Account;
import com.jinx.casino.Documents.BllCasino;
import com.jinx.casino.Models.Player;
import com.jinx.casino.Poker.Controller;
import com.jinx.casino.Shared.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/casino")
public class restCasino {

@Autowired
BllCasino bll = new BllCasino();

    @RequestMapping("hello")
    public String hello(){
        return "Hello I work Now";
    }

    @RequestMapping(path="/signup", method = RequestMethod.POST)
    public String addAccount(@RequestBody String email,@RequestBody String username, @RequestBody String password){
    Account account = new Account();
    account.setUsername(username);
    account.setEmail(email);
    account.setPassword(password);
    account.setCurrency(1000);
    account.setPlayer(new Player());

     bll.add(account);
     return("Saved");
    }

//    @RequestMapping(path="/login", method = RequestMethod.POST)
//    public void loginAccount(@RequestBody String username, @RequestBody String password){
//
//
//
//    }
    @RequestMapping(path = "/poker")
    public void pokerGame(@RequestBody Deck.Card[] player1,@RequestBody Deck.Card[] player2){
    Controller poker = new Controller();
    poker.checkForWin(player1,player2);

    }



}
