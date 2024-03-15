/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.person;

import db.DbConnectionManager;
import domain.Person;
import java.util.List;
import java.util.NoSuchElementException;
import repository.Dao;
import repository.DaoFactory;
import repository.DaoFactory.DaoFactoryType;
import repository.PersonDao;
import service.BaseService;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author gurra
 */
public class FindAllPersonService extends BaseService<List<Person>> {

    @Override
    public List<Person> execute() {
        return super.getFactory().get(DaoFactoryType.PERSON).getAll();
    }

//    @Override
//    public List<Person> execute() {
//        List<Person> personList = getFactory().get(DaoFactoryType.PERSON).getAll();
//
//        return personList;
//    }

}
