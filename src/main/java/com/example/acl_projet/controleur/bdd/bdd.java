package com.example.acl_projet.controleur.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bdd {

    private static String pseudo;
    private int id;
    private int points;

    public bdd() {

    }

    public static void Insert(){

    }

    public List<String> getPseudo() throws SQLException {
        List<String> Listpseudo = new ArrayList<>();
        Connexion connexion = new Connexion();
        Connection con = connexion.ConnexionBdd();
        Statement statement = con.createStatement();
        String selectDataSQL = "SELECT * FROM classement";
        ResultSet resultSet = statement.executeQuery(selectDataSQL);
        while (resultSet.next()) {
            pseudo = resultSet.getString("pseudo");
            Listpseudo.add(pseudo);
        }

        return Listpseudo;
    }

    public static void main(String[] args) {
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

            // Étape 4 : Insérer des données
            String insertDataSQL = "INSERT INTO classement (pseudo, points) VALUES " +
                    "('Alice', 25)";
            statement.execute(insertDataSQL);
            String selectDataSQL = "SELECT * FROM classement";
            ResultSet resultSet = statement.executeQuery(selectDataSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pseudo = resultSet.getString("pseudo");
                int points = resultSet.getInt("points");
                System.out.println("ID : " + id + ", pseudo : " + pseudo + ", Age : " + points);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
