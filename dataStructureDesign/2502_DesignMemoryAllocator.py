class AllocatorBruteForce:

    def __init__(self, n: int):
        self.memory = [0] * n
        self.n = n

    def allocate(self, size: int, mID: int) -> int:
        num_consecutive = 0
        start_index = -1
        for i in range(self.n):
            if self.memory[i] == 0:
                if num_consecutive == 0:
                    start_index = i
                num_consecutive += 1
                if num_consecutive == size:
                    for j in range(start_index, start_index + num_consecutive):
                        self.memory[j] = mID
                    return start_index
            else:
                num_consecutive = 0
                start_index = -1

        return -1
        

    def freeMemory(self, mID: int) -> int:
        num_freed = 0
        for i in range(self.n):
            if self.memory[i] == mID:
                self.memory[i] = 0
                num_freed += 1
        return num_freed
        


# Your Allocator object will be instantiated and called as such:
# obj = Allocator(n)
# param_1 = obj.allocate(size,mID)
# param_2 = obj.freeMemory(mID)