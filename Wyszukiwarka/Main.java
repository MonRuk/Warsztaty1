package Wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connect = Jsoup.connect("https://onet.pl");
        try {
            //createFile("popular_words.txt");
            PrintWriter file1 = new PrintWriter("popular_words.txt");
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String title = elem.text();
                title = title.replaceAll("\\p{P}", "");
                String words[] = title.split(" ");
                title = title.replace(",", "");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() >= 3) {
                        file1.println(words[i]);

                    }
                }


                System.out.println(elem.text());

            }
            file1.close();

            PrintWriter file2 = new PrintWriter("filtered_popular_words.txt");
            Path path1 = Paths.get("popular_words.txt");
            Scanner scan1 = new Scanner(path1);
            String wordsToExclude[] = new String[]{"oraz", "ponieważ", "dla", "nie", "tylko", "jest", "się", "też", "czy", "tak", "jak", "ale", "jeśli"};
            while (scan1.hasNextLine()) {
                String word = scan1.nextLine();
                int count = 0;
                for (int i = 0; i < wordsToExclude.length; i++) {
                    if (word.equalsIgnoreCase(wordsToExclude[i])) {
                        count = 1;
                    }
                }
                if (count == 0) {
                    file2.println(word);
                }
            }

            file2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


