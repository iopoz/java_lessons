package ru.kravchenko.algoritms.homework_5.box;

public class Item {
    private String name;
    private int weigth;
    private int cost;

    public Item(String name, int weight, int cost){
        this.cost = cost;
        this.weigth = weight;
        this.name = name;
    }

    public int getWeight() {
        return weigth;
    }

    public int getCost() {
        return cost;
    }

    public String getName(){
        return name;
    }


}
