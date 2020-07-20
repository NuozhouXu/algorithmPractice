class Solution {
    class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = s.charAt(i) - 'a';
        }
        
        int[] fst = new int[26];
        int[] lst = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            fst[vals[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            lst[vals[i]] = i;
        }
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int start = fst[i];
            int end = lst[i];
            for (int j = start; j <= end; j++) {
                start = Math.min(start, fst[vals[j]]);
                end = Math.max(end, lst[vals[j]]);
            }
            if (start < n && start == fst[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(start).append(",").append(end);
                set.add(sb.toString());
            }
        }
        
        List<Interval> substrs = new ArrayList<>();
        for (String str: set) {
            String[] a = str.split(",");
            substrs.add(new Interval(Integer.valueOf(a[0]), Integer.valueOf(a[1])));
        }
        
        substrs.sort((a, b) -> a.end - b.end);

        List<String> results = new ArrayList<>();
        int previousEnd = -1;
        for (Interval interval: substrs) {
            if (interval.start > previousEnd) {
                previousEnd = interval.end;
                results.add(s.substring(interval.start, interval.end + 1));
            }
        }
        return results;
    }
}