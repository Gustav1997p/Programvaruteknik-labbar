/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Person;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import repository.PersonDao;

/**
 *
 * @author Gustav
 */
public class ServicePersonTest {

    Person personForTest;
    Person personNoId;

    public ServicePersonTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        personForTest = new Person(1, "Kalle Karlsson", 2001);
        
    }

    @AfterEach
    public void tearDown() {
        personForTest = null;
    }

    /**
     * Test of getPerson method, of class ServicePerson.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        
        
        PersonDao personDaoMock = mock(PersonDao.class);
        // om get() anropas så returneras en Person
        when(personDaoMock.get(1)).thenReturn(new Person(1, "Kalle Karlsson", 2001));
        
        // injencera beriebdet ( av mockat object )
        ServicePerson instance = new ServicePerson(personDaoMock);

        Person expResult = personForTest;
        Person result = instance.getPerson(1);
        
        
        
        assertEquals(expResult.toString(), result.toString());
        verify(personDaoMock, times(1)).get(1);
        
        // Testar göra samma sak en gång till bara för att
       Person result2 = instance.getPerson(1);
       assertEquals(expResult.getName(), result2.getName());
       verify(personDaoMock, times(2)).get(1);
        

    }

    /**
     * Test of getAllPersons method, of class ServicePerson.
     */
    @Test
    public void testGetAllPersons() {
        System.out.println("getAllPersons");
        PersonDao personDaoMock = mock(PersonDao.class);
        // om getAllPersons() anropas så retunerar en lista med Person
        when(personDaoMock.getAll()).thenReturn(List.of(new Person(1, "Kalle Karlsson", 2001)));

        // Injencera beroendet(av mockat objekt)
        ServicePerson instance = new ServicePerson(personDaoMock);

        List<Person> expResult = List.of(personForTest);
        List<Person> result = instance.getAllPersons();

        assertEquals(expResult.toString(), result.toString()); // Kontrollera längden. 

        verify(personDaoMock, times(1)).getAll(); // Kontrollera betendeet (getAll() an´ropas)

    }

    /**
     * Test of savePerson method, of class ServicePerson.
     */
    @Test
    public void testSavePerson() {
        System.out.println("savePerson");
        personNoId = new Person("Kalle Karlsson", 2001);
        // Skapa en mock
        PersonDao personDaoMock = mock(PersonDao.class);
        // om save() anropas så returneras en person
        when(personDaoMock.save(personNoId)).thenReturn(new Person(1, "Kalle Karlsson", 2001));
        // Injencera beroendet(av mockat objekt)
        ServicePerson instance = new ServicePerson(personDaoMock);
        
        Person expResult = personForTest;
        Person result = instance.savePerson(personNoId);
        //Tester
        verify(personDaoMock, times(1)).save(personNoId);
        assertEquals(expResult.toString(), result.toString());
        assertFalse(result.equals(personNoId));
        
//        System.out.println(expResult.toString());
//        System.out.println(result.toString());
        
       
    }

    /**
     * Test of updatePerson method, of class ServicePerson.
     */
    @Test
    public void testUpdatePerson() {
        System.out.println("updatePerson");
        // Byta namn och födelseår på person att uppdatera
        personForTest.setName("Janne Karlsson");
        personForTest.setBirthYear(1988);
        //Skapa en mock 
        PersonDao personDaoMock = mock(PersonDao.class);
        //Om update() anropas så returneras en Person
        when(personDaoMock.update(personForTest)).thenReturn(new Person(1,"Janne Karlsson",1988));
        // Injencera beroendet(av mockat objekt)
        ServicePerson instance = new ServicePerson(personDaoMock);
        
        Person expResult = personForTest;
        Person result = instance.updatePerson(personForTest);
        
        assertEquals(expResult, result);
        verify(personDaoMock, times(1)).update(personForTest);
        
//        System.out.println(expResult.toString());
//        System.out.println(result.toString());
        
    }

    /**
     * Test of deletePerson method, of class ServicePerson.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        //Skapa en mock 
        PersonDao personDaoMock = mock(PersonDao.class);
        // Om delete() anropas så returnerar en person
        when(personDaoMock.delete(personForTest)).thenReturn(new Person(1, "Kalle Karlsson", 2001));
        // Injencera beroendet(av mockat objekt)
        ServicePerson instance = new ServicePerson(personDaoMock);
        
        Person expResult = personForTest;
        Person result = instance.deletePerson(personForTest);
        
        assertEquals(expResult, result);
        verify(personDaoMock, times(1)).delete(personForTest);
        
        
        
    }

}
