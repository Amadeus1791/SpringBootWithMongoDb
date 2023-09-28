package com.example.mongodb1.service;

import com.example.mongodb1.model.Country;
import com.example.mongodb1.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;



    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    public String addCountry(Country country) {
        Country newCountry = countryRepo.save(country);
        return newCountry.getId();
    }


}
