/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.Year;
import java.util.Objects;

/**
 *
 * @author Gustav
 */
public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private int birthYear;

    public Person(int id, String name, int birthYear) {
        setId(id);
        setName(name);
        setBirthYear(birthYear);
    }

    public Person(String name, int birthYear) {
        setName(name);
        setBirthYear(birthYear);
    }
    
    
    public void setBirthYear(int birthYear) {
        
        int length = (int) (Math.log10(birthYear)+1);
        int currentYear = Year.now().getValue();
        int maxAge = 120;
        int lowerLimitBirthYear = currentYear - maxAge;
        //Giltligt format, inte ett år som ej vart, rimlig ålder, du är inte 120 år gammal din sörk!
        if(length == 4 && currentYear > birthYear && lowerLimitBirthYear < birthYear){
            this.birthYear = birthYear;
        }
        else {
            throw new IllegalArgumentException("Birthyear is in the wrong format, please input birthyear with 4 letters, ex: 2008! \n Birthyear cannot exceed the current year ");
        }
        
    }
    
    //Begränsad längd, bara bokstäver?
    public void setName(String name) {
        
        //Kollar om textsträngen är längre än 25 karaktärer vilket ej är tillåtet
        if(name.length() > 25) {
            throw new IllegalArgumentException("Name cannot be longer than 25 characters");
        }
        //Regex för att titta tillåtna tecken + att strängen innehåller minst ett tecken
        else if (name.matches("^[a-zA-ZåäöÅÄÖ ]+")) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Name can only contain letters and/or cannot be left blank/empty");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    private void setId(int id) {
        this.id = id;
    }
    public String toString() {
        return "id: " + id + " Name: "+ name + " birthyear: "+birthYear;
    }
    @Override
    public int compareTo(Person o) {
        return this.hashCode() - o.hashCode();
    }
    @Override
    public boolean equals( Object p) {
        return p instanceof Person && hashCode() == p.hashCode();
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.birthYear;
        return hash;
    }
    
    
    
   
    
    
    
    
    
}
