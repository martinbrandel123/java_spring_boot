package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonnageController {

    private static List<Personnage> personnages = new ArrayList<Personnage>();

    @GetMapping("/")
    public String listePersonnage(){
        return "index";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        Personnage personnage = new Personnage();
        model.addAttribute("personnage", personnage);
        return "formulaire";
    }

    @PostMapping("/create")
    public String submitForm(@ModelAttribute("personnage") Personnage personnage, Model model){
        int id =  personnage.getId();
        String name =  personnage.getName();
        String classe =  personnage.getClasse();
        int life =  personnage.getLife();
        String image = personnage.getImage();

        personnages.add(new Personnage(id, name, classe, life));
        model.addAttribute("personnageListe", personnages);
        return "personnageListe";
    }

    @GetMapping("/personnage")
    public String getPeople(Model model) {
        model.addAttribute("nom", "voici un nom");
        model.addAttribute("personnageListe", personnages);
        return "personnageListe";
    }

    @GetMapping("/personnage/{id}")
    public String getPeople(@PathVariable("id") int id, Model model) {
        model.addAttribute("personnage", personnages.get(id));
        return "personnage";
    }
}
