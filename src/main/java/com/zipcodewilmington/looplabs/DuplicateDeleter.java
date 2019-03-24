package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications) {
        T[] newArray = null;
        for (int i = 0; i < array.length; i++) {
            int numOfDupes = myLittleCountMethod(array[i]);
            if (numOfDupes >= maxNumberOfDuplications) {
                int counter = 0;
                newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), (array.length - numOfDupes));
                for (int k = 0; k < array.length; k++) {
                    if (!array[i].equals(array[k])) {
                        newArray[counter] = array[k];
                        counter++;
                    }
                }
            }
        }
        return newArray;
    }

    abstract public T[] removeDuplicatesExactly(int exactNumberOfDuplications);

    public Integer myLittleCountMethod(T i) {

        int counter = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j].equals(i)) {
                counter++;

            }
        }
        return counter;
    }
}
