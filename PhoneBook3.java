import java.util.*;

public class PhoneBook3 {
    public String name;
    public String phones;

    public PhoneBook3(String name, String phones) {
        this.name = name;
        this.phones = phones;
    }

    public static HashMap<String, String> map3 = new HashMap<>();
    private static void ini(){
        PhoneBook3.add("Anna","111-111"); PhoneBook3.add("Maksim","222-111");
        PhoneBook3.add("Anna","111-222"); PhoneBook3.add("Maksim","222-222");
        PhoneBook3.add("Anna","111-333"); PhoneBook3.add("Oleg","333-111");
        PhoneBook3.add("Oleg","333-222"); PhoneBook3.add("Olga","444-111");
        PhoneBook3.add("Ivan","");
        PhoneBook3.add("Natasha","111-000"); PhoneBook3.add("Natasha","222-000");
        PhoneBook3.add("Natasha","333-000"); PhoneBook3.add("Natasha","444-000");
        PhoneBook3.add("Natasha","555-000"); PhoneBook3.add("Natasha","666-000");

        System.out.println();
        System.out.println("-----------3 вариант (исходная т/ф книга)-----------");
        System.out.println(PhoneBook3.map3);
    }
    public static void add(String name, String phones) {
        String str;
        if (!map3.containsKey(name)) {
            map3.put(name, phones);
        }
        else
        if (phones != null) {
            str = map3.get(name) + ", " + phones;
            map3.put(name,str);}
    }

    private static void printSorted (){
        Comparator<Map.Entry<String,String>> c = new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().length()-o1.getValue().length();
            }
        };
        System.out.println();
        System.out.println("--------Отсортированный вывод (вариант 3)-------------");
        PhoneBook3.map3.entrySet().stream().sorted(c).forEach(System.out::println);
    }

    public static void run (){
        PhoneBook3.ini();
        PhoneBook3.printSorted();

    }

}