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
    public String showCreateForm(Model model){
        Personnage personnage = new Personnage();
        model.addAttribute("personnage", personnage);
        return "formulaire";
    }

    @PostMapping("/create")
    public String submitForm(@ModelAttribute("personnage") Personnage personnage, Model model){
        personnages.add(personnage);
        model.addAttribute("personnageListe", personnages);
        return "formulaire";
    }
    @GetMapping("/update/{id}")
    public String showupdateForm(Model model, @PathVariable("id") int id){
        model.addAttribute("personnage", personnages.get(id));
        return "updatePersonnage";
    }

    @PutMapping("/update")
    public String updateForm(@ModelAttribute("personnage") Personnage personnage) {
        personnages.get(personnage.getId()).setName(personnage.getName());
        personnages.get(personnage.getId()).setClasse(personnage.getClasse());
        personnages.get(personnage.getId()).setLife(personnage.getLife());
        return "redirect:/listeDePersonnage";
    }



    @GetMapping("/listeDePersonnage")
    public String getPeople(Model model) {
        model.addAttribute("personnageListe", personnages);
        return "personnageListe";
    }

    @GetMapping("/personnage/{id}")
    public String getPersonnage(@PathVariable("id") int id, Model model) {
        model.addAttribute("personnage", personnages.get(id));
        return "personnage";
    }
    @DeleteMapping("/personnage/{id}")
    public String deletePersonnage(@PathVariable("id") int id) {
        personnages.remove(id);
        return "redirect:/listeDePersonnage";
    }
}
