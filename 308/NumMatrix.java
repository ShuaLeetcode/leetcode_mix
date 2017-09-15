import java.util.ArrayList;

/**
 * 308. Range Sum Query 2D - Mutable
 *
 * Created by qiuyankun on 18/6/17.
 */
public class NumMatrix {

    private int[][] matrix;
    private ArrayList<Integer[]> updateList;

    public NumMatrix(int[][] matrix) {
        updateList = new ArrayList<Integer[]>();
        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            this.matrix = new int[row][col];
            for (int rowIndex = 0; rowIndex < row; rowIndex ++) {
                int colIndex = 0;
                for (int ele: matrix[rowIndex]) {
                    this.matrix[rowIndex][colIndex] = ele;
                    colIndex ++;
                }
                if (colIndex < col) {
                    for (int index = colIndex; colIndex < col; colIndex ++) {
                        this.matrix[rowIndex][colIndex] = 0;
                    }
                }
            }

            for (int r = 1; r < row; r++) {
                this.matrix[r][0] += this.matrix[r - 1][0];
            }
            for (int c = 1; c < col; c++) {
                this.matrix[0][c] += this.matrix[0][c - 1];
            }
            for (int r = 1; r < row; r++) {
                for (int c = 1; c < col; c++) {
                    this.matrix[r][c] = this.matrix[r][c] - this.matrix[r - 1][c - 1] + this.matrix[r - 1][c] + this.matrix[r][c - 1];
                }
            }

        }
    }

    public void update(int row, int col, int val) {
        int ele = 0;
        if (row == 0 && col != 0) {
            ele = this.matrix[row][col] - this.matrix[row][col - 1];
        } else if (col == 0 && row != 0) {
            ele = this.matrix[row][col] - this.matrix[row - 1][col];
        } else if (col == 0 && row == 0) {
            ele = this.matrix[row][col];
        } else {
            ele = this.matrix[row][col] + this.matrix[row - 1][col - 1] -
                    this.matrix[row][col - 1] - this.matrix[row - 1][col];
        }
        int del = val - ele;
        for (Integer[] updateRec: updateList) {
            if (row == updateRec[0] && col == updateRec[1]) {
                del = del - updateRec[2];
            }
        }
        Integer[] updateRec = {row, col, del};
        this.updateList.add(updateRec);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if ((row1 < 0 || row2 >= this.matrix.length) || (col1 < 0 || col2 >= this.matrix[0].length)) {
            return sum;
        } else {
            if (row1 > 0 && col1 > 0) {
                sum = this.matrix[row2][col2] + this.matrix[row1 - 1][col1 - 1] -
                        this.matrix[row1 - 1][col2] - this.matrix[row2][col1 - 1];
            } else if (col1 != 0) {
                sum = this.matrix[row2][col2] - this.matrix[row2][col1 - 1];
            } else if (row1 != 0) {
                sum = this.matrix[row2][col2] - this.matrix[row1 - 1][col2];
            } else {
                sum = this.matrix[row2][col2];
            }

            for (Integer[] updateRec: updateList) {
                if (row1 <= updateRec[0] && updateRec[0] <= row2) {
                    if (col1 <= updateRec[1] && updateRec[1] <= col2) {
                        sum += updateRec[2];
                    }
                }
            }

            return sum;
        }
    }
}
