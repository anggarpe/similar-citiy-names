package com.angpe.city;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

class CityTest {
    List<String> cities;

    City city = new City();

    @BeforeEach
    public void init(){

        cities.add("Yogyakarta");
        cities.add("Surakarta");
    }

//    @Test
    void main() {
        City.main(new String[] {});
    }

    @Test
    void addSimilarCities() {
        Mockito.doNothing().when(city);
    }
}