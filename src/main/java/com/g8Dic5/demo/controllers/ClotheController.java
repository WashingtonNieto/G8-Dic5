package com.g8Dic5.demo.controllers;

import com.g8Dic5.demo.models.Clothe;
import com.g8Dic5.demo.services.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothe")
public class ClotheController {

    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll(){
        return clotheService.getAll();
    }

    @GetMapping("/{id}")
    public Clothe getById(@PathVariable String id){
        return clotheService.getById(id).orElse(null);
    }

    @PutMapping("/update/{reference}")
    public ResponseEntity<Clothe> update(@RequestBody Clothe clothe){
        Clothe u = clotheService.update(clothe);
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Clothe> post(@RequestBody Clothe clothe){
        Clothe u = clotheService.save(clothe);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reference}")
    public ResponseEntity delete(@PathVariable String reference) {
        clotheService.delete(reference);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
