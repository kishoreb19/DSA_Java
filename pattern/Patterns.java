package pattern;

public class Patterns {
    public static void triangle(int n){
        //   *
        //  * *
        // * * *
        //* * * *
        System.out.println("Triangle of size : "+n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
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

    public static void main(String[] args) {
        pascalTriangle(5);
    }
}
