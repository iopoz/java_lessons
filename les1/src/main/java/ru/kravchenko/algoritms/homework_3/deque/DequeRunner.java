package ru.kravchenko.algoritms.homework_3.deque;

public class DequeRunner {
    public static void main(String[] args) {
        Deque deq = new DequeImplementation(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
        insertRight(deq, 4);// 1 2 3 4
        insertLeft(deq, 5); // 5 1 2 3 4
        insertLeft(deq, 6); // 6 5 1 2 3 4

        removeLeft(deq); //5 1 2 3 4
        removeRight(deq); // 5 1 2 3

//        displayLeftToRight(deq); // Queue
//        displayRightToLeft(deq); //Stack
    }

    private static void insertRight(Deque deq, int value) {
        if ( !deq.isFull() ) {
            deq.insertRight(value);
        }
    }

    private static void insertLeft(Deque deq, int value) {
        if ( !deq.isFull() ) {
            deq.insertLeft(value);
        }
    }

    private static void removeRight(Deque deq) {
        if ( !deq.isEmpty() ) {
            deq.removeRight();
        }
    }

    private static void removeLeft(Deque deq) {
        if ( !deq.isEmpty() ) {
            deq.removeLeft();
        }
    }

    private static <T> void displayRightToLeft(Deque deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeRight());
        }
    }

    private static <T> void displayLeftToRight(Deque deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeLeft());
        }
    }
}
