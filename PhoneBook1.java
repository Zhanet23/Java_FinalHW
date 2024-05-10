import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class PhoneBook1 {
    public static HashMap<String, ArrayList<String>> phB = new HashMap<>();

    private static void ini(){
        PhoneBook1.add("Anna","111-111"); PhoneBook1.add("Maksim","222-111");
        PhoneBook1.add("Anna","111-222"); PhoneBook1.add("Maksim","222-222");
        PhoneBook1.add("Anna","111-333"); PhoneBook1.add("Oleg","333-111");
        PhoneBook1.add("Oleg","333-222"); PhoneBook1.add("Olga","444-111");
        PhoneBook1.add("Ivan","");
        PhoneBook1.add("Natasha","111-000"); PhoneBook1.add("Natasha","222-000");
        PhoneBook1.add("Natasha","333-000"); PhoneBook1.add("Natasha","444-000");
        PhoneBook1.add("Natasha","555-000"); PhoneBook1.add("Natasha","666-000");


        System.out.println();
        System.out.println("-----------вариант 1 (исходная т/ф книга)-----------");
        System.out.println(phB);
        System.out.println();
    }

    private static void add(String name, String phoneNum) {
        if (!phB.containsKey(name)) {
            phB.put(name, new ArrayList<>());
        }
        if (phoneNum != null) {phB.get(name).add(phoneNum);}
    }


    private static void printSorted() {
        TreeSet<Integer> a = new TreeSet<>();  // множество а будет хранить уникальные счетчики т/ф
        for (var item : phB.entrySet()) {
            a.add(item.getValue().size());
        }
        a = (TreeSet<Integer>) a.descendingSet(); // сортировка множества по убыванию

        for (var j : a) {
            for (var item : phB.entrySet()) {
                if (j == item.getValue().size())
                    System.out.printf("%-10s : %2s%n", item.getKey(), item.getValue());
            }
        }
    }
    public static void run (){
        PhoneBook1.ini();
        PhoneBook1.printSorted();

    }
}

