class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (ages[a] == ages[b]) {
                return scores[b] - scores[a];
            } else {
                return ages[b] - ages[a];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }
        int[] sortedScores = new int[n];
        int index = 0;
        while (!pq.isEmpty()) {
            int i = pq.poll();
            sortedScores[index++] = scores[i];
        }
        dp[0] = sortedScores[0];
        int maxScore = sortedScores[0];
        for (int i = 1; i < n; i++) {
            dp[i] = sortedScores[i];
            for (int j = 0; j < i; j++) {
                if (sortedScores[i] <= sortedScores[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + sortedScores[i]);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }
        return maxScore;
    }
}