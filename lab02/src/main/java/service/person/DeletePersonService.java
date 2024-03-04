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
 * @author Gustav
 */
public class DeletePersonService implements ServiceCommand<Person> {

    private Person personToDelete = null;

    public DeletePersonService(Person person) {
        this.personToDelete = person;

    }

    @Override
    public Person execute() {
        try {
            PersonDao personDao = new PersonDao();
            db.DbConnectionManager.getInstance().open();
            personDao.delete(personToDelete);

        } catch (CleaningManagerServiceException e) {
            System.out.println(e.getMessage());

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());

        } finally {
            db.DbConnectionManager.getInstance().close();

        }
        return personToDelete;
    }

}
