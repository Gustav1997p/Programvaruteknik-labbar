/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import db.DbConnectionManager;
import repository.DaoFactory;

/**
 *
 * @author gurra
 */
public interface ServiceCommand<T> {
    
    public void init(DaoFactory factory);
    public <T> T execute();
    
    
}
