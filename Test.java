import java.math.BigInteger;
import java.util.*;

public class Test {
    static void swap(int x,int y){
        int temp = x;
        x = y;
        y = temp;
    }
    public static void main(String[] args) {
//        ArrayList<Integer> list1= new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list1.add(1);
//        list1.add(6);
//        list2.add(1);
//        list2.add(6);
//        System.out.println(list1.addAll(list2));
//        System.out.println(list1);
//        Map<Integer,Integer> m = new HashMap<>();
//        m.put(1,9);
//        m.put(2,0);
//        for(int i : m.keySet()){
//            System.out.println(i+"  "+m.get(i));
//        }
//        try {
//            int r = 5/0;
//        }catch (Exception e){
//            System.out.println(e);
//            e.printStackTrace();
//        }
//        long ll = 2L;
//        float f = 0.333F;
//        System.out.println(ll);

        int num = 354;
        int rev=0;
        while(num>0){
            rev = rev*10 + num%10;
            num = num/10;
        }
        System.out.println(rev);


    }
}