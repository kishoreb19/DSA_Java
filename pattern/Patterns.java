package pattern;

public class Patterns {
    public static void triangle(int rows){
        //   *
        //  ***
        // *****
        //*******
        System.out.println("Triangle of size : "+rows);
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int k = 1; k <= i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pyramid(int n){
        //   *
        //  * *
        // * * *
        //* * * *
        // * * *
        //  * *
        //   *
        // Printing upper part of the pyramid
        System.out.println("Pyramid of size "+n);
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Printing lower part of the pyramid
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void square(int n){
        //* * * *
        //*     *
        //*     *
        //* * * *
        int rows = n;
        int columns = n;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                // Print '*' only for the first and last row, and first and last column
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    System.out.print("* ");
                } else {
                    System.out.print("  "); // Print spaces for the hollow part
                }
            }
            System.out.println();
        }
    }

    public static void pascalTriangle(int n){
        //    1
        //   1 1
        //  1 2 1
        // 1 3 3 1
        //1 4 6 4 1
        int numRows = n;

        // Generate and print Pascal's Triangle
        for (int i = 1; i <= numRows; i++) {
            for(int j=1;j<=numRows-i;j++){
                System.out.print(" ");
            }
            int number = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / j;
            }
            System.out.println();
        }
    }

    public static void binaryTriangle(int n){
        //1
        //0 1
        //1 0 1
        //0 1 0 1
        //1 0 1 0 1
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                if((i+j)%2==0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void numberTriangle(int n){
        //1
        //2 3
        //4 5 6
        //7 8 9 10
        //11 12 13 14 15
        int count =1;
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }
    public static void butterfly(int n){
        //*      *
        //**    **
        //***  ***
        //********
        //***  ***
        //**    **
        //*      *
        //Upper
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int j=1;j<=n*2 - 2*i;j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Lower
        for(int i =n-1;i>=1;i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int j=1;j<=n*2 - 2*i;j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void numberCrown(int n){
        //1      1
        //12    21
        //123  321
        //12344321
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for(int j=1;j<=n*2 - 2*i;j++){
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void alphabeticTriangle(int n){
        //A
        //A B
        //A B C
        //A B C D
        //A B C D E
        int x = 65-1;
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                char ch = (char)(x+j);
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    public static void alphaHillPattern(int n){
        //   A
        //  ABA
        // ABCAB
        //ABCDABC
        int x = 65-1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print((char)(x+k));
            }
            for (int k = 1; k <= i-1; k++) {
                System.out.print((char)(x+k));
            }
            System.out.println();
        }
    }
    public static void numberStaircase(int n){
        //1 2 3 4 17 18 19 20
        //5 6 7 14 15 16
        //8 9 12 13
        //10 11
        //Try with different inputs to see why a complex formula is used
        int count=1;
        int count2 = (n*n)+1;
        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print(count+" ");
                count++;
            }
            int y=count2-1;
            for(int j=n;j>=i;j--){
                System.out.print(count2+" ");
                count2 = count2+1;
            }
            count2 =y-(n-i-1);
            System.out.println();
        }
    }
    public static void printPattern(int n) {
        //1
        //11
        //111
        //1111
        //Do it in O(N)
        String s = "1";
        for(int i=1;i<=n;i++){
            System.out.print(s);
            s=s+"1";
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printPattern(5);
    }
}
