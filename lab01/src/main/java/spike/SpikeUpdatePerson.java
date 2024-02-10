/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import java.util.List;
import repository.PersonDao;
import service.ServicePerson;

/**
 *
 * @author gurra
 */
public class SpikeUpdatePerson {
     public static void main(String[] args) {
         
        ServicePerson servicePerson = new ServicePerson();
        List<Person> personList = servicePerson.getAllPersons();
        int age = 1997;
        String name = "Gustav";
        Person personToUpdate = new Person(1,name, age);
        // Skriver ut listan för att se hur det ser ut innan en person uppdateras
        for(Person t : personList) {
            System.out.println("id: "+t.getId()+" name: "+t.getName());

        }
        
        servicePerson.updatePerson(personToUpdate);
        
        // Skriver ut listan efter att en person uppdaterats
        personList = servicePerson.getAllPersons();
        for(Person t : personList) {
            System.out.println("id: "+t.getId()+" name: "+t.getName());
   
     }
    
}
}
