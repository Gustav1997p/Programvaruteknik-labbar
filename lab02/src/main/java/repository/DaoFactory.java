/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author gurra
 */
public class DaoFactory {
    
    public enum DaoFactoryType {
        PERSON, SITE
    }
    public Dao get(DaoFactoryType type) {
        return switch(type) {
            case PERSON -> new PersonDao();
            case SITE -> new SiteDao();
        };
    }
    
}
