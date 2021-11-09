package com.gorelko.ntiteam.service;

import com.gorelko.ntiteam.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LordServiceTest {

    @Autowired
    private LordService lordService;

    @Autowired
    private PlanetService planetService;

    @Test
    public void createLord() {
        lordService.createLord(30, "Vladimir");

        int actualAge = lordService.findAll().get(0).getAge();
        String actualString = lordService.findAll().get(0).getName();

        int expectedInt = 30;
        String expectedString = "Vladimir";

        assertEquals(expectedInt, actualAge);
        assertEquals(expectedString, actualString);

    }

    @Test
    public void setPlanetforLord(){

        planetService.createPlanet("Terra");
        List<Planet> listPlanet = planetService.findAll();
        String namePlanet = listPlanet.get(0).getName();

        lordService.createLord(30, "Vladimir");
        int actualAge = lordService.findAll().get(0).getAge();
        String actualString = lordService.findAll().get(0).getName();

        int expectedInt = 30;
        String expectedString = "Vladimir";

        assertEquals(expectedInt, actualAge);
        assertEquals(expectedString, actualString);

        lordService.setPlanetforLord(expectedInt, expectedString, namePlanet);

        String lordPlanet = planetService.findAll().get(0).getLord().getName();

        assertEquals(expectedString, lordPlanet);
    }

    @Test
    public void findLazyLords() {

        lordService.createLord(30, "Vladimir");
        lordService.createLord(20, "Yura");
        lordService.createLord(35, "Den");

        planetService.createPlanet("Terra");
        planetService.createPlanet("Cadia");

        lordService.setPlanetforLord(lordService.findAll().get(0).getAge(), lordService.findAll().get(0).getName(), planetService.findAll().get(0).getName());
        lordService.setPlanetforLord(lordService.findAll().get(1).getAge(), lordService.findAll().get(1).getName(), planetService.findAll().get(1).getName());

        int actualAge = lordService.findLazyLords().get(0).getAge();
        String actualString = lordService.findLazyLords().get(0).getName();

        int expectedInt = 35;
        String expectedString = "Den";

        assertEquals(expectedInt, actualAge);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void findYoungLords() {

        lordService.createLord(30, "Vladimir");
        lordService.createLord(20, "Yura");
        lordService.createLord(35, "Den");
        lordService.createLord(31, "Yura");
        lordService.createLord(22, "Kirill");
        lordService.createLord(23, "Andy");
        lordService.createLord(24, "Slava");
        lordService.createLord(40, "Boris");
        lordService.createLord(35, "Alex");
        lordService.createLord(32, "Masha");
        lordService.createLord(37, "Maria");

        int actualAge = lordService.findYoungLords().get(0).getAge();
        String actualString = lordService.findYoungLords().get(0).getName();

        int expectedInt = 20;
        String expectedString = "Yura";

        int sizeYoung = lordService.findYoungLords().size();

        assertEquals(expectedInt, actualAge);
        assertEquals(expectedString, actualString);
        assertEquals(10, sizeYoung);

    }

}