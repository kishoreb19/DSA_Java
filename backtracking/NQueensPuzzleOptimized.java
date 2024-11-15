package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NQueensPuzzleOptimized {
    static Set<Integer>
            rowCheck = new HashSet<>(),
            upperLDiag = new HashSet<>(),
            lowerLDiag = new HashSet<>();

    static void addSolution(int[][] board, ArrayList<ArrayList<Integer>> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                temp.add(board[i][j]);
            }
        }
        ans.add(temp);
    }

    static boolean isSafe(int row, int col, int[][] board, int n){

        if(rowCheck.contains(row) ||
                upperLDiag.contains((n-1) + (col-row)) ||
                lowerLDiag.contains(row+col)){
            return false;
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
                rowCheck.add(row);
                upperLDiag.add((n-1) + (col-row));
                lowerLDiag.add(row+col);

                solve(col+1,board,ans,n);

                //Backtrack
                board[row][col] = 0;

                rowCheck.remove(row);
                upperLDiag.remove((n-1) + (col-row));
                lowerLDiag.remove(row+col);
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
        //Time  Complexity - O(n!)
        //Space Complexity - O(n^2 + S * n^2), where S is the number of valid solutions.
        //https://www.naukri.com/code360/problems/the-n-queens-puzzle_981286?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
    }
}
