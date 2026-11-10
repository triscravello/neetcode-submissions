class TimeMap:
    def __init__(self):
        self.map = {}
        self.tree_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append((timestamp, value))
        if key not in self.tree_map:
            self.tree_map[key] = []
        self.tree_map[key].append((timestamp, value))
    
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map:
            return ""
        
        left, right = 0, len(self.map[key]) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if self.map[key][mid][0] == timestamp:
                return self.map[key][mid][1]
            if self.map[key][mid][0] < timestamp:
                left = mid + 1
            else:
                right = mid - 1
        
        return self.map[key][right][1] if right >= 0 else ""
        
