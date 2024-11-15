package backtracking;

import java.util.ArrayList;

public class NQueensPuzzle {
    static void addSolution(int[][] board, ArrayList<ArrayList<Integer>> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                temp.add(board[i][j]);
                //OPTIONAL TO PRINT
                System.out.print(board[i][j]+" ");
            }
            //OPTIONAL TO PRINT
            System.out.println();
        }
        System.out.println();
        ans.add(temp);
    }

    static boolean isSafe(int row, int col, int[][] board, int n){
        int x = row;
        int y = col;

        //Check for same row
        //No need to check for right side as it will be 0 because we are placing
        //queens from left to right.
        while(y>=0){
            if(board[row][y]==1){
                return false;
            }
            y--;
        }

        //No need to check for same column as we are placing queens left to right

        //Check for upper diagonal (left side)
        x = row;
        y = col;
        while(x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x--; y--;
        }

        //Check for bottom diagonal (left side)
        x = row;
        y = col;
        while(x<n && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x++; y--;
        }

        return true;
    }
    static void solve(int col, int[][] board, ArrayList<ArrayList<Integer>> ans, int n){
        if(col==n){
            addSolution(board,ans);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 1;
                //Now check for next column
                solve(col+1,board,ans,n);
                //Backtrack
                board[row][col] = 0;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> nQueens(int n)
    {
        // Write Your Code Here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(0,board,ans,n);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = nQueens(5);
        //Time  Complexity - O(n! x n)
        //Space Complexity - O(n^2 + S * n^2), where S is the number of valid solutions.
        //https://www.naukri.com/code360/problems/the-n-queens-puzzle_981286?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
