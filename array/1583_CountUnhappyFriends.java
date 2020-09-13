class Solution {
    // O(n^2) time
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] preferenceMap = new int[n][n];
        int[] pairMap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                preferenceMap[i][preferences[i][j]] = j;
            }
        }
        for (int[] pair: pairs) {
            pairMap[pair[0]] = pair[1];
            pairMap[pair[1]] = pair[0];
        }
        
        int count = 0;
        for (int[] pair: pairs) {
            int person1 = pair[0];
            int person2 = pair[1];
            // for person1, iterate all the persons with higher preference than person2
            for (int i = 0; i < preferenceMap[person1][person2]; i++) {
                int other = preferences[person1][i];
                if (preferenceMap[other][person1] < preferenceMap[other][pairMap[other]]) {
                    count++;
                    break;
                }
            }
            for (int i = 0; i < preferenceMap[person2][person1]; i++) {
                int other = preferences[person2][i];
                if (preferenceMap[other][person2] < preferenceMap[other][pairMap[other]]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}