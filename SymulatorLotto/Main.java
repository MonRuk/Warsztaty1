package SymulatorLotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.util.Arrays.*;


public class Main {
    public static void main(String[] args) {
        int minValue = 1;
        int maxValue = 49;
        int howManyNumbers = 6;


        System.out.println("Wytypuj " + howManyNumbers + " liczb z zakresu między " + minValue + " a " + maxValue);
        int[] guessNumbers = new int[howManyNumbers];

        try {

            guessNumbers = userNumbers(minValue, maxValue, howManyNumbers);

            int[] lotteryNumbers = drawnNumbers(minValue, maxValue, howManyNumbers);
            System.out.println("Maszyna Lotto wylosowała następujące liczby: " + Arrays.toString(lotteryNumbers));
            int matches = compareNumbers(guessNumbers, lotteryNumbers);

            if (matches == 6) {
                System.out.println("Brawo! Trafiłeś 6! Oto Twoje miliony");
            } else if (matches == 5) {
                System.out.println("To straszne! Byłeś o włos od bogactwa. Niestety tylko 5 trafień");
            } else if (matches == 4) {
                System.out.println("Nieźle! Trafiłeś 4. Starczy na pizzę");
            } else if (matches == 3) {
                System.out.println("Trafiłeś 3 liczby. Jeszcze 3 i byłbyś ustawiony");
            } else {
                System.out.println("Niestety udało Ci się trafić tylko " + matches);
            }


        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowy format danych");
        }


    }


    public static int[] userNumbers(int min, int max, int howMany) throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        int[] userNumbers = new int[howMany];
        int count = 0;
        boolean isNumDoubled = true;

        while (count < (howMany - 1) || isNumDoubled) {
            for (int i = 0; i < howMany; i++) {
                if (scan.hasNextInt()) {
                    int guess = scan.nextInt();
                    if (guess >= min && guess <= max) {

                        userNumbers[i] = guess;
                        count++;


                    } else if (guess < min || guess > max) {
                        System.out.println("Podałeś liczbę spoza zakresu - spróbuj jeszcze raz");
                        i--;
                    }
                } else {
                    throw new InputMismatchException();
                }
            }
                isNumDoubled = checkDoubles(userNumbers);
                if (isNumDoubled==true) {
                    System.out.println("Wprowadzono tę samą liczbę więcej niż raz - wybierz liczby ponownie");
                    //count--;
                }
            }



        Arrays.sort(userNumbers);
        System.out.println("Twoje typowane liczby to: " + Arrays.toString(userNumbers));

        scan.close();

        return userNumbers;

    }


    public static boolean checkDoubles(int[] arr) {
        boolean sameNumberTwiceOrMore = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    sameNumberTwiceOrMore = true;
                }
            }
        }
        return sameNumberTwiceOrMore;
    }


    public static int[] drawnNumbers(int min, int max, int howMany) {
        Integer[] arr = new Integer[max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        Collections.shuffle(asList(arr));
        //System.out.println(Arrays.toString(arr));
        int[] drawnNumbers = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            drawnNumbers[i] = arr[i];
        }
        Arrays.sort(drawnNumbers);
        return drawnNumbers;

    }

    public static int compareNumbers(int[] userNumbers, int[] gameNumbers) {

        int sameNumber = 0;

        for (int k = 0; k < userNumbers.length; k++) {
            for (int l = 0; l < userNumbers.length; l++) {
                if (gameNumbers[k] == userNumbers[l]) {
                    sameNumber++;
                }
            }
        }

        return sameNumber;
    }

}
