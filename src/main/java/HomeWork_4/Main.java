package HomeWork_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> addWordsArray = new ArrayList<>(Arrays.asList("привет", "как", "дела",
                "что", "нового", "привет", "как", "ты", "тут", "оказался"));

        Set<String> uniqueWordsArray = new HashSet<>();

        for(String s : addWordsArray) {
            if (uniqueWordsArray.add(s))
                System.out.printf("element: %s , count: %s%n", s, Collections.frequency(addWordsArray, s));
        }

        TelephoneBook telephoneBook = new TelephoneBook();
        telephoneBook.add(12123, "Petrov");
        telephoneBook.add(12567, "Vasechkin");
        telephoneBook.add(17863, "Karasev");
        telephoneBook.add(74387, "Petrov");

        telephoneBook.get("Petrov");

    }
}
