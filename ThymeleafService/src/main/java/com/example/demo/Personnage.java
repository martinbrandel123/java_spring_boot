package com.example.demo;

public class Personnage {





    private int id;
    private String name;
    private String classe;
    private int life;
    private String image;

    public Personnage(){
    }

    public Personnage(int id, String name, String classe, int life){
        this.id = id;
        this.name = name;
        this.classe = classe;
        this.life = life;
        this.image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgFgj_EgtQ-0kgtzpAt66rj365UO9NWsXDZQ&usqp=CAU";
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
    public String getImage() {return image;}



    // setters
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
    public void setImage(String image) {this.image = image;}

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classe='" + classe + '\'' +
                ", life=" + life +
                '}';
    }


}
