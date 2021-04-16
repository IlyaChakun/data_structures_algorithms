package by.chakun.recursion;

public class Recursion {


    public static int findFactorial(int number) {
        return doFindFactorial(number);
    }


    private static int doFindFactorial(int number) {
        if (number == 1) {
            return number;
        } else {
            return number * doFindFactorial(number - 1);
        }
    }

    public static int findSum() {
        int initPointer = 0;
        int[] array = new int[]{1, 2, 2, 2, 3, 5, 6};
        return doFindSum(array, initPointer);
    }

    private static int doFindSum(int[] array, int pointer) {
        if (pointer < array.length) {
            return array[pointer] + doFindSum(array, ++pointer);
        } else {
            return 0;
        }
    }


    public static int findMaxNumberInArray() {
        int[] array = new int[]{1, 2, 2, 2, 25, 3, 5, 100, 6};
        int currentMax = array[0];
        return doFindMaxNumberInArray(array, currentMax);
    }

    public static int doFindMaxNumberInArray(int[] array, int pointer) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 2) {
            return Math.max(array[0], array[1]); //array[0] > array[1] ? array[0] : array[1];
        }

        if (pointer < array.length) {
            return Math.max(array[pointer], doFindMaxNumberInArray(array, ++pointer));
        } else {
            return 0;
        }
    }


}
