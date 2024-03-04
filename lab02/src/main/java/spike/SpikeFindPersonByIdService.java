/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import service.person.FindPersonByIdService;

/**
 *
 * @author gurra
 */
public class SpikeFindPersonByIdService {
    public static void main(String[] args) {
        
        Person person1 = new FindPersonByIdService(1).execute();
        Person person2 = new FindPersonByIdService(10).execute();
        System.out.println(person1.getName());
        
        
    }
    
}
