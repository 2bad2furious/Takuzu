package com.example.user.takuzu.Domain.Model;

/**
 * Created by user on 26.03.2017.
 */

/* TODO zhezčit xd */
public class Solver {

    public static boolean isSolvable(GameField[][] arr) throws Exception {
        boolean solCols = checkSolvableColumns(arr);
        boolean solRows = checkSolvableRows(arr);
        System.out.println("checkSolvableColumns: " + solCols + " checkSolvableRows: " + solRows);
        if (true)
            throw new Exception("checkSolvableColumns: " + solCols + " checkSolvableRows: " + solRows);
        return (checkSolvableColumns(arr) && checkSolvableRows(arr));
    }

    public static boolean isSolved(GameField[][] arr) {
        boolean bool = checkSolvedColumns(arr);
        if (!bool) bool = checkSolvedRows(arr);
        return bool;
    }

    private static boolean checkSolvableColumns(GameField[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int redCount;
            int blueCount;
            int ColorLine;
            redCount = blueCount = ColorLine = 0;

            Color c = Color.EMPTY;
            Color curColor = null;

            for (int j = 0; j < arr[i].length; j++) {
                curColor = arr[i][j].getColor();

                if (curColor == c) {
                    ColorLine++;
                }
                c = curColor;

                if (curColor == Color.RED) redCount++;
                else if (curColor == Color.BLUE) blueCount++;

                if (ColorLine >= 3) return false;
            }

            if (redCount >= arr.length / 2 || blueCount >= arr.length / 2) return false;
        }
        return true;
    }

    private static boolean checkSolvableRows(GameField[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int redCount;
            int blueCount;
            int ColorLine;
            redCount = blueCount = ColorLine = 0;

            Color c = Color.EMPTY;
            Color curColor = null;

            for (int j = 0; j < arr[i].length; j++) {
                curColor = arr[j][i].getColor();

                if (curColor == c) {
                    ColorLine++;
                }
                c = curColor;

                if (curColor == Color.RED) redCount++;
                else if (curColor == Color.BLUE) blueCount++;

                if (ColorLine >= 3) return false;
            }

            if (redCount >= arr.length / 2 || blueCount >= arr.length / 2) return false;
        }
        return true;
    }

    private static boolean checkSolvedColumns(GameField[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int redCount;
            int blueCount;
            int ColorLine;
            redCount = blueCount = ColorLine = 0;

            Color c = Color.EMPTY;
            Color curColor = null;

            for (int j = 0; j < arr[i].length; j++) {
                curColor = arr[i][j].getColor();

                if (curColor == c) {
                    ColorLine++;
                }
                c = curColor;

                if (curColor == Color.RED) redCount++;
                else if (curColor == Color.BLUE) blueCount++;

                if (ColorLine >= 3) return false;
            }

            if (redCount != blueCount) return false;
        }
        return true;
    }

    private static boolean checkSolvedRows(GameField[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int redCount;
            int blueCount;
            int ColorLine;
            redCount = blueCount = ColorLine = 0;

            Color lastColor = Color.EMPTY;
            Color curColor = null;

            for (int j = 0; j < arr[i].length; j++) {
                curColor = arr[j][i].getColor();

                if (curColor == lastColor) {
                    ColorLine++;
                }
                lastColor = curColor;

                if (curColor == Color.RED) redCount++;
                else if (curColor == Color.BLUE) blueCount++;

                if (ColorLine >= 3) return false;
            }

            if (redCount != blueCount) return false;
        }
        return true;
    }
}
