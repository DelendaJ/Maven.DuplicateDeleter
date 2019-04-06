package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), (array.length));
        int index = 0;

        Map<T, Integer> counts = countDuplicates(array);
        for (int i = 0; i < array.length; i++) {
            int numOfDupes = counts.get(array[i]);
            if (numOfDupes < maxNumberOfDuplications) {
                newArray[index] = array[i];
                index++;
            }
        }
        return Arrays.copyOf(newArray, index);
    }

    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), (array.length));
        int index = 0;

        Map<T, Integer> counts = countDuplicates(array);
        for (int i = 0; i < array.length; i++) {
            int numOfDupes = counts.get(array[i]);
            if (numOfDupes != exactNumberOfDuplications) {
                newArray[index] = array[i];
                index++;
            }
        }
        return Arrays.copyOf(newArray, index);
    }

    protected Map<T, Integer> countDuplicates(T[] array) {
        HashMap<T, Integer> thisIsAMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int count = thisIsAMap.getOrDefault(array[i], 0);
            thisIsAMap.put(array[i], count + 1);

        }

        return thisIsAMap;
    }

}



