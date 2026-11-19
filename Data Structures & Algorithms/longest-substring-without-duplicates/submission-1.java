class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        while (right < s.length()) {
            if (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            } else {
                charSet.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
