package com.g8Dic5.demo.repositories.CRUD;

import com.g8Dic5.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserCrudRepository extends MongoRepository<User, Integer> {
}
