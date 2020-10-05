class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> results = new ArrayList<>();
        Map<String, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String[] str = keyTime[i].split(":");
            int hour = Integer.valueOf(str[0]);
            int minutes = Integer.valueOf(str[1]);
            int numMinutes = hour * 60 + minutes;
            groups.putIfAbsent(name, new ArrayList<>());
            groups.get(name).add(numMinutes);
        }
        for (String name: groups.keySet()) {
            Collections.sort(groups.get(name));
            Deque<Integer> queue = new ArrayDeque<>();
            for (int numMinutes: groups.get(name)) {
                queue.offer(numMinutes);
                while (!queue.isEmpty() && (numMinutes - queue.peek()) > 60) {
                    queue.poll();
                }
                if (queue.size() >= 3) {
                    results.add(name);
                    break;
                }
            }
        }
        Collections.sort(results);
        return results;
    }
}