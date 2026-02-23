class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        total_cost = 0
        l, r = 0, len(costs) - 1
        num_hired = 0
        front_heap, back_heap = [], []
        while num_hired < k:
            while len(front_heap) < candidates and l <= r:
                heapq.heappush(front_heap, costs[l])
                l += 1
            while len(back_heap) < candidates and l <= r:
                heapq.heappush(back_heap, costs[r])
                r -= 1
            f = front_heap[0] if front_heap else float('inf')
            b = back_heap[0] if back_heap else float('inf')

            if f <= b:
                total_cost += heapq.heappop(front_heap)
            else:
                total_cost += heapq.heappop(back_heap)
            num_hired += 1

        return total_cost