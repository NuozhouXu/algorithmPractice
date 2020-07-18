class Solution {
    // O(n) time O(n) space
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for (int p: preorder) {
            if (p < low) return false;
            while (!stack.isEmpty() && p > stack.peek()) {
                low = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }
    
    public boolean verifyPreorderNoSpace(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int p: preorder) {
            if (p < low) return false;
            while (i >= 0 && p > preorder[i]) {
                low = preorder[i--];
            }
            preorder[++i] = p;
        }
        return true;
    }
}