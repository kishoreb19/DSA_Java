package graph.problems;
import java.util.*;

public class CourseSchedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegrees = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            for(int neighbor : adj.get(i)){
                inDegrees[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inDegrees[i] == 0) q.add(i);
        }

        ArrayList<Integer> tSort = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            tSort.add(node);

            for(int neighbor : adj.get(node)){
                inDegrees[neighbor]--;
                if(inDegrees[neighbor] == 0) q.add(neighbor);
            }
        }
        int ans[] = new int[tSort.size()];
        for(int i=0; i<tSort.size(); i++){
            ans[i] = tSort.get(i);
        }
        return tSort.size() == numCourses ? ans:new int[] {};
        //Time  Complexity - O(V+E) (or equivalently,O(numCourses+prerequisites.length))
        //Space Complexity - O(V+E)
    }
    //https://leetcode.com/problems/course-schedule-ii/
}
