class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int candy: candies) uniqueCandies.add(candy);
        return Math.min(candies.length / 2, uniqueCandies.size());
    }
}