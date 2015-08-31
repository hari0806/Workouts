package com.workout.compare;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by HARI on 7/16/2015.
 */
public class CompareFileGenerate {
    private static final String FILE_ONE = "E:\\Temp\\comparefiles\\doc3.txt";
    public static void main(String[] args) {
        List<String> listLines = new ArrayList<String>();
        for(int i=0;i<200000000;i++){
            listLines.add(i + "\n");
            if((listLines.size()%10000) == 0){
                try {
                    Collections.shuffle(listLines);
                    if(i < 100000){
                        String removedItem = listLines.remove(2);
                        System.out.print("removedItem:" + removedItem);
                    }
                    writeBuffered(listLines);
                    listLines=new ArrayList<String>();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeBuffered(List<String> records) throws IOException {
        File file = new File(FILE_ONE);
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            write(records, bufferedWriter);
        } finally {
            // comment this out if you want to inspect the files afterward
            //file.delete();
        }
    }

    private static void write(List<String> records, Writer writer) throws IOException {
//        long start = System.currentTimeMillis();
        for (String record: records) {
            writer.write(record);
        }
        writer.flush();
        writer.close();
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) / 1000f + " seconds");
    }
}
