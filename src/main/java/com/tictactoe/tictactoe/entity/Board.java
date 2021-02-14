package com.tictactoe.tictactoe.entity;

import java.util.Objects;

import com.tictactoe.tictactoe.enums.Marker;

public class Board {

    public Marker[][] board;
    private int winLength;
    private int moveCount;

    public Board(int row, int col, int winLength) {
        this.winLength = winLength;
        this.moveCount = 0;
        this.board = new Marker[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                this.board[r][c] = Marker.BLANK;
            }
        }
    }

    public Board() {
    }

    public Board(Marker[][] board, int winLength, int moveCount) {
        this.board = board;
        this.winLength = winLength;
        this.moveCount = moveCount;
    }

    public Marker[][] getBoard() {
        return this.board;
    }

    public void setBoard(Marker[][] board) {
        this.board = board;
    }

    public int getWinLength() {
        return this.winLength;
    }

    public void setWinLength(int winLength) {
        this.winLength = winLength;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public Board board(Marker[][] board) {
        setBoard(board);
        return this;
    }

    public Board winLength(int winLength) {
        setWinLength(winLength);
        return this;
    }

    public Board moveCount(int moveCount) {
        setMoveCount(moveCount);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, winLength, moveCount);
    }

    @Override
    public String toString() {
        return "{" + " board='" + getBoard() + "'" + ", winLength='" + getWinLength() + "'" + ", moveCount='"
                + getMoveCount() + "'" + "}";
    }

}
