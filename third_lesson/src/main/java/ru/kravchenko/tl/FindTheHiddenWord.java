package ru.kravchenko.tl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class FindTheHiddenWord {


    private String[] words = {
            "apple", "orange", "lemon", "banana",
            "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple",
            "pumpkin", "potato"};
    protected String foundWord;
    protected String hiddenWord;
    final protected Map<Integer, Character> tmpWord = new HashMap<Integer, Character>();

    FindTheHiddenWord() {

    }

    void runGame() throws IOException {
        hiddenWord = hideWord(words);
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("I hidden one of them word from " + Arrays.toString(words));
            System.out.println("Input word, that I was able to hide");
            String userWord = br.readLine();
            if (!userWord.isEmpty()) {
                try {
                    userWord = userWord.toLowerCase();
                    for (int i = 0; i < hiddenWord.length(); i++) {
                        if (hiddenWord.charAt(i) == userWord.charAt(i)) {
                            tmpWord.put(i, hiddenWord.charAt(i));
                        }
                    }
                    if (hiddenWord.length() == tmpWord.size()) {
                        System.out.println("You are lucky person! It was " + hiddenWord);
                        break;
                    } else {
                        System.out.println("Your word is not equal my word, but I'll help you");
                        System.out.println("This correct characters " + doWord(tmpWord));
                    }
                } catch (Exception e) {
                    System.out.println("Your word is not equal my word, but I'll help you");
                    System.out.println("This correct characters " + doWord(tmpWord));
                }

            } else {
                System.out.println("Sorry! I think you forgot to input word!");
            }
        }

    }

    private String doWord(Map<Integer, Character> tmpWord) {
        String[] gottenWord = {
                "#", "#", "#", "#", "#",
                "#", "#", "#", "#", "#",
                "#", "#", "#", "#", "#"};
        for (int i : tmpWord.keySet()) {
            gottenWord[i] = String.valueOf(tmpWord.get(i));
        }
        foundWord = Arrays.toString(gottenWord);
        return foundWord;
    }

    private String hideWord(String[] words) {
        final Random rnd = new Random();
        final int indexWord = rnd.nextInt(words.length);
        return words[indexWord];
    }
}
