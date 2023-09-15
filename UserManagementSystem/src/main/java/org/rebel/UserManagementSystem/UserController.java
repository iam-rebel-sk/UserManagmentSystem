package org.rebel.UserManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    List<User> myUser;



    @PostMapping("user")
    public String addUser( @RequestBody User newUser) {
        myUser.add(newUser);
        return "New User added successfully";
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        for (User user : myUser) {
            if (user.getUserId().equals(id)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("user")
    public List<User> getAllUser(){
        return myUser;
    }

    @PutMapping("user/{userId}")
    public String setUserUpdate(@PathVariable Integer userId, @RequestBody User updatedUser)
    {
        for(User user : myUser)
        {
            if(user.getUserId().equals(userId))
            {
                user.setName(updatedUser.getName());
                user.setUserName(updatedUser.getUserName());
                user.setAddress(updatedUser.getAddress());
                user.setPhoneNumber(updatedUser.getPhoneNumber());

                return "User with ID " + userId + " updated successfully";
            }
        }

        return "Invalid id";
    }

    @DeleteMapping("user/{id}")
    public String removeUser(@PathVariable Integer id)
    {
        for(User user : myUser)
        {
            if(user.getUserId().equals(id))
            {
                myUser.remove(user);
                return "User with ID "   + id  + " removed successfully";
            }
        }

        return "Invalid id";
    }

}
