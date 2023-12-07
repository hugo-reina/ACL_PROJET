package com.example.acl_projet.controleur.bdd.DAO;

import com.example.acl_projet.controleur.bdd.Connexion;
import com.example.acl_projet.modele.Classement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassementDAOImpl implements ClassementDAO {

    Connexion connexion = new Connexion();
    String DataSQL;
    List<Classement> classementList = new ArrayList<>();
    @Override
    public void AjouterClassement(Classement classement) {
        DataSQL = "INSERT INTO classement (pseudo, points) VALUES (?, ?)";

        try(Connection connection = connexion.ConnexionBdd()){
            PreparedStatement statement = connection.prepareStatement(DataSQL);
            statement.setString(1,classement.getPseudo());
            statement.setInt(2,classement.getPoints());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Classement> getClassement() throws SQLException {
        DataSQL = "SELECT * FROM classement";
        try(Connection connection = connexion.ConnexionBdd()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DataSQL);

            while (resultSet.next()) {
                classementList.add(new Classement(resultSet.getInt("id"),resultSet.getString("pseudo"),resultSet.getInt("points")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return classementList;
    }

    @Override
    public List<Integer> getPoints() {
        ArrayList<Integer> points = new ArrayList<>();

        DataSQL = "SELECT points FROM classement";
        try(Connection connection = connexion.ConnexionBdd()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DataSQL);

            while (resultSet.next()) {

                points.add(resultSet.getInt("points"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return points;
    }

    @Override
    public List<String> getPseudo() {
        List<String> list = new ArrayList<>();

        DataSQL = "SELECT pseudo FROM classement";
        try(Connection connection = connexion.ConnexionBdd()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DataSQL);

            while (resultSet.next()) {

                list.add(resultSet.getString("pseudo"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
