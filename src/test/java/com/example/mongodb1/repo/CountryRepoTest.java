package com.example.mongodb1.repo;

import com.example.mongodb1.model.MyCountry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;


@DataMongoTest
class CountryRepoTest {

    @Autowired
    private CountryRepo countryRepo;
/*    @Autowired
    private MongoTemplate countryRepo;*/

    @BeforeEach
    void setUp() {
        countryRepo.deleteAll();

    }


    @Test
    void testSave() {
        // given: precondition
        MyCountry country = new MyCountry("1", "A", 10L, "z");

        // when: perform action I want to
        MyCountry savedCountry = countryRepo.save(country);
        Optional<MyCountry> byId = countryRepo.findById("1");


        // then: some kind of assert where I check that actual==expected
        Assertions.assertThat(savedCountry).isEqualTo(country);
        Assertions.assertThat(byId.get().getId()).isEqualTo("1");
    }

    @Test
    void testFindAll() {
        // given: precondition
        MyCountry country1 = new MyCountry("1", "A", 10L, "z");
        MyCountry country2 = new MyCountry("2", "A", 10L, "z");
        MyCountry country3 = new MyCountry("3", "A", 10L, "z");
        List<MyCountry> countryList = List.of(country1, country2, country3);

        countryRepo.saveAll(countryList);


        // when: perform action I want to
        List<MyCountry> all = countryRepo.findAll();

        // then: some kind of assert where I check that actual==expected
       // Assertions.assertThat(all).isEqualTo(countryList);
        Assertions.assertThat(all).contains(country1, country2, country3);
        Assertions.assertThat(all).hasSize(3);
     //   Assertions.assertThat(savedCountry).isEqualTo(country);
    }



    @DisplayName("hello I am so cool")
    @Test
    void findDistinctTopByName() {
    }

    @Test
    void findByPopulationGreaterThan() {
        // given: precondition
        MyCountry country1 = new MyCountry("1", "A", 10L, "z");
        MyCountry country2 = new MyCountry("2", "B", 500L, "z");
        MyCountry country3 = new MyCountry("3", "C", 99L, "z");
        MyCountry country4 = new MyCountry("4", "D", 10000L, "z");
        List<MyCountry> countryList = List.of(country1, country2, country3,country4);
        countryRepo.saveAll(countryList);
        Long numberOfPopulation = 100L;


        // when: perform action I want to
        List<MyCountry> all = countryRepo.findByPopulationGreaterThan(numberOfPopulation);

        // then: some kind of assert where I check that actual==expected
        // Assertions.assertThat(all).isEqualTo(countryList);
        Assertions.assertThat(all).contains(country2,country4);
        Assertions.assertThat(all).hasSize(2);
        //   Assertions.assertThat(savedCountry).isEqualTo(country);

    }

    @Test
    void findByPopulationIsBetweenOrderByPopulation() {
    }

    @Test
    void findByNameLike() {
    }

    @Test
    void existsByName() {
    }
}