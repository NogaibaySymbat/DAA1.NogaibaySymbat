package algorithm;

import algorithm.metrics.MetricsCollector;
import algorithm.util.Partition;

public class QuickSelect {
    public static int select(int[] array, int k, MetricsCollector metrics) {
        return select(array, 0, array.length - 1, k, metrics);
    }

    private static int select(int[] array, int left, int right, int k, MetricsCollector metrics) {
        metrics.getRecursionDepth().enter();

        if (left == right) {
            metrics.getRecursionDepth().exit();
            return array[left];
        }

        int pivotIndex = partition(array, left, right, metrics.getComparisons());

        if (k == pivotIndex) {
            metrics.getRecursionDepth().exit();
            return array[k];
        } else if (k < pivotIndex) {
            int result = select(array, left, pivotIndex - 1, k, metrics);
            metrics.getRecursionDepth().exit();
            return result;
        } else {
            int result = select(array, pivotIndex + 1, right, k, metrics);
            metrics.getRecursionDepth().exit();
            return result;
        }
    }

    private static int partition(int[] array, int left, int right, algorithm.metrics.ComparisonCounter counter) {
        return Partition.partition(array, left, right, counter);
    }
}