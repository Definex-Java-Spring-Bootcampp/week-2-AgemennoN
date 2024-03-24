
package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.BankRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private BankRepository bankRepository = new BankRepository();

    public Bank save(Bank bank) {
        System.out.println("bankRepository: " + bankRepository.hashCode());
        bankRepository.save(bank);
        return bank;
    }

    public List<Bank> getAll() {
        System.out.println("bankRepository: " + bankRepository.hashCode());
        return bankRepository.getAll();
    }

    public Bank getByname(String name) {
        Optional<Bank> foundBank = bankRepository.findByName(name);

        Bank bank = null;

        if (foundBank.isPresent()) {
            bank = foundBank.get();
        }

        return bank;
    }

    public CreditCard saveCreditCard(String name, CreditCard cc) {
        bankRepository.addCreditCardToBank(name, cc);
        return cc;
    }

    public List<CreditCard> getBanksAllCreditCards(String name) {
        return bankRepository.getBanksAllCreditCards(name);
    }
    
    
}
