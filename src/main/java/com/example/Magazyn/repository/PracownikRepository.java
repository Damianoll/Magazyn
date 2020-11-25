package com.example.Magazyn.repository;

import com.example.Magazyn.models.Pracownik;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PracownikRepository extends MongoRepository<Pracownik, Integer> {
}
