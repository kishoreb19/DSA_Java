package graph.problems;
import java.util.*;

public class CourseSchedule_I {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        //System.out.println(tSort);
        return tSort.size() == numCourses;
        //Time  Complexity - O(V+E) (or equivalently,O(numCourses+prerequisites.length))
        //Space Complexity - O(V+E)
    }
    //https://leetcode.com/problems/course-schedule/
}
