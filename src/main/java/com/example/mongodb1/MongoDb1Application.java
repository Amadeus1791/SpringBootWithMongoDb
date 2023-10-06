package com.example.mongodb1;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.service.CountryService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.IntStream;


@SpringBootApplication
public class MongoDb1Application {



    public static void main(String[] args) {
        SpringApplication.run(MongoDb1Application.class, args);
    }



}
