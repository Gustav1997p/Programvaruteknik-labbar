/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import java.util.NoSuchElementException;
import repository.Dao;
import repository.DaoFactory;
import repository.SiteDao;
import service.BaseService;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class UpdateSiteService extends BaseService<Site>{

    Site siteToUpdate = null;

    public UpdateSiteService(Site site) {
        this.siteToUpdate = site;
    }
    
    
    @Override
    public Site execute() {
        Dao<Site> dao = getFactory().get(DaoFactory.DaoFactoryType.SITE);
        return dao.update(siteToUpdate);
    }
    
}
