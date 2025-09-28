package algorithm;

import algorithm.metrics.ComparisonCounter;

public class ClosestPair {
    public static double findClosestPair(int[][] points, ComparisonCounter counter) {
        if (points.length < 2) {
            return Double.MAX_VALUE;
        }

        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                counter.increment();
                double distance = distance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }
    private static double distance(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }
}