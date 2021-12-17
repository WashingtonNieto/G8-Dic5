package com.g8Dic5.demo.controllers;

import com.g8Dic5.demo.models.Clothe;
import com.g8Dic5.demo.services.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")

public class ClotheController {

    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll(){
        return clotheService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference") String reference){
        return clotheService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe){
        return clotheService.create(clothe);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe){
        return clotheService.update(clothe);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }

    //Reto 5
    @GetMapping("/price/{price}")
    public List<Clothe> clotheGetByPrice(@PathVariable("price") double precio){
        return clotheService.clotheGetByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Clothe> findByDescriptionLike(@PathVariable("description") String description){
        return clotheService.findByDescriptionLike(description);
    }


}
