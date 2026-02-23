class SmallestInfiniteSet:

    def __init__(self):
        # The smallest integer that hasn't been popped from the infinite sequence
        self.current = 1
        # Min heap to store numbers that were popped and added back
        self.added_back = []
        # Set to track what's in the heap (for O(1) lookup)
        self.added_back_set = set()

    def popSmallest(self) -> int:
        # If we have any numbers that were added back, return the smallest one
        if self.added_back:
            smallest = heapq.heappop(self.added_back)
            self.added_back_set.remove(smallest)
            return smallest
        
        # Otherwise, return the current smallest from the infinite sequence
        smallest = self.current
        self.current += 1
        return smallest

    def addBack(self, num: int) -> None:
        # Only add back if:
        # 1. It's less than current (meaning it was already popped)
        # 2. It's not already in our added_back set
        if num < self.current and num not in self.added_back_set:
            heapq.heappush(self.added_back, num)
            self.added_back_set.add(num)

# Time Complexity:

# __init__: O(1)
# popSmallest: O(log n) where n is the size of the heap
# addBack: O(log n) for heap insertion


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)