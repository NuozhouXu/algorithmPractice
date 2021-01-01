class Solution {
    // O(N) time O(N) space
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece: pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) return false;
            int[] piece = map.get(arr[i]);
            for (int j = 0; j < piece.length; j++) {
                if (piece[j] != arr[i]) return false;
                i++;
            }
        }
        return true;
    }
}