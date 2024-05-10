public class Main {
    
    //public static List <Integer> ll = new ArrayList<>();
    public static void main(String[] args) {


        //------------------PhoneBook-----------------------------------------------------------------
        // Задача решена 4-мя способами, выполнение которых сравнено по времени.
        
        //----------------Вариант 1 (реализация через 3 цикла без компаратора)-------------------------

          long startTime1 = System.currentTimeMillis();
          PhoneBook1.run();
          long endTime1 = System.currentTimeMillis();
          double result1 = endTime1 - startTime1;


        //------------------вариант 2 (используя компаратор и 2 цикла с HashMap-----------------------
        // на основе имеющейся HashMap<String, ArrayList<String>> cоздаем новую  HashMap<String, Integer> temp
        // где ключ - также имя, а значение не список, а число (количество повторений телефонов)
        // Далее созданную HashMap<String, Integer> temp переделываем в список и сортируем его, описывая
        // логику - число больше/меньше. Дальше создаем LinkedHashMap на основе отсортированного списка
        // и выводим отсортированную телефонную книгу по убыванию количества номеров
          long startTime2 = System.currentTimeMillis();
          PhoneBook2.run();
          long endTime2 = System.currentTimeMillis();
          double result2 = endTime2 - startTime2;

//---------------------------------------------------------------------------------

        //-------------------------- 3 вариант---------------------------------------------------
        // т/ф книга организована через HashMap<String, String> Вывод по правилу убывания телефонов
        // реализовано БЕЗ циклов, через компаратор (в методе PhoneBook3.printSorted)
        // чем длиннее строка - значение элемента HashMap, значит, в этой записи больше телефонов.
        long startTime3 = System.currentTimeMillis();
        PhoneBook3.run();
        long endTime3 = System.currentTimeMillis();
        double result3 = endTime3 - startTime3;


        //-------------------------- 4 вариант (БЕЗ циклов, используя компаратор) ----------------------------------------------
        // т/ф книга организована через TreeMap<String, ArrayList<String>> для подсортировки имен - ключей.
        // Вывод записей - по убыванию количества телефонов. Если заведено имя, но т/ф пуст - вывод как пустого
        // списка, за т/ф не считается.
        // Реализация - БЕЗ циклов, через компаратор (в методе PhoneBook4.printSorted) через описанную
        // логику сравнения двух элементов Map, являющихся ArrayList<String>, по их размеру, что и является
        // количеством телефонов у записанного человека.
        long startTime4 = System.currentTimeMillis();
        PhoneBook4.run();
        long endTime4 = System.currentTimeMillis();
        double result4 = endTime4 - startTime4;
        
        System.out.println();
        System.out.printf("Выполнение задачи способом 4 = %s %s %n",result4,"ms");
        System.out.printf("Выполнение задачи способом 3 = %s %s %n",result3,"ms");
        System.out.printf("Выполнение задачи способом 2 = %s %s %n",result2,"ms");
        System.out.printf("Выполнение задачи способом 1 = %s %s %n",result1,"ms");
        System.out.println();
        // System.out.println(PhoneBook1.phB);
        // System.out.println(PhoneBook2.map2);
        // System.out.println(PhoneBook3.map3);
        // System.out.println(PhoneBook4.map4);

    }

// самый длинный по исполнению получается вариант 3, где т/ф книга организована как
// HashMap<String, String>, вероятно, из-за сортировки строк по их длине.
// Далее на третьем месте - вариант 1 с тремя циклами без компаратора.
// В варианте 2 и варианте 4 хранение т/ф книги организовано в  HashMap<String, ArrayList<String>>.
// 2 вариант работает быстрее 4-го. Вариант 2 плохо работает с null - значениями.

}