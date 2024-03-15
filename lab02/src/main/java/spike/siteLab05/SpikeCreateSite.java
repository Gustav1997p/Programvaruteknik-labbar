/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.siteLab05;

import domain.Site;
import service.ServiceCommand;
import service.ServiceRunner;
import service.site.CreateSiteService;

/**
 *
 * @author gurra
 */
public class SpikeCreateSite {
            public static void main(String[] args) {
                String city = "Borås";
                
                ServiceCommand<Site> create = new CreateSiteService(city);
                ServiceRunner<Site> runC = new ServiceRunner(create);
                Site site = runC.execute();
                
                System.out.println(site.toString());
            }

    
}
