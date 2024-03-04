/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import java.util.NoSuchElementException;
import repository.PersonDao;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author gurra
 */
public class FindPersonByIdService implements ServiceCommand<Person> {

    private int idPersonToFind;
    private Person personToReturn;

    public FindPersonByIdService(int id) {
        this.idPersonToFind = id;
    }

    @Override
    public Person execute() {

        try {
            PersonDao personDao = new PersonDao();
            db.DbConnectionManager.getInstance().open();
            personToReturn = personDao.get(idPersonToFind);

        } catch (CleaningManagerServiceException e) {
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            
        }
        finally {
            db.DbConnectionManager.getInstance().close();
        }
        return personToReturn;

    }

}
