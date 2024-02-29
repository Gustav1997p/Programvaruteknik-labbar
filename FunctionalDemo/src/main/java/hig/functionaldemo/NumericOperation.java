/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hig.functionaldemo;

import java.math.BigDecimal;

/**
 *
 * @author gurra
 */
@FunctionalInterface
public interface NumericOperation {
    BigDecimal get(BigDecimal a, BigDecimal b);
    
}
