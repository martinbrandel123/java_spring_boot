package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PersonnageController {

    private static List<Personnage> personnages = new ArrayList<Personnage>();
    private static String API_URL = "http://localhost:8081/personnageslist/";
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String listePersonnage(){
        return "index";
    }

    @GetMapping("/listeDePersonnage")
    public String getPeople(Model model) {
        List<Personnage> result = Arrays.asList(this.restTemplate.getForObject(API_URL, Personnage[].class));
        model.addAttribute("personnageListe", result);
        return "personnageListe";
    }

    @GetMapping("/personnage/{id}")
    public String getPersonnage(@PathVariable("id") int id, Model model) {
        Personnage result = this.restTemplate.getForObject( API_URL + id, Personnage.class);
        model.addAttribute("personnage", result);
        return "personnage";
    }
    @DeleteMapping("/personnage/{id}")
    public String deletePersonnage(@PathVariable("id") int id) {
        this.restTemplate.delete(API_URL + id);
        return "redirect:/listeDePersonnage";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model){
        Personnage personnage = new Personnage();
        model.addAttribute("personnage", personnage);
        return "formulaire";
    }

    @PostMapping("/create")
    public String submitForm(@ModelAttribute("personnage") Personnage personnage){
        this.restTemplate.postForLocation(API_URL, personnage);

        return "formulaire";
    }
    @GetMapping("/update/{id}")
    public String showupdateForm(Model model, @PathVariable("id") int id){
        Personnage personnage = this.restTemplate.getForObject( API_URL + id, Personnage.class);
        model.addAttribute("personnage", personnage);
        return "updatePersonnage";
    }

    @PutMapping("/update")
    public String updateForm(@ModelAttribute("personnage") Personnage personnage) {
        this.restTemplate.put(API_URL, personnage);
        return "redirect:/listeDePersonnage";
    }


    @GetMapping("/test")
    public String test(Model model) {

        return "test";
    }

}
