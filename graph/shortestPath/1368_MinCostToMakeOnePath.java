class Solution {
    // O(mn * log(mn))
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        dist[0][0] = 0;
        minQueue.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
        while (!minQueue.isEmpty()) {
            int[] node = minQueue.poll();
            int row = node[1];
            int col = node[2];
            visited[row][col] = true;
            
            for (int i = 1; i <= 4; i++) {
                int cost = grid[row][col] == i ? 0 : 1;
                int newRow = row + dirs[i - 1][0];
                int newCol = col + dirs[i - 1][1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && dist[newRow][newCol] > dist[row][col] + cost && !visited[newRow][newCol]) {
                    dist[newRow][newCol] = dist[row][col] + cost;
                    minQueue.offer(new int[]{dist[newRow][newCol], newRow, newCol});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}