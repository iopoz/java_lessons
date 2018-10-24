package ru.kravchenko.sl;

import java.util.List;

public class Finder {
    private final List<Integer> inputList;
    private static int minValue = 0;
    private static int maxValue = 0;

    public Finder(List<Integer> inputList) {
        this.inputList = inputList;
        setValues(inputList);

    }

    private static void setValues(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            minValue = (minValue < inputList.get(i)) ? minValue : inputList.get(i);
            maxValue = (maxValue > inputList.get(i)) ? maxValue : inputList.get(i);
        }
    }

    public Integer getMax() {
        return maxValue;
    }

    public Integer getMin() {
        return minValue;
    }
}
