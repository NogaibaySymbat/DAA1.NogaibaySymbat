package algorithm.metrics;

public class DepthTracker {
    private int currentDepth;
    private int maxDepth;

    public DepthTracker() {
        this.currentDepth = 0;
        this.maxDepth = 0;
    }

    public void enter() {
        currentDepth++;
        maxDepth = Math.max(maxDepth, currentDepth);
    }

    public void exit() {
        currentDepth--;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void reset() {
        currentDepth = 0;
        maxDepth = 0;
    }
}