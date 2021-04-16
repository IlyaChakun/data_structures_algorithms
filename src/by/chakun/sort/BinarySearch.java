package by.chakun.sort;

public class BinarySearch {


    public static int binarySearch(int[] list, int key) {

        int low = 0;
        int high = list.length - 1;// границы массива

        while (low <= high) {
            int mid = (low + high) / 2;

            int guess = list[mid];

            if (guess == key) {
                return mid;//return key position
            }
            if (guess > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
