package com.example.Thymleaf.model;

public class Personnage {
    private String firstName;
    private String lastName;
    private String characterClass;
    private int health;

    private int id;


    public Personnage(){

    }

    public Personnage(String firstName, String lastName, String characterClass, int health) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.characterClass = characterClass;
        this.health = health;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
