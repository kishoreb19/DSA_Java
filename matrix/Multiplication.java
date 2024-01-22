package matrix;

import java.util.Scanner;

public class Multiplication {
    public static int [][]input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix size m and n");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int matrix[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void multiply(int matrix1[][],int matrix2[][]){
        //Matrix1
        int r1 = matrix1.length;
        int c1 = matrix1[0].length;
        //Matrix2
        int r2 = matrix2.length;
        int c2 = matrix2[0].length;

        int res[][] = new int[r1][c2];
        
        if(c1 == r2){
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    res[i][j]=0;
                    for(int k=0;k<r2;k++){
                        res[i][j]=res[i][j]+matrix1[i][k]*matrix2[k][j];
                    }
                    System.out.print(res[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int matrix1[][] = input();
        int matrix2[][] = input();
        multiply(matrix1,matrix2);
    }
}
