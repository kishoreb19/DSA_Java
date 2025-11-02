package graph.problems;
import java.util.HashSet;
public class NumberOfDistinctIslands {

    static void dfs(int i, int j, int[][] arr, StringBuilder sb, String move, boolean[][] visited) {
        int m = arr.length;
        int n = arr[0].length;

        if (i >= 0 && i < m && j >= 0 && j < n && arr[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;  // Mark cell as visited
            sb.append(move);       // Append the movement direction

            // Explore in a fixed order: Left ? Right ? Top ? Bottom
            dfs(i, j - 1, arr, sb, "L", visited); // Left
            dfs(i, j + 1, arr, sb, "R", visited); // Right
            dfs(i - 1, j, arr, sb, "T", visited); // Top
            dfs(i + 1, j, arr, sb, "B", visited); // Bottom

            sb.append("X"); // Mark backtracking
        }
    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, arr, sb, "O", visited);  // Start DFS with "O" (origin)
                    set.add(sb.toString());  // Store the encoded shape
                }
            }
        }
        return set.size();
        //Time  Complexity: O(m × n)
        //Space Complexity: O(m × n)
    }
    //https://www.naukri.com/code360/problems/distinct-islands_630460?leftPanelTabValue=PROBLEM
    //https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16
}
