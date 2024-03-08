/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import java.util.List;
import java.util.stream.Collectors;
import service.site.FindAllSiteService;

/**
 *
 * @author Gustav
 */
public class SpikeFindAllSiteService {
    public static void main(String[] args) {
        
        List<Site> listOfSites = new FindAllSiteService().execute();
        var listOfNamse = listOfSites.stream().map(s -> s.getCity()).collect(Collectors.joining("\n"));
        System.out.println(listOfNamse);
    }
    
}
