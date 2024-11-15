package backtracking;

import java.util.ArrayList;

public class RatInAMaze {

    static boolean isSafe(int x, int y, int[][] visited, int[][] arr, int n){
        if((0<=x && x<n && 0<=y && y<n) && (arr[x][y]==1 && visited[x][y] != 1)){
            return true;
        }else{
            return false;
        }
    }

    static void solve(int x, int y, String ans, ArrayList<String> result, int[][] visited, int[][] arr, int n){

        //Destination Reached
        if(x==n-1 && y==n-1){
            result.add(ans);
            return;
        }

        visited[x][y] = 1;

        //Down
        if(isSafe(x+1,y,visited,arr,n)){
            solve(x+1,y,ans+'D',result,visited,arr,n);
        }
        //Left
        if(isSafe(x,y-1,visited,arr,n)){
            solve(x,y-1,ans+'L',result,visited,arr,n);
        }
        //Right
        if(isSafe(x,y+1,visited,arr,n)){
            solve(x,y+1,ans+'R',result,visited,arr,n);
        }
        //Up
        if(isSafe(x-1,y,visited,arr,n)){
            solve(x-1,y,ans+'U',result,visited,arr,n);
        }

        visited[x][y] = 0;
    }

    public static ArrayList<String> findSum(int[][] arr, int n) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();

        // Check if the starting or ending cell is blocked
        if(arr[0][0]==0 || arr[n-1][n-1]==0){
            return result;
        }

        int visited[][] = new int[n][n];
        solve(0,0,"",result,visited,arr,n);
        return result;
        //Time  Complexity - O(4^(n^2))
        //Space Complexity - O(n^2) (for recursion stack & visited array)
        //                 - O(4^(n^2)) (considering storage of all paths)
        //https://www.naukri.com/code360/problems/rat-in-a-maze_1215030?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
