class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int minimum = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num % 2 == 0) {
                pq.offer(num);
                minimum = Math.min(minimum, num);
            } else {
                pq.offer(num * 2);
                minimum = Math.min(minimum, num * 2);
            }
        }
        int maximum = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            ans = Math.min(ans, curr - minimum);
            if (curr % 2 == 0) {
                pq.offer(curr / 2);
                minimum = Math.min(minimum, curr / 2);
            } else {
                break;
            }
        }
        return ans;
    }
}