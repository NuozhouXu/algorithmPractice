class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # A valid tree with n nodes must have exactly n - 1 edges
        if len(edges) != n - 1:
            return False

        graph = defaultdict(list)

        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        visited = set()

        def dfs(node: int, parent: int) -> bool:
            visited.add(node)

            for neighbor in graph[node]:
                if neighbor == parent:
                    continue

                # Found a cycle
                if neighbor in visited:
                    return False

                if not dfs(neighbor, node):
                    return False

            return True

        # Start DFS from node 0
        if not dfs(0, -1):
            return False

        # All nodes must be connected
        return len(visited) == n