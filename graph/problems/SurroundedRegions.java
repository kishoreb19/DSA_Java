package graph.problems;

public class SurroundedRegions {
    void dfs(int i, int j, boolean[][] visited, char[][] board){
        //Marks all the O's connected from the borders as visited because they cannot be converted to X's as they are not surrounded by X in all 4 directions.
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;

        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};

        for(int[] dir : directions){
            int newX = i + dir[0];
            int newY = j + dir[1];

            if(0<= newX && newX<m && 0<=newY && newY<n &&
                    board[newX][newY] == 'O' && !visited[newX][newY]){
                dfs(newX, newY, visited, board);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        //1st Column and last Column
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(i,0,visited,board);
            }
            if(board[i][n-1] == 'O' && !visited[i][n-1]){
                dfs(i,n-1,visited,board);
            }
        }
        //1st Row and last Row
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(0,i,visited,board);
            }
            if(board[m-1][i] == 'O' && !visited[m-1][i]){
                dfs(m-1,i,visited,board);
            }
        }

        //Convert O's to X's which are inside the border and are not visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://leetcode.com/problems/surrounded-regions/
    //https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14&pp=iAQB
}
