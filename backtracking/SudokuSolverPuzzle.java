package backtracking;

public class SudokuSolverPuzzle {
    static boolean isValid(int row, int col, int val, int[][] board){
        for(int i=0;i<board[0].length;i++){
            //Row Check
            if(board[row][i]==val){
                return false;
            }
            //Col Check
            if(board[i][col]==val){
                return false;
            }
            //3x3 Matrix Check
            if(board[3*(row/3) + i/3] [3*(col/3) + i%3] == val){
                return false;
            }
        }
        return true;
    }

    static boolean solve(int[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==0){
                    //Empty Cell
                    for(int val = 1;val<=9;val++){
                        if(isValid(row,col,val,board)){
                            board[row][col] = val;
                            boolean nxtSolPossible = solve(board);
                            if(nxtSolPossible){
                                return true;
                            }else{
                                //backtrack
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static void solveSudoku(int[][] sudoku) {
        // Write your code here.
        solve(sudoku);
        //Time  Complexity - O(9^m), where m is the number of empty cells
        //Space Complexity - O(m) due to recursion call stack
        //https://www.naukri.com/code360/problems/sudoku-solver_699919?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
    }
}
