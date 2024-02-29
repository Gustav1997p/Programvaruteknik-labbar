/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import java.util.List;
import repository.SiteDao;
import service.site.ServiceSite;

/**
 *
 * @author Gustav
 */
public class SpikeCreateSite {
    
    public static void main(String[] args) {
        String cityName = "Malmö";
        Site location = new Site(cityName);
        ServiceSite serviceSite = new ServiceSite();
        
        // getAll() metoden
        List<Site> locationList = serviceSite.getAllSites();
        // Skriver ut listan för att jämföra innehållet från innan en ny site är sparad
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        System.out.println(serviceSite.saveSite(location).toString());
        
        // Uppdaterar listans innehåll efter save-metoden utförts
        locationList = serviceSite.getAllSites();
        // Skriver ut listen efter en site blivit sparad för att jämföra
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        System.out.println(serviceSite.getSite(7).toString());
       
        
    }
    
    
}
