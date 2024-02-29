/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import java.util.List;
import repository.PersonDao;

/**
 *
 * @author Gustav
 */
public class ServicePerson {
    private final PersonDao personDao;

    public ServicePerson() { 
        this(new PersonDao());
        
    }
    public ServicePerson(PersonDao persondao) {
        personDao = persondao;
    }
    
    public Person getPerson(int id) {
        return personDao.get(id);
    }
    public List<Person> getAllPersons() {
        return personDao.getAll();
    }
    public Person savePerson(Person personToSave) {
        return personDao.save(personToSave);
    }
    public Person updatePerson(Person personToUpdate) {
        return personDao.update(personToUpdate);
    }
    public Person deletePerson(Person personToDelete) {
        return personDao.delete(personToDelete);
    }
    
    
    
}
