package graph.problems;
import java.util.*;

public class FindEventualSafeStates {

    boolean dfsCycleCheck(int start, boolean[] visited, boolean[] dfsVisited, boolean[] markNodes, int[][] graph){
        visited[start] = true;
        dfsVisited[start] = true;

        for(int neighbor : graph[start]){
            if(!visited[neighbor]){
                boolean check = dfsCycleCheck(neighbor,visited,dfsVisited,markNodes,graph);
                if(check){
                    return true;
                }
            }else if (visited[neighbor] && dfsVisited[neighbor]){
                return true;
            }
        }
        dfsVisited[start] = false;
        markNodes[start] = true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v];
        boolean[] markNodes = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]){
                dfsCycleCheck(i,visited,dfsVisited,markNodes,graph);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<v; i++){ //Adds the safe nodes in ascending order
            if(markNodes[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
        //Time  Complexity - O(V+E)
        //Space Complexity - O(V)
    }
    //https://leetcode.com/problems/find-eventual-safe-states/
}
