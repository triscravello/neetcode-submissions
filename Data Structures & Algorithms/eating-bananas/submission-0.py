class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        while left < right:
            mid = (left + right) // 2
            if self.canEatAll(piles, h, mid):
                right = mid
            else:
                left = mid + 1
        return left

    def canEatAll(self, piles: List[int], h: int, k: int) -> bool:
        hours = 0
        for pile in piles:
            hours += math.ceil(pile / k)
        return hours <= h