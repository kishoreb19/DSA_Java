import java.math.BigInteger;
import java.util.*;

public class Test {
    static void swap(int x,int y){
        int temp = x;
        x = y;
        y = temp;
    }
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("X");
        pq.add("B");
        pq.add("A");
        pq.add("Y");
        System.out.println(pq);


    }
}