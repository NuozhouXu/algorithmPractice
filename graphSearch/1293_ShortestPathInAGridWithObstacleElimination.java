class Solution {
    // O(mnk) time and space
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int len = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                int K = node[2];
                if (row == m - 1 && col == n - 1) return len;
                for (int[] dir: dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    int newK = K;
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        if (grid[newRow][newCol] == 1) {
                            newK++;
                        }
                        if (newK <= k && !visited[newRow][newCol][newK]) {
                            visited[newRow][newCol][newK] = true;
                            queue.offer(new int[]{newRow, newCol, newK});
                        }
                    }
                }
            }
            len++;
        }
        return -1;
    }
}