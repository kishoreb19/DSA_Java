import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    static int rotateByK(int arr[],int k){
        int n = arr.length;
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==k){
                return mid;
            }
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
            }
            if(arr[mid]<=arr[high]){
                if(arr[mid]<k && k<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            if(arr[low]<arr[mid]){
                if(arr[low]<=k && k<arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    static int search_(int[] a, int target){
        int st = 0, end = a.length-1;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(a[mid] == target){
                return mid;
            }
            else if(a[st] == a[mid] && a[end] == mid){
                st++;
                end--;
            }
            else if (a[mid] <= a[end]){ // mid to end is sorted
                if(target > a[mid] && target <= a[end]){
                    st = mid+1;
                } else {
                    end = mid-1;
                }
            } else { // st to mid is sorted
                if(target >= a[st] && target < a[mid]){
                    end = mid-1;
                } else {
                    st = mid+1;
                }
            }
        }
        return -1;
    }
    static int bestTimeToBuyStock(int arr[]){
        int max = 0;
        for(int i =0;i<arr.length-1;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    int x = arr[j] - arr[i];
                    if(x>max){
                        max = x;
                    }
                }
            }
        }
        return max;
    }
    static void twoDArray(int arr[][],int target){
        int n = arr.length;
        int m = arr[0].length;
        int low =0;
        int high = n*m-1;
        while (low<=high){
            int mid = low-(low-high)/2;
            int midElement = arr[mid/m][mid%m];
            if(midElement==target){
                System.out.println(mid/m +" "+ mid%m);
                return;
            }
            if(midElement>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        System.out.println("NOT FOUND");
    }
    public static void main(String[] args) {
        System.out.println(rotateByK(new int[]{1,1,1,1,2,3,1,1}, 3));
        System.out.println(search_(new int[]{1, 1, 1, 2, 2, 3, 1}, 2));
        System.out.println(bestTimeToBuyStock(new int[]{98,101,66,72}));
        System.out.println();

        int arr[][] = {{1,2,3},{4,5,6}};
        twoDArray(arr,6);



    }
}
