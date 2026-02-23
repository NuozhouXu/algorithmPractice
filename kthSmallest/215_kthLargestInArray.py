class Solution:
    # Time Complexity: O(n log k)
    # Space Complexity: O(k)
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # Maintain a min heap of size k
        heap = []
        
        for num in nums:
            heapq.heappush(heap, num)
            if len(heap) > k:
                heapq.heappop(heap)
        
        return heap[0]  # smallest in heap = kth largest overall