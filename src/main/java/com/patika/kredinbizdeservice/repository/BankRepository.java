
package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BankRepository {

    private List<Bank> bankList = new ArrayList<>();
    
    public void save(Bank bank) {
        if (bank.getCreditCards() == null){
           bank.setCreditCards(new ArrayList<>());
        }
        if (bank.getLoanList()== null){
           bank.setLoanList(new ArrayList<>());
        }
        bankList.add(bank);
    }

    public List<Bank> getAll() {
        return bankList;
    }

    public Optional<Bank> findByName(String name) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(name))
                .findFirst();
    }
    
    public void addCreditCardToBank(String name, CreditCard cc){
        Optional<Bank> optionalBank = findByName(name);

        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            List<CreditCard> ccList = bank.getCreditCards();

            ccList.add(cc);
        } else {
            // Handle the case where no bank with the specified name is found
            System.out.println("No bank found with name: " + name);
        }
    }

    public List<CreditCard> getBanksAllCreditCards(String name) {
        Optional<Bank> optionalBank = findByName(name);
        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            return bank.getCreditCards();
        }
        else{
            return null;
        }
    }
}
