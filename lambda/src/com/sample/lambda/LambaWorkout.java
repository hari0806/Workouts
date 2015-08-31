package com.sample.lambda;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by HARI on 7/19/2015.
 */
public class LambaWorkout {
    public static void main(String[] args) {
        testList();
    }

    private static void testList1(){
        List<String> listTemp = new ArrayList<String>();
        listTemp.add("1");
        listTemp.add("2");
        listTemp.add("3");

        listTemp.forEach(s -> {s=s.concat("added");});
        listTemp.forEach(System.out::println);
    }

    private static void testList(){
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return Integer.signum(integer);
            }
        });
        l.forEach(System.out::println);

        System.out.println(Integer.signum(500));
    }
}
