/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import domain.Site;
import java.util.List;
import service.ServicePerson;

/**
 *
 * @author gurra
 */
public class SpikeDeletePerson {
     public static void main(String[] args) {
        int birthyear = 1997;
        String name = "temp";
         
        ServicePerson servicePerson = new ServicePerson();
        List<Person> personList = servicePerson.getAllPersons();
        // Temporär person som innehåller de
        Person personToDelete = new Person(3, name, birthyear);
        
        //Listan innan delete
        for(Person t : personList) {
            System.out.println("id: "+t.getId()+" name: "+t.getName());
        }
        
        servicePerson.deletePerson(personToDelete);
        
        //Listan efter delete
        personList = servicePerson.getAllPersons();
        for(Person t : personList) {
            System.out.println("id: "+t.getId()+" name: "+t.getName());
        }
        
         
         
         
         
     }
    
}
