/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import domain.LabLocation;
import java.util.List;
import repository.LabLocationDao;

/**
 *
 * @author Gustav
 */
public class TestSkapaLocation {
    
    public static void main(String[] args) {
        String cityName = "Stockholm";
        
        LabLocation location = new LabLocation(cityName);
        LabLocationDao locationDao = new LabLocationDao();
        List<LabLocation> locationList = locationDao.getAll();
        
        for(LabLocation t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        locationDao.save(location);
        
        locationList = locationDao.getAll();
        for(LabLocation t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        
    }
    
    
}
