/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hig.functionaldemo;

import java.math.BigDecimal;

/**
 *
 * @author gurra
 */
public class Adder implements NumericOperation{

    @Override
    public BigDecimal get(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
    
}
