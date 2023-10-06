package com.example.mongodb1.controller;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("country/query")
@RestController
public class CountryQueryController {
    @Autowired
    private CountryService countryService;

//    @GetMapping("/findbyname")
//    ResponseEntity<MyCountry> queryByName(@RequestParam String name) {
//        List<MyCountry> byName = countryService.findByName(name);
//        return new ResponseEntity<>(byName, HttpStatus.FOUND);
//    }

    @GetMapping("findbypopulationbetween")
    ResponseEntity<List<MyCountry>> findByPopulationIsBetweenOrderByPopulation(long lower, long upper) {
        List<MyCountry> result = countryService.findByPopulationIsBetweenOrderByPopulation(lower, upper);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
