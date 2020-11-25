package com.example.Magazyn.repository;

import com.example.Magazyn.models.Magazyn;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MagazynRepository extends MongoRepository<Magazyn, Integer> {
}
