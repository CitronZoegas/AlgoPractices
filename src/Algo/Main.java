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
        int[][] grid2D = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        SudokuSolver sudokuSolver = new SudokuSolver();
        if(sudokuSolver.calculateSudoku(grid2D)){
            System.out.println("IT WORKS!!!!");
        }



        /**
         * To Run the algorithm-Package
         */
        //Algorithms algo = new Algorithms();
	    //algo.maxProfit(arr);
    }
}
