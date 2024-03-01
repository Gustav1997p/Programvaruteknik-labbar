/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import java.util.List;
import repository.PersonDao;
import service.person.ServicePerson;

/**
 *
 * @author gurra
 */
public class SpikeCreatePerson {
    
    public static void main(String[] args) {
        
        ServicePerson servicePerson = new ServicePerson();
        List<Person> personList = servicePerson.getAllPersons();
        int birthyear = 1996;
        String name = "Ole";
         
        
        /**
         * Osäker om detta är hur det är menat att man ska spara en person med
         * ServicePerson-klassen eller om man skall skapa metoder i ServicePerson
         * som t.ex. heter "createPerson(int birthYear, String name)" där servicePerson
         * delegerar till Person-klassen som skapar Person-objektet.
         * T.ex. servicePerson.savePerson(servicePerson.createPerson(2000,"Stefan"); i denna situation
         * 
         * Jag har i nuläget tolkat det som att ServicePerson endast skall utföra operationer
         * via DAO-klassen och inte några operationer via Person-klassen såsom skapandet av Person.
         */
        Person personAttSpara = new Person(name, birthyear);
        
        //Skriver ut listan för att se hur den ser ut innan en ny person sparas
        for(Person t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName());

        }
        
        System.out.println(servicePerson.savePerson(personAttSpara).toString());
        
        //Uppdaterar listan och skriver ut den nya listan efter en person är blivit sparad
        //för att see att listan nu är annorlunda
        personList = servicePerson.getAllPersons();
        for(Person t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName());

        }
        
        // Litet kort test för endast get() metoden
        System.out.println(servicePerson.getPerson(1).getName());
        
    }
    
}

