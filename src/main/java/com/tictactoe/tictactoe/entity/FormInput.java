package com.tictactoe.tictactoe.entity;

import java.util.Objects;

public class FormInput {
    private int boardSize;
    // private int 

    public FormInput() {
    }

    public FormInput(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public FormInput boardSize(int boardSize) {
        setBoardSize(boardSize);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FormInput)) {
            return false;
        }
        FormInput formInput = (FormInput) o;
        return boardSize == formInput.boardSize;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(boardSize);
    }

    @Override
    public String toString() {
        return "{" +
            " boardSize='" + getBoardSize() + "'" +
            "}";
    }
   

}
