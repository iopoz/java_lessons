package ru.kravchenko.tl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class FindCorrectNumber {

    FindCorrectNumber() {

    }

    void runGame() throws IOException {
        final Random rnd = new Random();
        final int secretNumber = rnd.nextInt(9);
        int life = 3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input num that I was able to guess");
        while (life > 0) {
            final String inputStr = br.readLine();
            final int predictNum = getIntFromInput(inputStr);
            if (predictNum == secretNumber) {
                System.out.println("You are lucky person!!!");
                break;
            }
            if (life > 1) {
                if (predictNum > secretNumber) {
                    life--;
                    System.out.println("My Num is less than your! Try again. You have " + life + " life");
                } else {
                    life--;
                    System.out.println("My Num is greater than your! Try again. You have " + life + "life");
                }
            } else {
                life--;
                System.out.println("Unfortunately you loss! My num was " + secretNumber);
            }

        }

    }

    private static Integer getIntFromInput(String input) {
        return (!input.isEmpty()) ? Integer.parseInt(input) : 1;
    }
}
