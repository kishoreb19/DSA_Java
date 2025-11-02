package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    class Node{
        int i,j,time;
        Node(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    int bfs(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i,j,0));
                }
            }
        }

        int minTime = 0;
        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            Node node = q.poll();
            minTime = Math.max(minTime,node.time);

            for(int[] dir : directions){
                int newX = node.i + dir[0];
                int newY = node.j + dir[1];

                if(0<=newX && newX<m && 0<=newY && newY<n && grid[newX][newY] == 1){
                    q.add(new Node(newX, newY, node.time + 1));
                    grid[newX][newY] = 2;
                }
            }
        }
        return minTime;
    }
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int time = bfs(grid);

        //Check if any fresh orange is present or not
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://leetcode.com/problems/rotting-oranges/description/
    //https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10&pp=iAQB
}
