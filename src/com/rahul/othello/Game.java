package com.rahul.othello;

public class Game {
	private Board board;

	private short movesLeft;

	private Player whitePlayer, blackPlayer;

	public Game(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = new Board();
		this.movesLeft = 64;
		play();
	}

	public void play() {
		while (movesLeft > 0) {
			if (board.getTurn() == Coin.white) {
				while (!board.setPeice(Coin.white, whitePlayer.nextMove(board)))
					;
				movesLeft--;
			} else if (board.getTurn() == Coin.black) {
				while (!board.setPeice(Coin.black, blackPlayer.nextMove(board)))
					;
				movesLeft--;
			}
		}
		announceResult();
	}

	public void announceResult() {
		short whiteCount = board.getPeiceCount(Coin.white);
		short blackCount = (short) ((short) 64 - whiteCount);
		if (whiteCount > blackCount)
			System.out.println("White wins by " + (whiteCount - blackCount)
					+ " coins.");
		else if (whiteCount == blackCount)
			System.out.println("It's a draw!");
		else
			System.out.println("Black wins by " + (blackCount - whiteCount)
					+ " coins.");
	}
}
