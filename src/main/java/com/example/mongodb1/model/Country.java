package com.example.mongodb1.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class Country {
    @Id
    private String id;

    private String name;

    private Long population;

    private String shortcut;

    //private Capital capital;

    public Country(String name, Long population, String shortcut) {
        this.name = name;
        this.population = population;
        this.shortcut = shortcut;
    }


}
