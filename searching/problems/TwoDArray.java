package searching.problems;

public class TwoDArray {
    public static void searchIn2DArray_I(int arr[][], int target){
        //2D Array should be sorted
        int n = arr.length; //Rows
        int m = arr[0].length; // Columns
        int low = 0;
        int high = n*m-1;
        while (low<=high){
            int mid = low-(low-high)/2;
            int midElement = arr[mid/m][mid%m]; //Converting mid into rows and columns
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
        System.out.println("Element Not Found !");
    }
    public static void searchIn2DArray_II(int arr[][], int target){
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m-1;
        while (i<n && j>=0){
            if(arr[i][j]==target){
                System.out.println(i+ " "+ j);
                return;
            }
            if(arr[i][j]>target){
                j--; //Moving left for smaller elements
            }else{
                i++; //Moving downwards for larger elements
            }
        }
        System.out.println("Element Not Found !");
    }

    public static void main(String[] args) {
        int arr1[][] = {{1,2,3},{4,5,6},{7,8,9}};
        /*
        1   2   3
        4   5   6
        7   8   9
         */
        searchIn2DArray_I(arr1,6);
        int arr2[][]={{2,4,6,8},{5,6,7,20},{7,11,13,25},{12,14,17,30}};
        /*
        2    4    6  8
        5    6    7 20
        7   11   13 25
        12  14   17 30
         */
        searchIn2DArray_II(arr2,11);
    }
}
