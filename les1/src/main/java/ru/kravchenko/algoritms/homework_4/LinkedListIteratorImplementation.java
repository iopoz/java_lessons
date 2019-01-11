package ru.kravchenko.algoritms.homework_4;

import java.util.Iterator;

public class LinkedListIteratorImplementation implements LinkedListIterator {

    private Node current;
    private Node previous;
    private LinkedList parent;

    public LinkedListIteratorImplementation(LinkedList parent){
        this.parent = parent;
        reset();
    }


    @Override
    public void reset() {
        current = parent.getFirstElement();
        previous = null;
    }


    @Override
    public Node next() {
        previous = current;
        current = current.getNextElement();
        return previous;
    }

    @Override
    public Node getCurrent() {
        return current;
    }

    @Override
    public boolean atEnd() {
        return current == null;
    }

    @Override
    public void insertAfter(int data) {
        Node newNode = new Node(data);

        if ( parent.isEmpty() ){
            parent.setFirstElement(newNode);
            current = newNode;
        }
        else {
            newNode.setNextElement( current.getNextElement() );
            current.setNextElement(newNode);
            next();
        }
    }

    @Override
    public void insertBefore(int data) {
        Node newNode = new Node(data);
        if ( previous == null ){
            newNode.setNextElement( parent.getFirstElement() );
            parent.setFirstElement(newNode);
            reset();
        }
        else {
            newNode.setNextElement(current);
            previous.setNextElement(newNode);
            current = newNode;
        }

    }

    @Override
    public Node deleteCurrent() {
        Node deleted = current;

        if (previous == null){
            parent.setFirstElement( current.getNextElement() );
            reset();
        }
        else {
            previous.setNextElement( current.getNextElement() );
            if ( atEnd() ){
                reset();
            }
            else {
                current = current.getNextElement();
            }
        }

        return deleted;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return LinkedListIteratorImplementation.this.atEnd();
            }

            @Override
            public Object next() {
                return LinkedListIteratorImplementation.this.next();
            }
        };
    }
}
