class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        bank_dict = set(bank)
        if endGene not in bank_dict:
            return -1
        
        queue = deque([startGene])
        visited = {startGene}
        steps = 0
        while queue:
            queue_size = len(queue)
            for _ in range(queue_size):
                curr = queue.popleft()
                if curr == endGene:
                    return steps
                for i in range(len(curr)):
                    for c in ['A', 'C', 'G', 'T']:
                        if curr[i] != c:
                            next = curr[:i] + c + curr[i + 1:]
                            if next in bank_dict and next not in visited:
                                queue.append(next)
                                visited.add(next)
            steps += 1
        return -1
