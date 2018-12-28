package ru.kravchenko.algoritms.homework_3.stack;

public class StackImplements implements Stack {
    private char[] data;
    private int size;

    public StackImplements(int maxSize) {
        this.data = new char[maxSize];
        this.size = 0;
    }

    @Override
    public void push(char value) {
        data[size++] = value;
    }

    @Override
    public int pop() {
        return data[--size];
    }

    @Override
    public int peek() {
        return !isEmpty() ? data[size - 1] : -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }
}
