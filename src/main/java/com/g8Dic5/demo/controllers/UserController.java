package com.g8Dic5.demo.controllers;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")


public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping("/{email}/{password}")
    public User autenticateUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticateUsuario(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmails(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {

        return userService.birthtDayList(monthBirthtDay);
    }

}
