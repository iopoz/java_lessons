package ru.kravchenko.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Hello world!
 */
public class App {

    private static int sizeArea = 3;
    private static int wonComboSize = 3;
    private static int[] stepForAI;
    private static final char userStepValue = 'x';
    private static final char pcStepValue = 'o';
    private static final char emptyPlaceValue = '.';
    private static char[][] map;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        System.out.println("Input map size, by default it's 3:");
        final String mapSize = br.readLine();
        final int newSizeArea = getIntFromInput(mapSize);
        if (newSizeArea > 3) {
            sizeArea = newSizeArea;
        }
        System.out.println("Input won combo size, by default it's 3:");
        final String wonCombo = br.readLine();
        final int newSizeCombo = getIntFromInput(wonCombo);
        if (newSizeCombo > 3) {
            wonComboSize = newSizeCombo;
        }
        initMap();
        while (true) {
            goHuman();
            if (isPlayerWin(userStepValue, sizeArea, wonComboSize)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            goAI();
            printMap();
            if (isPlayerWin(pcStepValue, sizeArea, wonComboSize)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printMap();
    }

    private static void initMap() {
        map = new char[sizeArea][sizeArea];
        for (int i = 0; i < sizeArea; i++) {
            for (int j = 0; j < sizeArea; j++) {
                map[i][j] = emptyPlaceValue;
            }
        }
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= sizeArea || y >= sizeArea) return false;
        return map[y][x] == emptyPlaceValue;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < sizeArea; i++)
            for (int j = 0; j < sizeArea; j++)
                if (map[i][j] == emptyPlaceValue) return false;
        return true;
    }

    private static void printMap() {
        for (int i = 0; i < sizeArea; i++) {
            for (int j = 0; j < sizeArea; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static void goHuman() throws IOException {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.." + sizeArea + "):");
            x = getIntFromInput(br.readLine());
            y = getIntFromInput(br.readLine());
        } while (!isCellValid(x - 1, y - 1));
        map[y - 1][x - 1] = userStepValue;
    }

    private static void goAI() throws IOException {
        do {
            if (!isPlayerWin(userStepValue, sizeArea, wonComboSize - 1)) {
                stepForAI = new int[]{rnd.nextInt(sizeArea), rnd.nextInt(sizeArea)};
            }
        } while (!isCellValid(stepForAI[1], stepForAI[0]));
        map[stepForAI[0]][stepForAI[1]] = pcStepValue;
    }

    private static Integer getIntFromInput(String input) {
        return (!input.isEmpty()) ? Integer.parseInt(input) : 0;
    }

    private static Boolean isPlayerWin(char stepValue, int sizeMap, int wonLength) {
        int sumDiagB, sumDiagS;
        sumDiagB = sumDiagS = 0;

        for (int i = 0; i < sizeMap; i++) {

            int sumRow, sumCol;
            sumRow = sumCol = 0;

            for (int j = 0; j < sizeMap; j++) {
                sumRow += (map[i][j] == stepValue) ? 1 : -1;
                sumCol += (map[j][i] == stepValue) ? 1 : -1;
                if (j == i) {
                    sumDiagB += (map[i][i] == stepValue) ? 1 : -1;
                    sumDiagS += (map[i][sizeMap - 1 - i] == stepValue) ? 1 : -1;
                }
                if (sumRow >= wonLength && (stepForAI[0] != i && stepForAI[1] != j + 1)) {
                    stepForAI = new int[]{i, j + 1};
                    return true;
                } else if (sumCol >= wonLength && (stepForAI[0] != i + 1 && stepForAI[1] != j)) {
                    stepForAI = new int[]{i + 1, j};
                    return true;
                }
                if (sumRow < 0) sumRow = 0;
                if (sumCol < 0) sumCol = 0;
            }

            if (sumDiagB >= wonLength && (stepForAI[0] != i + 1 && stepForAI[1] != i + 1)) {
                stepForAI = new int[]{i + 1, i + 1};
                return true;
            } else if (sumDiagS >= wonLength && (stepForAI[0] != i + 1 && stepForAI[1] != sizeMap - i)) {
                stepForAI = new int[]{i + 1, sizeMap - i};
                return true;
            }
            if (sumDiagB < 0) sumDiagB = 0;
            if (sumDiagS < 0) sumDiagS = 0;
        }

        return false;
    }


}
