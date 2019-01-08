package ru.kravchenko.algoritms.homework_3;

import ru.kravchenko.algoritms.homework_3.stack.Stack;
import ru.kravchenko.algoritms.homework_3.stack.StackImplements;


public class RevertString {
    public static void main(String[] args) {
        String inputStr = "Input String";

        Stack outputStackStr = new StackImplements(inputStr.length());
        for (char c: inputStr.toCharArray()) {
            outputStackStr.push(c);
        }

        while (!outputStackStr.isEmpty()){
            System.out.print(Character.toString((char) outputStackStr.pop()));
        }
    }
}
