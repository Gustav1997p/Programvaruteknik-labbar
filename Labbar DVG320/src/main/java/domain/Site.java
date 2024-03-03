/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Gustav
 */
public class Site implements Comparable<Site> {
    
    private int id;
    private String city;
    
    public Site(int id, String city) {
        setId(id);
        setCity(city);
        
    }
    public Site(String city) {
        setCity(city);
        
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        
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
    @Override
    public String toString() {
        return "id: " + id + " city: "+ city;
    }
    @Override
    public int compareTo(Site o) {
        return this.hashCode() - o.hashCode();
    }
    @Override
    public boolean equals( Object p) {
        return p instanceof Site && hashCode() == p.hashCode();
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.city);
        return hash;
    }
    
    
}
