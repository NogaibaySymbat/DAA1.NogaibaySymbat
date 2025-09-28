package algorithm;

import algorithm.*;
import algorithm.metrics.MetricsCollector;
import algorithm.util.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        demonstrateQuickSort();
        demonstrateMergeSort();
        demonstrateQuickSelect();
        demonstrateClosestPair();
    }

    private static void demonstrateQuickSort() {
        System.out.println("1.QuickSort Demo: ");
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.print("Original array: ");
        printArray(array);

        MetricsCollector metrics = new MetricsCollector();
        int[] arrayCopy = array.clone();
        QuickSort.sort(arrayCopy, metrics);

        System.out.print("Sorted array: ");
        printArray(arrayCopy);
        System.out.println("Comparisons: " +metrics.getComparisons().getCount());
        System.out.println("Max recursion depth: " +metrics.getRecursionDepth().getMaxDepth());
    }

    private static void demonstrateMergeSort() {
        System.out.println("2.MergeSort Demo: ");
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.print("Original array: ");
        printArray(array);

        MetricsCollector metrics = new MetricsCollector();
        int[] arrayCopy = array.clone();
        MergeSort.sort(arrayCopy, metrics);

        System.out.print("Sorted array: ");
        printArray(arrayCopy);
        System.out.println("Comparisons: " + metrics.getComparisons().getCount());
        System.out.println("Max recursion depth: " + metrics.getRecursionDepth().getMaxDepth());
    }

    private static void demonstrateQuickSelect() {
        System.out.println("3.QuickSelect Demo: ");
        int[] array = {7, 10, 4, 3, 20, 15};

        System.out.print("Array: ");
        printArray(array);

        for (int k = 0; k < array.length; k++) {
            MetricsCollector metrics = new MetricsCollector();
            int[] arrayCopy = array.clone();
            int result = QuickSelect.select(arrayCopy, k, metrics);
            System.out.println(k + 1 + "-th smallest element: " + result +
                    " (comparisons: " + metrics.getComparisons().getCount() + ")");
        }
    }
    private static void demonstrateClosestPair() {
        System.out.println("4.Closest Pair Demo:");
        int[][] points = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};

        System.out.println("Points: ");
        for (int[] point : points) {
            System.out.println("  (" + point[0] + ", " + point[1] + ")");
        }

        algorithm.metrics.ComparisonCounter counter = new algorithm.metrics.ComparisonCounter();
        double distance = ClosestPair.findClosestPair(points, counter);

        System.out.println("Closest distance:" + String.format("%.2f", distance));
        System.out.println("Comparisons made:" + counter.getCount());
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}