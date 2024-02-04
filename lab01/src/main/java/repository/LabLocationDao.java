/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbConnectionManager;
import domain.LabLocation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Gustav
 */
public class LabLocationDao implements Dao<LabLocation> {
    
    DbConnectionManager dbConManagerSingleton = null;
    
    public LabLocationDao() {
        dbConManagerSingleton = DbConnectionManager.getInstance();
    }

    @Override
    public LabLocation get(int id) throws NoSuchElementException {
        LabLocation location = null;
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, city FROM locations WHERE id="+id);
           // Om resultset.next() har någonting indikerar det att en location med det id finns
            if(resultSet.next()) {
                location = new LabLocation(resultSet.getInt(1), resultSet.getString(2));
            }
            else {
                throw new NoSuchElementException("The location with id " + id + " do not exist in the database");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        dbConManagerSingleton.close();
        return location;
        
    }

    @Override
    public List<LabLocation> getAll() {
        ArrayList<LabLocation> listOfLocations = new ArrayList<>();
        try {
			ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, city FROM locations");
			while (resultSet.next()) {
				listOfLocations.add(new LabLocation(resultSet.getInt(1), resultSet.getString(2).trim())
						);
				
			}
			dbConManagerSingleton.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfLocations;
    }

    @Override
    public LabLocation save(LabLocation t) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LabLocation savedLocation = null;
        
        try {
            preparedStatement = dbConManagerSingleton.prepareStatement("INSERT INTO locations (city) VALUES (?)");
            preparedStatement.setString(1, t.getCity());
            preparedStatement.execute();
            // Selectsats för att hämta det genererade ID
            preparedStatement = dbConManagerSingleton.prepareStatement("Select LAST_INSERT_ID()");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            savedLocation = new LabLocation(resultSet.getInt(1), t.getCity());
            dbConManagerSingleton.close();
        }
        catch ( SQLException e) {
            e.printStackTrace();
        }
        return savedLocation;
        
  }

    @Override
    public LabLocation update(LabLocation t) {
        PreparedStatement selectStatement = null;
        PreparedStatement preparedStatement = null;
        LabLocation updatedLocation = null;
        
        try {
            //Tittar om Id redan finns i databasen
            if(get(t.getId())!= null) {
                preparedStatement = dbConManagerSingleton.prepareStatement("Update locations set city=? WHERE id=?");
                preparedStatement.setString(1, t.getCity());
                preparedStatement.setInt(2, t.getId());
                preparedStatement.execute();
                //Skapa nytt locationobjekt för att returnera
                updatedLocation = new LabLocation(t.getId(), t.getCity());
                dbConManagerSingleton.close();
                return updatedLocation;
                
            }
            else {
                System.out.println("Location with id " + t.getId()+ " do not exist");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
  }

    @Override
    public LabLocation delete(LabLocation t) {
        LabLocation deletedLocation = null;
        int rowCount = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
             //Tittar om Id redan finns i databasen
            if(get(t.getId())!= null) {
            // Tittar antalet rader innan delete
            resultSet = dbConManagerSingleton.excecuteQuery("Select COUNT(id) From locations");
            resultSet.next();
            rowCount = resultSet.getInt(1);
            
            preparedStatement = dbConManagerSingleton.prepareStatement("DELETE FROM locations where id=?");
            preparedStatement.setInt(1, t.getId());
            preparedStatement.execute();
            // Tittar antalet rader efter delete
            resultSet = dbConManagerSingleton.excecuteQuery("Select COUNT(id) FROM locations");
            resultSet.next();
            int newRowCounnt = resultSet.getInt(1);
            if( newRowCounnt ==(rowCount-1)) {
                deletedLocation = t;
            }
            }
            
          
            
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        dbConManagerSingleton.close();
        return deletedLocation;
  }
    
    
}
