package graph.problems;

public class NumberOfEnclaves {

    void dfs(int i, int j, boolean[][] visited, int[][] board){
        //Marks all the 1's connected from the borders as visited because they cannot be our answer since we can go out of boundry
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;

        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};

        for(int[] dir : directions){
            int newX = i + dir[0];
            int newY = j + dir[1];

            if(0<= newX && newX<m && 0<=newY && newY<n &&
                    board[newX][newY] == 1 && !visited[newX][newY]){
                dfs(newX, newY, visited, board);
            }
        }
    }

    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        //1st Column and last Column
        for(int i=0; i<m; i++){
            if(board[i][0] == 1 && !visited[i][0]){
                dfs(i,0,visited,board);
            }
            if(board[i][n-1] == 1 && !visited[i][n-1]){
                dfs(i,n-1,visited,board);
            }
        }
        //1st Row and last Row
        for(int i=0; i<n; i++){
            if(board[0][i] == 1 && !visited[0][i]){
                dfs(0,i,visited,board);
            }
            if(board[m-1][i] == 1 && !visited[m-1][i]){
                dfs(m-1,i,visited,board);
            }
        }

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://leetcode.com/problems/number-of-enclaves/
    //https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15&pp=iAQB
}
