/*
package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class PersonnageService implements PersonnageRepository {

    private List<Personnage> list = new ArrayList<Personnage>();
    public PersonnageService(){
    }


    @Override
    public List<Personnage> findAll() {
        return list;
    }

    @Override
    public Personnage findById(int id) {
        return list.get(id);
    }

    @Override
    public void save(Personnage personnage) {
        list.add(personnage);
    }

    @Override
    public void delete(int id) {
        list.remove(id);
    }

    @Override
    public void update(Personnage personnage) {
        for (int i = 0; i < list.size(); i++){
            if(personnage.getId() == list.get(i).getId() ){
                list.get(i).setName(personnage.getName());
                list.get(i).setClasse(personnage.getClasse());
                list.get(i).setLife(personnage.getLife());
            }
        }
    }
}
*/
