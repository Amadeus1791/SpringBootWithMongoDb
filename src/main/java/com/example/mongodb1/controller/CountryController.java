package com.example.mongodb1.controller;

import com.example.mongodb1.model.Country;
import com.example.mongodb1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/country")
@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping("/add")
    String postCountry(Country country) {
        return countryService.addCountry(country);
    }

}
