package com.example.demo;


import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api("API pour les opérations CRUD sur les produits.")
@RestController
public class PersonnageController {
/*    @Autowired
    private PersonnageService personnageService;*/

    @Autowired
    /* Spring s’occupe d’instancier la classe directement en injectant les dépendances  */
    private PersonnageRepository personnageRepository;

    @ApiOperation(value = "Récupère une liste de personnages")
    /* permet de donner des valeur à cette methode dans swagger*/
   @GetMapping("/personnageslist")
    /* permet de notifier le type de requette HTTP et la valeur de cette requette*/
    public List<Personnage> listePersonnages(){
        return this.personnageRepository.findAll();
    }

    @ApiOperation(value = "Récupère un personnage en fonction de l'id de l'url")
 @GetMapping(value = "/personnageslist/{id}", produces = "application/json")
    public Personnage afficherUnPersonnage(@PathVariable int id) {
        return this.personnageRepository.findById(id);
    }

    @ApiOperation(value = "Crée un personnage avec un nom, une classe, des points de vie")
    @PostMapping(value = "/personnageslist")
    public void creerUnPersonnage(@RequestBody Personnage personnage) {
        this.personnageRepository.save(personnage);
    }
    @ApiOperation(value = "Supprime un personnage en fonction de l'id de l'url")
    @DeleteMapping(value = "/personnageslist/{id}")
    public void supprimerUnPersonnage(@PathVariable int id) {
        this.personnageRepository.deleteById(id);
    }

    @ApiOperation(value = "modifier un personnage")
    @PutMapping(value = "/personnageslist")
    public void modifierUnPersonnage(@RequestBody Personnage personnage) {
       this.personnageRepository.save(personnage);
    }
}


