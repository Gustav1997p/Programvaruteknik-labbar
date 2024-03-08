/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import java.util.NoSuchElementException;
import repository.SiteDao;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class UpdateSiteService implements ServiceCommand<Site>{

    Site siteToUpdate = null;

    public UpdateSiteService(Site site) {
        this.siteToUpdate = site;
    }
    
    
    @Override
    public Site execute() {
        try {
            SiteDao siteDao = new SiteDao();
            db.DbConnectionManager.getInstance().open();
            siteToUpdate = siteDao.update(siteToUpdate);
        }catch(CleaningManagerServiceException e) {
            System.err.println(e.getMessage());
        }catch(NoSuchElementException e) {
            System.err.println(e.getMessage());
        }finally {
            db.DbConnectionManager.getInstance().close();
        }
        return siteToUpdate;
    }
    
}
