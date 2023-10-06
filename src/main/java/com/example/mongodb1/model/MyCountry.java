package com.example.mongodb1.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "country")
public class MyCountry {
    @Id
    private String id;

    @Field(name = "countryname")
    private String name;

    private Long population;

    private String shortcut;

    //private Capital capital;

    public MyCountry(String name, Long population, String shortcut) {
        this.name = name;
        this.population = population;
        this.shortcut = shortcut;
    }


}
