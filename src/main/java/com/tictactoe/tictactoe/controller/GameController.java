package com.tictactoe.tictactoe.controller;

import javax.servlet.http.HttpSession;

import com.tictactoe.tictactoe.constants.Constants;
import com.tictactoe.tictactoe.entity.Board;
import com.tictactoe.tictactoe.entity.FormInput;
import com.tictactoe.tictactoe.entity.GameState;
import com.tictactoe.tictactoe.entity.Player;
import com.tictactoe.tictactoe.enums.Marker;
import com.tictactoe.tictactoe.service.GameService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GameController {

    @Autowired
    private HttpSession session;

    @Autowired
    private GameService gameService;

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(Constants.VIEW_GAME);
        mv.addObject(Constants.FORM_INPUT, new FormInput());
        return mv;
    }

    @GetMapping("/reset")
    public RedirectView reset() {
        session.invalidate();
        return new RedirectView(Constants.VIEW_INDEX);
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute(Constants.FORM_INPUT) FormInput formInput) {
        ModelAndView mv = new ModelAndView();

        int boardSize = formInput.getBoardSize();
        log.info("Board size: " + boardSize);
        Board board = new Board(boardSize, boardSize, 3);

        Player player1 = new Player("Player 1", Marker.X);
        Player player2 = new Player("Player 2", Marker.O);

        GameState gameState = new GameState(player1);

        session.setAttribute(Constants.GAME_STATE, gameState);
        session.setAttribute(Constants.PLAYER1, player1);
        session.setAttribute(Constants.PLAYER2, player2);
        session.setAttribute(Constants.BOARD, board);
        session.setAttribute(Constants.BOARD_SIZE, boardSize);

        mv.setViewName(Constants.VIEW_GAME);
        return mv;
    }

    @GetMapping("/move")
    public @ResponseBody ModelAndView move(@RequestParam(value = "row", required = true) int row,
            @RequestParam(value = "col", required = true) int col) {
        ModelAndView mv = new ModelAndView();

        Board board = (Board) session.getAttribute(Constants.BOARD);
        GameState gameState = (GameState) session.getAttribute(Constants.GAME_STATE);
        Player player1 = (Player) session.getAttribute(Constants.PLAYER1);
        Player player2 = (Player) session.getAttribute(Constants.PLAYER2);

        if (board.getMoveCount() % 2 == 0) {
            board = gameService.move(row, col, board, gameState, player1);
        } else {
            board = gameService.move(row, col, board, gameState, player2);
        }

        try {
            gameState = gameService.checkBoard(board, gameState, player1, player2);
            session.setAttribute(Constants.GAME_STATE, gameState);
            log.info(gameState.toString());
            log.info(board.toString());
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        mv.setViewName(Constants.VIEW_GAME);
        return mv;
    }
}