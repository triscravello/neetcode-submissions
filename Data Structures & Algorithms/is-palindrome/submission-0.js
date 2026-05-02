class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isPalindrome(s) {
        const alphanumeric = s.replace(/[^a-z0-9]/gi, '').toLowerCase();

        const reversed = alphanumeric.split('').reverse().join('');
        return alphanumeric === reversed;
    }
}
