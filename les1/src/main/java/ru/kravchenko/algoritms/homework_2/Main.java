package ru.kravchenko.algoritms.homework_2;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int ARRAY_CAPACITY = 100000;
    private static final int MAX_VALUE = 1000;

    public static void main( String[] args )
    {
        Array arr1 = new ArrayImplements(ARRAY_CAPACITY);
        Array arr2 = new ArrayImplements(ARRAY_CAPACITY);
        Array arr3 = new ArrayImplements(ARRAY_CAPACITY);

        fillRandomArrays(arr1, arr2, arr3);

        measureSortTime(arr1::sortBubble, "sort Bubble");
        measureSortTime(arr2::sortInsert, "sort Insert");
        measureSortTime(arr3::sortSelect, "sort Select");
    }

    private static void fillRandomArrays(Array... arrays){
        Random rnd = new Random();

        for(int i=0; i < ARRAY_CAPACITY; i++){
            int value = rnd.nextInt(MAX_VALUE);
            for (Array array: arrays) {
                array.add(value);
            }
        }
    }

    private static void measureSortTime(Runnable action, String actionName){
        long startTime = System.nanoTime();
        action.run();
        long endTime = System.nanoTime();
        System.out.println(String.format("%s took time: %d ms",
                actionName,
                TimeUnit.NANOSECONDS.toMillis(endTime - startTime)));
    }
}
