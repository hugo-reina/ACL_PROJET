package com.example.acl_projet.controleur;

import com.example.acl_projet.modele.Joueur;
import com.example.acl_projet.vue.PageAbandonner;
import com.example.acl_projet.vue.PageClassement;
import com.example.acl_projet.vue.pageAccueil;
import com.example.acl_projet.vue.pageJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class modifPage{

    private Stage stage;
    private Parent root;
    private Scene scene;

    public modifPage() {
    }
    public void movePage(ActionEvent actionEvent, String chemin) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(pageAccueil.class.getResource("/com/example/acl_projet/"+ chemin));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void movePageJoueur(ActionEvent actionEvent, String chemin,Joueur joueur, Object o) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(pageAccueil.class.getResource("/com/example/acl_projet/"+ chemin));
        root = fxmlLoader.load();
        Joueur j = joueur;
        if (o instanceof PageAbandonner){
            PageAbandonner page = (PageAbandonner) o;
            page = fxmlLoader.getController();
            page.setJoueur(joueur);
        } else if (o instanceof pageJeu) {
           pageJeu page = (pageJeu) o;
           page = fxmlLoader.getController();
           System.out.println("je passe par la " + joueur.getPseudonyme());
           if(j!= null){
               System.out.println("ici " + j.getPseudonyme());
               page.setJoueur(j);
           }
        }else if (o instanceof PageClassement) {
            PageClassement page = (PageClassement) o;
            page = fxmlLoader.getController();
            page.setJoueur(joueur);

        }
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void movePagePrec(ActionEvent actionEvent, String chemin, String prec , Joueur joueur) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(pageAccueil.class.getResource("/com/example/acl_projet/"+ chemin));
        root = fxmlLoader.load();
        PageClassement page = fxmlLoader.getController();
        page.setJoueur(joueur);
        page.setPagePrecedente(prec);
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
