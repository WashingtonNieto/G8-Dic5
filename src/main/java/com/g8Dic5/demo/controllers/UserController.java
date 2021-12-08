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
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id).orElse(null);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }

/*
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        User u = userService.update(user);
        return new ResponseEntity(u, HttpStatus.OK);
    }
*/
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }


    @PostMapping("/new")
    public ResponseEntity<User> post(@RequestBody User user) {
        User u = userService.save(user);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /*
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
*/

}
