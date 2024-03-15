/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.personLab05;

import domain.Person;
import service.ServiceCommand;
import service.ServiceRunner;
import service.person.SavePersonService;

/**
 *
 * @author gurra
 */
public class SpikeSavePersonService {

    public static void main(String[] args) {
        String name = "Jesper";
        int by = 1992;
        
        ServiceCommand<Person> save = new SavePersonService(name, by);
        ServiceRunner<Person> runnerSave = new ServiceRunner(save);
        
        Person person = runnerSave.execute();
        System.out.println(person.toString());
        
        
        
    }

}
