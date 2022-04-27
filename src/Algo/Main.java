package Algo;

import AutoAttackingGame.MainPanel;
import BetterSudoku.SudokuChecker;
import BetterSudoku.SudokuSolver;

public class Main {

    public static void main(String[] args) {
        //test values
        String str = null;
        int num = 0;
        int[] arr= {1,2,3,4};
        int[][] arr2D = {{1,2,3},{1,2,3}};

        /**
         * To Run the Game-package
         */
        //MainPanel panel = new MainPanel();

        /**
         * To Run the sudoku-Package
         */
        //SudokuChecker sudokuCh = new SudokuChecker();

        /**
         * To Run the algorithm-Package
         */
        Algorithms algo = new Algorithms();
        System.out.println(algo.findCorrectNumber());
    }
}
