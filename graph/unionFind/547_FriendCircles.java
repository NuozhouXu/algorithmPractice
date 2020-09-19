class DSU {
    int[] parent;
    int[] rank;
    int count;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
        count = size;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
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
        count--;
        return true;
    }
    
    public int getCount() {
        return count;
    }
}

// O(N^2) time
class Solution {
    public int findCircleNum(int[][] M) {
        DSU dsu = new DSU(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) dsu.union(i, j);
            }
        }
        return dsu.getCount();
    }
}