package ru.kravchenko.tl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Third lesson. PC wants to play
 */
public class App {
    public static void main(String[] args) throws IOException {
        final String userName = System.getProperty("user.name");
        System.out.println("Hello dear " + userName + "!");
        System.out.println("I want you to play with me. I know two plays");
        int continuesNum = 1;
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Input N if you want to play in Numbers");
            System.out.println("Input W if you want to play in Words");
            System.out.println("Input Q if you want to exit");
            final String chose = br.readLine();
            switch (chose) {
                case "N":
                    final FindCorrectNumber firstGame = new FindCorrectNumber();
                    do {
                        firstGame.runGame();
                        System.out.println("Do you want to play again? 1 - yes / 0 - no");
                        final String inputStr = br.readLine();
                        continuesNum = getIntFromInput(inputStr);
                    } while (continuesNum != 0);
                    continuesNum = 1;
                    break;
                case "W":
                    final FindTheHiddenWord secondGame = new FindTheHiddenWord();
                    do {
                        secondGame.runGame();
                        System.out.println("Do you want to play again? 1 - yes / 0 - no");
                        final String inputStr = br.readLine();
                        continuesNum = getIntFromInput(inputStr);
                    } while (continuesNum != 0);
                    continuesNum = 1;
                    break;
                case "Q":
                    continuesNum = 0;
            }

        } while (continuesNum != 0);
    }

    private static Integer getIntFromInput(String input) {
        return (!input.isEmpty()) ? Integer.parseInt(input) : 1;
    }
}
