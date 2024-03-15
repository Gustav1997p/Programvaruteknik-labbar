/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.site;

import domain.Site;
import service.BaseService;
import service.ServiceCommand;

/**
 *
 * @author Gustav
 */
public class CreateSiteService extends BaseService<Site>{
    
    private String name;
    
    private Site site = null;

    public CreateSiteService(String name) {
        this.name = name;
        
    }

    @Override
    public Site execute() {
        this.site = new Site(name);
        return site;
    }
    
    
    
    
    
}
