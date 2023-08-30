package sorting;

public class MergeSort {
    public static void merge(int arr[],int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-(m+1)+1;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0;i<n1;i++){
            left[i] = arr[l+i]; //Since values of l&m will be changing on recursive calls
        }
        for(int i=0;i<n2;i++){
            right[i] = arr[(m+1)+i];
        }
        int i=0; int j=0; int k=l;
        while (i<n1 && j<n2){
            if(left[i]<=right[j]){//Change sign here for decreasing order
                arr[k] = left[i];
                i++;
                k++;
            }else{
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        //to cover the rest elements
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int arr[],int l,int r){
        if(l>=r){
            return;
        }
        int m = l-(l-r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
//        Worst Case - O(nlogn)
//        Best Case -  Ω(nlogn)
//        Avg Case -   Θ(nlogn)
//        Space Complexity : O(n)
    }
    public static void printArray(int arr[]){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {10,1,7,6,14,9};
        System.out.println("Before Sorting");
        printArray(arr);

        mergeSort(arr,0,arr.length-1);
        System.out.println("After Sorting");
        printArray(arr);
    }
}
