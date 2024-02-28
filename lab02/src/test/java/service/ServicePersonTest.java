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
        Person personToSave = null;
        ServicePerson instance = new ServicePerson();
        Person expResult = null;
        Person result = instance.savePerson(personToSave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePerson method, of class ServicePerson.
     */
    @Test
    public void testUpdatePerson() {
        System.out.println("updatePerson");
        Person personToUpdate = null;
        ServicePerson instance = new ServicePerson();
        Person expResult = null;
        Person result = instance.updatePerson(personToUpdate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class ServicePerson.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        Person personToDelete = null;
        ServicePerson instance = new ServicePerson();
        Person expResult = null;
        Person result = instance.deletePerson(personToDelete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
