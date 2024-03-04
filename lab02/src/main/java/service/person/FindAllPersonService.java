/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import java.util.List;
import java.util.NoSuchElementException;
import repository.PersonDao;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author gurra
 */
public class FindAllPersonService implements ServiceCommand<List<Person>> {
    

    @Override
    public List<Person> execute() {
        
        List<Person> personList = null;

        try {
            PersonDao personDao = new PersonDao();
            db.DbConnectionManager.getInstance().open();
            personList = personDao.getAll();
            
        } catch (CleaningManagerServiceException e) {
            e.printStackTrace();
            
        }
        finally {
            db.DbConnectionManager.getInstance().close();
        }
        return personList;
    }

}
