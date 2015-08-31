package com.workout.compare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by HARI on 7/16/2015.
 */
public class CompareFiles {
    private static final String FILE_ONE = "E:\\Temp\\comparefiles\\doc1.txt";
    private static final String FILE_TWO = "E:\\Temp\\comparefiles\\doc2.txt";
    public static void main(String[] args) {
        compareFiles();

    }

    public static void compareFiles(){

        BufferedReader readerA = null;
        BufferedReader readerB = null;
        int counter = 0;
        try {
            readerA = new BufferedReader(new FileReader(FILE_ONE));
            String lineA;
            while ((lineA = readerA.readLine()) != null)
            {
                long start = System.currentTimeMillis();
                readerB = new BufferedReader(new FileReader(FILE_TWO));
                String lineB;
                boolean found = false;
                while ((lineB = readerB.readLine()) != null)
                {
                    if(compare(lineA, lineB)){
                        found=true;
                        break;
                    }
                }
                readerB.close();
                if(!found){
                    System.out.println("Not found : " + lineA);
                }
//                if(counter % 1000 == 0){
                    System.out.println("counter :" + counter);
//                }
                counter++;
                long end = System.currentTimeMillis();
                System.out.println((end - start) / 1000f + " seconds");
                // TODO: ensure .close() is called on readerB
            }
            readerA.close();
            // TODO: ensure .close() is called on readerA
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    private static boolean compare(String lineA, String lineB) {
        if(lineA.equals(lineB)){
            return true;
        }
        return false;
    }


}
