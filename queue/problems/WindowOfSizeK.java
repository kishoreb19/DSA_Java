package queue.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class WindowOfSizeK {
    //First negative integer in every window of size K
    public static ArrayList<Integer> firstNegativeInteger(int A[],int K){
        int n = A.length;
        ArrayList<Integer> al = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        //First window
        for(int i=0;i<K;i++){
            if(A[i] < 0){
                dq.addLast(i);
            }
        }
        //Storing answer
        if(dq.size()>0){
            al.add(A[dq.peekFirst()]);
        }else{
            al.add(0);
        }

        for(int i=K;i<n;i++){
            if(!dq.isEmpty() && i - dq.peekFirst() >= K){
                dq.pollFirst();
            }

            if(A[i] < 0){
                dq.addLast(i);
            }

            if(dq.size()>0){
                al.add(A[dq.peekFirst()]);
            }else{
                al.add(0);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(firstNegativeInteger(new int[]{-8, 2, 3, -6, 10},2));
    }
}
