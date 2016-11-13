package main;

import java.util.Random;
import java.util.Arrays;

/**
 * @author Лобанов Михаил
 */
public final class ArrayUtil {
    private static int[] arr;
    private static int[] arr2;

    private ArrayUtil() {
    }

    /*
    Находит номер элемента массива с другим значением следующим за текущим, если он есть
     */
    private static int noRepeat(int[] arr, int i) {
        while ((i < arr.length - 1) && (arr[i] == arr[i + 1])) {
            i++;
        }
        return ++i;
    }

    /*
    Изменение размерности массива
     */
    public static int[] resize(int[] arrIn, int size) {
        arr = new int[size];
        if (size > arrIn.length) {
            for (int i = 0; i < arrIn.length; i++) {
                arr[i] = arrIn[i];
            }
        } else {
            for (int i = 0; i < size; i++) {
                arr[i] = arrIn[i];
            }
        }
        return arr;
    }

    /*
    Сравнение двух массивов без учета порядка
    Т.е. равны 2 множества или нет
     */
    public static boolean comparison(int[] arrIn, int[] arrIn2) {
        arr = arrIn.clone();
        arr2 = arrIn2.clone();
        boolean noneError = false;
        if (arr == null && arr2 == null) {
            noneError = true;
        } else if (arr != null && arr2 != null) {
            Arrays.sort(arr);
            Arrays.sort(arr2);
            int i = 0;
            int j = 0;
            int arrLengthMinusOne = arr.length - 1;
            int arr2LengthMinusOne = arr2.length - 1;
            do {
                if (arr[i] == arr2[j]) {
                    i = noRepeat(arr, i);
                    j = noRepeat(arr2, j);
                } else {
                    break;
                }
            } while ((i < arrLengthMinusOne) && (j < arr2LengthMinusOne));
            if (i < arrLengthMinusOne) {
                i = noRepeat(arr, i);
                i--;
            }
            if (j < arr2LengthMinusOne) {
                j = noRepeat(arr2, j);
                j--;
            }
            if ((i == arrLengthMinusOne && (j == arr2LengthMinusOne)) &&
                    (arr[arrLengthMinusOne] == arr2[arr2LengthMinusOne])) {
                noneError = true;
            }
        }
        return noneError;
    }

    /*
    Перемешать массив (java.util.Random)
     */
    public static int[] mix(int[] arrIn) {
        arr = arrIn.clone();
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rnd.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    /*
    Распечатать массив
     */
    public static void print(int[] arrIn) {
        for (int x : arrIn) {
            System.out.println(x);
        }
    }

    /*
    Фильтр массива по предикату
     */
    public static int[] filter(int[] arrIn, PredicateFilter predicate) {
        if (arrIn != null) {
            arr = new int[arrIn.length];
            int row = 0;

            for (int value : arrIn) {
                if (predicate.hasPredicate(value)) {
                    arr[row] = value;
                    row++;
                }
            }
            int[] arrOut = new int[row];
            System.arraycopy(arr, 0, arrOut, 0, row);
            return arrOut;
        } else {
            return arr;
        }
    }
}