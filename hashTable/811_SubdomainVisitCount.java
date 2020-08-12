class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] pair = cpdomain.split(" ");
            int num = Integer.valueOf(pair[0]);
            String domain = pair[1];
            count.put(domain, count.getOrDefault(domain, 0) + num);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    count.put(subdomain, count.getOrDefault(subdomain, 0) + num);
                }
            }
        }
        for (String key: count.keySet()) {
            int num = count.get(key);
            StringBuilder sb = new StringBuilder();
            sb.append(num).append(" ").append(key);
            results.add(sb.toString());
        }
        return results;
    }
}