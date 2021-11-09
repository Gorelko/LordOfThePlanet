package com.gorelko.ntiteam.service;

import com.gorelko.ntiteam.model.Lord;
import com.gorelko.ntiteam.model.Planet;
import com.gorelko.ntiteam.repository.LordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LordService {

    private final LordRepository lordRepository;

    public LordService(LordRepository lordRepository) {
        this.lordRepository = lordRepository;
    }

    public List<Lord> findAll() {
        return lordRepository.findAll();
    }

    public void createLord(int age, String name) {

        if (age > 0 && !name.equals("")) {

            Lord lord = new Lord();
            lord.setAge(age);
            lord.setName(name);

            boolean twin = false;

            List<Lord> listLord = lordRepository.findAll();

            for (Lord lord1 : listLord) {
                if (lord1.getName().equals(lord.getName()) && lord1.getAge() == lord.getAge()) {
                    twin = true;
                    break;
                }
            }

            if (twin == false)
                lordRepository.save(lord);
        }
    }


    public void setPlanetforLord(int ageLord, String nameLord, String namePlanet) {

        List<Lord> listLord = lordRepository.findAll();

        boolean busyPlanet = false;

        for (Lord lord : listLord) {
            List<Planet> planets = lord.getPlanets();

            for (Planet planet : planets) {
                if (planet.getName().equals(namePlanet)) {
                    busyPlanet = true;
                    break;
                }
            }

        }

        if (busyPlanet == false) {
            long id = lordRepository.idLord(ageLord, nameLord);
            lordRepository.setPlanetforLord(id, namePlanet);
        }

    }

    public List<Lord> findLazyLords() {
        return lordRepository.findLazyLords();
    }

    public List<Lord> findYoungLords() {
        return lordRepository.findYoungLords();
    }

}
