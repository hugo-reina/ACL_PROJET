package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.VerifPseudo;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import com.example.acl_projet.controleur.modifPage;
import com.example.acl_projet.modele.Classement;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class inscription {
    public TextField pseudo;
    public Label txtError;
    private modifPage modifPage = new modifPage();
    private VerifPseudo valide = new VerifPseudo();


    public void btnRetour(ActionEvent actionEvent) throws IOException {
        modifPage.movePage(actionEvent,"page-pseudo.fxml");
    }

    public void btnCreerCompte(ActionEvent actionEvent) throws IOException {
        if (valide.isOkInscription(pseudo)){
            ClassementDAO classementDAO = new ClassementDAOImpl();
            Classement classement = new Classement(1, pseudo.getText(),0);
            classementDAO.AjouterClassement(classement);
            modifPage.movePage(actionEvent,"page-jeu.fxml");
        }else {
            txtError.setVisible(true);
        }


    }
}
