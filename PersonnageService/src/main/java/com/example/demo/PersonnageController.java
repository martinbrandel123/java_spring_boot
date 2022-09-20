package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonnageController {

    @GetMapping("/Personnages")
    public String listePersonnages(){
        return "test : liste personnages";
    }



    @GetMapping(value = "/Personnages/{id}", produces = "application/json")
    public Personage afficherUnProduit(@PathVariable int id) {
        Personage personage = new Personage(id,"martin", "magicien", 100);
        return personage;
    }
}
