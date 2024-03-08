/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbConnectionManager;
import domain.Site;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import service.CleaningManagerServiceException;

/**
 *
 * @author Gustav
 */
public class SiteDao implements Dao<Site> {

    DbConnectionManager dbConManagerSingleton = null;

    public SiteDao() {
        dbConManagerSingleton = DbConnectionManager.getInstance();
    }

    @Override
    public Site get(int id) throws NoSuchElementException {
        Site location = null;
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, city FROM labLocations WHERE id=" + id);
            // Om resultset.next() har någonting indikerar det att en location med det id finns
            if (resultSet.next()) {
                location = new Site(resultSet.getInt(1), resultSet.getString(2));
            } else {
                throw new NoSuchElementException("The location with id " + id + " do not exist in the database");
            }
        } catch (SQLException e) {
            throw new CleaningManagerServiceException(e.getMessage());

        }

        return location;

    }

    @Override
    public List<Site> getAll() {
        ArrayList<Site> listOfLocations = new ArrayList<>();
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, city FROM labLocations");
            while (resultSet.next()) {
                listOfLocations.add(new Site(resultSet.getInt(1), resultSet.getString(2).trim())
                );

            }

        } catch (SQLException e) {
            throw new CleaningManagerServiceException(e.getMessage());
        }

        return listOfLocations;
    }

    @Override
    public Site save(Site t) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Site savedLocation = null;
        String sql = "INSERT INTO labLocations (city) VALUES (?)";

        try {
            preparedStatement = dbConManagerSingleton.prepareStatement(sql, true);
            preparedStatement.setString(1, t.getCity());
            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            savedLocation = new Site(resultSet.getInt(1), t.getCity());

        } catch (SQLException e) {
            throw new CleaningManagerServiceException(e.getMessage());
        }

        return savedLocation;

    }

    @Override
    public Site update(Site t) {

        PreparedStatement preparedStatement = null;
        Site updatedLocation = null;

        try {
            //Tittar om Id redan finns i databasen
            if (get(t.getId()) != null) {
                preparedStatement = dbConManagerSingleton.prepareStatement("Update labLocations set city=? WHERE id=?");
                preparedStatement.setString(1, t.getCity());
                preparedStatement.setInt(2, t.getId());
                preparedStatement.execute();
                //Skapa nytt locationobjekt för att returnera
                updatedLocation = new Site(t.getId(), t.getCity());

                return updatedLocation;

            }

        } catch (SQLException e) {
            throw new CleaningManagerServiceException(e.getMessage());
        }

        return t;
    }

    @Override
    public Site delete(Site t) {
        Site deletedLocation = null;
        int rowCount = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //Tittar om Id redan finns i databasen
            if (get(t.getId()) != null) {
                // Tittar antalet rader innan delete
                resultSet = dbConManagerSingleton.excecuteQuery("Select COUNT(id) From labLocations");
                resultSet.next();
                rowCount = resultSet.getInt(1);

                preparedStatement = dbConManagerSingleton.prepareStatement("DELETE FROM labLocations where id=?");
                preparedStatement.setInt(1, t.getId());
                preparedStatement.execute();
                // Tittar antalet rader efter delete
                resultSet = dbConManagerSingleton.excecuteQuery("Select COUNT(id) FROM labLocations");
                resultSet.next();
                int newRowCounnt = resultSet.getInt(1);
                if (newRowCounnt == (rowCount - 1)) {
                    deletedLocation = t;
                }
            }

        } catch (SQLException e) {
           throw new CleaningManagerServiceException(e.getMessage());

        }

        return deletedLocation;
    }

}
