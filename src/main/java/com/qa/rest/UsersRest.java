package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.service.UsersService;
import com.qa.repository.domain.Users;
import com.qa.repository.domain.UsersList;
import com.qa.util.Constants;

@RequestMapping(Constants.URL_BASE)
@RestController
public class UsersRest {

    @Autowired
    private UsersService usersService;

    @DeleteMapping(Constants.DELETE_URL)
    public String deleteUser(@PathVariable String username) {
    	return usersService.deleteUser(username);
    }

    @PutMapping(Constants.UPDATE_URL)
    public String updateUser(@RequestBody Users user) {
        return usersService.updateUser(user);
    }

    @PostMapping(Constants.CREATE_BASE+Constants._TRAINEE)
    public String createTrainee(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINEE);
    }
    
    @PostMapping(Constants.CREATE_BASE+Constants._TRAINER)
    public String createTrainer(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINER);
    }
    
    @PostMapping(Constants.CREATE_BASE+Constants._TRAINING_MANAGER)
    public String createTrainingManager(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINING_MANAGER);
    }
    
    @GetMapping(Constants.GET_ALL_URL)
    public UsersList getAllUsers() {
    	UsersList users = new UsersList();
    	users.setAllUsers(usersService.getAllUsers());
    	return users;
    }
    
    @GetMapping(Constants.GET_PASSWORD_URL)
    public String getPasswordByUsername(@PathVariable String username) {
    	return usersService.getPasswordByUsername(username);
    }
    

}
