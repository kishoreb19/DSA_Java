package random_questions;

public class Armstrong {

    static int no_of_digits(int n){
        int c=0;
        while(n>0){
            c++;
            n=n/10;
        }
        return c;
    }
    static int power(int x,int y){
        if(y==0){
            return 1;
        }
        return x*power(x,y-1);
    }
    static boolean armstrong(int n){
        int t = n;
        int x = 0;
        int order = no_of_digits(n);
        while(n>0){
            int r = n%10;
            x = x + power(r,order);
            n=n/10;
        }
        if(x==t){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(armstrong(153));
    }
}
