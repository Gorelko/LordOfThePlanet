package com.gorelko.ntiteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping("/")
    public String page1(
    ) {
        return "lord";
    }

    @GetMapping("/createLord")
    public String page2(
    ) {
        return "lord";
    }

    @GetMapping("/createPlanet")
    public String page3(
    ) {
        return "planet";
    }

    @GetMapping("/delplanet")
    public String page4(
    ) {
        return "delplanet";
    }

    @GetMapping("/toplords")
    public String page5(
    ) {
        return "toplords";
    }

    @GetMapping("/badloards")
    public String page6(
    ) {
        return "badloards";
    }

    @GetMapping("/lordplanet")
    public String page7(
    ) {
        return "lordplanet";
    }
}

