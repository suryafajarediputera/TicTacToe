package com.tictactoe.tictactoe.test;

import com.tictactoe.tictactoe.entity.Board;
import com.tictactoe.tictactoe.enums.Marker;
import com.tictactoe.tictactoe.service.GameService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    public static void main(String[] args){

        // GameService gameService = new GameService();
        // GameState gameState = new GameState();

        int row = 3;
        int col = 3;
        int winLength = 3;
        Board board = new Board(row, col, winLength);

        Marker[][] b = board.getBoard();
        log.info(b.getClass().getName());
        
        
        // log.info(arrString.getClass().getName());
                
        // Player p1 = new Player("Player 1", Marker.X);
        // Player p2 = new Player("Player 2", Marker.O);

        // gameService.move(0, 0, board, p1);
        // log.info(board.toString());
        // // log.info(p1.toString());
        // // log.info(p2.toString());
        // gameService.move(1, 0, board, p2);
        // log.info(board.toString());

        // gameService.move(3, 3, board, p1);

        // gameService.move(0, 1, board, p1);
        // gameService.move(1, 1, board, p2);

        // gameService.move(0, 2, board, p1);
        // gameService.move(1, 2, board, p2);

        // gameService.move(2, 0, board, p1);
        // gameService.move(2, 1, board, p2);

        // gameService.move(2, 2, board, p1);
        // log.info(p1.toString());
        // log.info(p2.toString());

        // boolean status = true;
        // int idx = 0;

    
        // gameService.move(0, 3, board, p1);
        // gameService.move(1, 3, board, p2);
        // gameService.move(0, 4, board, p1);
        // gameService.move(1, 4, board, p2);
    }

}
