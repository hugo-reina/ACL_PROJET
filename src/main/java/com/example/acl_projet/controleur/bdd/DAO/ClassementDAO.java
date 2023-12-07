package com.example.acl_projet.controleur.bdd.DAO;

import com.example.acl_projet.modele.Classement;

import java.sql.SQLException;
import java.util.List;

public interface ClassementDAO {

    void AjouterClassement(Classement classement);
    List<Classement> getClassement() throws SQLException;

    List<Integer> getPoints();

    List<String> getPseudo();
}
