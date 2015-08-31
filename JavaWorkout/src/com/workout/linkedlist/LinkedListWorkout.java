package com.workout.linkedlist;

/**
 * Created by HARI on 8/30/2015.
 */
public class LinkedListWorkout {

    public static void main(String[] args) {
        LinkedListWorkout llw = new LinkedListWorkout();
        Field linkedField = new Field(1, new Field(2, new Field(3, new Field(4, new Field(5, null)))));
        Field lastField = llw.getLastField(linkedField, true);
        Field finalField = lastField;
        Field tempField = null;
        int reverseCompleted = -1;
        while (reverseCompleted < 1){
           tempField = llw.getLastField(linkedField, true);
           lastField = llw.getLastField(finalField, false);
           if(lastField != null ) {lastField.setNext(tempField); }
            if(linkedField.getNext() == null){
                reverseCompleted ++;
            }
        }
        System.out.println(finalField);
    }

    private Field getLastField(Field field, boolean isSetNull){
        Field lastField = null;
        Field previousField = null;
        Field previousLastField = null;
        Field tempField = field;
        while(tempField != null){
            previousField = tempField;
            previousLastField = lastField;
            lastField = tempField.getNext();
            if(lastField != null){
                tempField = lastField.getNext();
            } else {
                lastField = tempField;
                previousField = previousLastField;
                tempField = null;
            }
        }
        if(isSetNull && previousField != null){
            previousField.setNext(null);
        }
        return lastField;
    }
}
