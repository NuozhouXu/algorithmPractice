class Solution {
    // O(N) time O(N) space
    public int[] findPermutation(String s) {
        int[] output = new int[s.length() + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i = 1; i <= s.length(); i++) {
            stack.push(i);
            if (s.charAt(i - 1) == 'I') {
                while (!stack.isEmpty()) {
                    output[index++] = stack.pop();
                }
            }
        }
        stack.push(s.length() + 1);
        while (!stack.isEmpty()) {
            output[index++] = stack.pop();
        }
        return output;
    }

    public int[] findPermutationNoSpace(String s) {
        int n = s.length() + 1;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) output[i] = i + 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int l = i;
                while (i < s.length() && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(output, l, i);
            }
        }
        return output;
    }
    
    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}