/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.personLab05;

import domain.Person;
import java.util.List;
import java.util.stream.Collectors;
import service.ServiceCommand;
import service.ServiceRunner;
import service.person.DeletePersonService;
import service.person.FindAllPersonService;
import service.person.FindPersonByIdService;

/**
 *
 * @author gurra
 */
public class SpikeDeletePersonService {

    public static void main(String[] args) {
        /**
         * Kör findPerson för att hitta en existerande person i databasen för
         * att ta bort den personen i fråga
         */
        ServiceCommand<Person> findPerson = new FindPersonByIdService(18);
        ServiceRunner<Person> runnerFindPerson = new ServiceRunner(findPerson);
        Person personToDelete = runnerFindPerson.execute();
        /**
         * Deletear den person vi tidigare hämtade
         */
        ServiceCommand<Person> delete = new DeletePersonService(personToDelete);
        ServiceRunner<Person> runnerDelete = new ServiceRunner(delete);
        Person deletedPerson = runnerDelete.execute();

        System.out.println(deletedPerson.toString());

        /**
         * Hämtar en lista av alla personer för att se om personen nu är borta
         * från databasen
         */
        ServiceCommand<List<Person>> findAll = new FindAllPersonService();
        ServiceRunner<List<Person>> runnerFindAll = new ServiceRunner(findAll);

        List<Person> personList = runnerFindAll.execute();

        var listOfNames = personList.stream().map(p -> p.toString()).collect(Collectors.joining("\n"));
        System.out.println(listOfNames);

    }

}
