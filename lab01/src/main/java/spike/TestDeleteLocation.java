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
public class TestDeleteLocation {
    public static void main(String[] args) {
        String cityName = "Sandviken";
        
        LabLocationDao locationDao = new LabLocationDao();
        List<LabLocation> locationList = locationDao.getAll();
        //Listan innan delete
        for(LabLocation t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        //Testar ta bort location
        LabLocation locationToDelete = new LabLocation(3, cityName);
        locationDao.delete(locationToDelete);
        locationList = locationDao.getAll();
        //Listan efter delete
        for(LabLocation t : locationList) {
            System.out.println("id: "+t.getId()+" city: "+t.getCity());
        }
        
    }
    
}
