package ru.kravchenko.algoritms.homework_3.stack;

public interface Stack {
    void push(char value);

    int pop();

    int peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();
}
