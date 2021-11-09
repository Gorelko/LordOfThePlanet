package com.gorelko.ntiteam.service;

import com.gorelko.ntiteam.model.Planet;
import com.gorelko.ntiteam.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public void createPlanet(String name) {
        if (!name.equals("")) {

            Planet planet = new Planet();
            planet.setName(name);

            List<Planet> listPlanet = planetRepository.findAll();

            boolean twin = false;

            for (Planet planet1 : listPlanet) {
                if (planet1.getName().equals(planet.getName())) {
                    twin = true;
                    break;
                }
            }

            if (twin == false)
                planetRepository.save(planet);
        }
    }

    public void deletePlanet(String name) {
        System.out.println(name);
        planetRepository.delPlanet(name);
    }

}
