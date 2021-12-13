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

    public List<User> getAll()
    {
        return userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
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

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }





}
