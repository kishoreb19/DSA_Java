package stack;

public class Stack {
    static void fun(String s,String res){
        if(s.length()==0){
            System.out.println(res);
            return;
        }
        char c = s.charAt(0);
        fun(s.substring(1),res+c);
        fun(s.substring(1),res);
    }

}
