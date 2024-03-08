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
public class FindSiteByIdService implements ServiceCommand<Site> {

    private int idSiteToFind;
    private Site siteToReturn;

    public FindSiteByIdService(int id) {
        this.idSiteToFind = id;
    }

    @Override
    public Site execute() {

        try {
            SiteDao siteDao = new SiteDao();
            db.DbConnectionManager.getInstance().open();
            siteToReturn = siteDao.get(idSiteToFind);

        } catch (CleaningManagerServiceException e) {
            System.err.println(e.getMessage());

        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());

        } finally {
            db.DbConnectionManager.getInstance().close();
        }
        return siteToReturn;

    }

}
