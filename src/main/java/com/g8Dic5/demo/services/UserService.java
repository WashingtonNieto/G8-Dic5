package com.g8Dic5.demo.services;

import com.g8Dic5.demo.models.User;
import com.g8Dic5.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll()
    {
        return userRepository.getAll();
    }
}
