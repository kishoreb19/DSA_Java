package heaps;

public class HeapifyAlgo {
    static void swap(int arr[], int x, int y){
        arr[x] = arr[x]^arr[y];
        arr[y] = arr[x]^arr[y];
        arr[x] = arr[x]^arr[y];
    }
    static void heapify(int arr[], int size, int i){
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left <= size && arr[largest]<arr[left]){
            largest = left;
        }
        if(right <= size && arr[largest]<arr[right]){
            largest = right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,size,largest);
        }
    }
    static void buildMaxHeap(int arr[], int n){
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }
    }
    static void print(int arr[], int n){
        for (int i =1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {-1,54,53,55,52,50};
        int n = arr.length-1;

        System.out.println("Before heapifying: ");
        print(arr,n);

        buildMaxHeap(arr,n);

        System.out.println("After heapifying: ");
        print(arr,n);

    }
}
//Before heapifying:
//54 53 55 52 50
//After heapifying:
//55 53 54 52 50
//Process finished with exit code 0