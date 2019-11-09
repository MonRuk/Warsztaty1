package pl.coderslab.warsztaty1.GraZgadnijLiczbę;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(100) + 1;

        System.out.println("Wylosowałem liczbę, zgadnij jaką");
        int count = 0;
        boolean win = false;
        while (!win ) {
            int numberGuess = wczytajLiczbe();
            if (numberGuess < number) {
                System.out.println("Podana liczba jest za mała");
            } else if (numberGuess > number) {
                System.out.println("Podana liczba jest za duża");
            } else {
                System.out.println("Zgadłeś");
                win = true;
            }
            count++;

            System.out.println("ilość prób: " + count);
        }
    }


    public static int wczytajLiczbe() {
        System.out.println("Podaj liczbę");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Musisz podać liczbę");
            scan.next();
        }
        return scan.nextInt();
    }
}
