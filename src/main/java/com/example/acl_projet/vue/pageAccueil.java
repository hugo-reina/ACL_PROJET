package com.example.acl_projet.vue;

import com.example.acl_projet.modele.Carte;
import com.example.acl_projet.modele.Joueur;
import com.example.acl_projet.modele.Paquet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.acl_projet.controleur.modifPage;

import java.io.IOException;

public class pageAccueil {
    private String pagePrecedente="pageAccueil";
    private Stage stage;
    private Parent root;
    private Scene scene;

    private modifPage modifPage = new modifPage();

    public void QuitterPartie(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void ScenePseudo(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"page-pseudo.fxml");

    }

/**Popup pour les règles du jeu**/
    public void popup(ActionEvent actionEvent) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Règle du jeu");

        // Contenu de la popup
        StackPane popupLayout = new StackPane();
        Label label = new Label();
        label.setText("Règles du jeu : Jeu de cartes pour obtenir le score le plus bas\n" +
                "\n" +
                "Objectif : Le but du jeu est d'obtenir le score le plus bas possible.\n" +
                "\n" +
                "Matériel : Les cartes utilisées sont celles de la belote, composées de 32 cartes réparties en 4 catégories colorées : pique (noir), cœur (rouge), trèfle (noir), carreau (rouge). Chaque catégorie comprend 8 cartes : A, K, D, V, 10, 9, 8, 7.\n" +
                "\n" +
                "Valeurs des cartes :\n" +
                "\n" +
                "A : 11 points\n" +
                "10 : 10 points\n" +
                "K : 4 points\n" +
                "D : 3 points\n" +
                "V : 2 points\n" +
                "9, 8, 7 : 0 points\n" +
                "Déroulement du jeu :\n" +
                "\n" +
                "Au début, le joueur a les options suivantes : commencer une partie, visualiser le tableau des records, quitter le jeu.\n" +
                "Si le joueur choisit de commencer une partie, le système lui propose d'entrer un pseudonyme ou d'abandonner la partie.\n" +
                "Une fois le pseudonyme renseigné, le joueur tire aléatoirement 5 fois (5 tours) deux cartes à chaque tour.\n" +
                "Pendant chaque tour, le joueur peut abandonner la partie à tout moment.\n" +
                "Les deux cartes tirées à chaque tour sont comparées de la manière suivante :\n" +
                "Si les cartes sont dépareillées en valeur et en couleur, la somme des valeurs des cartes est ajoutée au score du joueur.\n" +
                "Si les deux cartes ont la même valeur mais de couleur différente, la somme des valeurs des cartes est soustraite au score du joueur.\n" +
                "Si les deux cartes sont de la même couleur et ont la même valeur, le double de la somme des valeurs est soustrait au score du joueur.\n" +
                "À la fin de la partie (après 5 tours), le score du joueur est inscrit au tableau des records.\n" +
                "Ces règles constituent un résumé du jeu de cartes que vous souhaitez implémenter. Vous pouvez afficher ces règles dans votre popup pour informer les joueurs des règles du jeu.");
        popupLayout.getChildren().add(label);  // Ajoutez le label au layout

        Scene popupScene = new Scene(popupLayout, 1000, 500);
        popupStage.setScene(popupScene);

        // Bloque la fenêtre principale jusqu'à ce que la popup soit fermée
        popupStage.initOwner(((Button) actionEvent.getSource()).getScene().getWindow());
        popupStage.initModality(Modality.WINDOW_MODAL);

        popupStage.show();
    }

    public void VisuScore(ActionEvent actionEvent) throws IOException {
        Joueur joueur = new Joueur("",0);
        modifPage.movePagePrec(actionEvent,"page-classement.fxml",pagePrecedente,joueur);
    }
}