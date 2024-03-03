/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gurra
 */
public class PersonTest {
    Person person1 = null;
    Person person2 = null;
    
    public PersonTest() {
    }

    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
         person1 = new Person("Kalle Karlsson",2022);
         person2 = new Person(25,"Kalle Karlsson",2022);
    }
    
    @AfterEach
    public void tearDown() {
        person1 = null;
    }

    /**
     * Test of setBirthYear method, of class Person.
     */
    @Test
    public void testSetBirthYear() {
        System.out.println("setBirthYear");
        person1.setBirthYear(2000);
        int expected = 2000;
        assertEquals(expected, person1.getBirthYear());
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Janne Järn";
        person1.setName(name);
        assertEquals(name, person1.getName());
        
       
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Kalle Karlsson";
        String result = person1.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int result = person1.getId();
        assertEquals(0, result);
        result = person2.getId();
        assertEquals(25, result);
        
    }

    /**
     * Test of getBirthYear method, of class Person.
     */
    @Test
    public void testGetBirthYear() {
        System.out.println("getBirthYear");
        int expResult = 2022;
        int result = person1.getBirthYear();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSetBirthYearException() {
        assertThrows(IllegalArgumentException.class,() -> person1.setBirthYear(200));
    }
    @Test
    public void testSetNameException() {
        String emptyname ="";
        assertThrows(IllegalArgumentException.class, () -> person1.setName(emptyname));
        
    }
    @Test
    public void testSetNameException2() {
        String badName = "Jann3 Jan$$0n";
        assertThrows(IllegalArgumentException.class, () -> person1.setName(badName));
        
    }
    
}
