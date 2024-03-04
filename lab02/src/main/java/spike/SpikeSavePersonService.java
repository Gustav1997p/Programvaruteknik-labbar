/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import service.person.CreatePersonService;
import service.person.SavePersonService;

/**
 *
 * @author gurra
 */
public class SpikeSavePersonService {
    public static void main(String[] args) {
        
        String name = "Isabelle";
        int age = 2000;
        
        Person person = new SavePersonService(new CreatePersonService(name, age).execute()).execute();
        
//        Person person2 = new Person(name, age);
//        person2 = new SavePersonService(person2).execute();
//        
//        
//        Person person1 = new SavePersonService(name, age).execute();
//        
//        System.out.println(person1.toString());
        
        
        
    }
    
}
