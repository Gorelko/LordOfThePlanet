package com.gorelko.ntiteam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @Test
    public void createPlanet() {
        planetService.createPlanet("Terra");

        String actualString = planetService.findAll().get(0).getName();
        String expectedString = "Terra";

        assertEquals(expectedString, actualString);

    }

    @Test
    public void deletePlanet() {

        planetService.createPlanet("Terra");
        String actualString = planetService.findAll().get(0).getName();
        String expectedString = "Terra";

        assertEquals(expectedString, actualString);

        planetService.deletePlanet("Terra");

        int sizeListPlanet = planetService.findAll().size();

        assertEquals(0, sizeListPlanet);

    }
}