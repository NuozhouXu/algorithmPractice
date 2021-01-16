class Solution {
    // O(nlogn) time O(n) space
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int person: people) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        int ans = 0;
        while (map.size() > 0) {
            Integer weight2 = map.lastKey();
            decrement(map, weight2);
            ans++;
            Integer weight1 = map.floorKey(limit - weight2);
            if (weight1 != null) {
                decrement(map, weight1);
            }
        }
        return ans;
    }
    
    private void decrement(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) map.remove(key);
    }

    // O(nlogn) time O(1) space
    public int numRescueBoatsOptimal(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) i++;
            j--;
        }

        return ans;
    }
}