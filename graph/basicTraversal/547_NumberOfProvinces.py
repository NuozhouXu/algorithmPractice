class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = set()
        
        def dfs(city):
            for neighbor in range(n):
                if isConnected[city][neighbor] == 1 and neighbor not in visited:
                    visited.add(neighbor)
                    dfs(neighbor)
        
        provinces = 0
        for city in range(n):
            if city not in visited:
                visited.add(city)
                dfs(city)
                provinces += 1
        
        return provinces