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

    public Optional<User> getById(Integer id){
        return userCrudRepository.findById(id);
    }

    public Optional<User> getByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }

    public User save(User user){
        return userCrudRepository.save(user);
    }

    public void delete(Integer id){
        userCrudRepository.deleteById(id);
    }


}
