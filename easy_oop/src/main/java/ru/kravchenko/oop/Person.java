package ru.kravchenko.oop;

public class Person {
    private final String personFIO;
    private final String position;
    private final String email;
    private final String phone;
    private final int cost;
    private final int age;

    public Person(String personFIO, String position, String email, String phone, int cost, int age) {
        this.personFIO = personFIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.cost = cost;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getCost() {
        return cost;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonFIO() {
        return personFIO;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public String getFullInformation(){
        return getPersonFIO() + " " + getPosition() + " " + getEmail() + " " + getPhone() + " " + getCost() + " " + getAge();
    }
}
