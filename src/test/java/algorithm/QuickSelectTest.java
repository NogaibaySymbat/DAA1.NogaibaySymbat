package algorithm;

import algorithm.metrics.MetricsCollector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {
    @Test
    public void testQuickSelect() {
        int[] array = {5, 2, 8, 1, 9};

        MetricsCollector metrics = new MetricsCollector();
        int result = QuickSelect.select(array.clone(), 2, metrics); // 3-й наименьший элемент (0-based index)

        assertEquals(5, result);
        assertTrue(metrics.getComparisons().getCount() > 0);
    }

    @Test
    public void testQuickSelectSmallest() {
        int[] array = {5, 2, 8, 1, 9};

        MetricsCollector metrics = new MetricsCollector();
        int result = QuickSelect.select(array.clone(), 0, metrics); // Самый маленький элемент

        assertEquals(1, result);
    }

    @Test
    public void testQuickSelectLargest() {
        int[] array = {5, 2, 8, 1, 9};

        MetricsCollector metrics = new MetricsCollector();
        int result = QuickSelect.select(array.clone(), 4, metrics); // Самый большой элемент

        assertEquals(9, result);
    }

    @Test
    public void testQuickSelectWithDuplicates() {
        int[] array = {3, 2, 3, 1, 2};

        MetricsCollector metrics = new MetricsCollector();
        int result = QuickSelect.select(array.clone(), 2, metrics); // 3-й наименьший элемент

        assertEquals(2, result);
    }
}