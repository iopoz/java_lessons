package ru.kravchenko.algoritms.homework_4;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImplementation();
        LinkedListIterator iter1 = ((LinkedListImplementation) linkedList).getIterator();

        linkedList.add(0);

        iter1.reset();

        iter1.insertAfter(1);
        iter1.insertAfter(3);
        iter1.insertAfter(2);
        iter1.insertBefore(-10);

        linkedList.display();

        System.out.println("Current: " + iter1.getCurrent());
        System.out.println("Has next: " + iter1.atEnd());

        iter1.next();
        System.out.println("Deleted: " + iter1.deleteCurrent());
        System.out.println("Has next: " + iter1.atEnd());

        linkedList.display();

        System.out.println("---------Iter 2------------");
        LinkedListIterator iter2 = ((LinkedListImplementation) linkedList).getIterator();
        while ( !iter2.atEnd() ){
            System.out.println(iter2.getCurrent());
            iter2.next();
        }
    }
}
