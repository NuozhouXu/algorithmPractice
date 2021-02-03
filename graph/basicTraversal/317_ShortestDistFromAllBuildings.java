class Solution {
    
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numBuildings = 0;
        int[][] dist = new int[m][n];
        int[][] numReachableBuildings = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                    bfs(grid, dist, numReachableBuildings, i, j);
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && numReachableBuildings[i][j] == numBuildings) {
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private void bfs(int[][] grid, int[][] dist, int[][] numReachableBuildings, int startRow, int startCol) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                dist[row][col] += d;
                for (int[] dir: dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                       grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        numReachableBuildings[newRow][newCol]++;
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            d++;
        }
    }
}