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
public class FindSiteByIdService extends BaseService<Site> {

    private int idSiteToFind;

    public FindSiteByIdService(int id) {
        this.idSiteToFind = id;
    }

    @Override
    public Site execute() {
        Dao<Site> dao = super.getFactory().get(DaoFactory.DaoFactoryType.SITE);
        return dao.get(idSiteToFind);


    }

}
