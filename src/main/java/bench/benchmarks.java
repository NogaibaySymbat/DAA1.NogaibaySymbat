package bench;
import algorithm.MergeSort;
import algorithm.QuickSelect;
import algorithm.QuickSort;
import algorithm.metrics.MetricsCollector;
import algorithm.util.ArrayUtils;
import java.util.Arrays;

public class benchmarks {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000};
        System.out.printf("%-10s %8s %10s %12s %10s%n",
                "Algo", "N", "Time(ms)", "Comparisons", "Depth");

        for (int n : sizes) {
            int[] base = ArrayUtils.generateRandomArray(n, 0, 1_000_000);
            run("MergeSort", base, (a, m) -> MergeSort.sort(a, m));
            run("QuickSort", base, (a, m) -> QuickSort.sort(a, m));
            run("QuickSelect", base, (a, m) -> QuickSelect.select(a, n / 2, m));
        }
    }

    @FunctionalInterface
    interface Sorter { void exec(int[] a, MetricsCollector m); }
    private static void run(String name, int[] base, Sorter algo) {
        int[] arr = Arrays.copyOf(base, base.length);
        MetricsCollector m = new MetricsCollector();
        long t0 = System.nanoTime();
        algo.exec(arr, m);
        long t1 = System.nanoTime();
        System.out.printf("%-10s %8d %10.2f %12d %10d%n",
                name, arr.length, (t1 - t0) / 1_000_000.0,
                m.getComparisons().getCount(),
                m.getRecursionDepth().getMaxDepth());
    }
}
