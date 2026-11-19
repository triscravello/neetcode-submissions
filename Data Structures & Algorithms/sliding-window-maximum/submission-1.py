class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        if not nums or k == 0:
            return []

        result = []
        dq = deque()  # Stores indices of elements in decreasing order of value

        for i, num in enumerate(nums):
            # 1. Remove the front index if it is outside the current window [i - k + 1, i]
            if dq and dq[0] <= i - k:
                dq.popleft()

            # 2. Remove indices from the back whose values are smaller than current num
            while dq and nums[dq[-1]] < num:
                dq.pop()

            # 3. Push current index
            dq.append(i)

            # 4. Append the current window's maximum once the first k elements are processed
            if i >= k - 1:
                result.append(nums[dq[0]])

        return result