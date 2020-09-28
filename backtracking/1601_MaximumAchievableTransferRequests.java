class Solution {
    int ans;

    // O(N * 2 ^ R) where N is number of buildings and R is number of requests.
    public int maximumRequests(int n, int[][] requests) {
        ans = 0;
        backtrack(requests, 0, new int[n], 0);
        return ans;
    }
    
    private void backtrack(int[][] requests, int index, int[] count, int currNum) {
        if (index == requests.length) {
            for (int i: count) {
                if (i != 0) return;
            }
            ans = Math.max(ans, currNum);
            return;
        }
        
        int[] request = requests[index];
        count[request[0]]--;
        count[request[1]]++;
        backtrack(requests, index + 1, count, currNum + 1);
        count[request[0]]++;
        count[request[1]]--;
        
        backtrack(requests, index + 1, count, currNum);
    }
}