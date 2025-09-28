package algorithm;

import algorithm.metrics.MetricsCollector;
import algorithm.util.Partition;

public class QuickSort {
    public static void sort(int[] array, MetricsCollector metrics) {
        sort(array, 0, array.length - 1, metrics);
    }

    private static void sort(int[] array, int low, int high, MetricsCollector metrics) {
        metrics.getRecursionDepth().enter();

        if (low < high) {
            int pi = partition(array, low, high, metrics.getComparisons());
            sort(array, low, pi - 1, metrics);
            sort(array, pi + 1, high, metrics);
        }

        metrics.getRecursionDepth().exit();
    }

    private static int partition(int[] array, int low, int high, algorithm.metrics.ComparisonCounter counter) {
        return Partition.partition(array, low, high, counter);
    }
}