class Solution {
    // O(n) time O(1) space
    public int countVowelStrings(int n) {
        int[] count = new int[5];
        Arrays.fill(count, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 4; j++) {
                count[j] = count[j - 1] + count[j];
            }
        }
        int sum = 0;
        for (int num: count) sum += num;
        return sum;
    }

    
}