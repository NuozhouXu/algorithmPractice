class Solution {
    // O(nlogn) time O(n) space
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], -b[2]}); //start point
            heights.add(new int[]{b[1], b[2]}); //end point
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight = 0;
        List<List<Integer>> skyLine = new ArrayList<>();
        
        for (int[] h: heights) {
            if (h[1] < 0) {
                // start point
                heightMap.put(-h[1], heightMap.getOrDefault(-h[1], 0) + 1);
            } else {
                // end point
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(Arrays.asList(h[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
}