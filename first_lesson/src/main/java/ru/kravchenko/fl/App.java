package ru.kravchenko.fl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * First home work
 */
public class App {
    public static void main(String[] args) throws IOException {
        final int a = 1;
        final int b = 2;
        final int c = 3;
        final int d = 4;
        final String name = "Eugene";
        int year = 2018;

        boolean bool = true;
        byte bt = 0;

        long l = 10L;
        float f = 10.0F;
        double dbl = 10.0D;

        Float res = calcSum(a, b, c, d);
        bool = isInConstrains(res.intValue(), res.intValue() * d);

        String answer = "";

        while (!answer.equals("Q")) {
            System.out.println("Choose method you want to check. Or type Q to exit");
            System.out.println("calck method - type 1");
            System.out.println("between 10-20 method - type 2");
            System.out.println("positive num method - type 3");
            System.out.println("Is num negative method - type 4");
            System.out.println("Say Hello! method - type 5");
            System.out.println("Check Leap Year method - type 6");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            switch (input) {
                case "1":
                    System.out.println(res);
                    break;
                case "2":
                    System.out.println(bool);
                    break;
                case "3":
                    System.out.println(checkPositiveNum(res.intValue()));
                    break;
                case "4":
                    System.out.println(isNegativeNum(res.intValue()));
                    break;
                case "5":
                    System.out.println("Intut your name or we use default name");
                    String nameIn = br.readLine();
                    if (!nameIn.isEmpty()) {
                        System.out.println(sayHello(nameIn));
                    } else {
                        System.out.println(sayHello(name));
                    }
                    break;
                case "6":
                    System.out.println("Intut year or we use default name");
                    String yearStr = br.readLine();
                    if (!yearStr.isEmpty()) {
                        try {
                            year = Integer.parseInt(yearStr);
                        } catch (Exception e) {
                            System.out.println(yearStr + " is not Year. We used default value " + year);
                        }
                    }
                    System.out.println(checkLeapYear(year));
                    break;
                case "Q":
                    answer = "Q";
                    break;
            }
        }

    }


    private static float calcSum(int a, int b, float c, int d) {
        float ff = c / d;
        return a * (b + ff);
    }

    private static boolean isInConstrains(int a, int b) {
        return ((10 <= (a + b)) && ((a + b) <= 20));
    }

    private static String checkPositiveNum(int num) {
        if (num >= 0) {
            return "There is positive number";
        } else {
            return "There is negative number";
        }
    }

    private static boolean isNegativeNum(int num) {
        return (num < 0);
    }

    private static String sayHello(String name) {
        String hello = "Hello, ";
        hello = hello.concat(name);
        return (hello + "!");
    }

    private static String checkLeapYear(int year) {
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
            return "It's Leap year";
        }
        return "It's NOT Leap year";

    }

}

