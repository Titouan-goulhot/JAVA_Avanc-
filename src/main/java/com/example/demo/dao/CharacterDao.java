package com.example.demo.dao;
import com.example.demo.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CharacterDao extends JpaRepository<Personnage, Integer> {

    // Permet de faire la requête automatiquement gâce à SpringData (étend de JpaRepository)
    public List <Personnage>  findByNameLike(String name);



}
