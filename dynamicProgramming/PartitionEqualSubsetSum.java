package dynamicProgramming;

public class PartitionEqualSubsetSum {

    static boolean solve_rec(int i, int sum, int[] arr){
        int n = arr.length;
        if(i>=n){
            if(sum==0){
                return true;
            }else{
                return false;
            }
        }
        boolean include = solve_rec(i+1,sum-arr[i],arr);
        boolean exclude = solve_rec(i+1,sum,arr);

        return include || exclude;
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int i, int sum, int[] arr, int[][] dp){
        if (sum == 0) return 1;  // Found a valid subset
        if (i >= arr.length || sum < 0) return 0;  // Out of bounds or negative sum

        if (dp[i][sum] != -1) return dp[i][sum];

        int include = solve_dp(i+1, sum - arr[i], arr, dp);
        int exclude = solve_dp(i+1, sum, arr, dp);

        return dp[i][sum] = (include | exclude);
        //Time  Complexity - O(n * target)
        //Space Complexity - O(n * target) + O(n)
    }

    static boolean solve_tab(int[] arr){
        int n = arr.length;

        int target = 0;

        for(int i : arr){
            target+=i;
        }

        if(target%2 != 0){
            return false;
        }

        boolean[][] dp = new boolean[n+1][(target/2) + 1];

        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i = n-1; i>=0; i--){
            for(int sum = 0; sum<=target/2; sum++){
                boolean include = false;
                if(sum - arr[i]>=0){
                    include = dp[i+1][sum - arr[i]];
                }
                boolean exclude = dp[i+1][sum];

                dp[i][sum] = (include || exclude);
            }
        }

        return dp[0][target/2];
        //Time  Complexity - O(n * target)
        //Space Complexity - O(n * target)
    }

    static boolean solve_opt(int[] arr){
        int n = arr.length;

        int target = 0;

        for(int i : arr){
            target+=i;
        }

        if(target%2 != 0){
            return false;
        }

        boolean[] currRow = new boolean[(target/2) + 1];
        boolean[] nextRow = new boolean[(target/2) + 1];

        for(int i=0; i<=n; i++){
            nextRow[0] = true;
        }

        for(int i = n-1; i>=0; i--){
            for(int sum = 0; sum<=target/2; sum++){
                boolean include = false;
                if(sum - arr[i]>=0){
                    include = nextRow[sum - arr[i]];
                }
                boolean exclude = nextRow[sum];

                currRow[sum] = (include || exclude);
            }
            nextRow = currRow.clone();
        }

        return currRow[target/2];
        //Time  Complexity - O(n * target)
        //Space Complexity - O(target)
    }

    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        int sum = 0;

        for(int i : arr){
            sum+=i;
        }
        if(sum%2 != 0){
            return false;
        }
        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                dp[i][j] = -1;
            }
        }
        // return solve_dp(0,sum/2,arr,dp)==1;

        // return solve_opt(arr);
        return solve_opt(arr);
    }
    //https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
}