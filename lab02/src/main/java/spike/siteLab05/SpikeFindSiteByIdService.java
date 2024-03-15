/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.siteLab05;

import domain.Site;
import service.ServiceCommand;
import service.ServiceRunner;
import service.site.FindSiteByIdService;

/**
 *
 * @author gurra
 */
public class SpikeFindSiteByIdService {

    public static void main(String[] args) {
        ServiceCommand<Site> find = new FindSiteByIdService(20);
        ServiceRunner<Site> runFind = new ServiceRunner(find);
        
        Site site = runFind.execute();
        
        System.out.println(site.toString());
    }

}
