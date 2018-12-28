package ru.kravchenko.algoritms.homework_3.queue;

public interface Queue {
    void insert(int value);

    int remove();

    int peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();
}
