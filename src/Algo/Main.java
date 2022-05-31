package Algo;

import AutoAttackingGame.MainPanel;
import BetterSudoku.SudokuChecker;
import BetterSudoku.SudokuSolver;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        int[] testArray = new int[]{1, 3, 4, 6, 7, 9, 11, 15, 18, 23, 25};
        int left = testArray[0];
        int right = testArray.length+1;



        int index = 6;
        int mid = left + right / 2;

        int result = algo.binarySearch(testArray,index,left,right);
        if(result == -1){
            System.out.println("Target was not found");
        }else{
            System.out.println(result);
        }
    }
}
