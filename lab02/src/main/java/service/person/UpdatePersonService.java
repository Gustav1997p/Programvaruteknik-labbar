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
public class UpdatePersonService implements ServiceCommand<Person> {

    Person personToUpdate = null;

    public UpdatePersonService(Person person) {
        this.personToUpdate = person;
    }

    @Override
    public Person execute() {
        try {
            PersonDao personDao = new PersonDao();
            db.DbConnectionManager.getInstance().open();
           personToUpdate = personDao.update(personToUpdate);

        } catch (CleaningManagerServiceException e) {
            System.err.println(e.getMessage());

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());

        } finally {
            db.DbConnectionManager.getInstance().close();

        }
        return personToUpdate;
    }

}
