class Solution {
    // O(n) time O(1) space
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int rest = 0;
        
        for (int price: prices) {
            int prevSold = sold;
            
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prevSold);
        }
        
        return Math.max(sold, rest);
    }
}