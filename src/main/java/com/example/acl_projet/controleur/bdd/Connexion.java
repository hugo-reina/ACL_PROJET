package com.example.acl_projet.controleur.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

    private static Connexion instance;

    public static Connexion getInstance() {
        if (instance == null){
            instance = new Connexion();
        }
        return instance;
    }

    public Connection ConnexionBdd(){
        Connection connection = null;
        try {
            // Étape 1 : Charger le driver SQLite
            Class.forName("org.sqlite.JDBC");

            // Étape 2 : Se connecter à la base de données
            connection = DriverManager.getConnection("jdbc:sqlite:ma_base_de_donnees.db");
            System.out.println("Connexion établie.");

            // Étape 3 : Créer une table (si elle n'existe pas)
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS classement (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "pseudo TEXT, " +
                    "points INTEGER)";
            statement.execute(createTableSQL);
            System.out.println("Table créée avec succès.");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
