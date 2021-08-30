package com.example.Thymleaf.dao;

import com.example.Thymleaf.model.Personnage;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CharacterDao {
    public List<Personnage> findAll();
    public Optional<Personnage> findById(int id);
    public Personnage save(Personnage personnage);
    public ResponseEntity update(Personnage personnage);
    public Personnage deleteById(int id);



}
