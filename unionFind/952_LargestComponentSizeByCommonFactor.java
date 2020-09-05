class DSU {
    private int[] parent;
    private int[] rank;
    
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
    
    private Set<Integer> primeDecompose(int num) {
        Set<Integer> primeFactors = new HashSet<>();
        int factor = 2;

        while (num >= factor * factor) {
            if (num % factor == 0) {
                primeFactors.add(factor);
                num = num / factor;
            } else {
                factor++;
            }
        }
        primeFactors.add(num);
        return primeFactors;
    }
    
    public int largestComponentSize(int[] A) {
        int maxVal = Integer.MIN_VALUE;
        for (int i: A) maxVal = Math.max(maxVal, i);
        DSU dsu = new DSU(maxVal + 1);
        
        Map<Integer, List<Integer>> groupByPrimeFactor = new HashMap<>();
        
        for (int num: A) {
            Set<Integer> factors = primeDecompose(num);
            for (int factor: factors) {
                groupByPrimeFactor.putIfAbsent(factor, new ArrayList<>());
                groupByPrimeFactor.get(factor).add(num);
            }
        }
        
        for (int factor: groupByPrimeFactor.keySet()) {
            List<Integer> nums = groupByPrimeFactor.get(factor);
            for (int i = 0; i < nums.size() - 1; i++) {
                dsu.union(nums.get(i), nums.get(i + 1));
            }
        }
        
        int maxGroupSize = 0;
        Map<Integer, Integer> groupSize = new HashMap<>();
        for (int num: A) {
            int groupId = dsu.find(num);
            groupSize.put(groupId, groupSize.getOrDefault(groupId, 0) + 1);
            maxGroupSize = Math.max(maxGroupSize, groupSize.get(groupId));
        }
        return maxGroupSize;
    }
}