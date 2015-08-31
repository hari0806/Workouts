package com.workout.linkedlist;

/**
 * Created by HARI on 8/30/2015.
 */
public class Field {

    private int key;

    private Field next;

    Field(int key, Field field){
        this.key = key;
        this.next = field;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Field getNext() {
        return next;
    }

    public void setNext(Field next) {
        this.next = next;
    }
}
