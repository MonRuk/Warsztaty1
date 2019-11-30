package GraZgadnijLiczbę2;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max = 1001;
        int min = 0;
        boolean win = false;
        int guess = 500;

        System.out.println("Pomyśl o liczbie od 1 do 1000, a ja spróbuję ją odgadnąć");
        System.out.println("Zgaduję, że Twoja liczba to " + guess);


        int count = 1;
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        while (!win) {
            if (str.equals("więcej")) {
                min = guess;
                guess = guess + (max - min) / 2;
            } else if ((str.equals("mniej"))) {
                max = guess;
                guess = guess - (max - min) / 2;
            }

            if (str.equals("więcej") || str.equals("mniej")) {
                count++;
                System.out.println("Zgaduję, że Twoja liczba to " + guess);
                System.out.println("ilość prób: " + count);
                System.out.println("Podaj: mniej/więcej/trafiłeś");
                str = scan.next();
            } else {
                System.out.println("Podaj: mniej/więcej/trafiłeś");
                str = scan.next();
            }

            if (str.equals("trafiłeś")) {
                System.out.println("Brawo ja! Koniec gry");
                win = true;
            }
        }
        scan.close();
    }
}

