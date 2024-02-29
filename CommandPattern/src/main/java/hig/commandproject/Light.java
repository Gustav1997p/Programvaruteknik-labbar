/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hig.commandproject;

/**
 *
 * @author gurra
 */
public class Light {
    
    private boolean isOn;
    
    public void switchOn() {
        this.isOn = true;
    }
    
    public void switchOff() {
        this.isOn = false;
    }
    
    public String getLightStatus() {
        if(isOn){
        return "Light is on";
        }
        else return "Light is off";
    }
    
}
