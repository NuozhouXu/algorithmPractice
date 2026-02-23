class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        # Create pairs and sort by nums2 in descending order
        pairs = [(n2, n1) for n1, n2 in zip(nums1, nums2)]
        pairs.sort(reverse=True)
        
        max_score = 0
        nums1_sum = 0
        min_heap = []
        
        for n2, n1 in pairs:
            # Add current nums1 value to our selection
            heapq.heappush(min_heap, n1)
            nums1_sum += n1
            
            # If we have more than k elements, remove the smallest nums1
            if len(min_heap) > k:
                nums1_sum -= heapq.heappop(min_heap)
            
            # When we have exactly k elements, calculate score
            # Current n2 is the minimum because we sorted in descending order
            if len(min_heap) == k:
                score = nums1_sum * n2
                max_score = max(max_score, score)
        
        return max_score