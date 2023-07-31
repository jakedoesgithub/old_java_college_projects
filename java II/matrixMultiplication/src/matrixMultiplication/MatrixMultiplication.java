package matrixMultiplication;
/*
*Name: Jake Ardoin
Email: jardo16@lsu.edu
Project: PA=1 (Miltithreading)
Instructor: Feng Chen
Class: cs4103-sp21
LoginID: cs410302
*/

import java.util.Arrays;

public class MatrixMultiplication {
	int rowN;
    int colN;
    int[][] arA;
    int[][] arB;
    int[][] res;
    int r;
    int c;


    public MatrixMultiplication(int[][] arrayA, int[][] arrayB){
        this.rowN = 0;
        this.colN = 0;
        this.arA = arrayA;
        this.arB = arrayB;
        r = arA.length;
        c = arB[0].length;
        if(r != c){
            System.out.println("# rows of arrayA must match the #cols of arrayB");
        };
        this.res = new int[r][c];
    }


    public int[][] multiply(){
        int[][] bswapped = getColsB(this.arB);
        int i = 0;
        int j = 0;
        while(i < r){
            while(j < c){
                Thread t = new Thread(new RowColMultiplier(this.arA[i], bswapped[j], this.res, i, j));
                t.start();
                j++;
            };
            i++;
            j = 0;
        }


        return this.res;
    }


    private static int[][] getColsB(int[][] arr){
        int i = 0;
        int j = 0;
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[][] resArr = new int[numCols][numRows];

        while(i < numRows){
            while(j < numCols){
                resArr[j][i] = arr[i][j];
                j++;
            };
            i++;
            j = 0;
        }
        return resArr;
    }

	public static void main(String[] args) {
		int[][] A = {
	            {1, 4},
	            {2, 5},
	            {3, 6}
	        };
	    
	        int[][] B = {
	            {8, 7, 6},
	            {5, 4, 3}
	        };

	        MatrixMultiplication mm = new MatrixMultiplication(A, B);
	        int[][] res = mm.multiply();
	        System.out.println(Arrays.deepToString(res));
	        
	        
	}

}

