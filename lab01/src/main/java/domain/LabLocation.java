/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gustav
 */
public class LabLocation {
    
    private int id;
    private String city;
    
    public LabLocation(int id, String city) {
        setId(id);
        setCity(city);
        
    }
    public LabLocation(String city) {
        setCity(city);
        
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setCity(String city) {
        
        //Kollar om textsträngen är längre än 25 karaktärer vilket ej tillåts
        if(city.length() > 25) {
            throw new IllegalArgumentException("Name cannot exceed 25 characters");
        }
        //Regex för att titta att textsträngen endast innehåller tillåtna tecken & ej är tom
        if(city.matches("^[a-zA-zåäöÅÄÖ]+")) {
            this.city = city;
        }
        else {
            throw new IllegalArgumentException("City name can only contain letters");
        }
    }

    public int getId() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }
    
    
    
}
