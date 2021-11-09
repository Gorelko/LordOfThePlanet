package com.gorelko.ntiteam.controller;

import com.gorelko.ntiteam.model.Planet;
import com.gorelko.ntiteam.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planet")
public class PlanetController {

    private final PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping()
    public List<Planet> getPlanet() {
        return planetService.findAll();
    }

    @PutMapping("/name={name}")
    public List<Planet> setPlanet(@PathVariable("name") String name
    ) {
        planetService.createPlanet(name);
        return planetService.findAll();
    }

    @DeleteMapping("/delete={name}")
    public List<Planet> delPlanet(@PathVariable("name") String name
    ) {
        planetService.deletePlanet(name);
        return planetService.findAll();
    }
}
