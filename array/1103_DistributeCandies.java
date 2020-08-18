class Solution {
    // O(sqrt(candies))
    public int[] distributeCandies(int candies, int num_people) {
        int[] output = new int[num_people];
        int give = 0;
        while (candies > 0) {
            output[give % num_people] += Math.min(candies, give + 1);
            give++;
            candies -= give;
        }
        return output;
    }
}