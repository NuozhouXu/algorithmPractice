class HitCounter {
    
    private int[] times;
    private int[] hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.times = new int[300];
        this.hits = new int[300];
    }
    
    // O(1) time
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    // O(N) time where N is the time interval
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class ConcurrentHitCounter {
    
    private int[] times;
    private AtomicInteger[] hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.times = new int[300];
        this.hits = new AtomicInteger[300];
        for (int i = 0; i < 300; i++) {
            this.hits[i] = new AtomicInteger(0);
        }
    }
    
    // O(1) time
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index].set(1);
        } else {
            hits[index].incrementAndGet();
        }
    }
    
    // O(N) time where N is the time interval
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i].get();
            }
        }
        return total;
    }
}