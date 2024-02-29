/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import java.util.List;
import repository.PersonDao;
import service.ServiceCommand;

/**
 *
 * @author gurra
 */
public class FindAllPersonService implements ServiceCommand<List<Person>> {

    @Override
    public List<Person> execute() {
        
        
        PersonDao personDao = new PersonDao();
         db.DbConnectionManager.getInstance().open();
        List<Person> personList = personDao.getAll();
         db.DbConnectionManager.getInstance().close();
        return personList;

    }

}
