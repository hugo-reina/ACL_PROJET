package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import com.example.acl_projet.controleur.bdd.bdd;
import com.example.acl_projet.controleur.modifPage;
import com.example.acl_projet.modele.Carte;
import com.example.acl_projet.modele.Classement;
import com.example.acl_projet.modele.Joueur;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageClassement {
    private Joueur joueur;

    public Button btnRejouer;
    private modifPage modifPage = new modifPage();
    private String pagePrecedente;
    ClassementDAO classementDAO;
    @FXML
    private TableView<Joueur> table;

    @FXML
    private TableColumn<Joueur, String> pseudoColumn;

    @FXML
    private TableColumn<Joueur, Integer> scoreColumn;

    public void initialize() {
        classementDAO = new ClassementDAOImpl();
        // Initialisez votre liste de joueurs (pour cet exemple, je vais laisser une liste vide)
        // Remplacez cela par votre propre logique pour récupérer les données des joueurs.

        ObservableList<Joueur> joueurs = FXCollections.observableArrayList();
        // Exemple de données fictives :
// Suppose que classementDAO.getPseudo() renvoie une List<String> de pseudonymes
        List<String> pseudos = classementDAO.getPseudo();
        List<Integer> points = classementDAO.getPoints();

// Itère sur la liste des pseudonymes pour créer des objets Joueur
        // Vérifie que les deux listes ont la même taille
        if (pseudos.size() == points.size()) {
            // Itère sur la liste des pseudonymes pour créer des objets Joueur
            for (int i = 0; i < pseudos.size(); i++) {
                // Ajoute un nouveau Joueur avec le pseudonyme et le score associés
                joueurs.add(new Joueur(pseudos.get(i), points.get(i)));
            }
        } else {
            // Gérez l'erreur si les listes n'ont pas la même taille
            System.err.println("Erreur : Les listes de pseudos et de points n'ont pas la même taille.");
        }


        // Associez la liste de joueurs à la TableView
        table.setItems(joueurs);

        // Associez les propriétés aux colonnes
        pseudoColumn.setCellValueFactory(new PropertyValueFactory<>("pseudonyme"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
    }

    public void QuitterPartie(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"page-accueil.fxml");
    }

    public void setPagePrecedente(String pagePrecedente) {
        this.pagePrecedente = pagePrecedente;
        if(pagePrecedente.equals("pageJeu")){
            btnRejouer.setVisible(true);
            btnRejouer.setDisable(false);
        }
    }

    public void Rejouer(ActionEvent actionEvent) throws IOException {
        pageJeu p = new pageJeu();
        modifPage.movePageJoueur(actionEvent,"page-jeu.fxml", joueur, p);
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}


/**
 *
 */
