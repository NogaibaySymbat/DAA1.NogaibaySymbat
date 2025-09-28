package algorithm;

import algorithm.metrics.MetricsCollector;
import algorithm.util.ArrayUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = {5, 2, 8, 1, 9};
        int[] expected = {1, 2, 5, 8, 9};

        MetricsCollector metrics = new MetricsCollector();
        MergeSort.sort(array, metrics);

        assertArrayEquals(expected, array);
        assertTrue(metrics.getComparisons().getCount() > 0);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] array = ArrayUtils.generateRandomArray(100, 1, 1000);

        MetricsCollector metrics = new MetricsCollector();
        MergeSort.sort(array, metrics);

        assertTrue(ArrayUtils.isSorted(array));
        assertTrue(metrics.getComparisons().getCount() > 0);
    }
}