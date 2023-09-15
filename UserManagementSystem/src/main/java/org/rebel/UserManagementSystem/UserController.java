package org.rebel.UserManagementSystem;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    List<Users> myUser;



    @PostMapping("add")
    public String addUser( @RequestBody Users newUser) {
        myUser.add(newUser);
        return "New User added successfully";
    }

    @GetMapping("get")
    public List<Users> getUser(){
        return myUser;
    }
}
