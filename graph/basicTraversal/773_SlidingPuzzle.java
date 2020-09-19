class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        int[][] directions = new int[][]{{ 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                if (state.equals(target)) {
                    return steps;
                }
                int index = state.indexOf('0');
                for (int dir: directions[index]) {
                    String nextState = swap(state, index, dir);
                    if (!visited.contains(nextState)) {
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}