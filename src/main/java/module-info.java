module com.example.acl_projet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.acl_projet.controleur to javafx.fxml;

    opens com.example.acl_projet to javafx.fxml;
    exports com.example.acl_projet.vue;
    opens com.example.acl_projet.vue to javafx.fxml;
    exports com.example.acl_projet.modele;
    opens com.example.acl_projet.modele to javafx.fxml;
    exports com.example.acl_projet.controleur.bdd.DAO;
    opens com.example.acl_projet.controleur.bdd.DAO to javafx.fxml;
    exports com.example.acl_projet.controleur.bdd;
    opens com.example.acl_projet.controleur.bdd to javafx.fxml;
}