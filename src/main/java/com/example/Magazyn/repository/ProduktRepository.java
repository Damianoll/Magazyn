package com.example.Magazyn.repository;

import com.example.Magazyn.models.Produkt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduktRepository extends MongoRepository<Produkt, Integer> {
}
