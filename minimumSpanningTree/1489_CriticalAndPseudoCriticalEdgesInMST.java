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
}

class Solution {
    // An edge is critical iff all MSTs without this edge will have larger costs than the min cost. An edge is pseudo-critical if no matter we use or do not use this edge, we can always find an MST with the min cost.
    // O(E^2) time because we need to construct 2E times MST, each time takes O(E)
    // There is a more optimized O(ElogE) solution here: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/discuss/698311/Python-UnionFind-%2B-Kruskal-solution-with-detail-explanation-from-O(E2)-to-O(ElogE)
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            map.put(edges[i], i);
        }
        
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);
        int minCost = buildMST(n, edges, null, null);
        
        for (int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);
            if (costWithout > minCost){
                criticals.add(index);
            } else {
                int costWith = buildMST(n, edges, edge, null);
                if (costWith == minCost) {
                    pseduos.add(index);
                }
            }
            
        }
        
        return Arrays.asList(criticals, pseduos);
    }
    
    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        DSU dsu = new DSU(n);
        int cost = 0;
        if (pick != null){
            dsu.union(pick[0], pick[1]);
            cost += pick[2];
        }
        
        for (int[] edge : edges){
            if (edge != skip && dsu.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return dsu.count == 1? cost : Integer.MAX_VALUE;
    }
}