package com.example.mongodb1.repo;

import com.example.mongodb1.model.MyCountry;
import com.github.javafaker.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends MongoRepository<MyCountry,String> {



    List<MyCountry> findDistinctTopByName(String name);

    //public List<MyCountry> findD();

    List<MyCountry> findByPopulationGreaterThan(Long num);


    List<MyCountry> findByPopulationIsBetweenOrderByPopulation(Long lower, Long upper);




    public List<MyCountry> findByNameLike(String name);
    //public List<MyCountry> findByNameOrd(String name);
  //  List<MyCountry> find


    boolean existsByName(String name);
}
