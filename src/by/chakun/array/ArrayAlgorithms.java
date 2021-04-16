package by.chakun.array;

import by.chakun.sort.SelectionSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayAlgorithms {

    public static void printArray(int[] list) {
        for (int k : list) {
            System.out.println(k);
        }
    }


    public static void changeNumbersWithoutAdditionalVar(int a, int b) {
        System.out.println("init a=" + a);
        System.out.println("init b=" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void findMissingNumber() {
        int[] iArray = new int[]{1, 2, 3, 5, 6};
        int missing = doFindMissingNumber(iArray, 6);
        System.out.println("Missing Number=" + missing);
    }

    private static int doFindMissingNumber(int[] numbers, int totalCount) {//find from 1 to n
        int expectedSum = (int) (totalCount * ((float) (totalCount + 1) / 2));
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }

    public static void removeAllDuplicates() {
        int[] iArray = new int[]{1, 2, 2, 2, 3, 5, 6};
        System.out.println("init array with duplicates");
        printArray(iArray);
        int[] result = doRemoveDuplicates(iArray);
        System.out.println("after remove");
        printArray(result);
    }

    private static int[] doRemoveDuplicates(int[] numbersWithDuplicates) {//not best solution create with removing all 0
        SelectionSort.selectionSort(numbersWithDuplicates);

        int[] resultWithoutDuplicates = new int[numbersWithDuplicates.length];//с запасом

        int previous = numbersWithDuplicates[0];

        resultWithoutDuplicates[0] = previous;

        for (int i = 0; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];
            if (previous != ch) {
                resultWithoutDuplicates[i] = ch;
            }
            previous = ch;
        }

        return resultWithoutDuplicates;
    }


    public static void findLargestAndSmallest() {
        int[] iArray = new int[]{100, 2, -50, 2, 3, 5, 6};
        doFindLargestAndSmallest(iArray);
    }

    private static void doFindLargestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }


    public static void findSumEqualGivenNumber() {
        int[] iArray = new int[]{2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        int givenSum = 8;
        System.out.println("given sum =" + givenSum);
        doFindSumEqualGivenNumber(iArray, givenSum);
    }

    private static void doFindSumEqualGivenNumber(int[] array, int givenSum) {

        for (int i = 0; i < array.length; i++) {
            int firstNumber = array[i];
            for (int j = i + 1; j < array.length - 1; j++) {
                int secondNumber = array[j];

                if (firstNumber + secondNumber == givenSum) {
                    System.out.printf("(%d, %d) %n", firstNumber, secondNumber);
                }
            }
        }
    }


    public static void findNonRepeatedNumber() {
        int[] iArray = new int[]{2, 2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        doFindNonRepeatedNumber(iArray);
    }

    private static void doFindNonRepeatedNumber(int[] array) {
        Map<Integer, Integer> numberWithCount = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            int number = array[i];

            for (int j = i + 1; j < array.length; j++) {
                int secondNumber = array[j];
                if (number == secondNumber) {
                    if (numberWithCount.containsKey(number)) {
                        numberWithCount.put(number, numberWithCount.get(number) + 1);
                    } else {
                        numberWithCount.put(number, 1);
                    }
                }
            }
        }

        System.out.println(numberWithCount.entrySet());
    }


    public static void removeDuplicatesFromArray() {
        int[] iArray = new int[]{2, 2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        int[] newArray = doRemoveDuplicatesFromArray(iArray);

        printArray(newArray);
    }

    private static int[] doRemoveDuplicatesFromArray(int[] array) {

        Arrays.sort(array);

        int[] result = new int[array.length];
        int previous = array[0];
        result[0] = previous;

        for (int i = 1; i < array.length; i++) {
            int number = array[i];

            if (previous != number) {
                result[i] = number;
            }
            previous = number;
        }

        return result;
    }
}
