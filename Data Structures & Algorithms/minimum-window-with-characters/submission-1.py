from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""

        target_counts = Counter(t)
        required = len(t)
        left = 0
        min_len = float("inf")
        min_start = 0

        for right, char in enumerate(s):
            # If we still need this character for t, reduce required count
            if target_counts[char] > 0:
                required -= 1
            target_counts[char] -= 1

            # Once all characters from t are in the window, shrink from the left
            while required == 0:
                window_len = right - left + 1
                if window_len < min_len:
                    min_len = window_len
                    min_start = left

                left_char = s[left]
                target_counts[left_char] += 1
                
                # If count goes above 0, we just removed a necessary character
                if target_counts[left_char] > 0:
                    required += 1
                left += 1

        return "" if min_len == float("inf") else s[min_start : min_start + min_len]