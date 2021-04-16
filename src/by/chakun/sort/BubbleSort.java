package by.chakun.sort;

import by.chakun.array.ArraysUtils;

public class BubbleSort {


    public static void sort(int[] list) {
        int listLength = list.length;

        for (int i = 0; i < listLength; i++) {
            int exchanges = 0; //колво обменов
            for (int j = listLength - 1; j > i; j--) {
                if (ArraysUtils.less(list[j], list[j - 1])) {
                    ArraysUtils.swap(list, j, j - 1);
                    exchanges++;
                }
            }
            if (exchanges == 0) break;
        }
    }


}
