package ru.kravchenko.algoritms.homework_4;

import java.util.Iterator;

public class LinkedListImplementation implements LinkedList {

    protected Node firstElement;
    protected int size;

    public LinkedListIteratorImplementation getIterator(){
        return new LinkedListIteratorImplementation(this);
    }

    //метод iterator для поддержки foreach
    //@Override
    public Iterator iterator() {
        return new LinkedListIteratorImplementation(this).iterator();
    }

    @Override
    public void add(int value) {
        Node node = new Node(value);
        node.setNextElement(firstElement);
        firstElement = node;
        size ++;

    }

    @Override
    public int remove() {
        if (isEmpty()){
            return -1;
        }
        int data = firstElement.getData();
        firstElement = firstElement.getNextElement();
        size --;
        return data;
    }

    @Override
    public int remove(int value) {
        Node currentNode = firstElement;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.getData() == value) {
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextElement();
        }

        if (currentNode == null) {
            return -1;
        }

        if (previousNode == null) {
            firstElement = currentNode.getNextElement();
        }
        else {
            previousNode.setNextElement(currentNode.getNextElement());
        }

        size--;
        return currentNode.getData();
    }

    @Override
    public boolean find(int value) {
        Node currentNode = firstElement;

        while (currentNode != null) {
            if (currentNode.getData() == value) {
                return true;
            }
            currentNode = currentNode.getNextElement();
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("----------- Linked List Start");

        Node currentNode = firstElement;

        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.getNextElement();
        }
        System.out.println("----------- Linked List Finish");
    }

    @Override
    public Node getFirstElement() {
        return firstElement;
    }

    @Override
    public void setFirstElement(Node firstElement) {
        this.firstElement = firstElement;
    }
}
