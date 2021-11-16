package com.Pro150.Casino;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casino")
public class Controller {


    @RequestMapping("hello")
    public String hello(){
        return "Hello I work Now";
    }

}
