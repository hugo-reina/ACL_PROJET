package com.example.acl_projet.modele;

public class Classement {


    private int id;
    private String pseudo;
    private int points;

    public Classement(int id, String pseudo, int points) {
        this.id = id;
        this.pseudo = pseudo;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getPoints() {
        return points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
