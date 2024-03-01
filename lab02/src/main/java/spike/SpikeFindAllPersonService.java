/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import java.util.List;
import java.util.stream.Collectors;
import service.person.FindAllPersonService;

/**
 *
 * @author gurra
 */
public class SpikeFindAllPersonService {
    
    public static void main(String[] args) {
        
        List<Person> listOfPersons = new FindAllPersonService().execute();
//        for(Person p : listOfPersons) {
//            System.out.println(p.getName());
//            
//        }
        var listOfNames = listOfPersons.stream().map(p -> p.getName()).collect(Collectors.joining("\n"));
        System.out.println(listOfNames);
        
    }
    
}
