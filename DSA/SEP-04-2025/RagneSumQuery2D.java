import java.util.*;

public class RagneSumQuery2D {

}

class NumMatrix {

    int[][] p;

    public NumMatrix(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // prefix sum
        p = new int[rowSize+1][colSize+1];
        for(int row = 1; row<=rowSize; row++) {
            for(int col = 1; col<=colSize; col++) {
                p[row][col] = matrix[row - 1][col - 1] + p[row][col - 1] + p[row-1][col] - p[row-1][col-1];
            }
        }

        // for(int[] arr : p) {
        //     for(int i : arr) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return p[row2+1][col2+1] - p[row1][col2+1] - p[row2+1][col1] + p[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
