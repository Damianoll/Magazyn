package com.example.Magazyn.controllers;

import com.example.Magazyn.models.Produkt;
import com.example.Magazyn.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/produkty"})
public class ProduktController {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping(produces = "application/json")
    public List<Produkt> getProdukt(){
        List<Produkt> temp = produktRepository.findAll();
        return temp;
    }

    @PostMapping(produces = "application/json")
    public Produkt createProdukt(@RequestBody Produkt produkt){
        produkt.setId_produktu(findUnusedId());
        produktRepository.save(produkt);
        return produkt;
    }

    @DeleteMapping(produces = "application/json")
    public Produkt deleteProdukt(@RequestBody Produkt produkt){
        produktRepository.delete(produkt);
        return produkt;
    }

    public int findUnusedId(){
        int i = 0;
        while( produktRepository.existsById(i)){
            i++;
        }
        return i;
    }
}
