/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConnectionManager;
import repository.DaoFactory;

/**
 *
 * @author gurra
 */
public abstract class BaseService<T> implements ServiceCommand<T> {
    
    private DaoFactory factory;

    @Override
    public void init(DaoFactory factory) {
        setFactory(factory);
    }

    @Override
    public abstract T execute();

    
    public DaoFactory getFactory() {
        return factory;
    }

    public void setFactory(DaoFactory factory) {
        this.factory = factory;
    }
    
    
    
}
