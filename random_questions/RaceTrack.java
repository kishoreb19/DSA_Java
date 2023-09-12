package random_questions;

public class RaceTrack {
    public static boolean isAllotmentPossible(int arr[], int m, int minDistance){
        int kidsPlaced = 1;
        int lastKid = arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i]-lastKid>=minDistance){
                lastKid = arr[i];
                kidsPlaced++;
            }
        }
        if(kidsPlaced>=m){
            return true;
        }else{
            return false;
        }
    }
    public static int raceTrack(int arr[],int m) {
        if(m>arr.length){
            return -1;
        }
        int low =arr[1]-arr[0]; int high = arr[arr.length-1]-arr[0];
        //OR
        //int low = 0; int high = (int)1e9;
        int ans = -1;
        while (low <= high) {
            int mid = low - (low - high)/2;
            if (isAllotmentPossible(arr, m, mid)) {
                ans = mid;
                low = mid + 1;
                //Moving right as we need maximum
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] ={1,2,4,8,9};
        int numberOfKids = 2;
        System.out.println(raceTrack(arr,numberOfKids));
    }
}
