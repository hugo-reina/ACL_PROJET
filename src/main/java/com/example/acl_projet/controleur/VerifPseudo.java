package com.example.acl_projet.controleur;

import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class VerifPseudo {

    public VerifPseudo() {
    }

    public Boolean isOkLog(TextField pseudo){

        Boolean valide = false;
        /**
         * TODO Verifier que pseudo existe, et si ça existe o ajoute comme en dessous, sinon on demande de réésayer
         */

        if(pseudo.getText().isEmpty()){
            valide = false;
        }
        ClassementDAO classementDAO = new ClassementDAOImpl();
        List<String> pseudos = classementDAO.getPseudo();

        for(String s : pseudos){
            if (pseudo.getText().equals(s)){
                valide = true;
            }
        }
        return valide;
    }

    public Boolean isOkInscription(TextField pseudo){
        Boolean valide = true;
        /**
         * TODO Verifier que pseudo existe, et si ça existe o ajoute comme en dessous, sinon on demande de réésayer
         */

        if(pseudo.getText().isEmpty()){
            valide = false;
        }
        ClassementDAO classementDAO = new ClassementDAOImpl();
        List<String> pseudos = classementDAO.getPseudo();

        for(String s : pseudos){
            if (pseudo.getText().equals(s)){
                valide = false;
            }
        }
        return valide;
    }
}
