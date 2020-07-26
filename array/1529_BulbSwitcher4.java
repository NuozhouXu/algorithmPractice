class Solution {
    public int minFlips(String target) {
        int count = 0;
        int n = target.length();
        char curr = '1';
        for (int i = 0; i < n; i++) {
            if (target.charAt(i) == curr) {
                curr = (curr == '1' ? '0' : '1');
                count++;
            }
        }
        return count;
    }
}