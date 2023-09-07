package searching.problems;

public class RotatedSortedArray {
    //Rotate By K
    public static int[] rotateArrayByKLEFT(int arr[],int k){
        int n = arr.length;
        for(int i =1;i<=k;i++){
            int x = arr[0];
            for(int j=0;j<n-1;j++){
                //Shift elements to left
                arr[j] = arr[j+1];
            }
            arr[n-1] = x;
        }
        return arr;
        //Input  - 1 2 3 4 K=1
        //Output - 2 3 4 1
    }
    public static int[] rotateArrayByKRIGHT(int arr[],int k){
        int n = arr.length;
        for(int i =1;i<=k;i++){
            int x = arr[n-1];
            for(int j=n-1;j>0;j--){
                //Shift elements to right
                arr[j] = arr[j-1];
            }
            arr[0] = x;
        }
        return arr;
        //Input  - 1 2 4 3 5 6  K=2
        //Output - 5 6 1 2 4 3
    }

    //Find minimum element in rotated array or
    //Find pivot at which arr has been rotated
    public static int minElement(int arr[]){
        int low = 0;
        int high = arr.length-1;
        int n = arr.length;
        int ans=-1;
        while(low<=high){
            int mid = low-(low-high)/2;
            if(arr[mid]>arr[n-1]){
                //Left Array
                low = mid+1;
            }
            if(arr[mid]<=arr[n-1]){
                //Right Array
                ans = mid;
                high=mid-1;
            }
        }
        return ans;
    }

    //Return index of target
    public static int search(int arr[],int element){
        int low = 0; int high = arr.length-1;
        while (low<=high){
            int mid = low-(low-high)/2;
            if(arr[mid]==element){
                return mid;
            }
            if(arr[low]<arr[mid]){
                // low to mid is sorted
                if(arr[low]<= element && element<arr[mid]){
                    // element exists between low to mid
                    high = mid-1;
                }else{
                    low=mid+1;
                }
            }
            if(arr[mid]<arr[high]){
                // mid to high is sorted
                if(arr[mid]< element && element<=arr[high]){
                    // element exists between mid to high
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    //For Duplicate Elements
    public static int search_d(int arr[],int target){
        int low =0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low-(low-high)/2;
            if(arr[mid]==target){
                return mid;
            }

            if(arr[low]==arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
            }

            if(arr[mid]<=arr[high]){
                if(arr[mid]<target && target<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            else{
                if(arr[low]<=target && target<arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {10,11,12,1,2,3,4,5,6,7,8,9};
        int arr2[] = {1,1,1,2,2,3,1};
        //Index
        System.out.println(minElement(arr));
        System.out.println();
        for(int i : arr){
            System.out.print(search(arr,i)+" ");
        }
    }
}
