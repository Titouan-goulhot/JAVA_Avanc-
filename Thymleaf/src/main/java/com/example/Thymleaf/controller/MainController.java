package com.example.Thymleaf.controller;
import java.util.Optional;
import com.example.Thymleaf.dao.CharacterDao;
import com.example.Thymleaf.form.PersonnageForm;
import com.example.Thymleaf.model.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController{

    @Autowired
    private  CharacterDao characterDao;

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

//
    @RequestMapping(value = { "/characterList" }, method = RequestMethod.GET)
    public String characterList(Model model) {
        model.addAttribute("Personnage", characterDao.findAll());
        return "characterList";

    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.GET)
    public String showAddCharacterPage(Model model) {

        PersonnageForm personnageForm = new PersonnageForm();
        model.addAttribute("personnageForm", personnageForm);
        return "addCharacter";
    }



    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("personnageForm") PersonnageForm personnageForm) {

        String firstName = personnageForm.getFirstName();
        String lastName = personnageForm.getLastName();
        String characterClass = personnageForm.getCharacterClass();
        int health = personnageForm.getHealth();

        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0
        ) {

            //Récupérer l'ID max de la la liste des Personnage du DAO // Pour obtenir un ID = 1+max avec l'incrémentation
            int max = characterDao.findAll().stream()
                        .map(personnage -> personnage.getId())
                        .max(Integer::compare)
                        .orElse(0);


            int id = max+1;
            Personnage newPerson = new Personnage(firstName, lastName, characterClass, health, id);
            characterDao.save(newPerson);


        }
        return "redirect:/characterList";
    }


        // Affichage personnage Par ID
        @GetMapping(value = "/characterDetails/{id}")
        public String afficherUnPersonnage(@PathVariable int id, Model model) {
        //En ayant un findByID Optional -> il nous return l'ID
        model.addAttribute("personnage", characterDao.findById(id).orElse(null));
            return "characterDetails";
        }

}