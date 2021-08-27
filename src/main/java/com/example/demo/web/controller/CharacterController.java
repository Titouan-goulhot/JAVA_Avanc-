package com.example.demo.web.controller;
import com.example.demo.dao.CharacterDaoI;
import com.example.demo.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class CharacterController {


    @Autowired
    private CharacterDaoI characterDao;

    // Affichage liste characters
    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public List  <Character> listCharacter() {
        return characterDao.findAll();
    }
    // Affichage personnage Par ID
    @GetMapping(value = "/characters/{id}")
    public Optional<Character> afficherUnPersonnage(@PathVariable int id) {
        return characterDao.findById(id);
    }

    //ajouter un Personnage
    @PostMapping(value = "/characters")
    public Character ajouterCharacter(@RequestBody Character character) {
        characterDao.save(character);

        return character;

    }

    //Modification Personnage
    @PutMapping(value = "/characters/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable int id, @RequestBody Character character ){
        characterDao.update(character);

        return null;

    }

    // Suppression d'un Personnage
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable int id){
      characterDao.delete(id);
    }

}

