package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/*@Entity est une annotation qui indique que la classe correspond à une table de la base de données.*/
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String classe;
    private int life;

    public Personnage() {
    }

    public Personnage(int id, String name, String classe, int life){
        this.id = id;
        this.name = name;
        this.classe = classe;
        this.life = life;
    }

    public Personnage(String name, String classe, int life){
        this.name = name;
        this.classe = classe;
        this.life = life;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClasse() {
        return classe;
    }

    public int getLife() {
        return life;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
