class Solution {
    // O(N) time
    public int numSub(String s) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
                count = (count + sum) % ((int)1e9 + 7);
            } else {
                sum = 0;
            }
        }
        return count;
    }
}