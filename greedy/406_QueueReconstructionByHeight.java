class Solution {
    // O(n^2) time
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> output = new LinkedList<>();
        for (int[] p: people) {
            output.add(p[1], p); // LinkedList insert for java is O(n) because we have to get to the pointer by iterating from start first
        }
        return output.toArray(new int[people.length][2]);
    }
}