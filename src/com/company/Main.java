package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    /*
    Задание 5.1 (Пример рекурсии)
    У меня есть база данных 2500 людей. у всех есть возраст. Я вызываю метод, который берет первого человека,
    проверяет его возраст, если он равен 40 то записывает в массив его. После, метод переключается на следующего
    человека в списке и МЕТОД ВЫЗЫВАЕТСЯ СНОВА (проверяется не закончился ли список, если да, то выйти из метода).

    Задание 5.3 (пример стек вызова и стек вызова с рекурсией)
    а) очередь в магазине на кассе. первый пришел за ним следующий и стак далее. кто первый пришел тот и первый
    оплатил и вышел из магазина.
    б) пример с рекурсией. ребятам в школе по одному раздают мячикии они выстраиваются в линейку. а когда всем
    выдадут, так же по одному, начиная с того, кто взял последний мячик, начинают бросать мячи в корзину.
     */

    public static void main(String[] args) {

        task2();
        System.out.println();
        System.out.println("Задание 5.1 (Пример рекурсии)\n" +
                "    У меня есть база данных 2500 людей. у всех есть возраст. Я вызываю метод, который берет первого человека,\n" +
                "    проверяет его возраст, если он равен 40 то записывает в массив его. После, метод переключается на следующего\n" +
                "    человека в списке и МЕТОД ВЫЗЫВАЕТСЯ СНОВА (проверяется не закончился ли список, если да, то выйти из метода).");
        System.out.println();
        System.out.println("Задание 5.3 (пример стек вызова и стек вызова с рекурсией)\n" +
                "    а) очередь в магазине на кассе. первый пришел за ним следующий и стак далее. кто первый пришел тот и первый\n" +
                "    оплатил и вышел из магазина.\n" +
                "    б) пример с рекурсией. ребятам в школе по одному раздают мячикии они выстраиваются в линейку. а когда всем\n" +
                "    выдадут, так же по одному, начиная с того, кто взял последний мячик, начинают бросать мячи в корзину.");
        task4();
        task5();
        task6();

    }

    private static void task6() {
        System.out.println();
        System.out.println("--- Задание 5.6 ---");
        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(359);
        }
        System.out.println("не сорт массив " + Arrays.toString(arr));
        long a = System.nanoTime();
        System.out.println("Сорт массив слиянием " + Arrays.toString(sortMarge(arr)));
        System.out.println(System.nanoTime() - a + " Столько нано секунд потребовалось на слияние");
        System.out.println();
    }

    private static int[] sortMarge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merg(sortMarge(Arrays.copyOfRange(arr, 0, middle)),
                sortMarge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merg(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }

    private static void task5() {
        System.out.println();
        System.out.println("--- Задание 5.5 ---");
        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int low = 20;
        int high = 300;
        int find = 160;
        long a = System.nanoTime();
        System.out.println(recBinarFind(find, low, high, arr) + " ячейке лежит 160");
        System.out.println(System.nanoTime() - a + " нано секунд занял рекурсивный двоичный поиск");
    }

    private static int recBinarFind(int find, int low, int high, int[] arr) {
        if (low > high) return arr.length;
        int mid = (low + high)/2;
        if (arr[mid] == find) return mid;
        if (arr[mid] < find) return recBinarFind(find, low + 1, high, arr);
        else return recBinarFind(find, low, high - 1, arr);
    }

    private static void task4() {
        System.out.println();
        System.out.println("--- Задание 5.4 ---");
        long a = System.nanoTime();
        recursionIsOutput(1000);
        System.out.println("Столько времени заняла рекурсия " + (System.nanoTime() - a));
        long b = System.nanoTime();
        int d = 1000;
        while (d != 500){
            d = d - 1;
        }
        System.out.println("а это цикл до 500! ");
        System.out.println("Столько времени занял цикл " + (System.nanoTime() - b));
    }

    private static void task2() {
        System.out.println();
        System.out.println("--- Задание 5.2 ---");
        int infiniteRecursion = 1000;
        int recursionIsOutput = 1000;
        try {
            infiniteRecursion(infiniteRecursion);
        } catch (StackOverflowError e){
            System.out.println();
            System.out.println("В бесконечной рекурсии произошла ошибка, бесконечность поборола стеки!");
        }
        recursionIsOutput(recursionIsOutput);
        System.out.println("задаие выше --- Задание 5.2 ---");
    }

    private static void recursionIsOutput(int n) {
        if (n == 500) {
            System.out.println("рекурсия примера где 500 середина!");
        } else recursionIsOutput(n - 1);
    }

    private static int infiniteRecursion(int n) {
        System.out.println(n);
        return infiniteRecursion(n - 1);
    }
}
