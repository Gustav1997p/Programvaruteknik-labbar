/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import repository.SiteDao;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class SaveSiteService implements ServiceCommand<Site> {

    private Site siteToSave = null;

    public SaveSiteService(Site site) {
        this.siteToSave = site;
    }
    
    public SaveSiteService(String name, int birthYear) {
        this.siteToSave = new Site(birthYear, name);
    }

    @Override
    public Site execute() {
        try {
            SiteDao siteDao = new SiteDao();
            db.DbConnectionManager.getInstance().open();
            siteToSave = siteDao.save(siteToSave);

        } catch (CleaningManagerServiceException e) {
            System.err.println(e.getMessage());

        } finally {
            db.DbConnectionManager.getInstance().close();
        }

        return siteToSave;
    }

}
