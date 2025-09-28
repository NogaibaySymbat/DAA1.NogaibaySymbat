package algorithm;

import algorithm.metrics.ComparisonCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPaitTest {
    @Test
    public void testClosestPair() {
        int[][] points = {{1, 1}, {2, 2}, {4, 4}, {5, 5}};

        ComparisonCounter counter = new ComparisonCounter();
        double result = ClosestPair.findClosestPair(points, counter);

        assertEquals(Math.sqrt(2), result, 0.001);
        assertTrue(counter.getCount() > 0);
    }

    @Test
    public void testClosestPairWithTwoPoints() {
        int[][] points = {{1, 1}, {4, 5}};

        ComparisonCounter counter = new ComparisonCounter();
        double result = ClosestPair.findClosestPair(points, counter);

        assertEquals(5.0, result, 0.001); // distance between (1,1) and (4,5)
    }

    @Test
    public void testClosestPairSinglePoint() {
        int[][] points = {{1, 1}};

        ComparisonCounter counter = new ComparisonCounter();
        double result = ClosestPair.findClosestPair(points, counter);

        assertEquals(Double.MAX_VALUE, result, 0.001);
    }

    @Test
    public void testClosestPairEmpty() {
        int[][] points = {};

        ComparisonCounter counter = new ComparisonCounter();
        double result = ClosestPair.findClosestPair(points, counter);

        assertEquals(Double.MAX_VALUE, result, 0.001);
    }

    @Test
    public void testClosestPairWithNegativeCoordinates() {
        int[][] points = {{-1, -1}, {1, 1}, {-2, -2}, {2, 2}};

        ComparisonCounter counter = new ComparisonCounter();
        double result = ClosestPair.findClosestPair(points, counter);

        assertEquals(Math.sqrt(2), result, 0.001);
    }
}