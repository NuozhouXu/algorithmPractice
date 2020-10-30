class Solution {
    // O(nlogn) time
    public int[] arrayRankTransform(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        for (int num: arr) lst.add(num);
        Collections.sort(lst);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lst.size(); i++) {
            map.putIfAbsent(lst.get(i), map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}