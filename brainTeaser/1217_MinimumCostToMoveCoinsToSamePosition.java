class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 1) {
                oddSum++;
            } else {
                evenSum++;
            }
        }
        return Math.min(oddSum, evenSum);
    }
}