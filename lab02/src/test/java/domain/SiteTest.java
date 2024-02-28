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
 * @author Gustav
 */
public class SiteTest {
    private static Site site = null;
    private static Site siteId = null;
    
    public SiteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
       site = new Site("Gävle");
       siteId = new Site(8,"Uppsala");
    }
    
    @AfterAll
    public static void tearDownClass() {
        site = null;
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setCity method, of class Site.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "Sandviken";
        String expected = "Sandviken";
        assertEquals(city, expected);
    }

    /**
     * Test of getId method, of class Site.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        
        int expResult = 0;
        int expResult2 = 8;
        int result = site.getId();
        int result2 = siteId.getId();
        assertEquals(expResult,result);
        assertEquals(expResult2,result2);
       
    }

    /**
     * Test of getCity method, of class Site.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "Gävle";
        assertEquals(expResult, site.getCity());
        
    }
    @Test 
    public void testSetCityException() {
        assertThrows(IllegalArgumentException.class, () -> site.setCity(""));
    }
    @Test 
    public void testSetCityException2() {
        assertThrows(IllegalArgumentException.class, () -> site.setCity("$t0ckh0lM"));
    }
    
}
