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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) return new ArrayList<>();
        int n = accounts.size();
        DSU dsu = new DSU(n);
        
        Map<String, Integer> emailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToIndex.containsKey(email)) {
                    int index = emailToIndex.get(email);
                    dsu.union(index, i);
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }
        
        Map<Integer, Set<String>> indexToEmailList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parentIndex = dsu.find(i);
            indexToEmailList.putIfAbsent(parentIndex, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                indexToEmailList.get(parentIndex).add(accounts.get(i).get(j));
            }
        }
        
        List<List<String>> results = new ArrayList<>();
        for (int index: indexToEmailList.keySet()) {
            List<String> curList = new ArrayList<>();
            if (indexToEmailList.containsKey(index)) {
                curList.addAll(indexToEmailList.get(index));
            }
            Collections.sort(curList);
            curList.add(0, accounts.get(index).get(0));
            results.add(curList);
        }
        return results;
    }
}