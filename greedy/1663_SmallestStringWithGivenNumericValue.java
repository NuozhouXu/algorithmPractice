class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(k - i, 26);
            result[i] = (char) (add + 'a' - 1);
            k -= add;
        }
        return new String(result);
    }
}