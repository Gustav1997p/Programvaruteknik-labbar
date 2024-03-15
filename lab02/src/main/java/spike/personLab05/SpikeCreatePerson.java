/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.personLab05;

import domain.Person;
import service.ServiceCommand;
import service.ServiceRunner;
import service.person.CreatePersonService;

/**
 *
 * @author gurra
 */
public class SpikeCreatePerson {
        public static void main(String[] args) {
            String name = "Jan";
            int by = 1996;
            
            ServiceCommand<Person> create = new CreatePersonService(name, by);
            ServiceRunner<Person> runnerCreate = new ServiceRunner(create);
            Person person = runnerCreate.execute();
            
            System.out.println(person.toString());
        }

            
    
}
