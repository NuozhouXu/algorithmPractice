class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0; 
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> item = arrays.get(i);
            res = Math.max(res, Math.max(Math.abs(item.get(item.size() - 1) - minVal), Math.abs(maxVal - item.get(0))));
            minVal = Math.min(minVal, item.get(0));
            maxVal = Math.max(maxVal, item.get(item.size() - 1));
        }
        return res;
    }
}