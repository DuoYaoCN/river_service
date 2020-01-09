package com.river.controller;


import com.river.domain.Users;
import com.river.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UsersService service;

    @PutMapping("/insert/{account}/{username}/{password}/{status}")
    public void insertUser(@PathVariable String account, @PathVariable String username, @PathVariable String password, @PathVariable String status){
        service.insert(new Users(account, username, password, status));
    }

    @GetMapping("/verify/{account}/{password}")
    public Boolean verify(@PathVariable String account, @PathVariable String password){
        return service.verify(account, password);
    }

    @DeleteMapping("/delete/{account}")
    public void delete(@PathVariable String account){
        service.delete(account);
    }

    @PostMapping("/update/{account}/{username}/{password}/{status}")
    public void update(@PathVariable String account, @PathVariable String username, @PathVariable String password, @PathVariable String status){
        service.update(new Users(account, username, password, status));
    }
}
