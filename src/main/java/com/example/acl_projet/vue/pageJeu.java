package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import com.example.acl_projet.controleur.modifPage;
import com.example.acl_projet.modele.Carte;
import com.example.acl_projet.modele.Classement;
import com.example.acl_projet.modele.Joueur;
import com.example.acl_projet.modele.Paquet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class pageJeu{

    @FXML
    public Label  pseudoJeu;
    private String pagePrecedente ="pageJeu";
    private modifPage  modifPage = new modifPage();

    private Joueur joueur;
    ClassementDAO classementDAO;
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
    public Label Nom;

    int points;
    int total = 0;
    int nbPartie =0;
    private static Paquet paquet;
    public void pioche(ActionEvent actionEvent) {
        if (nbPartie == 5){
            btn_pioche.setVisible(false);
            btn_suivant.setVisible(true);
        }else {
            if (paquet == null || paquet.piocherCarte() == null) {
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

    public void pageScore(ActionEvent actionEvent) throws IOException, SQLException {
        classementDAO = new ClassementDAOImpl();
        ClassementDAO classementDAO = new ClassementDAOImpl();
        Classement classement = new Classement(1, joueur.getPseudonyme(),total);
        classementDAO.AjouterClassement(classement);
        modifPage.movePagePrec(actionEvent,"page-classement.fxml",pagePrecedente, joueur);
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
        if (pseudoJeu != null){
            this.pseudoJeu.setText("Bonne chance "+ joueur.getPseudonyme());
        }
        }

    public void btnQuitter(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"page-accueil.fxml");
    }

    public void btnAbandonner(ActionEvent actionEvent) throws IOException {
        PageAbandonner page = new PageAbandonner();
        modifPage.movePageJoueur(actionEvent, "page-abandonner.fxml",joueur, page);
    }
}
