class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            if len(stack) == 0:
                stack.append(asteroid)
            else:
                if asteroid < 0:
                    asteroid_destroyed = False
                    while len(stack) > 0 and stack[-1] > 0:
                        if abs(stack[-1]) > abs(asteroid):
                            asteroid_destroyed = True
                            break
                        elif abs(stack[-1]) < abs(asteroid):
                            stack.pop()
                        else:
                            stack.pop()
                            asteroid_destroyed = True
                            break
                    if not asteroid_destroyed:
                        stack.append(asteroid)
                else:
                    stack.append(asteroid)
        return stack