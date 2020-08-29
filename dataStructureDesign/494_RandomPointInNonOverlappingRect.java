class Solution {
    private int[][] rects;
    private Random r;
    private TreeMap<Integer, Integer> map;
    private int area;

    public Solution(int[][] rects) {
        this.rects = rects;
        r = new Random();
        map = new TreeMap<>();
        area = 0;
        for (int i = 0; i < rects.length; i++) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(area, i);
        }
    }
    
    public int[] pick() {
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        int[] rect = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }
}