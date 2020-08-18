class Solution {
    public int[][] highFive(int[][] items) {
        if (items.length == 0) return new int[0][0];
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int currId = 0;
        int currSum = 0;
        int currCount = 0;
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int score = items[i][1];
            if (currId == 0) {
                currId = id;
            }
            if (id != currId) {
                results.add(Arrays.asList(currId, currSum / 5));
                currId = id;
                currSum = 0;
                currCount = 0;
            }
            if (currCount < 5) currSum += score;
            currCount++;
        }
        results.add(Arrays.asList(currId, currSum / 5));
        int[][] output = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            output[i][0] = results.get(i).get(0);
            output[i][1] = results.get(i).get(1);
        }
        return output;
    }
}