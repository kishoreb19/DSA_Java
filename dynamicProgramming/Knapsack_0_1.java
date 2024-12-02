package dynamicProgramming;

public class Knapsack_0_1 {
    static int solve_rec(int i, int[] weight, int[] value, int capacity){
        if(i==0){
            if(weight[0]<=capacity){
                return value[0];
            }else{
                return 0;
            }
        }

        int take = Integer.MIN_VALUE;
        if(weight[i]<=capacity){
            take = value[i] + solve_rec(i-1, weight, value, capacity-weight[i]);
        }
        int notTake = 0 + solve_rec(i-1, weight, value, capacity);

        return Math.max(take,notTake);
        //Time  Complexity - O(2^n)
        //Space Complexity - O(n)
    }

    static int solve_dp(int i, int[] weight, int[] value, int capacity, int dp[][]){
        if(i==0){
            if(weight[0]<=capacity){
                return value[0];
            }else{
                return 0;
            }
        }

        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }

        int take = Integer.MIN_VALUE;
        if(weight[i]<=capacity){
            take = value[i] + solve_dp(i-1, weight, value, capacity-weight[i],dp);
        }
        int notTake = 0 + solve_dp(i-1, weight, value, capacity,dp);

        return dp[i][capacity] = Math.max(take,notTake);
        //Time  Complexity - O(n*capacity)
        //Space Complexity - O(n) + O(n*capacity)
    }

    static int solve_tab(int[] weight, int[] value, int n, int capacity){

        //step1 -> Create DP Table
        int dp[][] = new int[n][capacity+1];

        //step2 -> Analyse Base Case
        for(int w = weight[0]; w<=capacity; w++){
            if(weight[0]<=w){
                dp[0][w] =  value[0];
            }else{
                dp[0][w] = 0;
            }
        }

        //step3 -> Solve for remaining recursive calls

        //In recursion my function runs for
        // n-> from (n-1) to 0 so in tabulation reverse it i.e now n runs from 0 to (n-1).
        // capacity -> from capacity to 0 so in tabulation reverse it i.e now capacity runs from 0 to capacity.
        for(int i=1;i<=n-1;i++){
            for(int w=0; w<=capacity; w++){
                int take = Integer.MIN_VALUE;
                if(weight[i]<=w){
                    take = value[i] + dp[i-1][w-weight[i]];
                }
                int notTake = 0 + dp[i-1][w];

                dp[i][w] = Math.max(take,notTake);
            }
        }
        return dp[n-1][capacity];
        //Time  Complexity - O(n*capacity)
        //Space Complexity - O(n*capacity)
    }

    static int solve_space_optimized_1(int[] weight, int[] value, int n, int capacity){

        //step1 -> Create prev and curr array
        int prev[] = new int[capacity+1];
        int curr[] = new int[capacity+1];

        //step2 -> Analyse Base Case
        for(int w = weight[0]; w<=capacity; w++){
            if(weight[0]<=w){
                prev[w] =  value[0];
            }else{
                prev[w] = 0;
            }
        }

        //step3 -> Solve for remaining recursive calls

        //In recursion my function runs for
        // n-> from (n-1) to 0 so in tabulation reverse it i.e now n runs from 0 to (n-1).
        // capacity -> from capacity to 0 so in tabulation reverse it i.e now capacity runs from 0 to capacity.
        for(int i=1;i<=n-1;i++){
            for(int w=0; w<=capacity; w++){
                int take = Integer.MIN_VALUE;
                if(weight[i]<=w){
                    take = value[i] + prev[w-weight[i]];
                }
                int notTake = 0 + prev[w];

                curr[w] = Math.max(take,notTake);
            }
            //Make prev = curr now
            //We can directly write prev = curr beacuse in java arrays are passed by reference
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[capacity];
        //Time  Complexity - O(n*capacity)
        //Space Complexity - O(2*capacity) -> O(capacity)
    }

    static int solve_space_optimized_2(int[] weight, int[] value, int n, int capacity){

        //step1 -> curr array
        int curr[] = new int[capacity+1];

        //step2 -> Analyse Base Case
        for(int w = weight[0]; w<=capacity; w++){
            if(weight[0]<=w){
                curr[w] =  value[0];
            }else{
                curr[w] = 0;
            }
        }

        //step3 -> Solve for remaining recursive calls

        //Reverse the loops
        for(int i=n-1;i>=1;i--){
            for(int w=capacity; w>=0; w--){
                int take = Integer.MIN_VALUE;
                if(weight[i]<=w){
                    take = value[i] + curr[w-weight[i]];
                }
                int notTake = 0 + curr[w];

                curr[w] = Math.max(take,notTake);
            }
        }
        return curr[capacity];
        //Time  Complexity - O(n*capacity)
        //Space Complexity - O(capacity)
    }

    static int knapsack(int[] weight, int[] value, int n, int capacity) {

        // //solve_rec()
        // return solve_rec(n-1, weight, value, capacity);

        // //solve_dp()
        // int dp[][] = new int[n][capacity+1];
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return solve_dp(n-1, weight, value, capacity,dp);

        // //solve_tab()
        // return solve_tab(weight,value,n,capacity);

        // //solve_space_optimized_1()
        // return solve_space_optimized_1(weight,value,n,capacity);

        //solve_space_optimized_2()
        return solve_space_optimized_2(weight,value,n,capacity);
    }
    //https://www.naukri.com/code360/problems/0-1-knapsack_920542?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar&leftPanelTabValue=PROBLEM
}
