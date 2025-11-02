package graph.problems;
import java.util.*;

public class ShortestPathInBinaryMaze {

    class Pair{
        int x,y,weight;
        Pair(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    int shortestPath(int[][] grid, int[] src, int[] dest) {

        // Your code here
        int m = grid.length;
        int n = grid[0].length;

        if(src[0] == dest[0] && src[1] == dest[1]){
            return 0;
        }

        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[src[0]][src[1]] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src[0],src[1],0));

        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            int currW = p.weight;

            if(x==dest[0] && y==dest[1]){
                return currW;
            }

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(0<=newX && newX<m && 0<=newY && newY<n && grid[newX][newY] == 1){
                    if(currW + 1 < dist[newX][newY]){
                        dist[newX][newY] = currW + 1;
                        q.add(new Pair(newX,newY,dist[newX][newY]));
                    }
                }
            }


        }
        return -1;
        //Time  Complexity - O(mxn)
        //Space Complexity - O(mxn)
    }
    //https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
}
