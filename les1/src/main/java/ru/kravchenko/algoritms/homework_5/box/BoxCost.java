package ru.kravchenko.algoritms.homework_5.box;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoxCost {

    private static Item[] things = {
            new Item("PC", 5, 40000),
            new Item("Book", 1, 600),
            new Item("Binoculars", 2, 5000),
            new Item("Aid kit", 1, 1500),
            new Item("Bowler", 4, 500)};

    private static int MAX_BOX = 10;

    public static void main(String[] args) {
        System.out.println(findBestRes(things.length - 1, MAX_BOX));
    }

    private static int findBestRes(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        if (things[i].getWeight() > weigth) {
            return findBestRes(i-1, weigth);
        }
        else {
            return Math.max(findBestRes(i-1, weigth), findBestRes(i-1, weigth - things[i].getWeight()) + things[i].getCost());
        }
    }

}
