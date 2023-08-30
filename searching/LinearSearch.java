package searching;

public class LinearSearch {
    public static int linearSearch(int arr[],int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }

    //Using recursion
    public static int linearSearchRecursion(int arr[],int i,int element){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==element){
            return i;
        }else{
            return linearSearchRecursion(arr,i+1,element);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(linearSearch(arr,6));
        System.out.println(linearSearchRecursion(arr,0,3));
    }
}
