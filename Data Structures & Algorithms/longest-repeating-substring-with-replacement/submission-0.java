class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxCount = 0;
        int[] charCount = new int[26];
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'A']++;

            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
