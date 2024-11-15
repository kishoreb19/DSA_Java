import binaryTree.BTBuild_Traversal;

import java.util.*;

public class Test {
    static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static void print(int arr[]){
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void reverse(int arr[]){
        int i=0, j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
//        int arr[] = takeInput();
//        System.out.println("Before Reverse: ");
//        print(arr);
//        System.out.println("After Reverse: ");
//        reverse(arr);
//        print(arr);
//        System.out.println();
        Map<Integer,Integer>map = new HashMap<>();
        ArrayList<Integer> j = new ArrayList<>();
        j.add(9);
        System.out.println(j.toString());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedList<Integer>[] llarr = new LinkedList[10];
        for(int i =0;i<llarr.length;i++){
            llarr[i] = new LinkedList<>();
        }
        for(int i =0;i<llarr.length;i++){
            System.out.println(llarr[i]);
        }
    }

}