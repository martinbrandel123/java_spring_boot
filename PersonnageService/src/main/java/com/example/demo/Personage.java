package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Personage {

    private int id;
    private String name;
    private String classe;
    private int life;

    public Personage () {

    }

    public Personage(int id, String name, String classe, int life){
        this.id = id;
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
}
