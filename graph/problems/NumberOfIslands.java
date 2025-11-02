package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    void bfs(int i, int j, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        grid[i][j] = '0'; //Mark Visited

        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}}; //Left Right Top Bottom

        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] dir : directions){
                int newX = node[0] + dir[0];
                int newY = node[1] + dir[1];

                if((0<=newX && newX<m) && (0<=newY && newY<n) && grid[newX][newY] == '1'){
                    q.add(new int[] {newX,newY});
                    grid[newX][newY] = '0';
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://leetcode.com/problems/number-of-islands/
    //https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8&pp=iAQB
}
