from typing import List
from collections import deque

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights or not heights[0]:
            return []

        m, n = len(heights), len(heights[0])

        def bfs(starts):
            reachable = set(starts)
            queue = deque(starts)

            while queue:
                r, c = queue.popleft()

                for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    nr, nc = r + dr, c + dc

                    if (
                        0 <= nr < m and
                        0 <= nc < n and
                        (nr, nc) not in reachable and
                        heights[nr][nc] >= heights[r][c]
                    ):
                        reachable.add((nr, nc))
                        queue.append((nr, nc))

            return reachable

        pacific_starts = []
        atlantic_starts = []

        for r in range(m):
            pacific_starts.append((r, 0))       # left edge
            atlantic_starts.append((r, n - 1)) # right edge

        for c in range(n):
            pacific_starts.append((0, c))       # top edge
            atlantic_starts.append((m - 1, c)) # bottom edge

        pacific_reachable = bfs(pacific_starts)
        atlantic_reachable = bfs(atlantic_starts)

        return list(pacific_reachable.intersection(atlantic_reachable))
        