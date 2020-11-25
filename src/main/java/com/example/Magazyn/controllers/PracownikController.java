package com.example.Magazyn.controllers;

import com.example.Magazyn.models.Pracownik;
import com.example.Magazyn.repository.PracownikRepository;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping({"/pracownik"})
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PracownikController {

    @Autowired
    private PracownikRepository pracownikRepository;


    @GetMapping(produces = "application/json")
    public List<Pracownik> getPracownik(){
        List<Pracownik> temp = pracownikRepository.findAll();
        temp.sort(Comparator.comparing(Pracownik::getDataZatrudnienia).thenComparing(Pracownik::getImie));
        return temp;
    }

    @GetMapping(produces = "application/json", path = {"/{id}"})
    public Pracownik getPracownikById(@PathVariable int id){
        Pracownik temp = pracownikRepository.findById(id).get();
        return temp;
    }

    @PostMapping
    public Pracownik createPracownik(@RequestBody Pracownik pracownik){
        pracownik.setPracownikId(findUnusedId());
        pracownikRepository.save(pracownik);
        return pracownik;
    }

    @PutMapping(path = {"/{id}"})
    public Pracownik updatePracownik(@PathVariable("id") int id, @RequestBody Pracownik pracownik){
        Pracownik tmp = pracownikRepository.findById(id).get();
        tmp.setNazwisko(pracownik.getNazwisko());
        tmp.setImie(pracownik.getImie());
        tmp.setDataZatrudnienia(pracownik.getDataZatrudnienia());
        tmp.setStanowisko(pracownik.getStanowisko());
        tmp.setMagazynId(pracownik.getMagazynId());
        pracownikRepository.deleteById(id);
        pracownikRepository.save(tmp);
        return tmp;

    }

    @DeleteMapping(path = {"/{id}"})
    public Pracownik deletePracownik(@PathVariable int id){
        Pracownik pracownik = pracownikRepository.findById(id).get();
        pracownikRepository.deleteById(id);
        return pracownik;
    }

    public int findUnusedId(){
        int i = 0;
        while( pracownikRepository.existsById(i)){
            i++;
        }
        return i;
    }
}
