package com.rahul.othello.gui;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;
import com.rahul.othello.util.Coin;

public class GUIGame {
	private Board board;
	private Player whitePlayer, blackPlayer;

	public GUIGame(Player humanPlayer, Player computerPlayer) {
		this.whitePlayer = humanPlayer;
		this.blackPlayer = computerPlayer;
		this.board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public boolean humansTurn(Point nextMove) {
		return board.setPiece(Coin.white, nextMove);
	}

	public boolean gameOver() {
		return board.isGameOver();
	}

	public String announceResult() {
		short whiteCount = board.getPieceCount(Coin.white);
		short blackCount = (short) ((short) 64 - whiteCount);
		if (whiteCount > blackCount) {
			return "White wins by " + (whiteCount - blackCount) + " coins.";
		} else if (whiteCount == blackCount) {
			return "It's a draw!";
		} else {
			return "Black wins by " + (blackCount - whiteCount) + " coins.";
		}
	}

	public boolean humanCanMove() {
		Coin turn = board.getTurn();
		if (turn == Coin.white)
			return true;
		return false;
	}

	public Point computersTurn() {
		Point nextMove = blackPlayer.nextMove(board);
		board.setPiece(Coin.black, nextMove);
		
		return nextMove;
	}

}
