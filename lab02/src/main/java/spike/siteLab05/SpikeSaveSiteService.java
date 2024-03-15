/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.siteLab05;

import domain.Site;
import service.ServiceCommand;
import service.ServiceRunner;
import service.site.CreateSiteService;
import service.site.SaveSiteService;

/**
 *
 * @author gurra
 */
public class SpikeSaveSiteService {

    public static void main(String[] args) {
        String city = "Borås";

        ServiceCommand<Site> create = new CreateSiteService(city);
        ServiceRunner<Site> runC = new ServiceRunner(create);
        
        ServiceCommand<Site> save = new SaveSiteService(runC.execute());
        ServiceRunner<Site> runSave = new ServiceRunner(save);
        Site site = runSave.execute();
        System.out.println(site.toString());
    }

}
