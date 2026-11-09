class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return count.keySet().stream().sorted((a, b) -> count.get(b).compareTo(count.get(a))).limit(k).mapToInt(Integer::intValue).toArray();
    }
}
