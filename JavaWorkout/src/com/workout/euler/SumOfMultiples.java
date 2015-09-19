package com.workout.euler;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HARI on 9/19/2015.
 */
public class SumOfMultiples {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    private void multiplesOfNumber(int[] multiplesOfArray, int maxValue) {
        int multiplesOfSum = 0;
        List<Integer> listmultiplesOf = new ArrayList<Integer>();
        mainloop:
        for (int i = 1; i < maxValue; i++) {
            for(int multiplesOf : multiplesOfArray){
                if(isMultiplesOf(i,multiplesOf)){
                    multiplesOfSum += i;
                    listmultiplesOf.add(i);
                    break;
                }
            }

        }
        System.out.println("Multiples of number list: " + multiplesOfSum);
        PrintHelper.printObjectList(listmultiplesOf);
    }

    private boolean isMultiplesOf(int inputNumber, int multiplesOf){
        return (inputNumber % multiplesOf == 0);
    }

    public static void main(String[] args) {
        SumOfMultiples sumOfMultiples = new SumOfMultiples();
        int[] multiplesOfArray = new int[]{3,5};
        sumOfMultiples.multiplesOfNumber(multiplesOfArray, 1000);
    }
}
