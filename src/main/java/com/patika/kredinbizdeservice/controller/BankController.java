
package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/banks")
public class BankController {

    
    @Autowired
    private BankService bankService;
    
    // create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody Bank bank) {
        System.out.println("bankService: " + bankService.hashCode());
        return bankService.save(bank);
    }
    
    @GetMapping
    public List<Bank> getAll() {
        return bankService.getAll();
    }
    
    @GetMapping("/{name}")
    public Bank getByName(@PathVariable String name) {
        return bankService.getByname(name);
    }
    
    @PutMapping("/{name}/creditCard")
    public ResponseEntity<CreditCard> update(@PathVariable String name, @RequestBody CreditCard cc) {

        Bank bank = bankService.getByname(name);
        if (bank != null){
            CreditCard new_cc = bankService.saveCreditCard(name, cc);
            return ResponseEntity.ok().body(new_cc);
        }

        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{name}/creditCard")
    public List<CreditCard> getBanksAllCreditCards(@PathVariable String name) {
        return bankService.getBanksAllCreditCards(name);
    }
}
