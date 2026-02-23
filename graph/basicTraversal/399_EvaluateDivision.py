class Solution:
    def calcEquation(self, equations, values, queries):
        graph = defaultdict(dict)
        
        for (a, b), v in zip(equations, values):
            graph[a][b] = v
            graph[b][a] = 1/v
        
        def bfs(src, dst):
            if src not in graph or dst not in graph:
                return -1.0
            if src == dst:
                return 1.0
            visited = {src}
            queue = deque([(src, 1.0)])
            while queue:
                node, prod = queue.popleft()
                if node == dst:
                    return prod
                for nei, val in graph[node].items():
                    if nei not in visited:
                        visited.add(nei)
                        queue.append((nei, prod * val))
            return -1.0
        
        return [bfs(c, d) for c, d in queries]