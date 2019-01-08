package ru.kravchenko.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        final int sizeOfArray = 1000000;
//        int[] createdArray = createRandomArray(sizeOfArray);
//        final Random rand = new Random();
//        final int newNum = rand.nextInt(sizeOfArray + 1);
//
//        System.out.println( "Created Array" );
//        printArray(createdArray);
//
//        System.out.println("Added element to end of Array: " + newNum);
//        createdArray = addElementToArray(createdArray, newNum);
//
//
//        System.out.println("Find Index of " + newNum);
//        System.out.println("It was " + findElementIndexByValue(createdArray, newNum));
//
//        System.out.println("Delete " + newNum + " from Array");
//        createdArray = deleteElementByValue(createdArray, newNum).stream().mapToInt(i-> (int) i).toArray();
//        System.out.println("Find " +newNum + " in Array. Result is " + findElementIndexByValue(createdArray, newNum));
    }

//    public static int[] createRandomArray(int arraySize){
//        int[] bigArray = new int[arraySize];
//        Random rand = new Random();
//        for (int i=0; i < bigArray.length; i++) {
//            bigArray[i] = rand.nextInt(arraySize);
//        }
//        return bigArray;
//    }
//
//    public static int[] addElementToArray(int[] array, int num){
//        int[] result = Arrays.copyOf(array, array.length + 1);
//        result[result.length - 1] = num;
//        return result;
//    }
//
//    public static void printArray(int[] array){
//        for (int aPrintedArray : array) {
//            System.out.println(aPrintedArray);
//        }
//    }
//
//    public static int findElementValueByIndex(int[] array, int index){
//        if (index < array.length){
//            return array[index];
//        } else {
//            return -1;
//        }
//    }
//
//    public static List findElementIndexByValue(int[] array, int value){
//        List<Integer> foundItems = new ArrayList<>();
//        for (int i=0; i < array.length; i++) {
//            if (array[i] == value){
//                foundItems.add(i);
//            }
//        }
//        return foundItems;
//    }
//
//    public static List deleteElementByValue(int[] array, int value){
//        try{
//            List<Integer> res = new ArrayList();
//            for(int item : array) {
//                if (item != value) {
//                    res.add(item);
//                }
//            }
//            return res;
//        }catch (Exception e){
//            return Arrays.asList(array);
//        }
//
//    }
}
