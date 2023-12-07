package com.example.acl_projet.vue;

import com.example.acl_projet.controleur.bdd.DAO.ClassementDAO;
import com.example.acl_projet.controleur.bdd.DAO.ClassementDAOImpl;
import com.example.acl_projet.modele.Classement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/acl_projet/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("jeu de la belote");
        stage.setScene(scene);
        stage.show();

        ClassementDAO classementDAO = new ClassementDAOImpl();
        Classement classement = new Classement(1, "test",30);
        classementDAO.AjouterClassement(classement);

        List<Classement> list = new ArrayList<>();
        list = classementDAO.getClassement();
        for (Classement classement1 : list){
            System.out.println(classement1);
        }
    }

    public static void main(String[] args) {
        launch();
    }



}
