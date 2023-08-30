package sorting.problems;

public class SortInLinearTime {
    public static void sortInLinearTime(int arr[]){
        int x=-1;
        int y=-1;
        if(arr.length<=1){
            //Corner case, if single element is present
            return;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                if(x==-1){
                    //First Conflict
                    x=i-1;
                    y=i;
                }else {
                    //Second Conflict
                    y = i;
                }
            }
        }
        // Swap
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public static void main(String[] args) {
        int arr[] = {10,5,6,7,8,9,3};
        sortInLinearTime(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
