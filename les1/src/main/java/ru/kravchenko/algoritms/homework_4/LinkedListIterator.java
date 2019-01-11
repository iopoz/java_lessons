package ru.kravchenko.algoritms.homework_4;

public interface LinkedListIterator extends Iterable {
    //public interface LinkedListIterator {
    //перемещение в начало списка;
    void reset();

//    boolean hasNext();

    //перемещение итератора к следующему элементу
    Node next();

    //получение элемента, на который указывает итератор
    Node getCurrent();

    //возвращает true, если итератор находится в конце списка
    boolean atEnd();

    //вставка элемента после итератора
    void insertAfter(int data);

    //вставка элемента до итератора
    void insertBefore(int data);

    Node deleteCurrent();

}
