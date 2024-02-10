/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import java.util.List;
import repository.SiteDao;
import service.ServiceSite;

/**
 *
 * @author Gustav
 */
public class SpikeUpdateSite {
     public static void main(String[] args) {
         
        String cityName = "Göteborg";
        Site location = new Site(12,cityName);
        ServiceSite serviceSite = new ServiceSite();
        
        List<Site> locationList = serviceSite.getAllSites();
        // Skriver ut listan för att se hur det ser ut innan en site uppdateras
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        serviceSite.updateSite(location);
        //Uppdaterar listans innehåll
        locationList = serviceSite.getAllSites();
        // Skriver ut listan för att se innehållet efter en site uppdaterats
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
         
     }
    
}
