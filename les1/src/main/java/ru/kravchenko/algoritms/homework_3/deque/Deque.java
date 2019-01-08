package ru.kravchenko.algoritms.homework_3.deque;

import ru.kravchenko.algoritms.homework_3.queue.Queue;

public interface Deque extends Queue {
    void insertLeft(int value);
    void insertRight(int value);

    int removeLeft();
    int removeRight();
}
