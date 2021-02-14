package com.tictactoe.tictactoe.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.tictactoe.tictactoe.enums.GameStatus;

public class GameState {
    private GameStatus gameStatus;
    private String gameMessage;
    private Player turn;
    private List<String> turnMessage;

    public GameState() {
    }

    public GameState(Player turn) {
        this.gameStatus = GameStatus.GAME_START;
        this.gameMessage = "";
        this.turn = turn;
        this.turnMessage = new ArrayList<>();
    }

    public GameState(GameStatus gameStatus, String gameMessage, Player turn) {
        this.gameStatus = gameStatus;
        this.gameMessage = gameMessage;
        this.turn = turn;
        this.turnMessage = new ArrayList<>();
    }

    public GameState(GameStatus gameStatus, String gameMessage, Player turn, List<String> turnMessage) {
        this.gameStatus = gameStatus;
        this.gameMessage = gameMessage;
        this.turn = turn;
        this.turnMessage = turnMessage;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getGameMessage() {
        return this.gameMessage;
    }

    public void setGameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public Player getTurn() {
        return this.turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public List<String> getTurnMessage() {
        return this.turnMessage;
    }

    public void setTurnMessage(List<String> turnMessage) {
        this.turnMessage = turnMessage;
    }

    public void addTurnMessage(String log) {
        this.turnMessage.add(log);
    }

    public GameState gameStatus(GameStatus gameStatus) {
        setGameStatus(gameStatus);
        return this;
    }

    public GameState gameMessage(String gameMessage) {
        setGameMessage(gameMessage);
        return this;
    }

    public GameState turn(Player turn) {
        setTurn(turn);
        return this;
    }

    public GameState turnMessage(List<String> turnMessage) {
        setTurnMessage(turnMessage);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GameState)) {
            return false;
        }
        GameState gameState = (GameState) o;
        return Objects.equals(gameStatus, gameState.gameStatus) && Objects.equals(gameMessage, gameState.gameMessage)
                && Objects.equals(turn, gameState.turn) && Objects.equals(turnMessage, gameState.turnMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameStatus, gameMessage, turn, turnMessage);
    }

    @Override
    public String toString() {
        return "{" + " gameStatus='" + getGameStatus() + "'" + ", gameMessage='" + getGameMessage() + "'" + ", turn='"
                + getTurn() + "'" + ", turnMessage='" + getTurnMessage() + "'" + "}";
    }

}
