package com.Pro150.Casino.Controllers;

import com.Pro150.Casino.Documents.Account;
import com.Pro150.Casino.Documents.BllCasino;
import Models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/casino")
public class RestController {

@Autowired
BllCasino bll = new BllCasino();

    @RequestMapping("hello")
    public String hello(){
        return "Hello I work Now";
    }

    @RequestMapping(path="/AccountCreation")
    public String addAccount(){
    Account base = new Account();
    base.setUsername("default");
    base.setPassword("default");
    base.setCurrency(1000);
    base.setPlayer(new Player());

    return bll.add(base);
    }


}