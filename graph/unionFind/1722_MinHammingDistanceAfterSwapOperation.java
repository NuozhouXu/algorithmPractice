class DSU {
    private int[] parent;
    private int[] rank;
    
    public DSU(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        this.rank = new int[n];
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
        return true;
    }
}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] swap: allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int groupId = dsu.find(i);
            groups.putIfAbsent(groupId, new HashSet<>());
            groups.get(groupId).add(i);
        }
        int minDist = 0;
        for (int groupId: groups.keySet()) {
            Set<Integer> group = groups.get(groupId);
            minDist += calculateMinHammingDist(source, target, group);
        }
        return minDist;
    }
    
    private int calculateMinHammingDist(int[] source, int[] target, Set<Integer> group) {
        int dist = 0;
        Map<Integer, Integer> sourceCount = new HashMap<>();
        for (int index: group) {
            sourceCount.put(source[index], sourceCount.getOrDefault(source[index], 0) + 1);
        }
        for (int index: group) {
            int val = target[index];
            if (sourceCount.containsKey(val)) {
                sourceCount.put(val, sourceCount.get(val) - 1);
                if (sourceCount.get(val) == 0) {
                    sourceCount.remove(val);
                }
            } else {
                dist++;
            }
        }
        return dist;
    }
}