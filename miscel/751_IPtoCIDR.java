class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long x = 0;
		String[] ips = ip.split("\\.");
		for (int i = 0; i < ips.length; ++i) {
			x = x * 256 + Long.parseLong(ips[i]);
		}
        
        List<String> results = new ArrayList<>();
        while (n > 0) {
            if (x == 0) {
                results.add("0.0.0.0/32");
                n--;
                x++;
                continue;
            }
            long count = x & -x;
            while (count > n) {
                count >>= 1;
            }
            results.add(oneCIDR(x, count));
            x += count;
            n -= (int) count;
        }
        return results;
    }
    
    private String oneCIDR(long x, long cnt) {
        long d = x & 255;
        long c = (x >> 8) & 255;
        long b = (x >> 16) & 255;
        long a = (x >> 24) & 255;
        int len = 0;
        while (cnt > 0) {
            len++;
            cnt >>= 1;
        }
        int common = 32 - (len - 1);
        return a + "." + b + "." + c + "." + d + "/" + common;
    }
}