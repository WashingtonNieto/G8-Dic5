package com.g8Dic5.demo.controllers;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id).orElse(null);
    }

    @GetMapping("/emailexist/{email}")
    public User getByEmail(@PathVariable String email){
        return userService.getByEmail(email).orElse(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user){
        User u = userService.update(user);
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<User> post(@RequestBody User user){
        User u = userService.save(user);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
