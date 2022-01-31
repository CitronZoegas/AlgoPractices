package Algo;

import BetterSudoku.SudokuSolver;

public class Main {

    public static void main(String[] args) {
        //test values
        String str = null;
        int num = 0;
        int[] arr= {1,2,3,4};
        int[][] arr2D = {{1,2,3},{1,2,3}};

        /**
         * To Run the sudoku-Package
         */

        int[][] char2D =   {{'.','.','1'},{'.','.','.'},{'.','.','.'},
                            {'.','3','7'},{'.','.','.'},{'.','.','.'},
                            {'9','.','5'},{'.','.','.'},{'.','.','.'},
                            {'.','.','1'},{'.','.','.'},{'.','.','.'},
                            {'.','1','7'},{'.','.','.'},{'.','.','.'},
                            {'.','.','.'},{'.','.','.'},{'.','.','.'},
                            {'.','.','.'},{'.','.','.'},{'.','.','.'},
                            {'.','6','.'},{'.','.','.'},{'.','.','.'},
                            {'2','.','.'},{'.','.','.'},{'.','.','.'},};
        SudokuSolver sudokuSolver = new SudokuSolver();
        if(sudokuSolver.calculateSudoku(char2D)){
            System.out.println("IT WORKS!!!!");
        }



        /**
         * To Run the algorithm-Package
         */
        //Algorithms algo = new Algorithms();
	    //algo.maxProfit(arr);
    }
}
