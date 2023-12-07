package com.example.acl_projet.modele;

public class Carte {

    public String number;
    public String couleur;

    public Carte(String number, String couleur) {
        this.number = number;
        this.couleur = couleur;
    }

    public String getNumber() {
        return number;
    }

    public String getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return number + " de " + couleur;
    }
}
