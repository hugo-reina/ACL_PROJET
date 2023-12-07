package com.example.acl_projet.modele;

public class Joueur {

    private String pseudonyme;
    private int score;

    public Joueur(String pseudonyme, int score) {
        this.pseudonyme = pseudonyme;
        this.score = score;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Vous pouvez ajouter d'autres méthodes et fonctionnalités ici en fonction de vos besoins.

    @Override
    public String toString() {
        return "Joueur{" +
                "pseudonyme='" + pseudonyme + '\'' +
                ", score=" + score +
                '}';
    }
}
