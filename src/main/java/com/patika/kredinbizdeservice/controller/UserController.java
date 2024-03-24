package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.model.HouseLoan;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.model.VehicleLoan;
import com.patika.kredinbizdeservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    // create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        System.out.println("userService: " + userService.hashCode());
        return userService.save(user);
    }

    /*
    get all users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user) {

        User user1 = userService.update(email, user);

        if (user1 != null){
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{email}/application")
    public ResponseEntity<List<Application>> getApplicationsByEmail(@PathVariable String email) {
        List<Application> appList = userService.getApplicationsByEmail(email);

        if (appList != null){
            return ResponseEntity.ok().body(appList);
        }

        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{email}/application/creditCard")
    public ResponseEntity<Application> applicationCreditCard(@PathVariable String email, @RequestBody CreditCard creditCard) {

        User user = userService.getByEmail(email);
        if (user != null){
            Application new_application = userService.createApplication(email, creditCard);
            return ResponseEntity.ok().body(new_application);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{email}/application/loan/vehicle")
    public ResponseEntity<Application> applicationLoanVehicle(@PathVariable String email, @RequestBody VehicleLoan loan) {

        User user = userService.getByEmail(email);
        if (user != null){
            Application new_application = userService.createApplication(email, loan);
            return ResponseEntity.ok().body(new_application);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{email}/application/loan/house")
    public ResponseEntity<Application> applicationLoanHouse(@PathVariable String email, @RequestBody HouseLoan loan) {

        User user = userService.getByEmail(email);
        if (user != null){
            Application new_application = userService.createApplication(email, loan);
            return ResponseEntity.ok().body(new_application);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{email}/application/loan/consumer")
    public ResponseEntity<Application> applicationLoanConsumer(@PathVariable String email, @RequestBody ConsumerLoan loan) {

        User user = userService.getByEmail(email);
        if (user != null){
            Application new_application = userService.createApplication(email, loan);
            return ResponseEntity.ok().body(new_application);
        }
        return ResponseEntity.notFound().build();
    }


}
