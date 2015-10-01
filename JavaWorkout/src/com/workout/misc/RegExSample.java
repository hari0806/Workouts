package com.workout.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HARI on 10/1/2015.
 */
public class RegExSample {

    public static void main(String[] args) {
        // String to be scanned to find the pattern.

        String pattern = "\\*";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        List<String> listString = getInputLines();
        for (String line : listString) {
            // Now create matcher object.
            Matcher m = r.matcher(line);
            System.out.println(line + "--------" + m.find());
        }

    }

    private static List<String> getInputLines() {
        List<String> listString = new ArrayList<String>();
        listString.add("Provides a general overview of regular expressions. It also * introduces the core classes that comprise this API.");//should be true
        listString.add("Describes simple character classes, negation, ranges, unions, intersections, and subtraction.");
        listString.add("asdfas fasdf asdfas$&+,:;=?@#|'<>.-^*()%! asdf asdfasdf asdf asdf asdf "); //should be true
        listString.add(";=?@#|'<>.-^()%!");
        listString.add("A = 4.828a2, in which a is one of the sides.");
        listString.add("A = ?r2, in which ? is 3.1416 and r the radius..");
        listString.add("C = (Wtc)/1000, in which W is the number of watts,t the time in hou*rs, and c the cost in cents per kilowatt-hour."); //should be true
        listString.add("E = mc2, in which E is the energy in ergs, m the mass of the matter in grams, and c the speed of light in centimeters per second: (c2 = 9 × 1020)");
        return listString;
    }


}
