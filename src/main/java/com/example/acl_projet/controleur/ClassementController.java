package com.example.acl_projet.controleur;

import com.example.acl_projet.modele.Carte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.SQLException;

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
