package sorting.problems;

public class ShiftNegativeNumbers {
    public static void shiftNegativeNumbers(int arr[]){
        int i=0;int j=arr.length-1;
        while (i<j){
            //check for Positive Number
            while (arr[i]<0){
                i++;
            }
            //check for Negative Number
            while (arr[j]>0){
                j--;
            }
            //Swap Positive Number with Negative Number
            if(i<j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //Now all the Negative Numbers are on the left side
    }

    public static void main(String[] args) {
        int arr[]={19,-20,7,-4,-13,11,-5,3};
        shiftNegativeNumbers(arr);
        for (int i :arr){
            System.out.print(i+" ");
        }
    }
}
