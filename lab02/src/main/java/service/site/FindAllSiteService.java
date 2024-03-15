/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import java.util.List;
import repository.DaoFactory;
import repository.SiteDao;
import service.BaseService;
import service.CleaningManagerServiceException;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class FindAllSiteService extends BaseService<List<Site>>{

    @Override
    public List<Site> execute() {
        List<Site> siteList = getFactory().get(DaoFactory.DaoFactoryType.SITE).getAll();
        return siteList;
    }

    
    
    
}
