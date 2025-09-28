Assignment 1 — Design and Analysis of Algorithms
------------------------------------------------
Nogaibay Symbat | SE-2402


Intoduction
As part of the first assignment for the Design and Analysis of Algorithms course, I implemented several classic sorting and selection algorithms, as well as an algorithm for finding the nearest pair of points.The goal of the assignment was to study their structure, test their correctness, and evaluate how they behave on arrays of different sizes in terms of execution time, number of comparisons, and recursion depth.



Implementation details
MergeSort — classic recursive merge sort (top-down).
QuickSort — quick sort with array partitioning using the Lomuto scheme (pivot — last element).
QuickSelect — selection of the k-th element using the same partition function.
Closest Pair of Points — a naive O(n²) implementation that iterates through all pairs of points to demonstrate how counters work.

The project has its own utilities:
MetricsCollector combines a comparison counter and a recursion depth tracker.
ArrayUtils — random array generation, swap, sorting verification.
GeometryUtils — calculation of distances between points.
Partition — a general partitioning method for QuickSort and QuickSelect.

For performance analysis, there is a mini-benchmark (benchmarks.java) that measures:
execution time (in milliseconds),
number of comparisons,
maximum recursion depth.



Metrics
All metrics are collected via MetricsCollector:
Comparisons (ComparisonCounter) — increase with each key comparison:
in Partition.partition() when checking array[j] <= pivot;
in MergeSort.merge() when comparing elements of the left and right subarrays;
in ClosestPair.findClosestPair() when comparing distances between pairs of points.



Algorithm complexity

| Algorithm        | Average Time | Worst Time | Extra Space    |
| ---------------- | ------------ | ---------- | -------------- |
| **MergeSort**    | O(n log n)   | O(n log n) | O(n)           |
| **QuickSort**    | O(n log n)   | O(n²)      | O(log n) stack |
| **QuickSelect**  | O(n)         | O(n²)      | O(log n) stack |
| **Closest Pair** | O(n²)        | O(n²)      | O(1)           |



Results and Analysis
After running tests on arrays of different sizes, we made the following observations:
MergeSort and QuickSort grow approximately as O(n log n).
QuickSort is often slightly faster on small arrays, but it has a higher recursion depth, and its performance is more dependent on the pivot.
QuickSelect shows linear time on average for selecting the kth element and does not require a complete sort.
Closest Pair (naive) confirms quadratic complexity: the number of comparisons grows ~n², which makes the algorithm heavy on large data sets.

Conclusion
During this assignment IЖ implemented four algorithms: MergeSort, QuickSort, QuickSelect, and Closest Pair of Points; developed a metric system to measure the number of comparisons and the maximum recursion depth; wrote JUnit 5 tests to verify correctness; ran performance measurements and confirmed the expected behavior: MergeSort and QuickSort scale as O(n log n), QuickSelect runs in O(n) on average, and Closest Pair follows O(n²). This work helped me better understand the practical side of algorithm analysis, taught me how to measure key performance characteristics, and compare them with theoretical complexity.

