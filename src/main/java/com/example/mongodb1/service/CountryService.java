package com.example.mongodb1.service;

import com.example.mongodb1.exception.ResourceNotFoundException;
import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;



    public List<MyCountry> getAllCountries() {
        return countryRepo.findAll();
    }

    public MyCountry addCountry(MyCountry myCountry) {
        MyCountry newMyCountry = countryRepo.save(myCountry);
        return newMyCountry;
    }

    public MyCountry findCountry(String id) {
        Optional<MyCountry> foundCountry = countryRepo.findById(id);
        if (foundCountry.isEmpty()) {
            throw new ResourceNotFoundException("this country with the id: " + id + "does not exist");
        }
        return foundCountry.get();
    }

    public void deleteCountry(String id) {
        Optional<MyCountry> foundCountry = countryRepo.findById(id);
        if (foundCountry.isEmpty()) {
            throw new ResourceNotFoundException("this country with the id: " + id + "does not exist");
        }
        countryRepo.delete(foundCountry.get());
       // return "this country with the id:  + " +id + " + does not exist";
    }

    public void deleteAllCountries() {
        countryRepo.deleteAll();
    }

    public MyCountry updateCountry(MyCountry newCountry, String id) {
        Optional<MyCountry> foundCountry = countryRepo.findById(id);
        if (foundCountry.isEmpty()) {
            throw new ResourceNotFoundException("this country with the id: " + id + "does not exist");
        }
        MyCountry oldCountry = foundCountry.get();
        oldCountry.setName(newCountry.getName());
        oldCountry.setPopulation(newCountry.getPopulation());
        oldCountry.setShortcut(newCountry.getShortcut());
        return countryRepo.save(oldCountry);
    }





}
