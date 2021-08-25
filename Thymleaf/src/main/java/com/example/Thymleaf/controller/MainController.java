package com.example.Thymleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Thymleaf.form.PersonnageForm;
import com.example.Thymleaf.model.Personnage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MainController{

    private static List <Personnage> personnages = new ArrayList<>();

    static {
        personnages.add(new Personnage("Jhon", "Doe", "warrior", 8));
        personnages.add(new Personnage("Robby", "Williams", "wizard",12));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/characterList" }, method = RequestMethod.GET)
    public String characterList(Model model) {

        model.addAttribute("personnages", personnages);

        return "characterList";
    }

//    @RequestMapping(value = { " /characterDetails/{id}"})
//    public Optional<Personnage>afficherUnPersonnage(@PathVariable int id){
//        return
//    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.GET)
    public String showAddCharacterPage(Model model) {

        PersonnageForm personnageForm = new PersonnageForm();
        model.addAttribute("personnageForm", personnageForm);
        return "addCharacter";
    }
    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.POST)

    public String savePerson(Model model,

     @ModelAttribute("personnageForm") PersonnageForm personnageForm) {

        String firstName = personnageForm.getFirstName();
        String lastName = personnageForm.getLastName();
        String characterClass = personnageForm.getCharacterClass();
        int health = personnageForm.getHealth();

        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0
               ) {
            Personnage newPerson = new Personnage(firstName, lastName, characterClass, health);
            personnages.add(newPerson);

            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }

}