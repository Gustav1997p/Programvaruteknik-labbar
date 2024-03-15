/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike.siteLab05;

import domain.Site;
import java.util.List;
import java.util.stream.Collectors;
import service.ServiceCommand;
import service.ServiceRunner;
import service.site.DeleteSiteService;
import service.site.FindAllSiteService;
import service.site.FindSiteByIdService;

/**
 *
 * @author gurra
 */
public class SpikeDeleteSiteService {

    public static void main(String[] args) {
        /**
         * Kör findSite() fär att hitta en existerande site i databasen 
         * för att sedan deleta den siten
         */
        ServiceCommand<Site> find = new FindSiteByIdService(8);
        ServiceRunner<Site> runFind = new ServiceRunner(find);
        Site siteToDelete = runFind.execute();
        /**
         * Deletar den site vi tidigare hämtat
         */
        ServiceCommand<Site> delete = new DeleteSiteService(siteToDelete);
        ServiceRunner<Site>  runDelete = new ServiceRunner(delete);
        Site deletedSite = runDelete.execute();
        System.out.println(deletedSite.toString());
        
        /**
         * Hämtar en lista av alla sites för att se om det
         * deletade siten verkligen är borttagen från databasen.
         */
        ServiceCommand<List<Site>> all = new FindAllSiteService();
        ServiceRunner<List<Site>> runAll = new ServiceRunner(all);
        List<Site> siteList = runAll.execute();
        
        var listOfSites = siteList.stream().map(s->s.toString()).collect(Collectors.joining("\n"));
        
        System.out.println(listOfSites);
    }

}
