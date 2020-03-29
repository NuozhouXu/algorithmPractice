class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Construct the prerequisites graph
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courseGraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        // Records whether we have checked the path starting with the current course.
        boolean[] checked = new boolean[numCourses];
        // Records the current path we are checking. Courses are marked as true if they are on the path under investigation.
        boolean[] path = new boolean[numCourses];
        
        for (int course = 0; course < numCourses; course++) {
            // If we find a cycle in the directed graph, exit immediately.
            if (hasCycle(courseGraph, course, checked, path)) return false;
        }
        return true;
    }
    
    private boolean hasCycle(HashMap<Integer, List<Integer>> courseGraph, Integer course, boolean[] checked, boolean[] path) {
        // If we have checked the path starting with this course, and didn't find a cycle, we don't need to look into that path again. 
        if (checked[course]) return false;
        // If the course is already on the path under investigation, we have found a cycle.
        if (path[course]) return true;
        
        // Mark the current course as part of the path under investigation.
        path[course] = true;
        for (Integer neighbor: courseGraph.get(course)) {
            if (hasCycle(courseGraph, neighbor, checked, path)) return true;
        }
        // remove the course from the path under investigation
        path[course] = false;
        // Mark the current course as checked
        checked[course] = true;
        // We didn't find a cycle starting with the current course
        return false;
    }
}