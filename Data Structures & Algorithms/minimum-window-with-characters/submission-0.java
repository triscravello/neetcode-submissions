class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // ASCII size 128 handles both uppercase and lowercase letters
        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) {
            targetCounts[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length(); // Total characters needed from t
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If this character is still needed for t, decrement required
            if (targetCounts[rightChar] > 0) {
                required--;
            }
            targetCounts[rightChar]--;
            right++;

            // Once all characters from t are in the window, shrink from the left
            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                targetCounts[leftChar]++;
                
                // If incrementing makes the count > 0, we just lost a required character
                if (targetCounts[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
