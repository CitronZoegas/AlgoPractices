package BetterSudoku;



public class SudokuSolver {
    //its set to nine since my sudoku board is 9x9 char.
    //originally tried to do it with 'char' but 'int' seems alot easier.
    private int SIZE = 9;
    public Object SudokuChecker() {

        return null;

    }
    private boolean inRow(int[][] board, int row, int checkNumber){
        for(int i = 0;i < SIZE; i++){
            if(board[row][i] == checkNumber){
                return true;
            }
        }
        return false;
    }
    private boolean inCol(int[][] board, int col, int checkNumber){
        for(int i = 0;i < SIZE; i++){
            if(board[i][col] == checkNumber){
                return true;
            }
        }
        return false;
    }
    private boolean inBox(int[][]board, int row, int col, int checkNumber) {
        int inBoxRow = row - row % 3;
        int inBoxCol = col - col % 3;
        for(int i = inBoxRow; i <inBoxRow + 3; i++){
            for(int j = inBoxCol; j<inBoxCol + 3; j++){
                if(board[i][j] == checkNumber){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCoordinates(int[][]board,int row,int col, int checkNumber) {
        return inRow(board,row,checkNumber) &&
            inCol(board,col,checkNumber) &&
            inBox(board,row,col,checkNumber);

    }

    public boolean calculateSudoku(int[][]board) {
        for (int row = 0; row <SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if(board[row][col] == '.'){
                    for(int i = 1; i <= SIZE; i++){
                        if (checkCoordinates(board,row,col,i)){
                            board[row][col] = i;
                            if(calculateSudoku(board)){
                                return true;
                            }
                        }
                    }return false;
                }
            }
        }


        return true;
    }

}