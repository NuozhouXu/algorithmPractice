class FenwickTree {
    public int[] values;
    public FenwickTree(int size) {
        this.values = new int[size + 1];
    }
    
    public void update(int index, int value) {
        for (int i = index + 1; i < values.length; i += (i & (-i)) ) {
            values[i] += value;
        }
    }
    
    public int query(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= (i & (-i))) {
            sum += values[i];
        }
        return sum;
    }
}

class Solution {
    public int reversePairs(int[] nums) {
        Map<Long, Integer> ranks = new HashMap<>();
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add((long)nums[i]);
            set.add(((long)nums[i]) * 2);
        }
        int rank = 0;
        for (long num: set) {
            ranks.put(num, rank++);
        }

        int ans = 0;
        FenwickTree fenwickTree = new FenwickTree(ranks.size());
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += fenwickTree.query(ranks.get((long)nums[i]) - 1);
            fenwickTree.update(ranks.get(((long)nums[i]) * 2), 1);
        }
        return ans;
    }
}