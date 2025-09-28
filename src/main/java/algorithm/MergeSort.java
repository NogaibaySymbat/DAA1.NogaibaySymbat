package algorithm;
import algorithm.metrics.MetricsCollector;

public class MergeSort {
    public static void sort(int[] array, MetricsCollector metrics) {
        sort(array, 0, array.length - 1, metrics);
    }

    private static void sort(int[] array, int left, int right, MetricsCollector metrics) {
        metrics.getRecursionDepth().enter();

        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(array, left, mid, metrics);
            sort(array, mid + 1, right, metrics);
            merge(array, left, mid, right, metrics);
        }
        metrics.getRecursionDepth().exit();
    }

    private static void merge(int[] array, int left, int mid, int right, MetricsCollector metrics) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            metrics.getComparisons().increment();
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}