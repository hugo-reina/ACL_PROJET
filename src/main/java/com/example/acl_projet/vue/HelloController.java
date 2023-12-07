package com.example.acl_projet.vue;

import com.example.acl_projet.modele.Carte;
import com.example.acl_projet.modele.Paquet;
import javafx.application.Application;
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

import java.io.IOException;

public class HelloController {
    public Label pts;
    public Label parties;
    public Button btn_suivant;
    public Button btn_pioche;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ImageView imageView; // Récupère l'ImageView depuis le fichier FXML
    @FXML
    private ImageView imageView2; // Récupère l'ImageView depuis le fichier FXML

    @FXML
    private TextField Saisie;

    private String Valide;
    public Label Nom;

    @FXML
    private Button ValidPseudo;

    int points;
    int total = 0;
    int nbPartie =0;


    private static Paquet paquet;


    public void QuitterPartie(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void ScenePseudo(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("/com/example/acl_projet/choix-pseudo.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private int CompterPoints(Carte c1, Carte c2){
        int number = 0;
        //number = paquet.getNumber(c1) + paquet.getNumber(c2);
        if(c1.getNumber().equals(c2.getNumber()) && (c1.getCouleur().equals(c2.getCouleur()))){
            number += 2*(paquet.getNumber(c1) + paquet.getNumber(c2));
        }else if (c1.getNumber().equals(c2.getNumber()) && (!c1.getCouleur().equals(c2.getCouleur()))){
            number -= paquet.getNumber(c1) + paquet.getNumber(c2);
        }else{
            number += paquet.getNumber(c1) + paquet.getNumber(c2);
        }
        return number;
    }
    public void pioche(ActionEvent actionEvent) {
        if (nbPartie == 5){
            btn_pioche.setVisible(false);
            btn_suivant.setVisible(true);
        }else {
            if (paquet == null) {
                // Créez le paquet si c'est la première utilisation ou s'il est vide
                paquet = new Paquet();
                paquet.melanger();
            }
            System.out.println(paquet.getCartes().size());
            //Carte
            try {
                nbPartie = nbPartie + 1;
                Carte c1;
                Carte c2;
                c1 = paquet.piocherCarte();
                c2 = paquet.piocherCarte();
                Image image = new Image("file:src/main/cartes/" + c1.number + "_" + c1.couleur + ".png");
                Image image2 = new Image("file:src/main/cartes/" + c2.number + "_" + c2.couleur + ".png");
                imageView.setImage(image);
                imageView2.setImage(image2);
                points = CompterPoints(c1, c2);
                total = total + points;
                pts.setText("Mon score " + total + " (+" + points + ")");
                parties.setText("Partie numéro " + nbPartie);
                //Nom.setText(Saisie.getText());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void pageScore(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("/com/example/acl_projet/page-classement.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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

}