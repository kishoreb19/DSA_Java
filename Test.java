import java.util.Stack;

public class Test {
    public static void pattern(int n){
        int m=n*n;
        int c=0;
        for(int i=n;i>=1;i--){
            for(int j =1;j<=i;j++){
                c++;
                System.out.print(c+" ");
            }
            for(int j=1;j<=i;j++){
                m++;
                System.out.print(m+" ");
            }
            m=m-2*(i)+1;
            System.out.println();
        }
    }

    public static void f(Stack<Integer>s,int i,int size){
        if(i==size/2){
            s.pop();
            return;
        }
        int x = s.pop();
        f(s,i+1,size);
        s.push(x);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=9;i++){
            s.push(i);
        }
        int x = s.size();

        f(s,0,s.size());


        while (s.size()!=0){
            System.out.println(s.pop());
        }
    }
}
