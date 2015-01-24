package com.rahul.othello;

import com.rahul.othello.util.Coin;

/**
 * A framework for playing a single game
 * 
 * @author rahul
 */
public class Game {
	private Board board;

	private short movesLeft;

	private Player whitePlayer, blackPlayer;

	/**
	 * Initializes a game. Takes 2 objects which implement the <b>Player</b>
	 * interface as parameters
	 * 
	 * @param whitePlayer
	 * @param blackPlayer
	 */
	public Game(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = new Board();
		this.movesLeft = 64 - 4; // 4 coins are already placed initially
	}

	/**
	 * Start the game. This function exits only after the game has ended.
	 */
	public int play() {
		Point nextMove = null;
		if (Tournament.debug)
			System.out.println(board);

		while (movesLeft > 0) {
			if (board.getTurn() == Coin.white) {
				do {
					nextMove = whitePlayer.nextMove(board);
				} while (board.setPiece(Coin.white, nextMove) == false);
			} else if (board.getTurn() == Coin.black) {
				do {
					nextMove = blackPlayer.nextMove(board);
				} while (board.setPiece(Coin.black, nextMove) == false);
			}

			if (Tournament.debug) {
				if (nextMove == null)
					System.out.println(movesLeft + ". Player skipped a move.");
				else
					System.out.println(movesLeft + ". " + nextMove);
				System.out.println(board);
			}

			movesLeft--;
		}
		return announceResult();
	}

	private int announceResult() {
		short whiteCount = board.getPeiceCount(Coin.white);
		short blackCount = (short) ((short) 64 - whiteCount);
		if (whiteCount > blackCount) {
			if (Tournament.debug)
				System.out.println("White wins by " + (whiteCount - blackCount)
						+ " coins.");
			return 1;
		} else if (whiteCount == blackCount) {
			if (Tournament.debug)
				System.out.println("It's a draw!");
			return 0;
		} else {
			if (Tournament.debug)
				System.out.println("Black wins by " + (blackCount - whiteCount)
						+ " coins.");
			return -1;
		}
	}
}
