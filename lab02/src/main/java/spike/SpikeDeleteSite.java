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
public class SpikeDeleteSite {
    public static void main(String[] args) {
        String cityName = "Sandviken";
        ServiceSite serviceSite = new ServiceSite();
        
        
        List<Site> locationList = serviceSite.getAllSites();
        //Listan innan delete
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        //Testar ta bort location
        Site locationToDelete = new Site(14, cityName);
        serviceSite.deleteSite(locationToDelete);
        locationList = serviceSite.getAllSites();
        //Listan efter delete
        for(Site t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        
    }
    
}
