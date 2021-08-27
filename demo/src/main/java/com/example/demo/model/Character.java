package com.example.demo.model;

public class Character {

    //_________________________________________________ATTRIBUTS________________________________________________________________________________
    private int id;
    private String name;
    private String characterClass;
    private int life;

    //_________________________________________________CONSTRUCTEUR________________________________________________________________________________

    public Character(){

    }

    public Character(int id, String name, String characterClass, int life) {
        this.id = id;
        this.name = name;
        this.characterClass = characterClass;
        this.life = life;
    }

    //_________________________________________________GETTERS & SETTERS________________________________________________________________________________

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString(){
        return "Character{"+
                "id=" + id +
                "class=" + characterClass +
                ", nom='"+ name + '\'' +
                ", life=" + life+ '}';
    }

    //_________________________________________________________________________________________________________________________________



}
