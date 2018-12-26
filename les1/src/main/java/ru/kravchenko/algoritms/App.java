package ru.kravchenko.algoritms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final int sizeOfArray = 1000000;
        int[] createdArray = createRandomArray(sizeOfArray);
        final Random rand = new Random();
        final int newNum = rand.nextInt(sizeOfArray + 1);

        System.out.println( "Created Array" );
        printArray(createdArray);

        System.out.println("Added element to end of Array: " + newNum);
        printArray(addElementToArray(createdArray, newNum));


    }

    public static int[] createRandomArray(int arraySize){
        int[] bigArray = new int[arraySize];
        Random rand = new Random();
        for (int i=0; i < bigArray.length; i++) {
            bigArray[i] = rand.nextInt(arraySize);
        }
        return bigArray;
    }

    public static int[] addElementToArray(int[] array, int num){
        int[] result = Arrays.copyOf(array, array.length + 1);
        result[result.length - 1] = num;
        return result;
    }

    public static void printArray(int[] array){
        for (int aPrintedArray : array) {
            System.out.println(aPrintedArray);
        }
    }

//    public static int findElementByIndex(int[] array, int index){
//
//    }
}
