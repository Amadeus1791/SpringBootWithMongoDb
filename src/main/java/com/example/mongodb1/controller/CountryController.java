package com.example.mongodb1.controller;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/country")
@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    List<MyCountry> getCountries() {
        return countryService.getAllCountries();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    MyCountry postCountry(MyCountry myCountry) {
        return countryService.addCountry(myCountry);
    }



}
