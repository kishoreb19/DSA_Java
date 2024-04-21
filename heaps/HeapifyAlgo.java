package heaps;

public class HeapifyAlgo {
    static void swap(int arr[], int x, int y){
        arr[x] = arr[x]^arr[y];
        arr[y] = arr[x]^arr[y];
        arr[x] = arr[x]^arr[y];
    }
    static void heapify(int arr[], int n, int i){
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left < n && arr[largest]<arr[left]){
            largest = left;
        }
        if(right < n && arr[largest]<arr[right]){
            largest = right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,n,largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1,54,53,55,52,50};
        int n = arr.length-1;
        System.out.println("Before heapifying: ");
        for (int i =1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }
        System.out.println("After heapifying: ");
        for (int i =1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}