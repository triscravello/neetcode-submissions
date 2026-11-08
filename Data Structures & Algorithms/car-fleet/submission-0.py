class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), key=lambda x: x[0], reverse=True) # Sort cars by position in descending order
        stack = []
        for position, speed in cars:
            stack.append((target - position) / speed)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
        return len(stack)