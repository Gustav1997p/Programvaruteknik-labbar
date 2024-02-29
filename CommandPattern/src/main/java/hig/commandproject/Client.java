/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hig.commandproject;

/**
 *
 * @author gurra
 */
public class Client {
    
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        
        System.out.println("Light status is: " + light.getLightStatus());

        // Slå på
        //  remote.setCommand(lightOnCommand); // Vanligt
        // remote.setCommand(light::switchOn); // Nåt annat
        
        remote.setCommand(() -> light.switchOn()); //Lambda-uttryck
        remote.pressButton();
        System.out.println("Light status is: " + light.getLightStatus());
        //Slå av
        remote.setCommand(lightOffCommand);
        remote.pressButton();
        System.out.println("Light status is: " + light.getLightStatus());
        
    }
    
}
