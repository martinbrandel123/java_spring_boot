package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {
    List<Personnage> findAll();
    Personnage findById(int id);
    Personnage save(Personnage  personnage);
      void deleteById(int id);
/*     void save(Personnage personnage);*/
}
