package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.repositories.CRUD.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private IUserCrudRepository userCrudRepository;

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public List<User> getAll()
    {
        return userCrudRepository.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User user){
        return userCrudRepository.save(user);
    }

    public void update(User user){
        userCrudRepository.save(user);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    //Reto 5
    public List<User> birthtDayList(String monthBirthtDay){
        return userCrudRepository.findByMonthBirthtDate(monthBirthtDay);
    }







}
