package com.rahul.othello;

public class Game {
	private Board board;

	private short movesLeft;

	private Player whitePlayer, blackPlayer;

	public Game(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = new Board();
		this.movesLeft = 64 - 4;		// 4 coins are already placed initially
		play();
	}

	public void play() {
		Point nextMove = null;
		System.out.println(board);
		
		while (movesLeft > 0) {
			if (board.getTurn() == Coin.white) {
				do {
					 nextMove = whitePlayer.nextMove(board);
				} while (board.setPeice(Coin.white, nextMove) == false);
			} else if (board.getTurn() == Coin.black) {
				do {
					nextMove = blackPlayer.nextMove(board);
				} while (board.setPeice(Coin.black, nextMove) == false);
			}
			System.out.println(movesLeft-- + ". " + nextMove);
			System.out.println(board);
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
