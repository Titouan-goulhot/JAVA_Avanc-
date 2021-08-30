package com.example.demo.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "personnages")
public class Personnage {

    //_________________________________________________ATTRIBUTS________________________________________________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Name is requiered")
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "characterClass", length = 255, nullable = false)
    private String characterClass;
    @Column(name = "life", length = 20, nullable = false)
    private int life;

    //_________________________________________________CONSTRUCTEUR________________________________________________________________________________

    public Personnage(){

    }

    public Personnage(Integer id, String name, String characterClass, int life) {
        this.id = id;
        this.name = name;
        this.characterClass = characterClass;
        this.life = life;
    }

    //_________________________________________________GETTERS & SETTERS________________________________________________________________________________

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
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
