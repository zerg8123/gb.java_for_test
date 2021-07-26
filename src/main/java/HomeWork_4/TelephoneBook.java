package HomeWork_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneBook {
 private Map<Integer, String> phoneBook;

    TelephoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add (int number, String surname) {
        phoneBook.put(number, surname);
    }

    public void get (String surname) {
        if(phoneBook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = phoneBook.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if(temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.println("Such a name is not on the list.");
        }
    }
}


