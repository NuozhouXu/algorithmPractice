class Solution {
    // O(n^3) time O(n^2) space
    public int mctFromLeafValuesDP(int[] arr) {
        int[][] memo = new int[arr.length][arr.length];
        return mctFromLeafValuesHelper(arr, 0, arr.length - 1, memo);
    }
    
    private int mctFromLeafValuesHelper(int[] arr, int l, int r, int[][] memo) {
        if (memo[l][r] > 0) return memo[l][r];
        if (l >= r) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = l; j <= i; j++) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }
            for (int j = i + 1; j <= r; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }
            int rootVal = maxLeft * maxRight;
            minCost = Math.min(minCost, rootVal + mctFromLeafValuesHelper(arr, l, i, memo) + mctFromLeafValuesHelper(arr, i + 1, r, memo));
        }
        memo[l][r] = minCost;
        return minCost;
    }

    // O(n) time O(n) space  ??
    // https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
    public int mctFromLeafValuesOptimal(int[] arr) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}