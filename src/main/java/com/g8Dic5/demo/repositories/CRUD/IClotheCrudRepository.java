package com.g8Dic5.demo.repositories.CRUD;

import com.g8Dic5.demo.models.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClotheCrudRepository extends MongoRepository<Clothe, String> {
    Optional<Clothe> findByReference(String reference);
    public List<Clothe> findByPriceLessThanEqual(double precio);

    //Reto5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Clothe> findByDescriptionLike(String description);
}
