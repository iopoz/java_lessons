package ru.kravchenko.algoritms.homework_4;

public interface LinkedList {
    void add(int value);

    int remove();

    int remove(int value);

    boolean find(int value);

    boolean isEmpty();

    int getSize();

    void display();

    Node getFirstElement();

    void setFirstElement(Node node);
}
