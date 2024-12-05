package searching.problems;

public class MountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return -1;

        int low = 0 + 1;
        int high = (n-1)-1;
        while(low<=high){
            int mid = low-(low-high)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid-1]<arr[mid]){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
        //Time  Complexity - O(logN)
        //Space Complexity - O(1)
    }
//    public static int findPeakIndex(int arr[]){
//        int low = 0;
//        int high = arr.length - 1;
//        while (low < high){
//            int mid = low + (high - low) / 2;
//            if (arr[mid] < arr[mid + 1]) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low; //or high
//    }

//    public static int findPeakIndex(int arr[]){
//        int low =0;
//        int high = arr.length-1;
//        int peakIndex = -1;
//        while (low<=high){
//            int mid = low-(low-high)/2;
//            if(arr[mid]<arr[mid+1]){
//                //Inside Increasing Order
//                peakIndex = mid+1;
//                low=mid+1;
//            }
//            if(arr[mid]>arr[mid+1]){
//                //Inside Decreasing Order
//                high=mid-1;
//            }
//        }
//        return peakIndex;
//
//    }

//    public static int findPeakElement(int arr[]){
//        int low =0;
//        int high = arr.length-1;
//        while (low<=high){
//            int mid = low-(low-high)/2;
//            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
//                return mid;
//            }
//            if(arr[mid]<arr[mid+1]){
//                low = mid+1;
//            }
//            if(arr[mid]>arr[mid+1]){
//                high = mid-1;
//            }
//        }
//        return -1;
//    }
    public static int findPeakElement(int[] arr){
    int n= arr.length;
    if(n==1){
        return 0;
    }
    if(arr[0]>arr[1]){
        return 0;
    }
    if(arr[n-1]>arr[n-2]){
        return n-1;
    }
    int low = 1,high=n-2;
    while (low<=high){
        int mid = low-(low-high)/2;
        if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
            return mid;
        }
        if(arr[mid]<arr[mid+1]){
            low = mid+1;
        }
        if(arr[mid]>arr[mid+1]){
            high = mid-1;
        }
    }
    return -1;
}
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(peakIndexInMountainArray(arr1));
        //https://leetcode.com/problems/peak-index-in-a-mountain-array/

        int arr2[] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr2));
    }
}
