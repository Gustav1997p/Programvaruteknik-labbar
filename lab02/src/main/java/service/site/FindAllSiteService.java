/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import java.util.List;
import repository.SiteDao;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class FindAllSiteService implements ServiceCommand<List<Site>>{

    @Override
    public List<Site> execute() {
        
        List<Site> siteList = null;
        
        try{
            SiteDao siteDao = new SiteDao();
            db.DbConnectionManager.getInstance().open();
            siteList = siteDao.getAll();
            
        }
        catch (CleaningManagerServiceException e) {
            System.err.println(e.getMessage());
        }
        finally {
            db.DbConnectionManager.getInstance().close();
        }
        return siteList;
    }
    
    
}
