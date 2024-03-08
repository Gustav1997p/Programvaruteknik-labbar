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
public class DeleteSiteService implements ServiceCommand<Site> {

    private Site siteToDelete = null;

    public DeleteSiteService(Site site) {
        this.siteToDelete = site;
    }

    @Override
    public Site execute() {
        try {
            SiteDao siteDao = new SiteDao();
            db.DbConnectionManager.getInstance().open();
            siteDao.delete(siteToDelete);

        } catch (CleaningManagerServiceException e) {
            System.err.println(e.getMessage());

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());

        } finally {
            db.DbConnectionManager.getInstance().close();
        }
        return siteToDelete;
    }

}
