package by.chakun.sort;

import by.chakun.array.ArraysUtils;

public class SelectionSort {


    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[index]) {
                    index = j;
                }
            }
            ArraysUtils.swap(list, i, index);
        }
    }


    /**
     *  25  26  5   6   9
     *
     *  25 < 26 ? yes index=2
     *  25 < 5 ? no
     *  25 < 6 ? no
     *  25 < 9 ? no
     *  swap 25 and 26
     *
     *  26 25 5 6 9
     *
     *  25 < 5 ? no
     *  25 < 6 ? no
     *  25 < 9 ? no
     *
     *  26 25 5 6 9
     *
     *  5 < 6 ? yes index = 3
     *  5 < 9 ? yes index = 4
     *
     *  swap 5 and 9
     *  26 25 9 5 6
     *
     *  5 < 6 ? yes index = 4
     *
     *  26 25 9 6 5
     *
     *  finish
     */
}
