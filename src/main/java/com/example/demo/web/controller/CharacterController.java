package com.example.demo.web.controller;
import com.example.demo.dao.CharacterDao;
import com.example.demo.model.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class CharacterController {


    @Autowired
    private CharacterDao characterDao;

    // Affichage liste characters
    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public List  <Personnage> listCharacter() {
        return characterDao.findAll();
    }
    // Affichage personnage Par ID
    @GetMapping(value = "/characters/{id}")
    public Optional<Personnage> afficherUnPersonnage(@PathVariable Integer id) {
        return characterDao.findById(id);
    }

    //ajouter un Personnage
    @PostMapping(value = "/characters")
    public Personnage ajouterCharacter(@RequestBody Personnage personnage) {
        characterDao.save(personnage);

        return personnage;

    }

////    //Modification Personnage
//    @PostMapping(value = "/characters/{id}")
//    public @ResponseBody ResponseEntity<Personnage> updateCharacter(@PathVariable Integer id, @RequestBody Personnage personnage){
//        characterDao.save(personnage);
//
//        return null;
//
//    }

    // Suppression d'un Personnage
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable Integer id){
      characterDao.deleteById(id);
    }

}

