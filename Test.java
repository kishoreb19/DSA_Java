import java.util.Random;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i =1;i<=5;i++){
            s.push(i);
        }
        while (s.size()>2){

            s.pop();
        }
        System.out.println(s.peek());
    }
}
