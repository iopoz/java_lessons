package ru.kravchenko.algoritms.homework_3.stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new StackImplements(5);
        pushToStack(stack, '1');
        pushToStack(stack, '2');
        pushToStack(stack, '3');
        pushToStack(stack, '4');
        pushToStack(stack, '5');
        pushToStack(stack, '6');

        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.getSize());

        while ( !stack.isEmpty() ) {
            System.out.println(stack.pop());
        }

        popFromStack(stack);
    }

    private static void popFromStack(Stack stack) {
        if ( !stack.isEmpty() ) {
            System.out.println(stack.pop());
        }
    }

    private static void pushToStack(Stack stack, char value) {
        if ( !stack.isFull() ) {
            stack.push(value);
        }
    }
}
