package algorithm.metrics;

public class ComparisonCounter {
    private int count;

    public ComparisonCounter() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}