/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.LabPerson;
import java.util.List;
import repository.LabPersonDao;

/**
 *
 * @author gurra
 */
public class TestSkapa {
    
    public static void main(String[] args) {
    
    int age = 1967;
    String name = "Ola";
    
    LabPerson person = new LabPerson(name, age);
    LabPersonDao labPersonDao = new LabPersonDao();
    List<LabPerson> personList = labPersonDao.getAll();
    
    for(LabPerson t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName());

        }
    labPersonDao.save(person);
    
    personList = labPersonDao.getAll();
    for(LabPerson t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName()+" birthyear: "+t.getBirthYear());

        }
    


    
    }
    
}

