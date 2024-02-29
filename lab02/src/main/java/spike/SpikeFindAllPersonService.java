/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import java.util.List;
import service.person.FindAllPersonService;

/**
 *
 * @author gurra
 */
public class SpikeFindAllPersonService {
    
    public static void main(String[] args) {
        
        List<Person> listOfPersons = new FindAllPersonService().execute();
        for(Person p : listOfPersons) {
            System.out.println(p.getName());
            
        }
    }
    
}
