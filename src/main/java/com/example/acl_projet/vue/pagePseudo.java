package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.VerifPseudo;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import com.example.acl_projet.controleur.modifPage;
import com.example.acl_projet.modele.Classement;
import com.example.acl_projet.modele.Joueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class pagePseudo {

    public Label txtError;
    private modifPage modifPage = new modifPage();

    private VerifPseudo valide = new VerifPseudo();
    public TextField pseudo;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void btnRetour(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"page-accueil.fxml");
    }

    public void btnConnexion(ActionEvent actionEvent) throws IOException {
        if (valide.isOkLog(pseudo)){
            Joueur joueur = new Joueur(pseudo.getText(),0);
            pageJeu jeu = new pageJeu();
            modifPage.movePageJoueur(actionEvent,"page-jeu.fxml",joueur,jeu);
        }else {
            txtError.setVisible(true);
        }
    }

    public void btnInscription(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"inscription.fxml");
    }
}
