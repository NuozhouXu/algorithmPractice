class RecentCounter {
    
    private Deque<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}