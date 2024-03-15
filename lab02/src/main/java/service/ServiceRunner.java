/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConnectionManager;
import java.util.NoSuchElementException;
import repository.DaoFactory;

/**
 *
 * @author gurra
 */
public class ServiceRunner<T> {

    private final ServiceCommand<T> service;
    private DbConnectionManager dbConnManager;
    T result;

    public ServiceRunner(ServiceCommand<T> service) {
        this.service = service;
    }

    public T execute() {
        try {
            dbConnManager = DbConnectionManager.getInstance();
            service.init(new DaoFactory());
            dbConnManager.open();
            result = service.execute();
        } catch (CleaningManagerServiceException e) {
            e.printStackTrace();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            dbConnManager.close();
        }

        return result;
    }

}
