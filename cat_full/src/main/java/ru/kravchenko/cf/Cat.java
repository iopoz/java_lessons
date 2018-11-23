package ru.kravchenko.cf;

import java.util.Scanner;

public class Cat {
    final private String name;
    final private int portion;
    private boolean isFull;

    public Cat(String name, int portion) {
        this.name = name;
        this.portion = portion;
        this.isFull = false;
    }

    @Override
    public String toString() {
        return "CAT: " + name + " | PORTION: " + portion + "| ISFULL: " + isFull;
    }

    public void feedCat(Bowl bowl){
        if (!isCatFull(bowl)){
            final Scanner scanner = new Scanner(System.in);
            String command = "";
            while (!"0".equals(command)){
                System.out.println("Need more food. Do you want to add? 1-add, 0-cat is very fat");
                command = scanner.nextLine();
                if ("1".equals(command)){
                    System.out.println("Input count of food that should be added");
                    command = scanner.nextLine();
                    bowl.increaseFood(Integer.parseInt(command));
                    if (isCatFull(bowl)){
                        break;
                    }
                }
            }
        }
    }

    private boolean isCatFull(Bowl bowl){
        if (portion <= bowl.getSizePortion()){
            bowl.decreaseFood(portion);
            isFull = true;
            return true;
        } else {
            return false;
        }
    }
}
