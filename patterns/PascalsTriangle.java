package patterns;

import java.util.ArrayList;

public class PascalsTriangle {
    static int factorial(int n){
        int ans = 1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
    static int getElementAtRC(int row, int col){
        int ans = factorial(row)/(factorial(row-col)*factorial(col));
        return ans;
    }

    static ArrayList<Integer> getRow(int row){
        ArrayList<Integer>result = new ArrayList<>();
        int ans = 1;
        for(int col=0; col<=row; col++){
            if(col==0){
                result.add(ans);
            }else{
                ans = (int) ((long) ans * (row - col + 1) / col);
                result.add(ans);
            }
        }
        return result;
    }

    static void printPascalsTriangle(int n){
        for(int row=0;row<n;row++){
            for(int k = n-1; k>row;k--){
                //Print Spaces
                System.out.print(" ");
            }
            int ans = 1;
            for(int col=0;col<=row;col++){
                if(col==0){
                    System.out.print(ans+" ");
                }else{
                    ans = (int) ((long) ans * (row - col + 1) / col);
                    System.out.print(ans+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row = 4;
        int col = 2;

        //Print Pascal's Triangle
        printPascalsTriangle(row+1);//Printing 5 rows

        //Pascal's Triangle's Row at 4 (0-Based Indexing)
        System.out.print("Row at "+row+": ");
        for(int i: getRow(row)){
            System.out.print(i+" ");
        }
        System.out.println();

        //Pascal's Triangle at row=4 and col=2
        System.out.println("Element at ["+row+","+col+"]: "+getElementAtRC(row,col));

    }
}
