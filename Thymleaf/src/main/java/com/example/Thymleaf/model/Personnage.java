package com.example.Thymleaf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
// Toutes les nouvelles propriétés externes seront ignorées.....
@JsonIgnoreProperties(ignoreUnknown = true)
public class Personnage {
    private String name;
    private String characterClass;
    private int life;
    // Toutes valeurs par default neseront pas inclus dans le JSON
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int id;


    public Personnage(){

    }

    public Personnage(String name, String characterClass, int life, int id) {
        this(name, characterClass, life);
        this.id = id;
    }

    public Personnage(String name, String characterClass, int life) {
        this.name = name;
        this.characterClass = characterClass;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLife() {
        return life;
    }

    public void setlife(int life) {
        this.life = life;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
