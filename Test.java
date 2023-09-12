import java.util.Stack;

public class Test {
    public static void pattern(int n){
        for(int i =1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print(i+j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern(5);
    }
}
