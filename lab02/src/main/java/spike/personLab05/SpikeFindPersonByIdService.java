/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.personLab05;

import domain.Person;
import service.ServiceCommand;
import service.ServiceRunner;

import service.person.FindPersonByIdService;

/**
 *
 * @author gurra
 */
public class SpikeFindPersonByIdService {
public static void main(String[] args) {
   
    
    ServiceCommand<Person> findPerson = new FindPersonByIdService(18);
    ServiceRunner<Person> runnerFindPerson = new ServiceRunner(findPerson);
    
    Person person1 = runnerFindPerson.execute();
    
    System.out.println(person1.getName());
}
}
