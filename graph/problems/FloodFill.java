package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    void bfs(int i, int j, int[][] image, int color){
        int m = image.length;
        int n = image[0].length;

        int originalColor = image[i][j];
        if(originalColor == color) return; // Prevent unnecessary processing if starting node is already color
        image[i][j] = color;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});

        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};

        while(!q.isEmpty()){
            int[] pixel = q.poll();

            for(int[] dir : directions){
                int newX = pixel[0] + dir[0];
                int newY = pixel[1] + dir[1];

                if((0<=newX && newX<m && 0<=newY && newY<n) && //Check index within range
                        image[newX][newY] == originalColor && image[newX][newY] != color){
                    q.add(new int[] {newX, newY});
                    image[newX][newY] = color; //Mark visited
                }
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(sr,sc,image,color);
        return image;
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://leetcode.com/problems/flood-fill/
    //https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9&pp=iAQB
}
