class Solution {
    // O(nlogn) time
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < points.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] < points[i][0]) {
                stack.push(points[i]);
            } else {
                stack.peek()[0] = Math.max(stack.peek()[0], points[i][0]);
                stack.peek()[1] = Math.min(stack.peek()[1], points[i][1]);
            }
        }
        return stack.size();
    }

    // Sort by end 
    public int findMinArrowShotsGreedy(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int numArrows = 1;
        int currEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currEnd) {
                numArrows++;
                currEnd = points[i][1];
            }
        }
        return numArrows;
    }
}