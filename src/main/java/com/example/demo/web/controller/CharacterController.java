package com.example.demo.web.controller;
import com.example.demo.dao.CharacterDao;
import com.example.demo.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class CharacterController {


    @Autowired
    private CharacterDao characterDao;

    @RequestMapping(value = "/Characters", method = RequestMethod.GET)
    public List  <Character> listCharacter() {
        return characterDao.findAll();
    }

    @GetMapping(value = "/Characters/{id}")
    public Character afficherUnPersonnage(@PathVariable int id) {

        return characterDao.findById(id);
    }
}

