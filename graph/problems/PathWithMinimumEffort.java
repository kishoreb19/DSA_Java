package graph.problems;
import java.util.*;

public class PathWithMinimumEffort {

    class Tuple{
        int x,y,diff;
        Tuple(int x, int y, int diff){
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        //Using Dijkstra Algorithm

        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Tuple>pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new Tuple(0,0,0));

        int[][] effort = new int[m][n];
        for(int[] row : effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int x = t.x;
            int y = t.y;
            int diff = t.diff;

            if(x==m-1 && y==n-1){
                return diff;
            }

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(0<=newX && newX<m && 0<=newY && newY<n){
                    int routeDiff = Math.abs(heights[newX][newY] - heights[x][y]);
                    int maxDiff = Math.max(diff,routeDiff); //Maximum Diff in the route

                    if(maxDiff < effort[newX][newY]){
                        effort[newX][newY] = maxDiff;
                        pq.add(new Tuple(newX, newY, maxDiff));
                    }
                }
            }
        }
        return -1;
        //Time  Complexity - O(m*n*log(m*n))
        //Space Complexity - O(m*n)
    }
    //https://leetcode.com/problems/path-with-minimum-effort/
}
