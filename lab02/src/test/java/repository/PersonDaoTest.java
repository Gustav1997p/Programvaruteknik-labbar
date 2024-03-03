/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package repository;

import db.DbConnectionManager;
import domain.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author gurra
 */
public class PersonDaoTest {

    DbConnectionManager mockDbManager;
    PersonDao personDao;
    Person personToTest;

    public PersonDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        mockDbManager = mock(DbConnectionManager.class);
        personDao = new PersonDao(mockDbManager);
        personToTest = new Person(1, "Janne Jansson", 1969);
    }

    @AfterEach
    public void tearDown() {
        mockDbManager = null;
        personDao = null;
        personToTest = null;
    }

    /**
     * Test of get method, of class PersonDao.
     */
    @Test
    public void testGet() {
        System.out.println("get");

        try {
            int id = 1;
            String name = "Mikael";
            int by = 1970;
            ResultSet mockResultSet = mock(ResultSet.class);

            when(mockResultSet.next()).thenReturn(Boolean.TRUE);
            when(mockResultSet.getInt(1)).thenReturn(id);
            when(mockResultSet.getString(2)).thenReturn(name);
            when(mockResultSet.getInt(3)).thenReturn(by);
            when(mockDbManager.excecuteQuery(anyString())).thenReturn(mockResultSet);

            Person result = personDao.get(1);
            Person expResult = new Person(id, name, by);

            assertTrue(expResult.equals(result));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test of getAll method, of class PersonDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        try {
            ResultSet mockResultSet = mock(ResultSet.class);

            when(mockResultSet.next()).thenReturn(true, true, true, false);
            when(mockResultSet.getInt(1)).thenReturn(1, 2, 3);
            when(mockResultSet.getString(2)).thenReturn("Gustav", "Martin", "Agnes");
            when(mockResultSet.getInt(3)).thenReturn(1997, 1999, 2013);

            when(mockDbManager.excecuteQuery(anyString())).thenReturn(mockResultSet);

            List<Person> mockPersons = new ArrayList<>();
            mockPersons.add(new Person(1, "Gustav", 1997));
            mockPersons.add(new Person(2, "Martin", 1999));
            mockPersons.add(new Person(3, "Agnes", 2013));

            List<Person> expResult = mockPersons;
            List<Person> result = personDao.getAll();

            assertEquals(expResult, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test of save method, of class PersonDao.
     */
    @Test
    public void testSave() {
        System.out.println("save");

        try {
            int id = 1;
            String name = "Martin";
            int by = 1999;

            Person personToSave = new Person(name, by);
            
            PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
            when(mockDbManager.prepareStatement(anyString(), anyBoolean())).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.execute()).thenReturn(true);
            
            ResultSet mockResultSet = mock(ResultSet.class);
            when(mockResultSet.getInt(1)).thenReturn(id);
            when(mockResultSet.next()).thenReturn(true);
            when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet);

            Person result = personDao.save(personToSave);
            Person expResult = new Person(1, name, by);

            assertTrue(expResult.equals(result));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test of update method, of class PersonDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        try {
            int id = 1;
            String name = "Jon";
            String newName = "Steve";
            int by = 1999;
            PreparedStatement mockPreparedStateMent = mock(PreparedStatement.class);
            Person personToUpdate = new Person(id, name, by);
            PersonDao spyDao = spy(personDao);

            personToUpdate.setName(newName);

            when(mockDbManager.prepareStatement(anyString())).thenReturn(mockPreparedStateMent);
            when(mockPreparedStateMent.execute()).thenReturn(true);

            //when(spyDao.get(anyInt())).thenReturn(new Person(1, name, by));
            //^ ovan fungerar ej pga det är en spy och inte en mock. därav måste en doReturn göras.
            doReturn(new Person(id, name, by)).when(spyDao).get(anyInt());

            Person expResult = new Person(id, newName, by);
            Person result = spyDao.update(personToUpdate);

            assertEquals(expResult, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test of delete method, of class PersonDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        try {
            int rowCount = 5;
            int id = 1;
            String name = "Agnes";
            int by = 2013;
            Person personToDelete = new Person(id, name, by);

            ResultSet mockResultSet = mock(ResultSet.class);
            when(mockDbManager.excecuteQuery(anyString())).thenReturn(mockResultSet, mockResultSet);
            when(mockResultSet.next()).thenReturn(true, true);
            when(mockResultSet.getInt(1)).thenReturn(rowCount, rowCount -1);
            
            PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
            when(mockDbManager.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.execute()).thenReturn(true);
            
            Person result = personToDelete;
            Person expResult = personDao.delete(personToDelete);
            
            assertTrue(result.equals(expResult));
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
