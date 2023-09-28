package com.example.mongodb1;

import com.example.mongodb1.model.Country;
import com.example.mongodb1.service.CountryService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MongoDb1Application implements CommandLineRunner {
    Faker faker = new Faker();


    @Autowired
    private CountryService service;


    public static void main(String[] args) {
        SpringApplication.run(MongoDb1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Country country1 =
                new Country(faker.country().name(), faker.number().numberBetween(1000, 100000000L),faker.country().countryCode2());
        Country countrySimple = new Country("A", 1L, "b");
        service.addCountry(countrySimple);
    }

}
