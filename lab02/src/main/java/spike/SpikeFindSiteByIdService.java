/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.Site;
import service.site.FindSiteByIdService;

/**
 *
 * @author Gustav
 */
public class SpikeFindSiteByIdService {

    public static void main(String[] args) {
        Site site1 = new FindSiteByIdService(1).execute();
        Site site2 = new FindSiteByIdService(12).execute();
        System.out.println(site1.getCity());
        System.out.println(site2.getCity());
    }

}
