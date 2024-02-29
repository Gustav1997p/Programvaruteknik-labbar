/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hig.functionaldemo;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gurra
 */
public class FunctionalDemo {

    public static void main(String[] args) {

        var mainClass = new FunctionalDemo();
//        mainClass.performNumericOperation();
        mainClass.sortOuTEvenNumbersAndPrintSumAndSomeSpareExtrraWordsToMakeTheNameOfTheMethodEvenBetter();

    }

    public void sortOuTEvenNumbersAndPrintSumAndSomeSpareExtrraWordsToMakeTheNameOfTheMethodEvenBetter() {
        var values = List.of(7,2,4,8,3,11,18,34,21,13,15,17);
  
//        int sum = values.stream()
//                .filter(value -> value%2==0)
//                .reduce(Integer::sum)
//                .orElse(0);

        int sum = values.stream()
                .filter(v->v%2 ==0)
                .collect(Collectors.summingInt(Integer::intValue));
        
        var newList = values.stream()
                .filter(value -> (value&1) == 0)
                .map(value -> String.valueOf(value))
                .toList();
        
        
//        int sum =0;
//        
//        for(Integer element : values) {
//            if(element % 2 == 0) {
//                sum += element;
//            }
//        }
        System.out.println("sum of even element are: "+sum);
        System.out.println(newList);

    }

    public void performNumericOperation() {
        BigDecimal a = BigDecimal.valueOf(3.24); // Factory-metod
        BigDecimal b = BigDecimal.valueOf(2.72);

        //OperationExecutor execute = new OperationExecutor(new Adder()); // Här måste en klass skapas.
        //anonym klass
//        OperationExecutor execute = new OperationExecutor(new NumericOperation() {
//            @Override
//            public BigDecimal get(BigDecimal a, BigDecimal b) {
//                return a.subtract(b);
//
//            }
//        });
        //Lamda-uttryck
//        OperationExecutor execute = new OperationExecutor((c,d)->c.multiply(d));
        OperationExecutor execute = new OperationExecutor(BigDecimal::multiply);

        System.out.println("svaaret är : " + execute.apply(a, b));
    }

}
