/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import repository.Dao;
import repository.DaoFactory;
import repository.PersonDao;
import service.BaseService;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author gurra
 */
public class SavePersonService extends BaseService<Person> {
    // attribut av Person-objekt som skall sparas
    private Person personToSave = null;
    
    //Konstruktor som använder ett Person-objekt för att spara en person
    public SavePersonService(Person person) {
        this.personToSave = person;
    }
    /**
     * Överlagrad konstruktor som tar emot alla attribut som behövs för att skapa
     * ett Person-objekt.
     * 
     * Onödigt att först skapa ett Person-objekt innan man sparar när man
     * kan göra alltin samtidigt?
     * 
     * @param name, Namnet på det Person-objekt som skall skapas
     * @param birthYear, Födelseår på det Person-objekt som skall skapas. 
     */
    public SavePersonService(String name, int birthYear) {
        this.personToSave = new Person(name, birthYear);
    }
    

    @Override
    public Person execute() {
      Dao<Person> dao = getFactory().get(DaoFactory.DaoFactoryType.PERSON);
      return dao.save(personToSave);
    }
    
}
