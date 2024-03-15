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
import service.person.FindAllPersonService;

/**
 *
 * @author gurra
 */
public class SpikeFindAllPersonService {
        public static void main(String[] args) {
            
            ServiceCommand<List<Person>> findAll = new FindAllPersonService();
            ServiceRunner<List<Person>> runnerFindAll = new ServiceRunner(findAll);
            
            
            List<Person> personList = runnerFindAll.execute();
            
            var listOfNames = personList.stream().map(p -> p.getName()).collect(Collectors.joining("\n"));
            System.out.println(listOfNames);
        }

    
}
