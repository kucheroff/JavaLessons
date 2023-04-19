package lesson1;

import java.util.*;

public class lesson1 {
    public static void main(String[] args) {
        task1(5, 7);
//        task2();
//        task3();
//        task4(12, 0); // уствновка часов и минут.
//        task5();
    }


    private static void turn_left(int[] arr, int n) {
        if (n == 0) return;

        int zero_num = arr[0];

        for (int i = 1; i < arr.length; i++ ){
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = zero_num;
        turn_left(arr, n -1);
    }

    private static void turn_right(int[] arr, int n) {
        if (n == 0) return;

        int last_num = arr[arr.length-1];

        for (int i = 0; i < arr.length-1; i++ ){
            arr[arr.length-1-i] = arr[arr.length-2-i];
        }

        arr[0] = last_num;
        turn_right(arr, n -1);
    }

    private static void task5() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите количество сдвигов (+ вправо / - влево) : ");
        int my_shift = iScanner.nextInt();

        if (my_shift >= 0) turn_right(arr, my_shift);
        else turn_left(arr, my_shift * -1);

        System.out.println("Сдвинутый массив: ");
        System.out.printf(Arrays.toString(arr));
    }

    private static void task4(int h, int m) {
        Scanner iScanner = new Scanner(System.in);
        Calendar cal = new GregorianCalendar(Locale.ENGLISH);
        System.out.print("Введите имя: ");
        String name = iScanner.nextLine();

        cal.set(Calendar.HOUR_OF_DAY, h);
        cal.set(Calendar.MINUTE, m);
        int curr_hour = cal.get(Calendar.HOUR_OF_DAY);

        if (curr_hour >= 5 && curr_hour < 12) System.out.printf("Доброе утро, %s!", name);
        else
            if (curr_hour >= 12 && curr_hour < 18) System.out.printf("Добрый день, %s!", name);
        else
            if (curr_hour >= 18 && curr_hour < 23) System.out.printf("Добрый вечер, %s!", name);
        else
                System.out.printf("Доброй ночи, %s!", name);
    }

    private static void task3() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || j == arr[i].length - i-1) arr[i][j] = 1;
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void task2() {
        int[] arr = new int[10];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = (int) (Math.random() * 9 + 1);
        }

        int i_min = arr[0];
        int i_max = arr[0];

        for (int i = 2; i< arr.length; i++){
            if (arr[i] > i_max) i_max = arr[i];
            if (arr[i] < i_min) i_min = arr[i];
        }

        System.out.printf("Исходный массив: %s\n",Arrays.toString(arr));
        System.out.printf("Минимальный элемент массива: %d. Максимальный элемент массива: %d",i_min, i_max);

    }

    private static void task1(int len, int InitValue) {
        int[] mass = new int[len];
        Arrays.fill(mass, InitValue);
        System.out.println(Arrays.toString(mass));
    }
}
