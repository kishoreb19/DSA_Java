package backtracking;

public class WordSearch {
    boolean findWord(int row, int col,int idx,char[][] board, String word){
        if(idx==word.length()){
            //Debugging
            for(char[] rows : board){
                for(char c : rows){
                    System.out.print(c+" ");
                }
                System.out.println();
            }
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(idx)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '*';//Visited

        if(findWord(row-1,col,idx+1,board,word)){//Top
            return true;
        }

        if(findWord(row+1,col,idx+1,board,word)){//Bottom
            return true;
        }

        if(findWord(row,col+1,idx+1,board,word)){//Right
            return true;
        }

        if(findWord(row,col-1,idx+1,board,word)){//Left
            return true;
        }

        //Backtrack
        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(findWord(i,j,0,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Time  Complexity - O(m*n*(4^L))
    //Space Complexity - O(L) , L -> Length of word
    //https://leetcode.com/problems/word-search/
}
