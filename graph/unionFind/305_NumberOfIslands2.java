class DSU {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public DSU(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = -1;
        }
        this.rank = new int[size];
        this.count = 0;
    }
    
    public void addLand(int x) {
        if (parent[x] == -1) {
            parent[x] = x;
            count++;   
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        this.count--;
        return true;
    }
    
    public int getCount() {
        return count;
    }
}

class Solution {
    // O(m * n + k) where k is the number of positions.
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> results = new ArrayList<>();
        int[][] matrix = new int[m][n];
        DSU dsu = new DSU(m * n);
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] position: positions) {
            int row = position[0];
            int col = position[1];
            matrix[row][col] = 1;
            int index = calculateIndex(row, col, n);
            dsu.addLand(index);
            for (int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] == 1) {
                    dsu.union(index, calculateIndex(newRow, newCol, n));
                }
            }
            results.add(dsu.getCount());
        }
        return results;
    }
    
    private int calculateIndex(int row, int col, int n) {
        return row * n + col;
    }
}