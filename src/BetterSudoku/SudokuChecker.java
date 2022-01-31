package BetterSudoku;

import java.util.HashSet;

public class SudokuChecker {

    public SudokuChecker() {

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
