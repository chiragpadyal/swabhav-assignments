package com.swabhav;

public class TicTacToeFacade {

    private final TicTacToe ticTacToe;

    public TicTacToeFacade(int boardSize) {
        this.ticTacToe = new TicTacToe(boardSize);
    }

    public void startGame() {
        ticTacToe.playGame();
    }
}
