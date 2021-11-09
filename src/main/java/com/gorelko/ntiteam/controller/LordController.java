package com.gorelko.ntiteam.controller;

import com.gorelko.ntiteam.model.Lord;
import com.gorelko.ntiteam.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lord")
public class LordController {

    private final LordService lordService;

    @Autowired
    public LordController(LordService lordService) {
        this.lordService = lordService;
    }

    @GetMapping()
    public List<Lord> getLord() {
        return lordService.findAll();
    }

    @PutMapping("/agelord={agelord}&namelord={namelord}")
    public List<Lord> setLord(@PathVariable("agelord") int ageLord,
                              @PathVariable("namelord") String nameLord
    ) {
        lordService.createLord(ageLord, nameLord);

        return lordService.findAll();

    }

    @PutMapping("/age={agelord}&name={namelord}&planet={nameplanet}")
    public List<Lord> setPlanetForLord(@PathVariable("agelord") int ageLord,
                                       @PathVariable("namelord") String nameLord,
                                       @PathVariable("nameplanet") String nameplanet
    ) {
        lordService.setPlanetforLord(ageLord, nameLord, nameplanet);
        return lordService.findAll();
    }

    @GetMapping("/lazy")
    public List<Lord> getLazyLord() {
        return lordService.findLazyLords();
    }

    @GetMapping("/young")
    public List<Lord> getYoungLord() {
        return lordService.findYoungLords();
    }

}
