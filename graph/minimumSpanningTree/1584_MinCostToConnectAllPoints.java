class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
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
        return true;
    }
}

class Solution {
    // O(ElogE) or O(ElogV) they are equivalent. https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.offer(new int[]{i, j, w});
            }
        }
        int minCost = 0;
        DSU dsu = new DSU(n);
        while (!edges.isEmpty()) {
            int[] edge = edges.poll();
            if (dsu.union(edge[0], edge[1])) {
                minCost += edge[2];
            }
        }
        return minCost;
    }
}