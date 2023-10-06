package com.example.mongodb1.service;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.repo.CountryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MATCHER;
import static org.mockito.Mockito.when;

class CountryServiceTest {

    @Mock
    private CountryRepo countryRepo;


    @InjectMocks
    private CountryService countryService;

    MyCountry c1;
    MyCountry c2;
    MyCountry c3;
    MyCountry c4;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        c1 = new MyCountry("a", 12343L, "asdf");
        c2 = new MyCountry("d", 12343L, "asdf");
        c3 = new MyCountry("b", 12343909243L, "asdf");
        c4 = new MyCountry("c", 12343334278L, "asdf");
    }

    @Test
    void getAllCountries() {
        // given
        when(countryRepo.findAll()).thenReturn(List.of(c1, c2, c3, c4));

        // when
        List<MyCountry> allCountries = countryService.getAllCountries();

        // then
        assertThat(allCountries).isEqualTo(List.of(c1, c2, c3, c4));
    }

    @Test
    void addCountry() {
        // given
        when(countryRepo.save(c1)).thenReturn(c1);
        // when
        String id = countryService.addCountry(c1);
        // then
        assertThat(id).isEqualTo(c1.getId());
    }

    @Test
    void findByName() {
    }

    @Test
    void findByNameLike() {
    }

    @Test
    void existsById() {
    }

    @Test
    void existsByName() {
    }

    @Test
    void queryForAllCountriesGreaterThanPopulation() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findByPopulationIsBetweenOrderByPopulation() {
    }
}