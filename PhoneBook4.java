import java.util.*;

public class PhoneBook4 {
    public static TreeMap<String, ArrayList<String>> map4 = new TreeMap<>();

    private static void ini(){
        PhoneBook4.add("Natasha","111-000"); PhoneBook4.add("Natasha","222-000");
        PhoneBook4.add("Natasha","333-000"); PhoneBook4.add("Natasha","444-000");
        PhoneBook4.add("Natasha","555-000"); PhoneBook4.add("Natasha","666-000");

        PhoneBook4.add("Anna","111-111"); PhoneBook4.add("Maksim","222-111");
        PhoneBook4.add("Anna","111-222"); PhoneBook4.add("Maksim","222-222");
        PhoneBook4.add("Anna","111-333"); PhoneBook4.add("Oleg","333-111");
        PhoneBook4.add("Oleg","333-222"); PhoneBook4.add("Olga","444-111");
        PhoneBook4.add("Ivan",null);
        System.out.println("-----------4 вариант (исходная т/ф книга)-----------");
        System.out.println(PhoneBook4.map4);
    }

     private static void add(String name, String phoneNum) {
        if (!map4.containsKey(name)) {map4.put(name, new ArrayList<>());}
        // введенное имя - ключ сейчас в любом случае уже есть
        if (phoneNum != null) {map4.get(name).add(phoneNum);}
           else map4.put(name, new ArrayList<>());
    }

    private static void printSorted (){
        Comparator<Map.Entry<String,ArrayList<String>>> cc = new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                return o2.getValue().size()-o1.getValue().size();
            }
        };
        System.out.println();
        System.out.println("--------Отсортированный вывод (вариант 4)-------------");
        PhoneBook4.map4.entrySet().stream().sorted(cc).forEach(System.out::println);
    }

    public static void run (){
        PhoneBook4.ini();
        PhoneBook4.printSorted();

    }

}
