/**
 * Pair class to store key-value pairs
 */
// class Pair {
//     /**
//      * @param {number} key The key to be stored in the pair
//      * @param {string} value The value to be stored in the pair
//      */
//     constructor(key, value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    /**
     * @param {Pair[]} pairs
     * @returns {Pair[][]}
     */
    insertionSort(pairs) {
        const result = [];
        const n = pairs.length;

        if (n === 0) return result;

        result.push([...pairs]);

        for (let i = 1; i < n; i++) {
            let currentPair = pairs[i];
            let j = i - 1;

            while (j >= 0 && pairs[j].key > currentPair.key) {
                pairs[j + 1] = pairs[j];
                j--;
            }

            pairs[j + 1] = currentPair;

            result.push([...pairs]);
        }

        return result;
    }
}
