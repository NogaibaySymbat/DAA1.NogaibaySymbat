package algorithm.metrics;

public class MetricsCollector {
    private ComparisonCounter comparisons;
    private DepthTracker recursionDepth;

    public MetricsCollector() {
        this.comparisons = new ComparisonCounter();
        this.recursionDepth = new DepthTracker();
    }

    public ComparisonCounter getComparisons() {
        return comparisons;
    }

    public DepthTracker getRecursionDepth() {
        return recursionDepth;
    }

    public void reset() {
        comparisons.reset();
        recursionDepth.reset();
    }
}