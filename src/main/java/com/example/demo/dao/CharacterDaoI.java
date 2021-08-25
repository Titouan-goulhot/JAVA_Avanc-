package com.example.demo.dao;
import com.example.demo.model.Character;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDaoI implements CharacterDao {

    private static List<Character> liste_characters = new ArrayList<>(
            List.of(
                    new Character(0, "Alonzo", "wizard", 12),
                    new Character(1, "Pipoudou", "warrior", 10),
                    new Character(2, "René La taupe", "wizard", 14),
                    new Character(3, "No One", "warrior", 13),
                    new Character(4, "Alphonse", "warrior", 10),
                    new Character(5, "Patrick", "wizard", 16)
            )
    );

    public List<Character> findAll() {
        return liste_characters;
    }


    public Optional<Character> findById(int id) {
        for (Character character : liste_characters){
            if(character.getId() == id){
                return Optional.of(character);
            }
        }
        return Optional.empty();
    }


    public Character save(Character character) {
        liste_characters.add(character);
        return character;
    }


    public ResponseEntity update(Character character) {
        findById(character.getId()).ifPresent(c -> {
            c.setName(character.getName());
        } );


//        if (findById(character.getId()).isPresent()) {
//            findById(character.getId()).setName(character.getName());
//            findById(character.getId()).setCharacterClass(character.getCharacterClass());
//            findById(character.getId()).setLife(character.getLife());
//        }
        return findById(character.getId()).isPresent()
                ? new ResponseEntity(character, HttpStatus.OK)
                : new ResponseEntity("Le personnage à mettre à jour n'existe pas", HttpStatus.BAD_REQUEST);
    }


    public Character delete(int id) {
        liste_characters.remove(id);
        return null;
    }




}
