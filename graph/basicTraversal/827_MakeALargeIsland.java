class Solution {
    private static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    // O(mn) time
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int index = 2;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, index);
                    sizeMap.put(index, size);
                    index++;
                    ans = Math.max(ans, size);
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int size = 1;
                    for (int[] dir: dirs) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (isValid(grid, newRow, newCol) && grid[newRow][newCol] > 1 && !seen.contains(grid[newRow][newCol])) {
                            size += sizeMap.get(grid[newRow][newCol]);
                            seen.add(grid[newRow][newCol]);
                        }
                    }
                    ans = Math.max(ans, size);
                }
            }
        }
        return ans;
    }
    
    private int dfs(int[][] grid, int row, int col, int index) {
        int area = 1;
        grid[row][col] = index;
        for (int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
                area += dfs(grid, newRow, newCol, index);
            }
        }
        return area;
    }
    
    private boolean isValid(int[][] grid, int newRow, int newCol) {
        return newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length;
    }
}