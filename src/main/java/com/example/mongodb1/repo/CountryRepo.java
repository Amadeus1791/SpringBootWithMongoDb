package com.example.mongodb1.repo;

import com.example.mongodb1.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends MongoRepository<Country,String> {
}
