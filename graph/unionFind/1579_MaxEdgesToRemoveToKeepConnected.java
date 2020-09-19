class DSU {
    int[] parent;
    int[] rank;
    int count;

    public DSU(int size) {
        parent = new int[size + 1];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size + 1];
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

class Solution {
    // O(E) E is num of edges
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        int numEdgesAdded = 0;
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        
        for (int[] edge: edges) {
            int type = edge[0];
            if (type == 3) {
                if (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2])) {
                    numEdgesAdded++;
                }
            } else if (type == 2) {
                if (bob.union(edge[1], edge[2])) {
                    numEdgesAdded++;
                }
            } else if (type == 1) {
                if (alice.union(edge[1], edge[2])) {
                    numEdgesAdded++;
                }
            }
        }
        
        return (alice.getCount() == 1 && bob.getCount() == 1) ? edges.length - numEdgesAdded : -1;
    }
}