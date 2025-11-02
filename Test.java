import java.util.*;


interface A{
    int sum();
}

public class Test {

    static int fun(int a){

        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {

        int k = 10;
        A a = new A(){
            public int sum(){
                int a = 10;
                int b = 11;

                int k = a+b;
                return k;
            }
        };

        System.out.println(a.sum()+"k");

        int c = 10;
        int d = 20;

        System.out.println(fun(c++));
        System.out.println(c);
    }
}
