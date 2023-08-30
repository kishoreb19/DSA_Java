package searching.problems;

public class SquareRoot {
    public static int squareRoot(int x){
        int i=0;
        while(i*i<=x){
            i++;
        }
//        if(i*i==x){
//            return i;
//        }else{
//            return i-1;
//        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(25));
    }
}
