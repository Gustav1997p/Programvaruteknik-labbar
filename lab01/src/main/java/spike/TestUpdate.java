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
public class TestUpdate {
     public static void main(String[] args) {
    
    int age = 1989;
    String name = "Jon";
    LabPerson person = new LabPerson(21,name, age);
    LabPersonDao labPersonDao = new LabPersonDao();
    List<LabPerson> personList = labPersonDao.getAll();
    // Hämtar hela listan för att titta vad som finns innan kör metod
    for(LabPerson t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName());

        }
    labPersonDao.update(person);
    // Testat ta bort person, fungerar
    //LabPerson personToDelete = new LabPerson(1,name, age);
    //labPersonDao.delete(personToDelete);
    personList = labPersonDao.getAll();
    //Hämtar hela listan för att jämföra vad som finns efter körd metod
    for(LabPerson t : personList) {
        System.out.println("id: "+t.getId()+" name: "+t.getName()+" birthyear: "+t.getBirthYear());

        }
    
    
     }
    
}
