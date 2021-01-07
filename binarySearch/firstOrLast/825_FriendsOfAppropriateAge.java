class Solution {
    // age[B] <= age[A] && age[B] > 0.5 * age[A] + 7
    // O(nlogn) time
    public int numFriendRequests(int[] ages) {
        int count = 0;
        Arrays.sort(ages);
        for (int i = ages.length - 1; i >= 0; i--) {
            if (ages[i] <= 14) break;
            int lowerBound = findLowerBound(0, i, ages, ages[i] / 2 + 8);
            int upperBound = findUpperBound(i, ages.length, ages, ages[i]);
            count += (upperBound - lowerBound);
        }
        return count;
    }
    
    private int findLowerBound(int l, int r, int[] ages, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            // Find lestmost >= target
            if (ages[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private int findUpperBound(int l, int r, int[] ages, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            // Find leftmost > target
            if (ages[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    // O(n) time
    public int numFriendRequestsOptimal(int[] ages) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int age: ages) count.put(age, count.getOrDefault(age, 0) + 1);
        for (int a: count.keySet()) {
            for (int b: count.keySet()) {
                if (b <= a && b > a * 0.5 + 7) {
                    ans += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return ans;
    }
}