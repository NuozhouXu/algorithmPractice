class Solution {
    public int maxLength(List<String> arr) {
        boolean[] charSet = new boolean[26];
        int[] ans = new int[1];
        backtrack(arr, charSet, ans, 0, 0);
        return ans[0];
    }
    
    private void backtrack(List<String> arr, boolean[] charSet, int[] ans, int index, int currLen) {
        if (index == arr.size()) {
            ans[0] = Math.max(ans[0], currLen);
            return;
        }
        // not take
        backtrack(arr, charSet, ans, index + 1, currLen);
        
        // take
        String word = arr.get(index);
        boolean[] copyCharSet = Arrays.copyOf(charSet, 26);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (copyCharSet[c - 'a']) {
                ans[0] = Math.max(ans[0], currLen);
                return;
            }
            copyCharSet[c - 'a'] = true;
        }
        backtrack(arr, copyCharSet, ans, index + 1, currLen + word.length());
    }
}