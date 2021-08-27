package com.example.Thymleaf.controller;
import java.util.List;

import com.example.Thymleaf.dao.CharacterDao;
import com.example.Thymleaf.form.PersonnageForm;
import com.example.Thymleaf.model.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class MainController {

    @Autowired
    private CharacterDao characterDao;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    private String url = "http://localhost:8080/characters/";

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    //
    @RequestMapping(value = {"/characterList"}, method = RequestMethod.GET)

    public String characterList(Model model) {

        List<Personnage> characters = restTemplate.getForObject(url,List.class);
        model.addAttribute("Personnage", characters);
        return "characterList";

    }

    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.GET)
    public String showAddCharacterPage(Model model) {


        PersonnageForm personnageForm = new PersonnageForm();
        model.addAttribute("personnageForm", personnageForm);
        return "addCharacter";
    }


    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personnageForm") PersonnageForm personnageForm) {
        PersonnageForm characters = restTemplate.postForObject(url, personnageForm, PersonnageForm.class );
        String name = personnageForm.getName();
        String characterClass = personnageForm.getCharacterClass();
        int life = personnageForm.getLife();

        if (name != null && name.length() > 0 //
        ) {

            //Récupérer l'ID max de la la liste des Personnage du DAO // Pour obtenir un ID = 1+max avec l'incrémentation
            int max = characterDao.findAll().stream()
                    .map(personnage -> personnage.getId())
                    .max(Integer::compare)
                    .orElse(0);

            int id = max + 1;
            Personnage newPerson = new Personnage( name ,characterClass, life, id);
            characterDao.save(newPerson);

            return "redirect:/characterList";

        }
        model.addAttribute("errorMessage",errorMessage);
        return"addCharacter";
    }

        // Affichage personnage Par ID
        @GetMapping(value = "/characterDetails/{id}")

        public String afficherUnPersonnage(@PathVariable int id, Model model) {
            Personnage characters = restTemplate.getForObject(url+id,Personnage.class);

        //En ayant un findByID Optional -> il nous return l'ID
        model.addAttribute("personnage", characters);
            return "characterDetails";
        }

}