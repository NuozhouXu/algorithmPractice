class Solution {
    // O(NLogN) time O(N) space
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip: trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        int currCapacity = 0;
        for (int change: map.values()) {
            currCapacity += change;
            if (currCapacity > capacity) return false;
        }
        return true;
    }
}