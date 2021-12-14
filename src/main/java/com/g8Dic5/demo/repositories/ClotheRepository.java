package com.g8Dic5.demo.repositories;

import com.g8Dic5.demo.models.Clothe;
import com.g8Dic5.demo.repositories.CRUD.IClotheCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClotheRepository {

    @Autowired
    private IClotheCrudRepository clotheCrudRepository;

    public List<Clothe> getAll()
    {
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getClothe(String id){return clotheCrudRepository.findById(id); }

    public Optional<Clothe> getByReference(String reference){
        return clotheCrudRepository.findByReference(reference);
    }

    public Clothe create(Clothe clothe){
        return clotheCrudRepository.save(clothe);
    }

    public void delete(String id){
        clotheCrudRepository.deleteById(id);
    }


}
