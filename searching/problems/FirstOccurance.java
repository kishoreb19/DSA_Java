package searching.problems;

public class FirstOccurance {
    public static int binarySearchFO(int arr[],int element){
        int low =0 ;
        int high = arr.length-1;
        int firstOccurance = -1;
        while (low<=high){
            int mid = low-(low-high)/2;
            if(arr[mid]==element){
                firstOccurance = mid;
                high=mid-1;
            }else if(arr[mid]>element){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return firstOccurance;
    }

    public static void main(String[] args) {
        int arr[] = {0,3,5,5,5,5,5};
        System.out.println(binarySearchFO(arr,5));
    }
}
