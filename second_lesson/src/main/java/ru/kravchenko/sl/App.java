package ru.kravchenko.sl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Second home work
 */
public class App {
    public static void main(String[] args) throws IOException {
        final String userName = System.getProperty("user.name");
        System.out.println("Hi, " + userName + "!");
        startCondition();
    }

    private static void startCondition() throws IOException {
        String answer = "";

        while (!answer.equals("Q")) {
            System.out.println("Choose method you want to check. Or type Q to exit");
            System.out.println("generate list between 0,1 method - type 1");
            System.out.println("set fixed list - type 2");
            System.out.println("fix list element less 6 - type 3");
            System.out.println("double list - type 4");
            System.out.println("find min max - type 5");
            System.out.println("check sum - type 6");
            System.out.println("Shift list on n steps - type 7");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            switch (input) {
                case "1":
                    System.out.println("Input count of list elements:");
                    final String nStr = br.readLine();
                    final List<Integer> getList = (List<Integer>) generateRandomBitArray(getIntFromInput(nStr));
                    final List<Integer> reversedList = (List<Integer>) reversList(getList);
                    System.out.println("Generated list: " + getList);
                    System.out.println("Reversed list: " + reversedList);
                    break;
                case "2":
                    int step = 3;
                    System.out.println("Input step value or skip, by default it's 3:");
                    final String stepStr = br.readLine();
                    int newStep = getIntFromInput(stepStr);
                    if (newStep > 1) {
                        step = newStep;
                    }
                    int[] simpleList = new int[8];
                    for (int i = 0; i < simpleList.length; i++) {
                        simpleList[i] = (i * step);
                    }
                    System.out.println("Your simple List: " + Arrays.toString(simpleList));
                    break;
                case "3":
                    int count = 12;
                    System.out.println("Input count value or skip, by default it's 12:");
                    String countStr = br.readLine();
                    final List<Integer> listForFix = generateList(count, countStr);
                    System.out.println("Main list: " + listForFix);
                    System.out.println("Fixed List: " + fixLessSix(listForFix));
                    break;
                case "4":
                    System.out.println("Input length of double list:");
                    final String lengthStr = br.readLine();
                    int[][] getDoubleList = buildDoubleList(getIntFromInput(lengthStr));
                    System.out.println(Arrays.deepToString(getDoubleList));
                    break;
                case "5":
                    count = 10;
                    System.out.println("Input count value or skip, by default it's 10:");
                    countStr = br.readLine();
                    final List<Integer> listForFind = generateList(count, countStr);
                    Finder finder = new Finder(listForFind);
                    System.out.println("Your generated list: " + listForFind);
                    System.out.println("min list element: " + finder.getMin() + ", max list element: " + finder.getMax());
                    break;
                case "6":
                    count = 10;
                    System.out.println("Input count value or skip, by default it's 10:");
                    countStr = br.readLine();
                    final List<Integer> listForCompare = generateList(count, countStr);
                    System.out.println("Your generated list: " + listForCompare);
                    System.out.println("Is sums equal? " + isSumEquals(listForCompare));
                    break;
                case "7":
                    count = 10;
                    System.out.println("Input count value or skip, by default it's 10:");
                    countStr = br.readLine();
                    System.out.println("Input n steps for Shift list:");
                    String shiftStr = br.readLine();
                    final List<Integer> listForShift = generateList(count, countStr);
                    System.out.println("Your generated list: " + listForShift);
                    System.out.println("Shifted list " + shiftList(listForShift, getIntFromInput(shiftStr)));
                    break;
                case "Q":
                    answer = "Q";
                    break;
            }

        }
    }

    private static List<Integer> shiftList(List<Integer> listForShift, Integer intFromInput) {
        final List<Integer> newArray = new ArrayList<Integer>();
        if (intFromInput > 0) {
            newArray.addAll(listForShift.subList((listForShift.size() - intFromInput), listForShift.size()));
            newArray.addAll(listForShift.subList(0, (listForShift.size() - intFromInput)));
        } else {
            newArray.addAll(listForShift.subList(Math.abs(intFromInput), listForShift.size()));
            newArray.addAll(listForShift.subList(0, Math.abs(intFromInput)));
        }
        return newArray;
    }

    private static int[][] buildDoubleList(Integer intFromInput) {
        int[][] doubleList = new int[intFromInput][intFromInput];
        for (int i = 0; i < intFromInput; i++) {
            for (int j = 0; j < intFromInput; j++) {
                if ((i == j) || (i == intFromInput - (j + 1))) {
                    doubleList[i][j] = 1;
                } else {
                    doubleList[i][j] = 0;
                }
            }
        }
        return doubleList;
    }

    private static List<Integer> generateRandomBitArray(int n) {
        final List<Integer> list = new ArrayList<Integer>(n);
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            final int el = rnd.nextInt(n * (i + 1));
            if (el % (i + 1) > 0) {
                list.add((1));
            } else {
                list.add(0);
            }
        }
        return list;
    }

    private static List<Integer> reversList(List<Integer> list) {
        final List<Integer> reversedList = new ArrayList<Integer>();
        for (Integer aList : list) {
            if (aList == 0) {
                reversedList.add(1);
            } else {
                reversedList.add(0);
            }
        }
        return reversedList;
    }

    private static Integer getIntFromInput(String input) {
        return (!input.isEmpty()) ? Integer.parseInt(input) : 1;
    }

    private static List<Integer> fixLessSix(List<Integer> inputList) {
        final List<Integer> fixedList = new ArrayList<Integer>();
        for (Integer anInputList : inputList) {
            if (anInputList < 6) {
                fixedList.add(anInputList * 2);
            } else {
                fixedList.add(anInputList);
            }
        }
        return fixedList;
    }

    private static List<Integer> generateList(int count, String countStr) {
        final List<Integer> generatedList = new ArrayList<Integer>();
        int newCount = getIntFromInput(countStr);
        if (newCount > 1) {
            count = newCount;
        }
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            generatedList.add(rnd.nextInt(count));
        }
        return generatedList;
    }

    private static boolean isSumEquals(List<Integer> inputList) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < inputList.size(); i++) {
            leftSum = 0;
            rightSum = 0;

            for (int a = 0; a < i; a++) {
                leftSum += inputList.get(a);
            }

            for (int b = i; b < inputList.size(); b++) {
                rightSum += inputList.get(b);
            }

            if (rightSum == leftSum) return true;
        }
        return false;
    }
}
