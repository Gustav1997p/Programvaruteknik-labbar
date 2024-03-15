/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import domain.Person;
import java.util.NoSuchElementException;
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
public class FindPersonByIdService extends BaseService<Person> {

    private int idPersonToFind;
    

    public FindPersonByIdService(int id) {
        this.idPersonToFind = id;
    }

    @Override
    public Person execute() {
        Dao<Person> dao = getFactory().get(DaoFactory.DaoFactoryType.PERSON);
        return dao.get(idPersonToFind);


    }

}
