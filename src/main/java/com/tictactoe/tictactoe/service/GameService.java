package com.tictactoe.tictactoe.service;

import com.tictactoe.tictactoe.constants.Constants;
import com.tictactoe.tictactoe.entity.Board;
import com.tictactoe.tictactoe.entity.GameState;
import com.tictactoe.tictactoe.entity.Player;
import com.tictactoe.tictactoe.enums.GameStatus;
import com.tictactoe.tictactoe.enums.Marker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    public Board move(int row, int col, Board board, GameState gameState, Player player) {
        int winLength = board.getWinLength();
        int moveCount = board.getMoveCount();
        Marker[][] arrBoard = board.getBoard();

        try {
            if (arrBoard[row][col] == Marker.BLANK) {
                arrBoard[row][col] = player.getMarker();
                board.setMoveCount(moveCount + 1);
                System.out.println();
                System.out.println();

                String str = player.getName() + " mark " + row + "," + col;
                log.info(str);
                gameState.addTurnMessage(str);
                
            } else {
                log.info(row + "," + col + " not null");
                // gameState.addTurnMessage(player.getName() + " mark " + row + "," + col);
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

        // check col
        for (int i = 0; i < winLength; i++) {
            if (arrBoard[row][i] != player.getMarker())
                break;
            if (i == winLength - 1) {
                String str = player.getName()+ " score point at colomn.";
                log.info(str);
                gameState.addTurnMessage(str);
                player.scorePoint();
            }
        }

        // check row
        for (int i = 0; i < winLength; i++) {
            if (arrBoard[i][col] != player.getMarker())
                break;
            if (i == winLength - 1) {
                String str = player.getName()+ " score point at row: ";
                log.info(str);
                gameState.addTurnMessage(str);
                player.scorePoint();
            }
        }

        // check diag
        if (row == col) {
            for (int i = 0; i < winLength; i++) {
                if (arrBoard[i][i] != player.getMarker())
                    break;
                if (i == winLength - 1) {
                    String str = player.getName()+ " score point at diagonal.";
                    log.info(str);
                    gameState.addTurnMessage(str);
                    player.scorePoint();
                }
            }
        }

        // check anti diag
        if (row + col == winLength - 1) {
            for (int i = 0; i < winLength; i++) {
                if (arrBoard[i][(winLength - 1) - i] != player.getMarker())
                    break;
                if (i == winLength - 1) {
                    String str = player.getName()+ " score point at anti diagonal.";
                    log.info(str);
                    gameState.addTurnMessage(str);
                    player.scorePoint();
                }
            }
        }
        return board;
    }

    public GameState checkBoard(Board board, GameState gameState, Player p1, Player p2) {
        gameState.setGameStatus(GameStatus.IN_PROGRESS);
        // Check game turn
        if (board.getMoveCount() % 2 == 0) {
            gameState.setTurn(p1);
        } else {
            gameState.setTurn(p2);
        }

        // Check End Game
        if (Math.pow(board.getBoard().length, 2) == board.getMoveCount()) {
            if (p1.getScore() > p2.getScore()) {
                gameState.setGameStatus(GameStatus.FIRST_PLAYER_WON);
                gameState.setTurn(p1);
            } else if (p2.getScore() > p1.getScore()) {
                gameState.setGameStatus(GameStatus.SECOND_PLAYER_WON);
            } else {
                gameState.setGameStatus(GameStatus.DRAW);
            }
            gameState.addTurnMessage("End Game.");
        }
        return gameState;
    }

}
