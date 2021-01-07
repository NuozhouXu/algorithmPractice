class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log: logs) {
            String[] segments = log.split(":");
            int id = Integer.valueOf(segments[0]);
            String type = segments[1];
            int time = Integer.valueOf(segments[2]);
            
            if (type.equals("start")) {
                stack.push(new int[]{id, time, 0});
            } else {
                int[] node = stack.pop();
                ans[node[0]] += (time - node[1] - node[2] + 1);
                if (!stack.isEmpty()) {
                    stack.peek()[2] += (time - node[1] + 1);
                }
            }
        }
        return ans;
    }
}