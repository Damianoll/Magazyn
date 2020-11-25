package com.example.Magazyn.controllers;

import com.example.Magazyn.models.Magazyn;
import com.example.Magazyn.models.Pracownik;
import com.example.Magazyn.repository.MagazynRepository;
import com.example.Magazyn.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RequestMapping({"/magazyn"})
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MagazynController {

    @Autowired
    public MagazynRepository magazynRepository;
    @Autowired
    public PracownikRepository pracownikRepository;

    @GetMapping(produces = "application/json")
    public List<Magazyn> getMagazyny(){
        List<Magazyn> temp = magazynRepository.findAll();
        temp.sort(Comparator.comparing(Magazyn::getNazwa).thenComparing(Magazyn::getAdres));
        return temp;
    }

    @GetMapping(produces = "application/json", path = {"/{id}"})
    public Magazyn getMagazynById(@PathVariable int id){
        Magazyn temp = magazynRepository.findById(id).get();
        return temp;
    }

    @PostMapping
    public Magazyn createMagazyn(@RequestBody Magazyn magazyn){
        magazyn.setIdMagazynu(findUnusedId());
        magazynRepository.save(magazyn);
        return magazyn;
    }

    @PutMapping(path = {"/{id}"})
    public Magazyn updatePracownik(@PathVariable("id") int id, @RequestBody Magazyn magazyn){
        Magazyn tmp = magazynRepository.findById(id).get();
        tmp.setNazwa(magazyn.getNazwa());
        tmp.setAdres(magazyn.getAdres());
        magazynRepository.deleteById(id);
        magazynRepository.save(tmp);
        return tmp;

    }

    @DeleteMapping(path = {"/{id}"})
    public Magazyn deleteMagazyn(@PathVariable int id){
        Magazyn magazyn = magazynRepository.findById(id).get();
        magazynRepository.deleteById(id);
        for(Pracownik pracownik: pracownikRepository.findAll()){
            System.out.println(pracownik.getImie());
            if(pracownik.getMagazynId() == id){
                System.out.println(pracownik.getImie());
                pracownikRepository.delete(pracownik);
            }
        }
        return magazyn;
    }

    public int findUnusedId(){
        int i = 0;
        while( magazynRepository.existsById(i)){
            i++;
        }
        return i;
    }

}
