package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.modifPage;
import com.example.acl_projet.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class PageAbandonner {

    public Label txt;
    private Joueur joueur;
    private String pagePrecedente ="pageJeu";
    private modifPage modif = new modifPage();

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
        txt.setText("Que voulez vous faire " + joueur.getPseudonyme());
        System.out.println(joueur.getPseudonyme());
    }

    public void Jouer(ActionEvent actionEvent) throws IOException {
        pageJeu jeu = new pageJeu();
        modif.movePageJoueur(actionEvent,"page-jeu.fxml",joueur,jeu);
    }

    public void VisuScore(ActionEvent actionEvent) throws IOException {
        modif.movePagePrec(actionEvent,"page-classement.fxml",pagePrecedente,joueur);
    }

    public void Deconnection(ActionEvent actionEvent) throws IOException {
        modif.movePage(actionEvent,"page-accueil.fxml");
    }
}
