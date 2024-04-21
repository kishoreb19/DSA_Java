package heaps;

public class InsertionDeletion {

    static void swap(int arr[], int x, int y){
        arr[x] = arr[x]^arr[y];
        arr[y] = arr[x]^arr[y];
        arr[x] = arr[x]^arr[y];
    }
    static class Heap{
        int[] arr;
        int size;
        Heap(){
            arr = new int[100];
            size = 0;
        }
        void insert(int data){
            size++;
            int index = size;
            arr[index] = data;
            while(index>1){
                int parent = index/2;
                if(arr[parent]<arr[index]){
                    swap(arr,parent,index);
                    index = parent;
                }else {
                    return;
                }
            }
            //Time Complexity - O(logN)
        }
        void delete(){
            if(size==0) {
                System.out.println("Nothing to delete!");
                return;
            }
            swap(arr,1,size);
            size--;

            //Taking root node to its correct position
            int i=1;
            while(i<size){
                int leftIndex = 2*i;
                int rightIndex = 2*i + 1;
                if(leftIndex<size && arr[i]<arr[leftIndex]){
                    swap(arr,i,leftIndex);
                    i = leftIndex;
                }else if (rightIndex<size && arr[i]<arr[rightIndex]){
                    swap(arr,i,rightIndex);
                    i = rightIndex;
                }else{
                    return;
                }
            }
            //Time Complexity - O(logN)
        }
        void print(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(30);
        h.insert(20);
        h.insert(50);
        h.insert(60);
        h.print();
        h.delete();
        System.out.println("After Deletion: ");
        h.print();
    }
}
