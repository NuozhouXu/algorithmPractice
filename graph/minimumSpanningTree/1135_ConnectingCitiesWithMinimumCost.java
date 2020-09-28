class DSU {
    private int[] parent;
    private int[] rank;
    private int count;
    
    public DSU(int size) {
        this.parent = new int[size + 1];
        for (int i = 1; i <= size; i++) parent[i] = i;
        this.rank = new int[size + 1];
        this.count = size;
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
        count--;
        return true;
    }
    
    public int getCount() {
        return count;
    }
}

class Solution {
    // Kruskal's algorithm O(ElogE)
    public int minimumCost(int N, int[][] connections) {
        int minCost = 0;
        DSU dsu = new DSU(N);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for (int[] connection: connections) {
            if (dsu.union(connection[0], connection[1])) {
                minCost += connection[2];
            }
        }
        return dsu.getCount() == 1 ? minCost : -1;
    }
}