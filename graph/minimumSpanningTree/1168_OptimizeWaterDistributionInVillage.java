class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int size) {
        this.parent = new int[size + 1];
        for (int i = 0; i <= size; i++) parent[i] = i;
        this.rank = new int[size + 1];
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
        return true;
    }
}

class Solution {
    // O(ElogE)
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int minCost = 0;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < wells.length; i++) {
            edges.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] pipe: pipes) {
            edges.add(pipe);
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        DSU dsu = new DSU(n);
        for (int[] edge: edges) {
            int house1 = edge[0], house2 = edge[1], cost = edge[2];
            if (dsu.union(house1, house2)) {
                minCost += cost;
            }
        }
        return minCost;
    }
}