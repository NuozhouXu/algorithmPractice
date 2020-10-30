class Solution {
    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int l = 0;
        int r = 1000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canReach(heights, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean canReach(int[][] heights, int limit) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            if (row == heights.length - 1 && col == heights[0].length - 1) return true;
            for (int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && !visited[newRow][newCol]) {
                    int diff = Math.abs(heights[newRow][newCol] - heights[row][col]);
                    if (diff <= limit) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return false;
    }
}