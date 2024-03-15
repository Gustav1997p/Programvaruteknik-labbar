/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import db.DbConnectionManager;
import domain.Person;
import repository.DaoFactory;
import service.BaseService;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class CreatePersonService extends BaseService<Person> {
    
    private String name;
    private int birthYear;
    private Person person = null;
    
    
    public CreatePersonService(String name, int birthyear) {
        this.name = name;
        this.birthYear = birthyear;
    }

    @Override
    public Person execute() {
        this.person = new Person(name, birthYear);
        return person;
        
    }

    
    
    
}
