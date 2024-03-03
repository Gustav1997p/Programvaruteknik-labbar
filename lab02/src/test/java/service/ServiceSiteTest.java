/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Site;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.SiteDao;

/**
 *
 * @author Gustav
 */
public class ServiceSiteTest {

    Site siteForTest;
    Site siteNoId;
    SiteDao siteDaoMock;

    public ServiceSiteTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        siteForTest = new Site(1, "Gävle");
        siteDaoMock = mock(SiteDao.class);
    }

    @AfterEach
    public void tearDown() {
        siteForTest = null;
        siteDaoMock = null;
    }

    /**
     * Test of getSite method, of class ServiceSite.
     */
    @Test
    public void testGetSite() {
        System.out.println("getSite");

        when(siteDaoMock.get(1)).thenReturn(new Site(1, "Gävle"));
        // injencera beriebdet ( av mockat object )
        ServiceSite instance = new ServiceSite(siteDaoMock);

        Site expResult = siteForTest;
        Site result = instance.getSite(1);

        assertEquals(expResult, result);
        verify(siteDaoMock, times(1)).get(1);

    }

    /**
     * Test of getAllSites method, of class ServiceSite.
     */
    @Test
    public void testGetAllSites() {
        System.out.println("getAllSites");
        
        when(siteDaoMock.getAll()).thenReturn(List.of(new Site(1, "Gävle")));
        // injencera beriebdet ( av mockat object )
        ServiceSite instance = new ServiceSite(siteDaoMock);
        
        List<Site> expResult = List.of(siteForTest);
        List<Site> result = instance.getAllSites();
        
        assertEquals(expResult.toString(), result.toString());
        verify(siteDaoMock, times(1)).getAll();
        
        
        
    }

    /**
     * Test of saveSite method, of class ServiceSite.
     */
    @Test
    public void testSaveSite() {
        System.out.println("saveSite");
        siteNoId = new Site("Sandviken");
        when(siteDaoMock.save(siteNoId)).thenReturn(new Site(1, "Gävle"));
        // injencera beriebdet ( av mockat object )
        ServiceSite instance = new ServiceSite(siteDaoMock);
        
        Site expResult = siteForTest;
        Site result = instance.saveSite(siteNoId);
        
        verify(siteDaoMock, times(1)).save(siteNoId);
        assertTrue(result.equals(expResult));
        
        
    }

    /**
     * Test of updateSite method, of class ServiceSite.
     */
    @Test
    public void testUpdateSite() {
        System.out.println("updateSite");
        siteForTest.setCity("Sandviken");
        when(siteDaoMock.update(siteForTest)).thenReturn(new Site(1, "Sandviken"));
        // injencera beriebdet ( av mockat object )
        ServiceSite instance = new ServiceSite(siteDaoMock);
        
        Site expResult = siteForTest;
        Site result = instance.updateSite(siteForTest);
        
        assertTrue(expResult.equals(result));
        verify(siteDaoMock, times(1)).update(siteForTest);
        
    }

    /**
     * Test of deleteSite method, of class ServiceSite.
     */
    @Test
    public void testDeleteSite() {
        System.out.println("deleteSite");
        
        when(siteDaoMock.delete(siteForTest)).thenReturn(new Site(1, "Gävle"));
        // injencera beriebdet ( av mockat object )
        ServiceSite instance = new ServiceSite(siteDaoMock);
        
        Site expResult = siteForTest;
        Site result = instance.deleteSite(siteForTest);
        
        assertTrue(expResult.equals(result));
        verify(siteDaoMock, times(1)).delete(siteForTest);
    }

}
