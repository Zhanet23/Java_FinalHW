import java.util.*;

public class PhoneBook2 {     // одна запись человека и его телефонов
    public String name;        // переменная - имя человека
    public ArrayList<String> list;  // переменная - писок его телефоны
    public static  HashMap<String, ArrayList<String>> map2 = new HashMap<>();

    public PhoneBook2(String name, ArrayList<String> list) { // объект - запись книги
        this.name = name;
        this.list = list;
    }

     private static void ini(){
        ArrayList <String> list = new ArrayList<>();
        list.add("111-111"); PhoneBook2.add(new PhoneBook2("Anna", list));
        list.clear();  list.add("222-111"); PhoneBook2.add(new PhoneBook2("Maksim", list));
        list.clear();  list.add("111-222"); PhoneBook2.add(new PhoneBook2("Anna", list));
        list.clear();  list.add("222-222"); PhoneBook2.add(new PhoneBook2("Maksim", list));
        list.clear();  list.add("111-333"); PhoneBook2.add(new PhoneBook2("Anna", list));
        list.clear();  list.add("333-111"); PhoneBook2.add(new PhoneBook2("Oleg", list));
        list.clear();  list.add("333-222"); PhoneBook2.add(new PhoneBook2("Oleg", list));
        list.clear();  list.add("444-111"); PhoneBook2.add(new PhoneBook2("Olga", list));
        list.clear();  list.add(null); PhoneBook2.add(new PhoneBook2("Ivan", list));

         list.clear();  list.add("111-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));
         list.clear();  list.add("222-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));
         list.clear();  list.add("333-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));
         list.clear();  list.add("444-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));
         list.clear();  list.add("555-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));
         list.clear();  list.add("666-000"); PhoneBook2.add(new PhoneBook2("Natasha", list));


        System.out.println();
        System.out.println("-----------2 вариант (исходная т/ф книга)-----------");
        System.out.println(PhoneBook2.map2);
    }

    private static void add(PhoneBook2 o) {
        if (!map2.containsKey(o.name)) {
            map2.put(o.name, new ArrayList<>());
        }
        if (o.list != null) {map2.get(o.name).add(o.list.get(0));}
    }

    private static void printSorted (){
        HashMap<String, Integer> temp = new HashMap<>(); // новая HashMap (temp)(ключ(имя)-значение(кол-во повторений т/ф)
        for (var item : PhoneBook2.map2.entrySet()) {
            temp.put(item.getKey(),item.getValue().size());
        }
        // из этой новой HashMap делаем список (lm) и сортируем его компаратором по
        // значению, в котором лежат числа (количества повторений телефонов)
        List<Map.Entry<String, Integer>> lm = new ArrayList<>(temp.entrySet());
        //System.out.println(lm);
        Collections.sort(lm, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        // создаем LinkedHashMap на основе отсортированного списка lm
        LinkedHashMap<String, ArrayList<String>> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : lm) {
        //PhoneBook2.map2.get(entry.getKey());
            sortedHashMap.put(entry.getKey(), PhoneBook2.map2.get(entry.getKey()));
        }
        System.out.println();
        System.out.println("--------Отсортированный вывод (вариант 2)-------------");
        //System.out.println(sortedHashMap);
        sortedHashMap.entrySet().stream().forEach(System.out::println);
    }
    

    public static void run (){
        PhoneBook2.ini();
        PhoneBook2.printSorted();

    }
}
