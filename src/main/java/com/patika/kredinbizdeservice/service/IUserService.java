package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Product;
import com.patika.kredinbizdeservice.model.User;

import java.util.List;

public interface IUserService {
    User save(User user);

    List<User> getAll();

    User getByEmail(String email);
    
    User update(String email, User user);

    List<Application> getApplicationsByEmail(String email);
    
    Application createApplication(String email, Product product);
}