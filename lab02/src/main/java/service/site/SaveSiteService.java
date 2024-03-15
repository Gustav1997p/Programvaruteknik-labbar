/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
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
public class SaveSiteService extends BaseService<Site> {

    private Site siteToSave = null;

    public SaveSiteService(Site site) {
        this.siteToSave = site;
    }
    
    public SaveSiteService(String name, int birthYear) {
        this.siteToSave = new Site(birthYear, name);
    }

    @Override
    public Site execute() {
        Dao<Site> dao = getFactory().get(DaoFactory.DaoFactoryType.SITE);
        return dao.save(siteToSave);
    }

}
