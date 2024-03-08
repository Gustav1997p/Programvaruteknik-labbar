/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import service.ServiceCommand;
import service.site.FindSiteByIdService;
import service.site.UpdateSiteService;

/**
 *
 * @author Gustav
 */
public class SpikeUpdateSiteService {

    public static void main(String[] args) {
        String name = "Oslo";
        
        Site siteToUpdate = new FindSiteByIdService(15).execute();
        System.out.println(siteToUpdate.toString());
        
        siteToUpdate.setCity(name);
        ServiceCommand cmd = new UpdateSiteService(siteToUpdate);
        
        System.out.println(cmd.execute().toString());
    }

}
