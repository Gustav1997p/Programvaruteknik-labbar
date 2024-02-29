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
public class OperationExecutor {
    private final NumericOperation operator;

    public OperationExecutor(NumericOperation operator) {
        this.operator = operator;
    }
    
    public BigDecimal apply(BigDecimal a, BigDecimal b) {
        
        return operator.get(a, b);
    }
}
