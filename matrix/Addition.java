package matrix;

import java.util.Scanner;

public class Addition {
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

    public static void add(int matrix1[][], int matrix2[][]){
        if(matrix1.length==matrix2.length && matrix1[0].length==matrix2[0].length){
            //Order of both the matrix should be same for addition
            for(int i = 0; i< matrix1.length; i++){
                for(int j=0;j<matrix1[0].length;j++){
                    System.out.print(matrix1[i][j]+matrix2[i][j]+" ");
                }
                System.out.println();
            }

        }
    }
    public static void main(String[] args) {
        int matrix1[][] = input();
        int matrix2[][] = input();
        add(matrix1,matrix2);
    }
}
