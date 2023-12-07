package com.example.acl_projet.controleur;

import com.example.acl_projet.controleur.bdd.bdd;
import com.example.acl_projet.modele.Carte;
import com.example.acl_projet.modele.Classement;
import com.example.acl_projet.vue.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassementController {

    @FXML
    private TableView<Carte> table;
    @FXML
    public void initialize() throws SQLException {
        ObservableList<Carte> personnes = FXCollections.observableArrayList(

                // Ajoutez autant d'objets que nécessaire
        );
        // Associez la liste à la TableView
        table.setItems(personnes);
    }
}
