package com.g8Dic5.demo.repositories.CRUD;

import com.g8Dic5.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IUserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    //List<User> findByBirthDate(Date date);

    Optional<User> findByEmailAndPassword(String email,String password);

    //Reto 5
    List<User> findByMonthBirthtDay(String monthBirthtDay);

    //para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}

