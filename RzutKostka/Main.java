package RzutKostka;

import java.util.Random;


public class Main {


    public static void main(String[] args) {
        int wynik = rollDice("2D10+20");
        int wynik1 = rollDice("2D10-20");
        System.out.println(wynik);
        System.out.println(wynik1);
    }

    public static int rollDice(String dice) {
        int dIndex = dice.indexOf('D');
        String dStr = dice.substring(0, dIndex);
        int x;
        if (dStr.equals("")) {
            x = 1;
        } else {
            x = Integer.parseInt(dStr);
        }


        int plusIndex;
        if (dice.contains("+")) {
            plusIndex = dice.indexOf('+');
        } else if (dice.contains("-")) {
            plusIndex = dice.indexOf('-');
        } else {
            plusIndex = 0;
        }

        String yStr = "";
        String zStr = "";
        if (plusIndex != 0) {
            yStr = dice.substring(dIndex + 1, plusIndex);
            zStr = dice.substring(plusIndex, dice.length());
        } else {
            yStr = dice.substring(dIndex + 1);
        }

        int z = 0;
        int y = Integer.parseInt(yStr);
        if (zStr != "") {
            z = Integer.parseInt(zStr);
        }

        return  generateNumber(x, y, z);
    }


    private static int generateNumber(int x, int y, int z) {
        int sum = 0;
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            sum += (rand.nextInt(y) + 1);
        }
        sum += z;
        return sum;
    }


}

