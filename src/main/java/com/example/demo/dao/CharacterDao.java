package com.example.demo.dao;
import com.example.demo.model.Character;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface CharacterDao {

    public List <Character>  findAll();
    public Optional<Character> findById(int id);
    public Character save(Character character);
    public ResponseEntity update(Character character);
    public Character delete(int id);


}
