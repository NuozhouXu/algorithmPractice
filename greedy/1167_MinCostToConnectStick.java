class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int stick: sticks) minQueue.offer(stick);
        int cost = 0;
        while (minQueue.size() > 1) {
            int first = minQueue.poll();
            int second = minQueue.poll();
            cost += (first + second);
            minQueue.offer(first + second);
        }
        return cost;
    }
}