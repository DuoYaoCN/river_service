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
    public String insertUser(@PathVariable String account, @PathVariable String username, @PathVariable String password, @PathVariable String status){
        return service.insert(new Users(account, username, password, status));
    }

    @GetMapping("/get/{account}")
    public Users getUser(@PathVariable String account){
        return service.select(account);
    }
    @GetMapping("/verify/{account}/{password}")
    public String verify(@PathVariable String account, @PathVariable String password) {
        return service.verify(account, password);
    }

    @DeleteMapping("/delete/{account}")
    public String delete(@PathVariable String account){
        return service.delete(account);
    }

    @PostMapping("/update/{account}/{username}/{password}/{status}")
    public void update(@PathVariable String account, @PathVariable String username, @PathVariable String password, @PathVariable String status){
        service.update(new Users(account, username, password, status));
    }
}
