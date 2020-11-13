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
    
    public int createSortedArray(int[] instructions) {
        int m = 100002;
        long cost = 0;
        long MOD = 1000000007;

        FenwickTree bit = new FenwickTree(m);
        for (int i = 0; i < instructions.length; i++) {
            int leftCost = bit.query(instructions[i] - 1);
            int rightCost = i - bit.query(instructions[i]);
            cost += Math.min(leftCost, rightCost);
            bit.update(instructions[i], 1);
        }
        return (int) (cost % MOD);
    }
}