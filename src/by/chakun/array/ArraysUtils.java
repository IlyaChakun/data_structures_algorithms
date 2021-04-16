package by.chakun.array;

public class ArraysUtils {

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static void swap(int[] list, int i, int j) {
        int swap = list[i];
        list[i] = list[j];
        list[j] = swap;
    }

}
