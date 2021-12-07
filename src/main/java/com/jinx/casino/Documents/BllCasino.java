package com.jinx.casino.Documents;

import com.jinx.casino.Service.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BllCasino {

    @Autowired
    private AccountRepository repo;





        public void add(Account account){
        repo.save(account);

        }

        public String delete(Account account){

            repo.delete(account);

            return account.getUsername();
        }


}
