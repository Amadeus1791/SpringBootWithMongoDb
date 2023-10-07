package com.example.mongodb1.controller;

import com.example.mongodb1.model.MyCountry;
import com.example.mongodb1.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
class CountryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetCountries() throws Exception {
        //given
        MyCountry c1 = new MyCountry("1", "a", 1L, "ads");
        MyCountry c2 = new MyCountry("2", "b", 1L, "ads");
        List<MyCountry> countryList = List.of(c1, c2);

        when(countryService.getAllCountries()).thenReturn(countryList);

        // when
        ResultActions resultActions = mockMvc.perform(get("/country/all"));

        // then
        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.size()").value((countryList.size())));
    }



    @Test
    void postCountry() throws Exception {
        MyCountry c1 = new MyCountry("1", "a", 1L, "ads");
        given(countryService.addCountry(any(MyCountry.class)))
                .willReturn(c1);

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/country/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c1)));

        // then
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(c1.getId())))
                .andExpect(jsonPath("$.population", is(c1.getPopulation().intValue())))
                .andExpect(jsonPath("$.shortcut", is(c1.getShortcut())));
    }
}