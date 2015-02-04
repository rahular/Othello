package com.rahul.othello.gui;

import com.rahul.othello.Board;
import com.rahul.othello.Player;
import com.rahul.othello.Point;
import com.rahul.othello.util.Coin;

public class GUIGame {
	private Board board;
	private Player computerPlayer;

	public GUIGame(Player computerPlayer) {
		this.computerPlayer = computerPlayer;
		this.board = new Board();
	}

	public Board getBoard() {
		return board;
	}

	public boolean humansTurn(Coin playerColor, Point nextMove) {
		return board.setPiece(playerColor, nextMove);
	}

	public boolean gameOver() {
		return board.isGameOver();
	}

	public String announceResult() {
		short whiteCount = board.getPieceCount(Coin.white);
		short blackCount = board.getPieceCount(Coin.black);
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

	public Point computersTurn(Coin playerColor) {
		Point nextMove = computerPlayer.nextMove(board);
		board.setPiece(playerColor, nextMove);
		
		return nextMove;
	}

}
