/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Person;
import service.ServiceCommand;
import service.person.FindPersonByIdService;
import service.person.UpdatePersonService;

/**
 *
 * @author Gustav
 */
public class SpikeUpdatePersonService {
    public static void main(String[] args) {
        
        String name = "Anton";
        int birthyear = 1998;
        
        Person personToUpdate = new FindPersonByIdService(13).execute();
        System.out.println(personToUpdate.toString());
        personToUpdate.setBirthYear(birthyear);
        personToUpdate.setName(name);
        ServiceCommand cmd = new UpdatePersonService(personToUpdate);
        
        
        System.out.println(cmd.execute().toString());
        
        
    }
    
}
