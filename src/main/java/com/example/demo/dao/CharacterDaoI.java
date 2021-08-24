package com.example.demo.dao;
import com.example.demo.model.Character;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDaoI implements CharacterDao {

    private static List<Character> liste_characters = new ArrayList<>(
            List.of(
                    new Character(1, "Alonzo", "wizard", 12),
                    new Character(2, "Pipoudou", "warrior", 10),
                    new Character(3, "René La taupe", "wizard", 14),
                    new Character(4, "No One", "warrior", 13),
                    new Character(5, "Alphonse", "warrior", 10),
                    new Character(6, "Patrick", "wizard", 16)
            )
    );

@Override
    public List<Character>findAll() {
        return liste_characters;
    }
@Override
    public Character findById(int id) {
        for (Character character : liste_characters){
            if(character.getId() == id){
                return character;
            }
        }
        return null;
    }
@Override
    public Character save(Character character) {
        liste_characters.add(character);
        return null;
    }
}
