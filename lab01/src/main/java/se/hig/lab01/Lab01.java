/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package se.hig.lab01;

import domain.Person;
import java.time.Year;
import java.util.List;
import repository.PersonDao;

/**
 *
 * @author Gustav
 */
public class Lab01 {

    public static void main(String[] args) {
        PersonDao labPersonDao = new PersonDao();
        List<Person> personList = labPersonDao.getAll();
        
        
       
        
        for(Person person : personList) {
            System.out.println(person.getName());
        }
        for(Person person : personList) {
            System.out.println("id: "+person.getId()+" name: "+person.getName());
        }
        int tal = 2008;
        int length = (int) (Math.log10(tal)+1);
        System.out.println("tal: "+tal);
        System.out.println("längd: "+length);
        Person person = new Person("Gustav", 2025);
        
        String name = "";
        if (name.matches("^[a-zA-ZåäöÅÄÖ]+")) {
        System.out.println("Name: "+ " containts only letters");
    }
        else {
            System.out.println("Name: "+ " doesnt containts only letters");
        }
    }
}
