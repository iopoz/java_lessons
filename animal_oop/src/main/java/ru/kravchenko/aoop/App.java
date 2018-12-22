package ru.kravchenko.aoop;

import java.util.Scanner;

/**
 * catDog
 */
public class App {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        double distanceRun = Math.random() * 200;
        double distanceJump = Math.random() * 2;
        double distanceSwim = Math.random() * 0;
        Cat cat = new Cat(distanceRun, distanceJump, distanceSwim);

        distanceRun = Math.random() * 500;
        distanceJump = Math.random() * 0.5;
        distanceSwim = Math.random() * 100;
        Dog dog = new Dog(distanceRun, distanceJump, distanceSwim);


        System.out.println("Кошка может пробежать: " + cat.getAnimalDistanceRun() +
                " м. \nСобака может пробежать: " + dog.getAnimalDistanceRun() + " м.");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить run(" + distance + "). Результат: " + cat.run(distance));
        System.out.println("Собака пытается выполнить run(" + distance + "). Результат: " + dog.run(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может прыгнуть: " + cat.getAnimalDistanceJump() +
                " м. \nСобака может прыгнуть: " + dog.getAnimalDistanceJump() + " м.");

        System.out.println("Введите высоту препятствия:");
        distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить jump(" + distance + "). Результат: " + cat.jump(distance));
        System.out.println("Собака пытается выполнить jump(" + distance + "). Результат: " + dog.jump(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может проплыть: " + cat.getAnimalDistanceSwim() +
                " м. \nСобака может проплыть: " + dog.getAnimalDistanceSwim() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();

        System.out.println("Кошка пытается выполнить swim(" + distance + "). Результат: " + cat.swim(distance));
        System.out.println("Собака пытается выполнить swim(" + distance + "). Результат: " + dog.swim(distance));

    }
}
