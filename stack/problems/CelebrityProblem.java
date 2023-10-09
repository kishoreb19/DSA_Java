package stack.problems;

import java.util.Stack;

public class CelebrityProblem {
    public static boolean knows(int arr[][],int a,int  b){
        return arr[a][b] == 1;
    }
    public static int celebrityProblem(int arr[][],int n){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while(stack.size() > 1 ){
            int a = stack.pop();
            int b = stack.pop();

            if(knows(arr,a,b)){
                //If 'a' knows 'b' then push 'b' since celebrity doesn't know anybody.
                stack.push(b);
            }else{
                stack.push(a);
            }
        }
        int potentialCandidate = stack.peek();
        //Verifying whether our potentialCandidate is celebrity or not.
        int zeroCount =0; int oneCount=0;
        for(int i=0;i<n;i++){
            if(arr[potentialCandidate][i]==0){
                zeroCount++;
            }
            if(arr[i][potentialCandidate]==1){
                oneCount++;
            }
        }
        if(zeroCount==n && oneCount==n-1){
            return potentialCandidate;
        }else{
            return -1;
        }
        //Time Complexity - O(N)
    }
    public static void main(String[] args) {
        System.out.println(celebrityProblem(new int[][]{
                        {0,1,0},
                        {0,0,0},
                        {0,1,0}},
                3));
    }
}
