package random_questions;
public class ChocolateProblem {

    //Minimum of Maximums

    public static boolean divisionPossible(int arr[],int m, int maxChocolateAllowed){
        int numberOfStudents = 1;
        int numberOfChocolates =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxChocolateAllowed){
                return false;
            }
            if(numberOfChocolates+arr[i]<=maxChocolateAllowed){
                numberOfChocolates+=arr[i];
            }else{
                numberOfStudents++;
                numberOfChocolates=arr[i];
            }
        }
        if(numberOfStudents<=m){
            return true;
        }else{
            return false;
        }
    }
    public static int chocolateProblem(int arr[],int m){
        int start=0; int end = (int)1e9;
        //Or
        //int start=min(arr) and int end = sum(arr)
        int ans=0;
        while (start<=end){
            int mid = start-(start-end)/2;
            if(divisionPossible(arr,m,mid)){
                ans = mid;
                end = mid-1;
                //We need to move left side as we want minimum
            }else{
                start = mid+1;
                //We need to move right side for greater value
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
