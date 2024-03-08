/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import service.site.CreateSiteService;
import service.site.SaveSiteService;

/**
 *
 * @author Gustav
 */
public class SpikeSaveSiteService {
    public static void main(String[] args) {
        String cityName = "Berlin";
        
        Site site = new SaveSiteService(new CreateSiteService(cityName).execute()).execute();
        System.out.println(site.toString());
    }
    
}
