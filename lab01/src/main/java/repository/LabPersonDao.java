package repository;

import com.mysql.cj.xdevapi.SelectStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import db.DbConnectionManager;
import domain.LabPerson;
/**
 * DAO for the persistent handling of a Person object. It manages all
 * CRUD operations and conversion between the object world student and
 * the relational version student (DB version).
 * Due to the use of a DbConnectionManager the DAO doesen't need to 
 * use, or even know, about any of lower level connections to the Database.
 * It 'speaks' in Objects with the object world (Domain model)and in 
 * relational sql strings, tables, columns and result sets with the database.
 * @author awi
 *
 */
public class LabPersonDao implements Dao<LabPerson> {

	DbConnectionManager dbConManagerSingleton = null;
	
	public LabPersonDao() {
		dbConManagerSingleton = DbConnectionManager.getInstance();
	}
	
	@Override
	public LabPerson get(int id) throws NoSuchElementException {
		LabPerson student = null;
		try{
			ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year FROM persons WHERE id=" + id);
			if( !resultSet.next())
				throw new NoSuchElementException("The person with id " + id + " doesen't exist in database");
			else
				student = new LabPerson(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			dbConManagerSingleton.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public List<LabPerson> getAll() {
		
		ArrayList<LabPerson> list = new ArrayList<>();
		
		try {
			ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year FROM persons");
			while (resultSet.next()) {
				list.add(new LabPerson(resultSet.getInt(1), 
									 resultSet.getString(2).trim(),
									 resultSet.getInt(3))
						);
				
			}
			dbConManagerSingleton.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
                dbConManagerSingleton.close();
		return list;
	}

	@Override
	public LabPerson save(LabPerson t) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LabPerson savedPerson = null;
		
                
		try {
			
			
			//*******This is the main 'save' operation ***************************
			preparedStatement = dbConManagerSingleton.prepareStatement(
											  "INSERT INTO persons (name, birth_year) VALUES (?, ?)");
			preparedStatement.setString(1, t.getName());
			preparedStatement.setInt(2, t.getBirthYear());
			preparedStatement.execute();
                        
                        preparedStatement = dbConManagerSingleton.prepareStatement("SELECT LAST_INSERT_ID()");
                        preparedStatement.execute();
                        
                        resultSet = preparedStatement.getResultSet();
			resultSet.next();
                        int generatedId = resultSet.getInt(1);
                        savedPerson = new LabPerson(generatedId, t.getName(), t.getBirthYear());
                        dbConManagerSingleton.close();
			// ********************************************************************
			
			
		}
		catch ( SQLException e) {
			e.printStackTrace();
		}
		return savedPerson;
	}
	/**
	 * This method uses a temporary Student set with the desired changed values.
	 * It must have a 'id' that corresponds to a existing record in the database.
	 * @param t - an instance of a Student with new values on attributes but 
	 * an 'id' identical to an existing student in the DB
     * @return 
	 */
	@Override
	public LabPerson update(LabPerson t) {
            
            PreparedStatement sselectStatement = null;
            PreparedStatement preparedStatement = null;
            LabPerson updatedPerson = null;
            
            try {
                //sselectStatement = dbConManagerSingleton.prepareStatement("SELECT * FROM persons WHERE id =");
                //sselectStatement.setInt(1, t.getId());
                //ResultSet resultSet = sselectStatement.executeQuery();
                
               // if(resultSet.next()) {
                if(get(t.getId()) != null){
                    preparedStatement = dbConManagerSingleton.prepareStatement("update persons set name=? ,birth_year=? where id=?");
                    preparedStatement.setString(1,t.getName() );
                    preparedStatement.setInt(2, t.getBirthYear());
                    preparedStatement.setInt(3, t.getId());
                    preparedStatement.execute();
                    
                    updatedPerson = new LabPerson(t.getId(), t.getName(), t.getBirthYear());
                    dbConManagerSingleton.close();
                    return updatedPerson;
                }
                else {
                    //Hantera om ID inte finns i databasen
                    System.out.println("Person med id " + t.getId()+ " existerar inte");
               
                }
                
            }catch(SQLException e) {
                e.printStackTrace();
                
            }
	
            return t;
	}

	@Override
	public LabPerson delete(LabPerson t) {
            
                LabPerson deletedPerson = null;
		int id = t.getId();
                int rowCount = 0;
                PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
                
                try {
                    //****This is just for checking the 'delete' is a sucess. Count rows before delete***
			resultSet = dbConManagerSingleton.excecuteQuery("SELECT COUNT(id) FROM persons");
			resultSet.next();
			rowCount = resultSet.getInt(1);
			//System.out.println(rowCount); // Debug print
                    preparedStatement = dbConManagerSingleton.prepareStatement("DELETE FROM persons where id="+id);
                   preparedStatement.execute();
                   
                   // **** Check nbr of rows after 'save'. Compare with previous row count *****
			resultSet = dbConManagerSingleton.excecuteQuery("SELECT COUNT(id) FROM persons");
			resultSet.next();
			int newRowCount = resultSet.getInt(1);
			if( newRowCount == (rowCount - 1)){ // Check if table is one more row after 'save'
				deletedPerson = t;
                        }
//			System.out.format("Previous row count: %d    Current row count: %d", rowCount, newRowCount);
dbConManagerSingleton.close();
                } 
                catch (SQLException e) {
			e.printStackTrace();
		}
                return deletedPerson;

	}

}
