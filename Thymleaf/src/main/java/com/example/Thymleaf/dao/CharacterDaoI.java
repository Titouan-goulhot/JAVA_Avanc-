package com.example.Thymleaf.dao;
import com.example.Thymleaf.model.Personnage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public class CharacterDaoI implements CharacterDao {

    private static List <Personnage> personnagesList = new ArrayList<>(


            List.of(

                    new Personnage("Jhon", "warrior", 8, 0),
                    new Personnage("Robby", "wizard",12, 1)
            )
    );
    public List<Personnage> findAll() {
        return personnagesList;
    }


    public Optional<Personnage> findById(int id) {
        for (Personnage character : personnagesList){
            if(character.getId() == id){
                return Optional.of(character);
            }
        }
        return Optional.empty();
    }


    @Override
    public ResponseEntity update(Personnage character) {
        return null;
    }

    @Override
    public Personnage deleteById(int id) {
        return null;
    }


    public Personnage save(Personnage character) {
        personnagesList.add(character);
        return character;
    }

}
