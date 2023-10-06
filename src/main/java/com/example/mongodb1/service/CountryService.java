package com.example.mongodb1.service;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;



    public List<MyCountry> getAllCountries() {
        return countryRepo.findAll();
    }

    public String addCountry(MyCountry myCountry) {
        MyCountry newMyCountry = countryRepo.save(myCountry);
        return newMyCountry.getId();
    }


    public List<MyCountry> findByName(String name) {
        return countryRepo.findDistinctTopByName(name);
    }

    public List<MyCountry> findByNameLike(String name) {
        return countryRepo.findByNameLike(name);
    }


    public boolean existsById(String id) {
       return countryRepo.existsById(id);
    }

    public boolean existsByName(String name) {
        return countryRepo.existsByName(name);
    }



    public List<MyCountry> queryForAllCountriesGreaterThanPopulation(Long num) {
        return countryRepo.findByPopulationGreaterThan(num);
    }

    public void deleteAll() {
        countryRepo.deleteAll();
    }

//    public List<MyCountry> listDistinctCountriesByName(String name) {
//        return countryRepo.findDistinctByName(name);
//    }

    // Argentina

    public List<MyCountry> findByPopulationIsBetweenOrderByPopulation(Long lower, Long upper) {
        return countryRepo.findByPopulationIsBetweenOrderByPopulation(lower, upper);
    }




}
