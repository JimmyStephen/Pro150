package com.Pro150.Casino.Documents;

import com.Pro150.Casino.Service.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BllCasino {

    @Autowired
    private AccountRepository repo;


        public String add(Account account){
        repo.save(account);
        return account.Id;
        }

        public String delete(Account account){

            repo.delete(account);

            return account.getUsername();
        }

    }
