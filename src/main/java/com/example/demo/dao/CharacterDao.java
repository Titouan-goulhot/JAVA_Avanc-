package com.example.demo.dao;
import com.example.demo.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CharacterDao extends JpaRepository<Personnage, Integer> {

    public List <Personnage>  findAll();
    public Optional<Personnage> findById(Integer id);
    public Personnage save(Personnage character);
//    public ResponseEntity update(Personnage character);
    public void deleteById(Integer id);


}
