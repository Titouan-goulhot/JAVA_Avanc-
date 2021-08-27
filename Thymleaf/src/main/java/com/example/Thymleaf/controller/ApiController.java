package com.example.Thymleaf.controller;

import com.example.Thymleaf.model.PersonnageFromApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080/characters/";

    @GetMapping("/characters")
    public List<Object> getPersonnages(){

       List characters = restTemplate.getForObject(url,List.class);
        return Arrays.asList(characters);
    }


}
