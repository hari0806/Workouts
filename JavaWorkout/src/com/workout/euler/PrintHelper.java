package com.workout.euler;

import java.util.List;

/**
 * Created by HARI on 9/19/2015.
 */
public class PrintHelper {

    public static void printObjectList(List<? extends Object> listObject){
        System.out.println();
        for (Object obj: listObject){
            System.out.print(obj + ", ");
        }
    }
}
