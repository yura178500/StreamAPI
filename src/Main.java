import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите
minMaxConsumer.accept(null, null);
*/
            public static <T> void findMinMax(
                    Stream<? extends T> stream,
                    Comparator<? super T> order,
                    BiConsumer<? super T, ? super T> minMaxConsumer) {

                List<T> items = stream.sorted (order).collect (Collectors.toList());
                if (!items.isEmpty()) {
                    minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

                } else {
                    minMaxConsumer.accept(null, null);
                }
            }

            public static void main(String[] args) throws Exception {
                Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)). stream();

                findMinMax(
                        stream,
                        (x, y) -> x.compareTo(),
                        (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
                );

                stream.close();
            }
    public Main{
//Реализуйте метод, который принимает на вход Список целых чисел и определяет количество четных
// и выводит их в консоль. Решать именно с применением Stream API
// 1. Создать поток данных из случайного массива чисел
ArrayList<Integer> AL = new ArrayList<Integer>();
    int number;
    Random rnd = new Random();

    for (int i=0; i<10; i++) {
        number = rnd.nextInt() % 100;
        AL.add(number);
    }

    System.out.println("Array AL:");
    System.out.println(AL);

    int n2 = (int)(AL.stream().filter((n)->(n%2)==0)).count();
    System.out.println("n2 = " + n2);
}}



