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
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long)nums[i];
        }
        Set<Long> set = new HashSet<>();
        for (long num: prefixSum) {
            set.add(num);
            set.add(num - (long)lower);
            set.add(num - (long)upper - 1);
        }
        List<Long> sortedNums = new ArrayList<>(set);
        Collections.sort(sortedNums);
        Map<Long, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (long num: sortedNums) {
            if (!ranks.containsKey(num)) {
                ranks.put(num, rank++);
            }
        }
        int count = 0;
        FenwickTree bit = new FenwickTree(ranks.size());
        for (long num: prefixSum) {
            count += bit.query(ranks.get(num - (long)lower)) - bit.query(ranks.get(num - (long)upper - 1));
            bit.update(ranks.get(num), 1);
        }
        return count;
    }
}