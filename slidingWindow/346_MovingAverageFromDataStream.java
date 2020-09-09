class MovingAverage {
    
    private Deque<Integer> queue;
    private int sum;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();
        this.sum = 0;
        this.size = size;
    }
    
    // O(1) time O(N) space
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return (double) sum / queue.size();
    }
}