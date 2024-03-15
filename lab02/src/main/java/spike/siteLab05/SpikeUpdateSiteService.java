/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.siteLab05;

import domain.Site;
import service.ServiceCommand;
import service.ServiceRunner;
import service.site.FindSiteByIdService;
import service.site.UpdateSiteService;

/**
 *
 * @author gurra
 */
public class SpikeUpdateSiteService {

    public static void main(String[] args) {
        /**
         * Kör findSite för att hitta en existerande site i databasen
         * för att uppdatera den siten i fråga
         */
        ServiceCommand<Site> find = new FindSiteByIdService(7);
        ServiceRunner<Site> runFind = new ServiceRunner(find);
        Site siteToUpdate = runFind.execute();
        System.out.println(siteToUpdate.getCity());
        siteToUpdate.setCity("Dublin");
        /**
         * Uppdaterar siten vi hämtade
         */
        ServiceCommand<Site> update = new UpdateSiteService(siteToUpdate);
        ServiceRunner<Site> runUpdate = new ServiceRunner(update);
        runUpdate.execute();
        /**
         * Hämta site med samma id från databasen för att kontrollera att namnet är uppdaterat
         */
        Site updatedSite = runFind.execute();
        System.out.println(updatedSite.getCity());
    }

}
