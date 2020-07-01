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
    // https://www.youtube.com/watch?v=2SVLYsq5W8M&t=330s
    // O(nlogn) time O(n) space
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new LinkedList<>();
        
        Map<Integer, Integer> ranks = new HashMap<>();
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);
        int rank = 0;
        for (int i = 0; i < sortedNum.length; i++) {
            if (!ranks.containsKey(sortedNum[i])) {
                ranks.put(sortedNum[i], rank++);
            }
        }

        FenwickTree fenwickTree = new FenwickTree(ranks.size());
        List<Integer> res = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0, fenwickTree.query(ranks.get(nums[i]) - 1)); // Query the number of elements that has rank lower than the current
            fenwickTree.update(ranks.get(nums[i]), 1);
        }
        return res;
    }
}