/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.personLab05;

import domain.Person;
import service.ServiceCommand;
import service.ServiceRunner;
import service.person.FindPersonByIdService;
import service.person.UpdatePersonService;

/**
 *
 * @author gurra
 */
public class SpikeUpdatePersonService {

    public static void main(String[] args) {
        /**
         * Kör findPerson för att hitta en existerande person i databasen
         * för att uppdatera den personen i fråga
         */
        ServiceCommand<Person> findPerson = new FindPersonByIdService(18);
        ServiceRunner<Person> runnerFindPerson = new ServiceRunner(findPerson);
        Person personToUpdate = runnerFindPerson.execute();
        System.out.println(personToUpdate.getName());
        personToUpdate.setName("Joakim");
        /**
         * Uppdaterar person vi tidigare hämtade
         */
        ServiceCommand<Person> update = new UpdatePersonService(personToUpdate);
        ServiceRunner<Person> runnerUpdate = new ServiceRunner(update);
        runnerUpdate.execute();
        /**
         * Hämta person med Id från databasen för att se om namnet är uppdaterat
         */
        Person updatedPerson = runnerFindPerson.execute();
        System.out.println(updatedPerson.getName());

    }

}
