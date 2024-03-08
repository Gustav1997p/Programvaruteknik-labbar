/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import service.site.DeleteSiteService;
import service.site.FindSiteByIdService;

/**
 *
 * @author gurra
 */
public class SpikeDeleteSiteService {

    public static void main(String[] args) {

        Site site = new FindSiteByIdService(13).execute();
        System.out.println(site.toString());
        DeleteSiteService dss = new DeleteSiteService(site);
        dss.execute();
        
        
    }

}
