package graph.algorithms;

public class FloydWarshallAlgorithm {

    public void shortestDistance(int[][] mat) {
        int n = mat.length;

        // Step 1: Replace -1 with MAX and set self-loops to 0
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == -1)
                    mat[i][j] = Integer.MAX_VALUE;
                if(i == j)
                    mat[i][j] = 0;
            }
        }

        // Step 2: Floyd-Warshall core
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(mat[i][via] != Integer.MAX_VALUE && mat[via][j] != Integer.MAX_VALUE)
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        // Step 3: Check for negative edge cycle
        for(int i = 0; i < n; i++) {
            if(mat[i][i] < 0) {
                System.out.println("Negative Edge Cycle Detected!");
                break;
            }
        }

        // Step 4: Restore -1 for unreachable paths
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == Integer.MAX_VALUE)
                    mat[i][j] = -1;
                if(i == j)
                    mat[i][j] = 0;
            }
        }
        //Time  Complexity - O(n^3)
        //Space Complexity - O(1) (in-place)
    }
    //https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall
}
