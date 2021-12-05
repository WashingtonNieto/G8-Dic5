package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.repositories.CRUD.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private IUserCrudRepository userCrudRepository;

    public List<User> getAll()
    {
        return userCrudRepository.findAll();
    }

}
