class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int currLevel = -1;
        List<Integer> friendList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                temp.add(person);
                for (int neighbor: friends[person]) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            friendList = temp;
            currLevel++;
            if (currLevel == level) break;
        }
        Map<String, Integer> count = new HashMap<>();
        for (int person: friendList) {
            for (String video: watchedVideos.get(person)) {
                count.put(video, count.getOrDefault(video, 0) + 1);
            }
        }
        List<String> results = new ArrayList<>(count.keySet());
        Collections.sort(results, (a, b) -> {
            if (count.get(a) == count.get(b)) {
                return a.compareTo(b);
            } else {
                return count.get(a) - count.get(b);
            }
        });
        return results;
    }
}