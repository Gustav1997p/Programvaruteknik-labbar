/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Site;
import java.util.List;
import repository.SiteDao;

/**
 *
 * @author Gustav
 */
public class ServiceSite {
    private final SiteDao siteDao;

    public ServiceSite() {
        this(new SiteDao());
    }
    public ServiceSite(SiteDao sitedao) {
        siteDao = sitedao;
        
        
    }
    public Site getSite(int id) {
        return siteDao.get(id);
    }
    public List<Site> getAllSites() {
        return siteDao.getAll();
    }
    public Site saveSite(Site siteToSave) {
        return siteDao.save(siteToSave);
    }
    public Site updateSite(Site siteToUpdate) {
        return siteDao.update(siteToUpdate);
    }
    public Site deleteSite(Site siteToDelete) {
        return siteDao.delete(siteToDelete);
    }
    
    
    
}
