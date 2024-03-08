package repository;

import com.mysql.cj.xdevapi.SelectStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import db.DbConnectionManager;
import domain.Person;
import service.CleaningManagerServiceException;
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
public class PersonDao implements Dao<Person> {
        
	DbConnectionManager dbConManagerSingleton = null;
	
	public PersonDao() {
		dbConManagerSingleton = DbConnectionManager.getInstance();
	}
        public PersonDao(DbConnectionManager dbConnectionManager) {
            dbConManagerSingleton = dbConnectionManager;
        }
	
	@Override
	public Person get(int id) throws NoSuchElementException, CleaningManagerServiceException {
		Person student = null;
		try{
			ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year FROM labPersons WHERE id=" + id);
			if( !resultSet.next())
				throw new NoSuchElementException("The person with id " + id + " doesen't exist in database");
			else
				student = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			
		}
		catch (SQLException e) {
			throw new CleaningManagerServiceException(e.getMessage());
		}
		
		return student;
	}

	@Override
	public List<Person> getAll() throws CleaningManagerServiceException {
		
		ArrayList<Person> list = new ArrayList<>();
		
		try {
			ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year FROM labPersons");
                        
			while (resultSet.next()) {
				list.add(new Person(resultSet.getInt(1), 
									 resultSet.getString(2).trim(),
									 resultSet.getInt(3))
						);
				
			}
			
		} catch (SQLException e) {
			throw new CleaningManagerServiceException(e.getMessage());
		}
                
		return list;
	}

	@Override
	public Person save(Person t) throws CleaningManagerServiceException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Person savedPerson = null;
                
		try {
			//*******This is the main 'save' operation ***************************
			preparedStatement = dbConManagerSingleton.prepareStatement("INSERT INTO labPersons (name, birth_year) VALUES (?, ?)", true);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setInt(2, t.getBirthYear());
			preparedStatement.execute();
                        
                        //preparedStatement = dbConManagerSingleton.prepareStatement("SELECT LAST_INSERT_ID()");
                        //preparedStatement.execute();
                        //resultSet = preparedStatement.getResultSet();
                        resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
                        int generatedId = resultSet.getInt(1);
                        savedPerson = new Person(generatedId, t.getName(), t.getBirthYear());
                        
			// ********************************************************************
			
			
		}
		catch ( SQLException e) {
			throw new CleaningManagerServiceException(e.getMessage());
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
	public Person update(Person t) {
            
            //PreparedStatement sselectStatement = null;
            PreparedStatement preparedStatement = null;
            Person updatedPerson = null;
            
            try {
                //sselectStatement = dbConManagerSingleton.prepareStatement("SELECT * FROM persons WHERE id =");
                //sselectStatement.setInt(1, t.getId());
                //ResultSet resultSet = sselectStatement.executeQuery();
                
               // if(resultSet.next()) {
                if(get(t.getId()) != null){
                    preparedStatement = dbConManagerSingleton.prepareStatement("update labPersons set name=? ,birth_year=? where id=?");
                    preparedStatement.setString(1,t.getName() );
                    preparedStatement.setInt(2, t.getBirthYear());
                    preparedStatement.setInt(3, t.getId());
                    preparedStatement.execute();
                    
                    updatedPerson = new Person(t.getId(), t.getName(), t.getBirthYear());
                    
                    return updatedPerson;
                }
                
                
            }catch(SQLException e) {
                throw new CleaningManagerServiceException(e.getMessage());
                
            }
            
	
            return t;
	}

	@Override
	public Person delete(Person t) throws CleaningManagerServiceException {
            
            
                Person deletedPerson = null;
                /**
                 * Här kollas om det är ett id som finns i databasen.
                 * Finns det inget kastas NoSuchElementException från get() metoden.
                 * Bandaid fix atm, kanske måste göra om hela metoden?
                 * id=0 är standardvärde då id inte blivit tilldelad från AutoIncrement i databasen.
                 */
                
		int id = t.getId();
                if(id == 0) {
                    throw new NoSuchElementException("This person do not exist in the database and can therefore not be deleted!");
                }
                int rowCount = 0;
                PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
                
                try {
                    //****This is just for checking the 'delete' is a sucess. Count rows before delete***
			resultSet = dbConManagerSingleton.excecuteQuery("SELECT COUNT(id) FROM labPersons");
			resultSet.next();
			rowCount = resultSet.getInt(1);
			//System.out.println(rowCount); // Debug print
                    preparedStatement = dbConManagerSingleton.prepareStatement("DELETE FROM labPersons where id="+id);
                   preparedStatement.execute();
                   
                   // **** Check nbr of rows after 'save'. Compare with previous row count *****
			resultSet = dbConManagerSingleton.excecuteQuery("SELECT COUNT(id) FROM labPersons");
			resultSet.next();
			int newRowCount = resultSet.getInt(1);
			if( newRowCount == (rowCount - 1)){ // Check if table is one more row after 'save'
				deletedPerson = t;
                        }
//			System.out.format("Previous row count: %d    Current row count: %d", rowCount, newRowCount);

                } 
                catch (SQLException e) {
			new CleaningManagerServiceException(e.getMessage());
		}
                
                return deletedPerson;

	}

}
