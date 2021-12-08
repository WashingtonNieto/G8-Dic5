package com.g8Dic5.demo.services;

import com.g8Dic5.demo.models.Clothe;
import com.g8Dic5.demo.repositories.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheService {

    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll()
    {
        return clotheRepository.getAll();
    }

    public Optional<Clothe> getById(String id){
        return clotheRepository.getById(id);
    }

    public Clothe save(Clothe clothe){
        if(clothe.getReference() == null)
            return clothe;
        Optional<Clothe> existeClothe = getById((clothe.getReference()));

        if(existeClothe.isPresent())
            return clothe;

        return clotheRepository.save(clothe);
    }

    public Clothe update(Clothe clothe){
        Optional<Clothe> existeClothe = getById(clothe.getReference());

        if(existeClothe.isEmpty()){
            return clothe;
        }

        existeClothe.get().setReference((clothe.getReference()));
        existeClothe.get().setCategory((clothe.getCategory()));
//        existeClothe.get().setSize((clothe.getSize()));
        existeClothe.get().setDescription((clothe.getDescription()));
        existeClothe.get().setAvailability((clothe.isAvailability()));
        existeClothe.get().setPrice((clothe.getPrice()));
        existeClothe.get().setQuantity((clothe.getQuantity()));
        existeClothe.get().setPhotography((clothe.getPhotography()));
        return clotheRepository.save(existeClothe.get());
    }

    public void delete(String id){
        clotheRepository.delete(id);
    }
}
