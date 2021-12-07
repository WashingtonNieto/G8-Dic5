package com.g8Dic5.demo.repositories.CRUD;

import com.g8Dic5.demo.models.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IClotheCrudRepository extends MongoRepository<Clothe, String> {
    Optional<Clothe> findByReference(String reference);
}
