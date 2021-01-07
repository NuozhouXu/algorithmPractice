class DSU {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        this.rank = new int[n];
        this.count = n;
    }
    
    // path compression
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    
    // union by rank
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
        count--;
        return true;
    }
    
    public int getCount() {
        return this.count;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.getCount();
    }
}