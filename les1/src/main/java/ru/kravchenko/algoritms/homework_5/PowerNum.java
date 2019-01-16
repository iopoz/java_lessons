package ru.kravchenko.algoritms.homework_5;

public class PowerNum {
    public static void main(String[] args) {
        System.out.println(" 5 in power 3 = " + powerNum(5,3));
        System.out.println(" 5 in power -2 = " + powerNum(5,-2));
    }

    private static float powerNum(int num, int power) {
        if (power == 0){
            return 1;
        }
        else if (power < 0){
            float dec = 1;
            dec = num * powerNum(num, Math.abs(power) - 1);
            return 1 / dec;
        }
        else{
            return num * powerNum(num, power - 1);
        }
    }
}
