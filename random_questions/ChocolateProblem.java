package random_questions;

import com.sun.source.tree.BreakTree;

public class ChocolateProblem {
    public static boolean divisionPossible(int arr[],int m, int maxChocolateAllowed){
        int currentStudent = 1;
        int chocolate =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxChocolateAllowed){
                return false;
            }
            if(chocolate+arr[i]<=maxChocolateAllowed){
                chocolate+=arr[i];
            }else{
                currentStudent++;
                chocolate=arr[i];
            }
        }
        if(currentStudent<=m){
            return true;
        }else{
            return false;
        }
    }
    public static int chocolateProblem(int arr[],int m){
        int start=0; int end = (int)1e9;
        int ans=0;
        while (start<=end){
            int mid = start-(start-end)/2;
            if(divisionPossible(arr,m,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,1,6};
        int m = 4;
        System.out.println(chocolateProblem(arr,m));
    }
}
