package algorithm.util;

import algorithm.metrics.ComparisonCounter;

public class Partition {
    public static int partition(int[] array, int low, int high, ComparisonCounter counter) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            counter.increment();
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}