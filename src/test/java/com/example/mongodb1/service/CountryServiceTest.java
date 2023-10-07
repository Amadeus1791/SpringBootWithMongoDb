package com.example.mongodb1.service;

import com.example.mongodb1.exception.ResourceNotFoundException;
import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.repo.CountryRepo;
import com.github.javafaker.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.MATCHER;
import static org.mockito.Mockito.*;
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
        MyCountry id = countryService.addCountry(c1);
        // then
        assertThat(id).isEqualTo(c1);
    }

    @Test
    void testupdateCountry() {
        // given
        MyCountry oldCountry = new MyCountry("1", "a", 1L, "a");
        MyCountry newCountry = new MyCountry("2", "b", 2L, "a");

        when(countryRepo.findById(oldCountry.getId())).thenReturn(Optional.of(oldCountry));
        when(countryRepo.save(any(MyCountry.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        //String updatedString = "newName";

        // when
        MyCountry country = countryService.updateCountry(newCountry, "1");

        // then
        assertThat(country.getName()).isEqualTo(newCountry.getName());

    }

    @Test
    void testDeleteCountry() {
        // given
        MyCountry oldCountry = new MyCountry("1", "a", 1L, "a");

        when(countryRepo.findById(oldCountry.getId())).thenReturn(Optional.of(oldCountry));

        // when
        countryService.deleteCountry(oldCountry.getId());

        // then
        Mockito.verify(countryRepo,times(1)).delete(oldCountry);
    }

    @Test
    void testDeleteCountryWithException() {
        // given
        MyCountry oldCountry = new MyCountry("1", "a", 1L, "a");

        when(countryRepo.findById(oldCountry.getId())).thenReturn(Optional.empty());

        // when
        //countryService.deleteCountry(oldCountry.getId());

        // then
        assertThatThrownBy(() -> countryService.deleteCountry(oldCountry.getId()))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("this country with the id: " + oldCountry.getId() + "does not exist");

    }


}