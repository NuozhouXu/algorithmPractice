class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (task1, task2) -> (task1[1] - task1[0]) - (task2[1] - task2[0]));
        
        int totalEffort = 0;
        
        for (int i = 0; i < tasks.length; i++) {
            totalEffort = Math.max(totalEffort + tasks[i][0], tasks[i][1]);
        }
        
        return totalEffort;
    }
}