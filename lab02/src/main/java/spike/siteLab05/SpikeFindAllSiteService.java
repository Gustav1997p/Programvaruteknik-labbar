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
import service.site.FindAllSiteService;

/**
 *
 * @author gurra
 */
public class SpikeFindAllSiteService {

    public static void main(String[] args) {
        ServiceCommand<List<Site>> findAll = new FindAllSiteService();
        ServiceRunner<List<Site>> runFindAll = new ServiceRunner(findAll);
        List<Site> siteList = runFindAll.execute();
        
        var listOfSites = siteList.stream().map(s->s.toString()).collect(Collectors.joining("\n"));
        System.out.println(listOfSites);

    }

}
