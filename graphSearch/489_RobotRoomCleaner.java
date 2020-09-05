/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        cleanRoomHelper(robot, 0, 0, 0, new HashSet<>());   
    }
    
    private void cleanRoomHelper(Robot robot, int x, int y, int currDir, Set<String> visited) {
        robot.clean();
        for (int newDir = currDir; newDir < currDir + 4; newDir++) {
            int newX = directions[newDir % 4][0] + x;
            int newY = directions[newDir % 4][1] + y;
            if (!visited.contains(newX + " " + newY) && robot.move()) {
                visited.add(newX + " " + newY);
                cleanRoomHelper(robot, newX, newY, newDir, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}