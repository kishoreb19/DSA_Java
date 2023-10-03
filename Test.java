import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {

    public static ArrayList<Integer> checkDuplicates(int arr[]){
        Arrays.sort(arr);
        ArrayList<Integer> obj = new ArrayList<>();
        int temp = -1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                if(temp != arr[i]){
                    obj.add(arr[i]);
                    temp = arr[i];
                }
            }
        }
        if(obj.isEmpty()){
            obj.add(-1);
            return obj;
        }else{
            return obj;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkDuplicates(new int[]{5,6,2,0,4}));
    }
}
