class Solution {
    // O(n) time O(k) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] results = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
			// remove the number outside of the window
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				results[ri++] = nums[q.peek()];
			}
		}
        
        return results;
    }
}