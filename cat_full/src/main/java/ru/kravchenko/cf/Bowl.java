package ru.kravchenko.cf;

public class Bowl {
    private int sizePortion;

    public Bowl(int sizePortion) {
        this.sizePortion = sizePortion;
    }

    @Override
    public String toString() {
        return "Bowl: " + sizePortion;
    }

    public int getSizePortion() {
        return sizePortion;
    }

    public void increaseFood(int amount){
        sizePortion += amount;
    }

    public void decreaseFood(int amount){
        if (sizePortion >= amount){
            sizePortion -= amount;
        }
    }
}
