class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
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
        return true;
    }
}

class Solution {
    // O(n^2) time
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU dsu = new DSU(n);
        for (int i = 1; i <= n; i++) {
            for (int j = i * 2; j <= n; j+=i) {
                if (i > threshold) {
                    dsu.union(i, j);
                }
            }
        }
        List<Boolean> results = new ArrayList<>();
        for (int[] query: queries) {
            results.add(dsu.find(query[0]) == dsu.find(query[1]));
        }
        return results;
    }
}