class Solution {
    // O(mn) time O(mn) space
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] curr, int[] destination) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: dirs) {
            int newRow = curr[0];
            int newCol = curr[1];
            while (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == 0) {
                newRow += dir[0];
                newCol += dir[1];
            }
            newRow -= dir[0];
            newCol -= dir[1];
            if (destination[0] == newRow && destination[1] == newCol) return true;
            if (!visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                boolean found = dfs(maze, visited, new int[]{newRow, newCol}, destination);
                if (found) return true;
            }
        }
        return false;
    }
}