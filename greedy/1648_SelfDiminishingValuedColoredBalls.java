class Solution {
    
    private static long mod = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        long ans = 0;
        int n = inventory.length;
        Arrays.sort(inventory);
        reverse(inventory);
        int i = 0;
        long curr = inventory[i];
        while (orders > 0) {
            while (i < n && inventory[i] == curr) i++;
            long next = i == n ? 0 : inventory[i];
            long count = Math.min(orders, i * (curr - next));
            long t = curr - next;
            long r = 0;
            if (orders < i * (curr - next)) {
                t = orders / i;
                r = orders % i;
            }
            long nextP = curr - t;
            ans = (ans + (curr + nextP + 1) * t / 2 * i + nextP * r) % mod;
            orders -= count;
            curr = next;
        }
        return (int) ans;
    }
    
    private void reverse(int[] arr) {
        int l = 0; 
        int r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}