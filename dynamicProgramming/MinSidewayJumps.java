package dynamicProgramming;

public class MinSidewayJumps {

    int solve_rec(int currPos, int currLane, int[] obstacles,int n){
        if(currPos>=n){
            return 0;
        }
        if(obstacles[currPos+1]!=currLane){
            return solve_rec(currPos+1,currLane,obstacles,n);
        }else{
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(i!=currLane && obstacles[currPos]!=i){
                    ans = Math.min(ans,1+solve_rec(currPos,i,obstacles,n));
                }
            }
            return ans;
        }
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    int solve_dp(int currPos, int currLane, int[] obstacles,int n, int[][] dp){
        if(currPos>=n){
            return 0;
        }
        if(dp[currPos][currLane] != -1){
            return dp[currPos][currLane];
        }
        if(obstacles[currPos+1]!=currLane){
            return dp[currPos][currLane] = solve_dp(currPos+1,currLane,obstacles,n,dp);
        }else{
            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(i!=currLane && obstacles[currPos]!=i){
                    ans = Math.min(ans,1+solve_dp(currPos,i,obstacles,n,dp));
                }
            }
            return dp[currPos][currLane] = ans;
        }
        //Time  Complexity - O(n*3) -> O(n)
        //Space Complexity - O(n*3) + O(n) -> O(n)
    }

    int solve_tab(int[] obstacles){
        int n = obstacles.length-1;
        int[][] dp = new int[n+1][3+1];

        dp[n][0] = 0;
        dp[n][1] = 0;
        dp[n][2] = 0;
        dp[n][3] = 0;

        for(int currPos = n - 1; currPos >= 0; currPos--){
            for(int currLane = 1; currLane <= 3; currLane++){
                if(obstacles[currPos+1]!=currLane){
                    dp[currPos][currLane] =dp[currPos+1][currLane];
                }else{
                    int ans = Integer.MAX_VALUE;
                    for(int i=1;i<=3;i++){
                        if(i!=currLane && obstacles[currPos]!=i){
                            ans = Math.min(ans,1+dp[currPos+1][i]);
                        }
                    }
                    dp[currPos][currLane] = ans;
                }
            }
        }
        return Math.min(dp[0][2], Math.min(dp[0][1] + 1, dp[0][3] + 1));
        //Time  Complexity - O(n*3) -> O(n)
        //Space Complexity - O(n*3) -> O(n)
    }

    int solve_opt(int[] obstacles){
        int n = obstacles.length-1;
        int[] currRow = new int[4];
        int[] nextRow = new int[4];

        nextRow[0] = 0;
        nextRow[1] = 0;
        nextRow[2] = 0;
        nextRow[3] = 0;

        for(int currPos = n - 1; currPos >= 0; currPos--){
            for(int currLane = 1; currLane <= 3; currLane++){
                if(obstacles[currPos+1]!=currLane){
                    currRow[currLane] =nextRow[currLane];
                }else{
                    int ans = Integer.MAX_VALUE;
                    for(int i=1;i<=3;i++){
                        if(i!=currLane && obstacles[currPos]!=i){
                            ans = Math.min(ans,1+nextRow[i]);
                        }
                    }
                    currRow[currLane] = ans;
                }
            }
            nextRow = currRow.clone();
        }
        return Math.min(currRow[2], Math.min(currRow[1] + 1, currRow[3] + 1));
        //Time  Complexity - O(n*3) -> O(n)
        //Space Complexity - O(3) -> O(1)
    }

    public int minSideJumps(int[] obstacles) {
        // int n = obstacles.length-1;

        // int dp[][] = new int[n+1][3+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(0,2,obstacles,n,dp);
        return solve_opt(obstacles);
    }
    //https://leetcode.com/problems/minimum-sideway-jumps/
}
