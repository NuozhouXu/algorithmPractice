class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        # Build adjacency list with direction info
        # (neighbor, cost) where cost=1 means original direction (need to reverse), cost=0 means already pointing toward 0
        graph = defaultdict(list)
        for a, b in connections:
            graph[a].append((b, 1))  # a->b original, costs 1 to reverse
            graph[b].append((a, 0))  # b->a is reverse direction, costs 0
        
        # BFS from 0, count edges that need reversal
        visited = set([0])
        queue = deque([0])
        changes = 0
        
        while queue:
            node = queue.popleft()
            for neighbor, cost in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    changes += cost
                    queue.append(neighbor)
        
        return changes