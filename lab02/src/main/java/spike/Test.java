/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;

/**
 *
 * @author gurra
 */
public class Test {
     public static void main(String[] args) {
         Person person = new Person("Gustav", 2000);
         System.out.println(person.getId());
         System.out.println(person.toString());
     }
    
}
