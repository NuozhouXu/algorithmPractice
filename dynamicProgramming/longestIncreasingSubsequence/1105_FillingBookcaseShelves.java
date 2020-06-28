class Solution {
    // O(n^2) time O(n) space
    /*
    The key idea of this algorithm goes as follows

        Start placing books one by one, always use a new shelve to begin with
        After you stored the new height value at this position in your dp array, start looking back at previous books one by one, and see while the width permits, how many books you can fit on this new level.
        Check to see if bringing said books down reduced the overall height, if it did, update the new loest height value at your dp array.
        return the last element of your dp array

    */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= books.length; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            dp[i] = dp[i - 1] + height; // if put the new book on a new line
            for (int j = i - 1; j > 0; j--) {
                width += books[j-1][0];
                if (width > shelf_width) break;
                height = Math.max(height, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + height);
            }
        }
        return dp[books.length];
    }
}