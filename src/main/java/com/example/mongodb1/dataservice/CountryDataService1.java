package com.example.mongodb1.dataservice;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.service.CountryService;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CountryDataService1 implements CommandLineRunner {
    Faker faker = new Faker();


    @Autowired
    private CountryService service;


    @Override
    public void run(String... args) throws Exception {
//        MyCountry myCountry1 =
//                new MyCountry(faker.country().name(), faker.number().numberBetween(1000, 100000000L), faker.country().countryCode2());
//        service.addCountry(myCountry1);

//
//        boolean argentina = service.existsByName("Argentina");
//        System.out.println(argentina);
        // Country countrySimple = new Country("A", 1L, "b");

//        IntStream.range(1, 100)
//                .mapToObj(value -> new MyCountry(faker.country().name(), faker.number().numberBetween(1000, 100000000L), faker.country().countryCode2()))
//                .forEach(myCountry -> service.addCountry(myCountry));
      //  service.deleteAll();

        MyCountry c1 = new MyCountry("a", 12343L, "asdf");
        MyCountry c2 = new MyCountry("d", 12343L, "asdf");
        MyCountry c3 = new MyCountry("b", 12343909243L, "asdf");
        MyCountry c4 = new MyCountry("c", 12343334278L, "asdf");
        List<MyCountry> countries = new ArrayList<>(List.of(c1,c2,c3,c4));


       // System.out.println(service.listDistinctCountriesByName("a"));

        int numberOfIterations = 4;

        for (int i = 0; i < numberOfIterations; i++) {
            MyCountry newCountry = countries.get(i);
            // MyCountry newCountry = new MyCountry(faker.country().name(), faker.number().numberBetween(1000, 100000000L), faker.country().countryCode2());
            if(!service.existsByName(newCountry.getName())) {
                service.addCountry(newCountry);
            }
        }
//        List<MyCountry> myCountries = service.queryForAllCountriesGreaterThanPopulation(123439L);
//        System.out.println(myCountries);

        List<MyCountry> allCountries = service.getAllCountries();
        System.out.println(allCountries);
       /* List<MyCountry> argentina = service.findByNameLike("am");
        System.out.println(argentina);*/

 /*       boolean b = service.existsById("6517dc1355410a317710cc0");
        System.out.println(b);*/



    }
}
