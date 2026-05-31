class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        const countMap = new Map();

        const buckets = Array.from({ length: nums.length + 1}, () => []);
        const result = [];

        for (const num of nums) {
            countMap.set(num, (countMap.get(num) || 0) + 1);
        }

        for (const [num, freq] of countMap.entries()) {
            buckets[freq].push(num);
        }

        for (let i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i].length > 0) {
                for (const num of buckets[i]) {
                    result.push(num);
                    if (result.length === k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
