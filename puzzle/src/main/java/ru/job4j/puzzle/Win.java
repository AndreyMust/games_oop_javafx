package ru.job4j.puzzle;

public class Win {
    public static boolean checkVertical(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean isWin = true;
            for (int j = 0; j < board.length; j++) {
                isWin = isWin && (board[j][i] == 1);
            }
            if (isWin) {
                return isWin;
            }
        }
        return false;
    }

    public static boolean checkHorizontal(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            boolean isWin = true;
            for (int cell = 0; cell < board.length; cell++) {
                isWin = isWin && (board[row][cell] == 1);
            }
            if (isWin) {
                return isWin;
            }
        }
        return false;
    }

    public static boolean check(int[][] board) {
        return checkHorizontal(board) || checkVertical(board);
    }

}
