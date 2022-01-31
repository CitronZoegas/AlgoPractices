package BetterSudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SudokuChecker {


    public int[][] char2D =   {{'.','.','1'},{'.','.','.'},{'.','.','.'},
            {'.','3','7'},{'.','.','.'},{'.','.','.'},
            {'9','.','5'},{'.','.','.'},{'.','.','.'},
            {'.','.','1'},{'.','.','.'},{'.','.','.'},
            {'.','1','7'},{'.','.','.'},{'.','.','.'},
            {'.','.','.'},{'.','.','.'},{'.','.','.'},
            {'.','.','.'},{'.','.','.'},{'.','.','.'},
            {'.','6','.'},{'.','.','.'},{'.','.','.'},
            {'2','.','.'},{'.','.','.'},{'.','.','.'},};
    public int[][] grid2D = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};



    public SudokuChecker() {
        SudokuSolver sudokuSolver = new SudokuSolver();
        //use grid2D or randomArray() to start this.
        if(sudokuSolver.calculateSudoku(randomArray())){
            System.out.println("IT WORKS!!!!");
        }
    }

    public int[][] randomArray() {
        int[][] board = new int[9][9];
        Random rand = new Random();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = rand.nextInt(9);
            }
        }
        return board;
    }

    public boolean checkThis(char[][]board) {
        char period = '.';
        HashSet<String> gridBoard = new HashSet<>();
        int boardLen = board.length;
        for(int row = 0;row <boardLen; row++ ){
            for(int col = 0; col < boardLen; col++){
                char currChar = board[row][col];
                if(board[row][col] != period){
                    if( !gridBoard.add(currChar+"row"+row) ||
                        !gridBoard.add(currChar+"col"+col) ||
                        !gridBoard.add(currChar+"3x3Box"+row/3+col/3))
                        return false;
                }
            }
        }
        return true;
    }
}
